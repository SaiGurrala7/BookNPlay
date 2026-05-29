
package travel;
import java.util.Scanner;

class UI {

    public static Scanner sc = new Scanner(System.in);

	public static String spc1 = "\n\t\t\t\t\t";
	public static String spc2 = "\t\t\t\t\t\t";

    // RESET
    public static  String reset = "\u001B[0m";

    // TEXT COLORS
    public static String black = "\u001B[30m";
    public static String red = "\u001B[31m";
    public static String green = "\u001B[32m";
    public static String yellow = "\u001B[33m";
    public static String blue = "\u001B[34m";
    public static String purple = "\u001B[35m";
    public static  String cyan = "\u001B[36m";
    public static  String white = "\u001B[37m";

    // BRIGHT TEXT
    public static String brightRed = "\u001B[91m";
    public static  String brightGreen = "\u001B[92m";
    public static  String brightYellow = "\u001B[93m";
    public static  String brightBlue = "\u001B[94m";
    public static  String brightPurple = "\u001B[95m";
    public static  String brightCyan = "\u001B[96m";
    public static  String brightWhite = "\u001B[97m";

    // BACKGROUND COLORS
    public static  String bgBlack = "\u001B[40m";
    public static  String bgRed = "\u001B[41m";
    public static  String bgGreen = "\u001B[42m";
    public static  String bgYellow = "\u001B[43m";
    public static  String bgBlue = "\u001B[44m";
    public static  String bgPurple = "\u001B[45m";
    public static  String bgCyan = "\u001B[46m";
    public static  String bgWhite = "\u001B[47m";

    // BRIGHT BACKGROUND
    public static  String bgBrightRed = "\u001B[101m";
    public static  String bgBrightGreen = "\u001B[102m";
    public static  String bgBrightYellow = "\u001B[103m";
    public static  String bgBrightBlue = "\u001B[104m";
    public static  String bgBrightPurple = "\u001B[105m";
    public static  String bgBrightCyan = "\u001B[106m";
    public static  String bgBrightWhite = "\u001B[107m";

    // TEXT EFFECTS
    public static  String bold = "\u001B[1m";
    public static  String underline = "\u001B[4m";
    public static  String blink = "\u001B[5m";

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

	public static void waveText(String msg) {
    for (int i = 0; i < 10; i++) {
        System.out.print("\r");
        for (int s = 0; s < i; s++) System.out.print(" ");
        System.out.print(brightCyan + bold + msg + reset);
        sleep(120);
    }
    System.out.println();
}

	public static void glitch(String msg) {
    String[] junk = {"#", "@", "$", "%", "&", "!"};
    for (int i = 0; i < 6; i++) {
        StringBuilder g = new StringBuilder();
        for (char c : msg.toCharArray()) {
            if (Math.random() > 0.7)
                g.append(junk[(int)(Math.random()*junk.length)]);
            else
                g.append(c);
        }
        System.out.print("\r" + brightPurple + bold + g + reset);
        sleep(120);
    }
    System.out.println("\r" + brightWhite + bold + msg + reset);
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

	public static void fireText(String msg) {
    String[] fire = {red, brightRed, yellow, brightYellow};
    for (int i = 0; i < 4; i++) {
        for (String f : fire) {
            System.out.print("\r" + f + bold + msg + reset);
            sleep(120);
        }
    }
    System.out.println();
	}
}



 abstract class Travel {
    String from, to;
    int tickets;

    Travel(String from, String to, int tickets) {
        this.from = from;
        this.to = to;
        this.tickets = tickets;
    }

    abstract int pricePerTicket();      

    public int totalPrice() {           
        return pricePerTicket() * tickets;
    }
}

class Bus extends Travel {

    Bus(String from, String to, int tickets) {
        super(from, to, tickets);
    }

    int pricePerTicket() {
        if (route("Hyderabad","Bangalore")) return 800;
        if (route("Hyderabad","Vizag")) return 700;
        if (route("Bangalore","Vizag")) return 900;
        return 0;
    }

    boolean route(String a, String b) {
        return (from.equals(a) && to.equals(b)) || (from.equals(b) && to.equals(a));
    }
}

class Train extends Travel {

    Train(String from, String to, int tickets) {
        super(from, to, tickets);
    }

