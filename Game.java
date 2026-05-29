package game;
import java.util.*;

class colurs {

    public static Scanner sc = new Scanner(System.in);

	static String spc1 = "\n\t\t\t\t\t";
	static String spc2 = "\t\t\t\t\t\t";

    // RESET
    public static final String reset = "\u001B[0m";

    // TEXT COLORS
    public static final String black = "\u001B[30m";
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String yellow = "\u001B[33m";
    public static final String blue = "\u001B[34m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";
    public static final String white = "\u001B[37m";

    // BRIGHT TEXT
    public static final String brightRed = "\u001B[91m";
    public static final String brightGreen = "\u001B[92m";
    public static final String brightYellow = "\u001B[93m";
    public static final String brightBlue = "\u001B[94m";
    public static final String brightPurple = "\u001B[95m";
    public static final String brightCyan = "\u001B[96m";
    public static final String brightWhite = "\u001B[97m";

    // BACKGROUND COLORS
    public static final String bgBlack = "\u001B[40m";
    public static final String bgRed = "\u001B[41m";
    public static final String bgGreen = "\u001B[42m";
    public static final String bgYellow = "\u001B[43m";
    public static final String bgBlue = "\u001B[44m";
    public static final String bgPurple = "\u001B[45m";
    public static final String bgCyan = "\u001B[46m";
    public static final String bgWhite = "\u001B[47m";

    // BRIGHT BACKGROUND
    public static final String bgBrightRed = "\u001B[101m";
    public static final String bgBrightGreen = "\u001B[102m";
    public static final String bgBrightYellow = "\u001B[103m";
    public static final String bgBrightBlue = "\u001B[104m";
    public static final String bgBrightPurple = "\u001B[105m";
    public static final String bgBrightCyan = "\u001B[106m";
    public static final String bgBrightWhite = "\u001B[107m";

    // TEXT EFFECTS
    public static final String bold = "\u001B[1m";
    public static final String underline = "\u001B[4m";
    public static final String blink = "\u001B[5m";

    // TYPEWRITER (slow printing)
    public static void typeWriter(String msg, int delay) {
        for (char ch : msg.toCharArray()) {
            System.out.print(ch);
            sleep(delay);
        }
        System.out.println();
    }

    // GOLD SHINE EFFECT
    public static void goldShine(String msg) {
        String[] golds = {yellow, brightYellow, brightWhite};
        for (int r = 0; r < 3; r++) {
            for (String g : golds) {
                System.out.print("\r" + g + bold + msg + reset);
                sleep(120);
            }
        }
        System.out.println();
    }

    // BOMB FLASH
    public static void bombFlash() {
        String txt = "  B O M B ! ";
        for (int i = 0; i < 6; i++) {
            System.out.print("\r" + (i % 2 == 0 ? bgBrightRed : bgBlack) + bold + txt + reset);
            sleep(130);
        }
        System.out.println();
    }

    // LOADING ANIMATION
    public static void loading(String msg) {
        for (int r = 0; r < 3; r++) {
            System.out.print("\r" + brightGreen + msg + "." + reset); sleep(200);
            System.out.print("\r" + brightGreen + msg + ".." + reset); sleep(200);
            System.out.print("\r" + brightGreen + msg + "..." + reset); sleep(200);
        }
        System.out.println();
    }

    private static void sleep(int ms) {
        try { Thread.sleep(ms); } catch (Exception e) {}
    }
}



class GB
{	
	
	static final int size=36;
	static final int gold_count=30;

	static Scanner sc=new Scanner(System.in);
	int gamescore=0;
	
	static GB gbobj=new GB();
	

	 static void showMenu() 
	{

			System.out.println("\n");
			System.out.println("\t\t\t\t\t\t\t+--------------------------------------+");
			System.out.println("\t\t\t\t\t\t\t|  +--------------------------------+  |");
			System.out.println("\t\t\t\t\t\t\t|  |" + colurs.yellow + "  MAIN MENU " + colurs.reset + "\t\t    |  |");
			System.out.println("\t\t\t\t\t\t\t|  +--------------------------------+  |");
			System.out.println("\t\t\t\t\t\t\t|  |                                |  |");
			System.out.println(colurs.blink+"\t\t\t\t\t\t\t|  |  1. Play Game 		    |  |"+colurs.reset);
			System.out.println(colurs.blink+"\t\t\t\t\t\t\t|  |  2. View High Score            |  |"+colurs.reset);
			System.out.println(colurs.blink+"\t\t\t\t\t\t\t|  |  3. Exit Gaming World          |  |"+colurs.reset);
			System.out.println("\t\t\t\t\t\t\t|  |                                |  |");
			System.out.println("\t\t\t\t\t\t\t|  +--------------------------------+  |");
			System.out.println("\t\t\t\t\t\t\t+--------------------------------------+");
			System.out.println();
			System.out.print(colurs.bgBrightWhite+colurs.black + "Choose option:" + colurs.reset);
   	 }
	
