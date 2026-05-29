package user;
import java.util.Scanner;
import travel.*;
import room.*;
import movie.*;
import game.*;

class InvalidException extends Exception
{
	InvalidException(String Msg)
	{
		super(Msg);
	}
}

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
        sleep(180);
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



class Authentication {
    private String User_Name;
    private String Email;
    private long Mobile_No;
    private double Balance;
    private String Address;
    private int Age;
    private String Password;
    private String Pin;

    Authentication(String User_Name, String Email, long Mobile_No, String Address, int Age, String Password) {
        this.User_Name = User_Name;
        this.Email = Email;
        this.Mobile_No = Mobile_No;
        this.Balance = 5000;
        this.Address = Address;
        this.Age = Age;
        this.Password = Password;
        this.Pin = "0000";
    }

    // Setters
    void setUser_Name(String User_Name) { this.User_Name = User_Name; }
    void setEmail(String Email) { this.Email = Email; }
    void setMobile_No(long Mobile_No) { this.Mobile_No = Mobile_No; }
    void setBalance(double Balance) { this.Balance = Balance; }
    void setAge(int Age) { this.Age = Age; }
    void setAddress(String Address) { this.Address = Address; }
    void setPassword(String Password) { this.Password = Password; }

    // Getters
    String getUser_Name() { return User_Name; }
    String getEmail() { return Email; }
    long getMobile_No() { return Mobile_No; }
    double getBalance() { return Balance; }
    String getAddress() { return Address; }
    int getAge() { return Age; }
    String getPassword() { return Password; }
    String getPin() { return Pin; }
}

public class Home1 extends Authentication {
    static Scanner sc = new Scanner(System.in);
    int c = 0;
    int fr = 0;
    int k;

    Home1() {
        super(sc.next(), sc.next(), sc.nextLong(), sc.next(), sc.nextInt(), sc.next());
    }

    boolean Login() {
        System.out.print(UI.brightCyan + "Enter Email_id / Mobile_Number : " + UI.reset);
        String Id = sc.next();
        String em = getEmail();
        long mb = getMobile_No();
        String check = "";
        if (Id.contains("@")) {
            check = em;
        } else if (Id.length() == 10 && Id.matches("\\d+")) {
            check = "" + mb;
        }
        System.out.print(UI.brightCyan + "Enter the password : " + UI.reset);
        String pass = sc.next();

        if (Id.equals(check) && pass.equals(getPassword())) {
            return true;
        } else {
            this.c += 1;
            if (c < 3) {
                System.out.println(UI.red + "-------- Entered details are invalid (" + (3 - c) + " attempts left) -----" + UI.reset);
                return Login();
            } else {
                return false;
            }
        }
    }

    void SignUp() {
        System.out.println(UI.brightYellow + "\n--- Registration Page ---" + UI.reset);
        System.out.print("Enter the Name : "); setUser_Name(sc.next());
        System.out.print("Enter the Email_Id : "); setEmail(sc.next());
        System.out.print("Enter the Mobile_No : "); setMobile_No(sc.nextLong());
        System.out.print("Enter the Address : "); setAddress(sc.next());
        System.out.print("Enter the Age : "); setAge(sc.nextInt());
        System.out.print("Enter the Password : "); setPassword(sc.next());
        
        System.out.println(UI.green + "------ Registration Successful ------" + UI.reset);
        boolean r = Login();
        if (r) {
            this.c = 0;
            System.out.println(UI.bgGreen + UI.black + " ---- Login Successful ---- " + UI.reset);
        } else {
            this.c = 0;
            System.out.println(UI.bgRed + " - - - - Too many attempts try after Some time - - - - " + UI.reset);
        }
    }

    boolean Otp() {
        int h = 1000 + (int) (Math.random() * 9000);
        System.out.println(UI.brightYellow + "OTP: " + h + UI.reset);
        System.out.print("Enter OTP: ");
        int i = sc.nextInt();
        return i == h;
    }

    boolean forgotpass() {
        System.out.print("Enter the Email_id / Mobile_Number : ");
        String Id = sc.next();
        String check = (Id.contains("@")) ? getEmail() : "" + getMobile_No();

        if (Id.equals(check)) {
            if (Otp()) {
                System.out.print(UI.brightCyan + "Enter new pass: " + UI.reset);
                setPassword(sc.next());
                return true;
            }
        }
        return false;
    }
}