    int pricePerTicket() {
        if (route("Hyderabad","Bangalore")) return 600;
        if (route("Hyderabad","Vizag")) return 500;
        if (route("Bangalore","Vizag")) return 700;
        return 0;
    }

    boolean route(String a, String b) {
        return (from.equals(a) && to.equals(b)) || (from.equals(b) && to.equals(a));
    }
}


class Flight extends Travel {

    Flight(String from, String to, int tickets) {
        super(from, to, tickets);
    }

    int pricePerTicket() {
        if (route("Hyderabad","Bangalore")) return 3000;
        if (route("Hyderabad","Vizag")) return 2500;
        if (route("Bangalore","Vizag")) return 3500;
        return 0;
    }

    boolean route(String a, String b) {
        return (from.equals(a) && to.equals(b)) || (from.equals(b) && to.equals(a));
    }
}

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static int main(int Score) {

        //System.out.println("===== TRAVEL BOOKING SYSTEM =====");
	UI.loading("Opening Travel Module");
        UI.fireText("===== TRAVEL BOOKING SYSTEM =====");
        
 	System.out.println(UI.brightBlue + UI.bold +"\nChoose Mode" + UI.reset);
        System.out.println(UI.cyan + "1. Bus" + UI.reset);
        System.out.println(UI.cyan + "2. Train" + UI.reset);
        System.out.println(UI.cyan + "3. Flight" + UI.reset);
        System.out.print(UI.yellow + "Enter choice : " + UI.reset);

        int choice = sc.nextInt();
        if(choice==1 ||(choice==2||choice==3))
	{
        
      	 UI.waveText("SELECT SOURCE CITY");
        System.out.println(UI.green + "1. Hyderabad" + UI.reset);
        System.out.println(UI.green + "2. Bangalore" + UI.reset);
        System.out.println(UI.green + "3. Vizag" + UI.reset);

        String from = city(sc.nextInt());

        UI.waveText("Choose Destination City:");
        System.out.println(UI.green + "1. Hyderabad" + UI.reset);
        System.out.println(UI.green + "2. Bangalore" + UI.reset);
        System.out.println(UI.green + "3. Vizag" + UI.reset);
        String to = city(sc.nextInt());

        if (from.equals(to)) {
           System.out.println(UI.brightRed + "Source and Destination cannot be same!" + UI.reset);
        }

	System.out.print(UI.brightWhite + "Enter No. of Tickets : " + UI.reset);
        int t = sc.nextInt();

        Travel travel = null;

      
        switch (choice) {
            case 1:
                travel = new Bus(from, to, t);
                break;
            case 2:
                travel = new Train(from, to, t);
                break;
            case 3:
                travel = new Flight(from, to, t);
                break;

        	}
	
          System.out.println(UI.brightPurple +"\nYou have redeem points : " + Score + UI.reset);
        	System.out.print(UI.yellow + "Use points? (1.Yes / 2.No) : " + UI.reset);
         int ssc=sc.nextInt();
	 // Output
       UI.goldShine("TICKET DETAILS");

        System.out.println(UI.brightCyan + "Mode     : " + UI.white +travel.getClass().getSimpleName() + UI.reset);
        System.out.println(UI.brightCyan + "From     : " + UI.white + travel.from + UI.reset);
        System.out.println(UI.brightCyan + "To       : " + UI.white + travel.to + UI.reset);
        System.out.println(UI.brightCyan + "Tickets  : " + UI.white + travel.tickets + UI.reset);
        System.out.println(UI.brightCyan + "Price/1  : " + UI.white +"Rs." + travel.pricePerTicket() + UI.reset);
	
        if(ssc==1)
	{
		   int discount = Score * 3;
            int total = travel.totalPrice() - discount;
            if (total < 0) total = 0;
            System.out.println(UI.green + "Discount : Rs." + discount + UI.reset);
            System.out.println(UI.brightGreen + UI.bold +
                    "TOTAL    : Rs." + total + UI.reset);
            Score = 0;
	}
        else if(ssc==2)
	{
		 System.out.println(UI.brightGreen + UI.bold +
                    "TOTAL    : Rs." + travel.totalPrice() + UI.reset);
	}
        System.out.println(" =========================== ");
        }
        else
	{
                System.out.println("Invalid choice!");
                main(Score);
	}
        return Score;
    }

    static String city(int c) {
        if (c == 1) return "Hyderabad";
        if (c == 2) return "Bangalore";
        return "Vizag";
    }
}