	static void play()
	{
		boolean [] gold=new boolean[size];
		boolean [] reveal=new boolean[size];
		
		System.out.print(colurs.brightBlue+"ENTER YOUR NAME:"+colurs.reset);

		String user = sc.nextLine().trim();
		System.out.println();

		placegold(gold);

		while(true){
			printboard(gold,reveal);
			System.out.print("Enter position number 1 to 36:");
			int number=sc.nextInt();
			if(number==0){
				colurs.typeWriter(colurs.red + "Exiting game ..." + colurs.reset, 30);
				break;
			}
			if(number<1||number>36){
				System.out.println(colurs.red + "Invalid cell! Choose 1–36." + colurs.reset);
				continue;
			}
			int cell=number-1;
			if(reveal[cell]){
				System.out.println(colurs.yellow + "Already selected!" + colurs.reset);
				continue;
			}
			reveal[cell] = true;
			if(gold[cell])
			{
				System.out.println("GOLD FOUND");
				gbobj.gamescore++;
			}
			else{
				colurs.bombFlash();
				System.out.println(colurs.red+"BOMB"+colurs.reset);
				break;
			}
		}
		
		System.out.println("=======GAME OVER========");
		
		printfinalboard(gold);
		System.out.println("score:"+gbobj.gamescore);
	}

	//GOLD PLACE
	static void placegold(boolean [] gold)
	{
		int placed=0;
		Random r = new Random();
		while(placed<gold_count)
		{
			int id=r.nextInt(size);
			if(!gold[id]){
				gold[id]=true;
				placed++;
			}
		}
	}
	

	//PRINT BOARD	
	static void printboard(boolean []gold ,boolean []reveal)
	{
		for(int i=0;i<size;i++){
			if(!reveal[i]){
				System.out.printf(colurs.brightWhite + "%3d" + colurs.reset, (i + 1));
			}
			else{
				if(gold[i])
					System.out.print(colurs.yellow + " G " + colurs.reset);

				else
					System.out.print(colurs.red + " B " + colurs.reset);
			}
			if((i+1)%6==0)System.out.println();
		}
	}
		

	//FINAL 		
	static void printfinalboard(boolean[] gold)
	{
		 System.out.println(colurs.bold + "--- FULL MAP ---" + colurs.reset);
		for(int i=0;i<size;i++)
		{
			if(gold[i])
				System.out.print(colurs.yellow + " G " + colurs.reset);

			else
				System.out.print(colurs.red + " B " + colurs.reset);

			if((i+1)%6==0)
				System.out.println();
		}
	}

	static void viewHighscore()
	{
		System.out.println("===== HIGH SCORE=====");
		System.out.println(colurs.brightGreen+"Siva ganesh :30"+colurs.reset);
	}


	public static int main1()
	{
		
	System.out.print(colurs.bgBrightYellow + colurs.black + colurs.spc1+colurs.blink+"		=============== GOLD MINES ============="+colurs.reset);

	System.out.println();
	System.out.println();
	System.out.println();
	System.out.println(colurs.bgBrightWhite+colurs.red+" GAME RULES "+colurs.reset);
	System.out.println();
	System.out.println(colurs.brightWhite+"1.Select any cell from 1 to 36. each cell may hide Gold (G) or a Bomb (B)."+colurs.reset);
	System.out.println(colurs.brightWhite+"2.the score counts only when you find Gold"+colurs.reset);
	System.out.println(colurs.brightWhite+"3.Bombs do  end the game. "+colurs.reset);


		while(true){
			showMenu();
		
		int choice=sc.nextInt();
		sc.nextLine();
			switch(choice){
				case 1:play();break;
				case 2:viewHighscore();break;
				case 3:colurs.typeWriter(colurs.brightRed + "Exiting..." + colurs.reset, 40);
					return gbobj.gamescore;
				default:
					System.out.print("Invalid Choice");
			}
		}
	}
				
}




class MathQuizFinal {

