package movie;
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
// ====== ABSTRACT CLASS ======
abstract class Movie {
    String movieName, showTime;
    int tickets;

    Movie(String movieName, String showTime, int tickets) {
        this.movieName = movieName;
        this.showTime = showTime;
        this.tickets = tickets;
    }

    abstract int pricePerTicket();

    int totalPrice() {
        return pricePerTicket() * tickets;
    }
}

// ====== NORMAL MOVIE ======
class NormalMovie extends Movie {
    NormalMovie(String movieName, String showTime, int tickets) {
        super(movieName, showTime, tickets);
    }
    int pricePerTicket() {
        return 150;
    }
}

// ====== 3D MOVIE ======
class Movie3D extends Movie {
    Movie3D(String movieName, String showTime, int tickets) {
        super(movieName, showTime, tickets);
    }
    int pricePerTicket() {
        return 250;
    }
}

// ====== IMAX MOVIE ======
class IMAXMovie extends Movie {
    IMAXMovie(String movieName, String showTime, int tickets) {
        super(movieName, showTime, tickets);
    }
    int pricePerTicket() {
        return 350;
    }
}

// ====== MAIN CLASS ======
public class Mov {

    static Scanner sc = new Scanner(System.in);

    // ====== MOVIE MENU ======
    public static int main2(int Score) {

        while (true) {
		//UI.loading("Loading Movie Section");
		System.out.println();
		
		UI.fireText("=== MOVIE BOOKING SYSTEM === ");
		//UI.goldShine("MOVIE BOOKING SYSTEM");

	System.out.println(UI.brightBlue + UI.bold +"\n========= MOVIE MENU =========" + UI.reset);

	System.out.println(UI.cyan + "1. Browse Movies" + UI.reset);
	System.out.println(UI.cyan + "2. View Shows" + UI.reset);
	System.out.println(UI.cyan + "3. Book Tickets" + UI.reset);
	System.out.println(UI.red  + "4. Exit" + UI.reset);

	System.out.print(UI.yellow + "Choose Option : " + UI.reset);


            int option = sc.nextInt();

            switch (option) {
                case 1:
                    browseMovies();
                    break;

                case 2:
                    viewShows();
                    break;

                case 3:
                    Score = bookTickets(Score);
                    break;

                case 4:
                    System.out.println("Returning to Main Menu...");
                    return Score;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }

    // ====== BROWSE MOVIES ======
    static void browseMovies() {
     UI.waveText("MOVIES AVAILABLE");
	System.out.println(UI.brightYellow + "1. Pushpa 2" + UI.reset);
	System.out.println(UI.brightYellow + "2. Salaar" + UI.reset);
	System.out.println(UI.brightYellow + "3. Avatar" + UI.reset);

    }

    // ====== VIEW SHOWS ======
    static void viewShows() {
        
	System.out.println("\n--- Show Timings ---");
	System.out.println(UI.green + "1. Morning    10:00 AM" + UI.reset);
	System.out.println(UI.green + "2. Afternoon  2:00 PM" + UI.reset);
	System.out.println(UI.green + "3. Night      7:00 PM" + UI.reset);

    }

    // ====== BOOK TICKETS ======
    static int bookTickets(int Score) {

        System.out.println("\nChoose Movie:");
        browseMovies();
        int m = sc.nextInt();
        String movie = getMovie(m);

        System.out.println("\nChoose Show Time:");
        viewShows();
        int s = sc.nextInt();
        String show = getShow(s);

        UI.typeWriter("\nChoose Screen Type:", 40);
		System.out.println(UI.cyan + "1. Normal" + UI.reset);
		System.out.println(UI.brightPurple + "2. 3D" + UI.reset);
		System.out.println(UI.brightRed + "3. IMAX" + UI.reset);

        int type = sc.nextInt();

        System.out.print("Enter No. of Tickets: ");
        int t = sc.nextInt();

        Movie movieObj;

        switch (type) {
            case 1:
                movieObj = new NormalMovie(movie, show, t);
                break;
            case 2:
                movieObj = new Movie3D(movie, show, t);
                break;
            case 3:
                movieObj = new IMAXMovie(movie, show, t);
                break;
            default:
                System.out.println("Invalid screen type!");
                return Score;
        }

        System.out.println("\nYou have redeem points: " + Score);
        System.out.print("Do you want to use them? (1.Yes / 2.No): ");
        int use = sc.nextInt();

	UI.goldShine("BOOKING CONFIRMATION");

	System.out.println(UI.brightCyan + "Movie     : " + UI.white + movieObj.movieName + UI.reset);
	System.out.println(UI.brightCyan + "Show Time : " + UI.white + movieObj.showTime + UI.reset);
	System.out.println(UI.brightCyan + "Type      : " + UI.white + movieObj.getClass().getSimpleName() + UI.reset);
	System.out.println(UI.brightCyan + "Tickets   : " + UI.white + movieObj.tickets + UI.reset);
	System.out.println(UI.brightCyan + "Price/1   : " + UI.white + "Rs." + movieObj.pricePerTicket() + UI.reset);


        if (use == 1) {
            int discount = Score * 3;
            int total = movieObj.totalPrice() - discount;
            if (total < 0) total = 0;
            System.out.println("Discount  : Rs." + discount);
            System.out.println("Total     : Rs." + total);
            Score = 0;
        } else {
            System.out.println(UI.brightGreen + UI.bold +"TOTAL PAYABLE : Rs." + movieObj.totalPrice() + UI.reset);

        }

        System.out.println("================================");
        return Score;
    }

    // ====== HELPERS ======
    static String getMovie(int m) {
        if (m == 1) return "Pushpa 2";
        if (m == 2) return "Salaar";
        return "Avatar";
    }

    static String getShow(int s) {
        if (s == 1) return "10:00 AM";
        if (s == 2) return "2:00 PM";
        return "7:00 PM";
    }
}