class User {
    public static void main(String args[])throws Exception {
        System.out.println(UI.yellow + "ENTER DETAILS:- " + UI.reset);
	System.out.println(UI.yellow + "1.Enter Name" + UI.reset);
	System.out.println(UI.yellow + "2.Email" + UI.reset);
	System.out.println(UI.yellow + "3.Mobile" + UI.reset);
	System.out.println(UI.yellow + "4.Address" + UI.reset);
	System.out.println(UI.yellow + "5.Age" + UI.reset);
	System.out.println(UI.yellow + "6.Password" + UI.reset);
        Home1 h = new Home1();

         System.out.println(UI.cyan+UI.bold+"==============================");

       // UI.fireText("BOOKNPLAY");
	//UI.waveText("BOOKNPLAY");
	//UI.boxTitle("BOOKNPLAY");
	System.out.print("\t\t\t.");
	UI.glitch("BOOKNPLAY");
        System.out.println(UI.cyan+"=============================="+UI.reset);
        
        boolean exit = false;
        while (!exit) {
            System.out.println(UI.brightPurple + "\nSelect an operation:" + UI.reset);
            System.out.println(UI.white+" 1. Login\n 2. SignUp\n 3. Forgotten Password\n 4. Exit"+UI.reset);
            System.out.print(UI.bold + "Enter an operation to Proceed : " + UI.reset);
            
            int k = Home.sc.nextInt();
            int proceed = 0;
            int Score = 10;

            if (k == 1) {
                if (h.Login()) {
                    h.c = 0; proceed = 1;
                    System.out.println(UI.bgGreen + UI.black + " ==== Login Successful ==== " + UI.reset);
                } else {
                    h.c = 0;
                    System.out.println(UI.bgRed + " - - - - Too many attempts try after Some time - - - - " + UI.reset);
                }
            } else if (k == 2) {
                h.SignUp();
                proceed = 1;
            } else if (k == 3) {
                if (h.forgotpass()) {
                    System.out.println(UI.green + "---- Password reset Successful ----" + UI.reset);
                    if (h.Login()) { h.c = 0; proceed = 1; }
                } else {
                    System.out.println(UI.red + "Failed to reset password." + UI.reset);
                }
            } else if (k == 4) {
                System.out.println(UI.cyan + "- - - - - - Thank You - - - - - -" + UI.reset);
                return;
            }
	    else
	    {
		h.k+=1;
			System.out.print(h.k);
			System.out.println("Entered Invalid Operatior");
		if(h.k==3)
		{
			System.out.print(h.k);
			InvalidException ie=new InvalidException("Invalid operation");
			throw ie;
		}	
	    }


            if (proceed > 0) {
		h.k=0;
                while (true) {
                    System.out.println(UI.brightYellow + "\n--- MAIN MENU ---" + UI.reset);
		
                   //System.out.println(Colurs.brightPurple + Colurs.bold +"\n========== MAIN MENU ==========" + Colurs.reset);

			System.out.println(UI.brightWhite + "1. Travel Booking" + UI.reset);
			System.out.println(UI.brightWhite + "2. Room Booking" + UI.reset);
			System.out.println(UI.brightWhite + "3. Movie Booking" + UI.reset);
			System.out.println(UI.brightWhite + "4. Play Games" + UI.reset);
			System.out.println(UI.red  + "5. Exit" + UI.reset);

			System.out.print(UI.yellow + "Choose an option : " + UI.reset);


			
                    int pof = Home.sc.nextInt();
                    if (pof == 1) { Main m = new Main(); Score = m.main(Score); }
                    else if (pof == 2) { RB r = new RB(); Score = r.main1(Score); }
                    else if (pof == 3) { Mov mv = new Mov(); Score = mv.main2(Score); }
                    else if (pof == 4) { 
				Game gme = new Game();
				 Score += gme.gamer(); 	
				System.out.println(UI.brightWhite+"your Score is :"+Score+UI.reset);
		}
                    else if(pof ==5){
                        System.out.println(UI.spc1 + UI.bgBlue + " ==== Thank You ==== " + UI.reset);
                        break;
                    }
	     else
	    {
		h.k+=1;
			System.out.print(h.k);
			System.out.println("Entered Invalid Operatior");
		if(h.k==3)
		{
			System.out.print(h.k);
			InvalidException ie=new InvalidException("Invalid operation");
			throw ie;
		}	
	    }

                }
            }
        }
    }
}