	static MathQuizFinal qzobj=new MathQuizFinal();
	 int qzscore = 0;
    public static int main2() {
        Scanner scanner = colurs.sc;
        Random random = new Random();
        
       
        int totalQuestions = 10;
	

        // --- NEW INTRO EFFECT ---
        System.out.print("\033[H\033[2J"); // Clear screen (works in most consoles)
        System.out.flush();
        
        System.out.println("\n\n");
        System.out.println(colurs.spc2 + colurs.bgBlue + colurs.brightWhite + colurs.bold + "  MATH QUIZ CHALLENGE  " + colurs.reset);
        System.out.println(colurs.spc2 + colurs.cyan + "    Test your brain!   " + colurs.reset);
        System.out.println("\n");
        
        // Use the loading effect from colurs class
        System.out.print(colurs.spc2);
        colurs.loading("Generating Questions");
	scanner.nextLine();
        System.out.println("\n");

        for (int i = 1; i <= totalQuestions; i++) {
            
            // Generate Question
            int num1 = random.nextInt(90) + 10; 
            int num2 = random.nextInt(90) + 10;
            int type = random.nextInt(3); // 0:+, 1:-, 2:*
            
            String op = "";
            int correct = 0;

            if (type == 0) { op = "+"; correct = num1 + num2; }
            else if (type == 1) { op = "-"; correct = num1 - num2; }
            else { op = "*"; correct = num1 * num2; }

            // --- STYLED QUESTION PRINTING ---
            System.out.println(colurs.yellow + "------------------------------------------------" + colurs.reset);
            String qText = colurs.cyan + "Question " + i + ": " + colurs.reset;
            String mathText = colurs.bold + colurs.brightWhite + num1 + " " + colurs.brightPurple + op + colurs.brightWhite + " " + num2 + colurs.reset;
            
            System.out.print(qText + mathText + colurs.bold + colurs.yellow + " = " + colurs.reset);

            // Input
            String input = scanner.nextLine();

            // Check Answer
            try {
                int ans = Integer.parseInt(input.trim());
                if (ans == correct) {
                    qzobj.qzscore++;
                    // Green Text for correct
                    System.out.println(colurs.brightGreen + "   >>> Correct! " + colurs.reset + "Score: " + qzobj.qzscore);
                } else {
                    // Red Text for wrong
                    System.out.println(colurs.brightRed + "   >>> Wrong! " + colurs.reset + "The answer was: " + colurs.bold + correct + colurs.reset);
                }
            } catch (NumberFormatException e) {
                System.out.println(colurs.bgRed + colurs.brightWhite + "   INVALID INPUT   " + colurs.reset + " (Answer was " + correct + ")");
            }
            
            System.out.println(); 
        }

        // --- FINAL RESULTS WITH EFFECTS ---
        System.out.println("\n" + colurs.spc2 + colurs.bgWhite + colurs.black + "    FINAL RESULTS    " + colurs.reset);
        
        // Typewriter effect for calculation
        System.out.print(colurs.spc2);
        colurs.typeWriter(colurs.cyan + "Calculating your score..." + colurs.reset, 50);

        System.out.println();

        if (qzobj.qzscore >= 8) {
            // High score gets Gold Shine!
            colurs.goldShine(colurs.spc2 + " EXCELLENT! " + qzobj.qzscore + " / " + totalQuestions + " ");
        } else if (qzobj.qzscore >= 5) {
            // Medium score
            System.out.println(colurs.spc2 + colurs.brightYellow + "Good Job! " + qzobj.qzscore + " / " + totalQuestions + colurs.reset);
        } else {
            // Low score
            System.out.println(colurs.spc2 + colurs.red + "Game Over. " + qzobj.qzscore + " / " + totalQuestions + colurs.reset);
        }
        
        System.out.println("\n" + colurs.spc2 + "========================");
      	return qzobj.qzscore;
    }
}


public class Game{ 
    public int gamer() {

	int finalscore=GB.gbobj.gamescore+MathQuizFinal.qzobj.qzscore;


        while(true) {
            System.out.println("\n\n");
            System.out.println(colurs.spc2+colurs.brightGreen+"==============================="+colurs.reset);
            System.out.println(colurs.spc2+colurs.brightRed+"      JAVA GAMING       "+colurs.reset);
            System.out.println(colurs.spc2+colurs.brightGreen+"==============================="+colurs.reset);
            System.out.println(colurs.spc2+colurs.brightWhite+"1. GOLD MINE GAME"+colurs.reset);
            System.out.println(colurs.spc2+colurs.brightWhite+"2. MATH QUIZ"+colurs.reset);
            System.out.println(colurs.spc2+colurs.brightWhite+"3. EXIT"+colurs.reset);
            System.out.println(colurs.spc2+colurs.brightGreen+"-------------------------------"+colurs.reset);
            System.out.print("Select a game: ");

	
		
	
            if (colurs.sc.hasNextInt()) {
                int choice1 = colurs.sc.nextInt();
                switch(choice1) {
                    case 1: finalscore+=GB.main1(); break;
                    case 2: finalscore+=MathQuizFinal.main2(); break;
                    case 3: 
                         return finalscore;
                    default:
                        System.out.println("Invalid Option");
                }
            }
		else {
                	colurs.sc.next(); 
               		System.out.println("Please enter a number.");
            	}
        }
	
    }
}

	