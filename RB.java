package room;
import java.util.Scanner;

public class RB {
    
    // --- COLOR CODES ---
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE_BOLD = "\033[1;37m";

    static String city = "";
    static String hotelname = "";
    static int roomnumber;
    static String roomtype;
    static double amount = 0.0;
    static String customername = "";

    static Scanner sc = new Scanner(System.in);

    // --- EFFECT: TYPEWRITER ---
    static void typeEffect(String text) {
        for (char c : text.toCharArray()) {
            System.out.print(c);
            try {
                Thread.sleep(20); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }

    // --- CORE LOGIC ---
    static int bookRoom(String selectedCity, String selectedHotel, int Score) {
        while (true) {
            System.out.println("\n" + CYAN + "=== AVAILABLE ROOMS IN " + selectedHotel + " ===" + RESET);
            System.out.println(WHITE_BOLD + "101, 102, 103" + RESET + " - Single Room  = " + GREEN + "1200/-" + RESET);
            System.out.println(WHITE_BOLD + "201, 202" + RESET + "      - Double Room  = " + GREEN + "2000/-" + RESET);
            System.out.println(WHITE_BOLD + "301, 302" + RESET + "      - Suite Room   = " + GREEN + "3500/-" + RESET);
            System.out.println(WHITE_BOLD + "401" + RESET + "           - Party Room   = " + GREEN + "5000/-" + RESET);
            System.out.println(RED + "0             - Back to Hotel Menu" + RESET);

            System.out.print(YELLOW + "Enter Room Number: " + RESET);
            int roomchoice = sc.nextInt();
            
            amount = 0.0; 

            switch (roomchoice) {
                case 101: case 102: case 103:
                    roomtype = "Single Room";
                    amount = 1200.0;
                    break;
                case 201: case 202:
                    roomtype = "Double Room";
                    amount = 2000.0;
                    break;
                case 301: case 302:
                    roomtype = "Suite Room";
                    amount = 3500.0;
                    break;
                case 401:
                    roomtype = "Party Room";
                    amount = 5000.0;
                    break;
                default:
                    System.out.println(RED + "INVALID ROOM CHOICE, TRY AGAIN" + RESET);
                    continue; 
            }

            city = selectedCity;
            hotelname = selectedHotel;
            roomnumber = roomchoice;
            
            Score=printBill(Score);
            return Score; 
        }
    }

    static int printBill(int Score) {
        System.out.println();
        typeEffect(GREEN + "Generating Receipt..." + RESET);
        try { Thread.sleep(1000); } catch(Exception e){} 

         System.out.println("You have redeem points  "+Score+" Do you want to use ");
	 System.out.print("1.Yes \t 2.No : ");
         int ssc=sc.nextInt();
        System.out.println(YELLOW + "+==========================================+" + RESET);
        System.out.println(YELLOW + "|           " + CYAN + "ROOM BOOKING CONFIRMED" + YELLOW + "         |" + RESET);
        System.out.println(YELLOW + "+==========================================+" + RESET);
        System.out.println(YELLOW + "| " + WHITE_BOLD + "Name      : " + RESET + String.format("%-26s", customername) + YELLOW + " |" + RESET);
        System.out.println(YELLOW + "| " + WHITE_BOLD + "City      : " + RESET + String.format("%-26s", city) + YELLOW + " |" + RESET);
        System.out.println(YELLOW + "| " + WHITE_BOLD + "Hotel     : " + RESET + String.format("%-26s", hotelname) + YELLOW + " |" + RESET);
        System.out.println(YELLOW + "| " + WHITE_BOLD + "Room No   : " + RESET + String.format("%-26s", roomnumber) + YELLOW + " |" + RESET);
        System.out.println(YELLOW + "| " + WHITE_BOLD + "Room Type : " + RESET + String.format("%-26s", roomtype) + YELLOW + " |" + RESET);
        System.out.println(YELLOW + "+==========================================+" + RESET);
	if(ssc==1)
	{
		        System.out.println(YELLOW + "| " + GREEN + "TOTAL     : " + (amount-(Score*3)) + "/-                   " + YELLOW + " |" + RESET);
			Score=0;
	}
	else if(ssc==2)
	{
		        System.out.println(YELLOW + "| " + GREEN + "TOTAL     : " + amount + "/-                   " + YELLOW + " |" + RESET);
	}
        System.out.println(YELLOW + "+==========================================+" + RESET);
        System.out.println(PURPLE + "\nThank you for choosing us, " + customername + "!" + RESET);
	return Score;
    }

    static int hyderabadMenu(int Score) {
        while (true) {
            System.out.println("\n" + BLUE + "--- HOTELS IN HYDERABAD ---" + RESET);
            System.out.println("1. Novotel Hyderabad");
            System.out.println("2. Taj Hotel Hyderabad");
            System.out.println("3. ITC Kakatiya Hyderabad");
            System.out.println(RED + "4. Back" + RESET);
            System.out.print(YELLOW + "Choose Hotel: " + RESET);

            int choice = sc.nextInt();
            switch (choice) {
                case 1: Score=bookRoom("HYDERABAD", "Novotel Hyderabad",Score); break;
                case 2: Score=bookRoom("HYDERABAD", "Taj Hotel Hyderabad",Score); break;
                case 3: Score=bookRoom("HYDERABAD", "ITC Kakatiya Hyderabad",Score); break;
                default: System.out.println(RED + "Invalid Choice" + RESET);break;
            }
		break;
        }
	return Score;
    }

    static int bangaloreMenu(int Score) {
        while (true) {
            System.out.println("\n" + BLUE + "--- HOTELS IN BANGALORE ---" + RESET);
            System.out.println("1. Novotel Bangalore");
            System.out.println("2. Taj Hotel Bangalore");
            System.out.println("3. ITC Kakatiya Bangalore");
            System.out.println(RED + "4. Back" + RESET);
            System.out.print(YELLOW + "Choose Hotel: " + RESET);

            int choice = sc.nextInt();
            switch (choice) {
                case 1: Score=bookRoom("BANGALORE", "Novotel Bangalore",Score); break;
                case 2: Score=bookRoom("BANGALORE", "Taj Hotel Bangalore",Score); break;
                case 3: Score=bookRoom("BANGALORE", "ITC Kakatiya Bangalore",Score); break;
                default: System.out.println(RED + "Invalid Choice" + RESET);break;
            }
	break;
        }
	return Score;
    }

    static int vizagMenu(int Score) {
        while (true) {
            System.out.println("\n" + BLUE + "--- HOTELS IN VIZAG ---" + RESET);
            System.out.println("1. Novotel Vizag");
            System.out.println("2. Taj Hotel Vizag");
            System.out.println("3. ITC Kakatiya Vizag");
            System.out.println(RED + "4. Back" + RESET);
            System.out.print(YELLOW + "Choose Hotel: " + RESET);

            int choice = sc.nextInt();
            switch (choice) {
                case 1: Score=bookRoom("VIZAG", "Novotel Vizag",Score); break;
                case 2: Score=bookRoom("VIZAG", "Taj Hotel Vizag",Score); break;
                case 3: Score=bookRoom("VIZAG", "ITC Kakatiya Vizag",Score); break;
                case 4: return vizagMenu(Score);
                default: System.out.println(RED + "Invalid Choice" + RESET);break;
            }
	break;
        }
	return Score;
    }

    static int startBooking(int Score) {
        while (true) {
            System.out.println("\n" + PURPLE + "=================================" + RESET);
            System.out.println(CYAN + "      CHOOSE CITY FOR BOOKING     " + RESET);
            System.out.println(PURPLE + "=================================" + RESET);
            System.out.println("1. HYDERABAD");
            System.out.println("2. BANGALORE");
            System.out.println("3. VIZAG");
            System.out.println(RED + "4. Exit App" + RESET);
            System.out.print(YELLOW + "Enter Choice: " + RESET);

            int choicecity = sc.nextInt();

            switch (choicecity) {
                case 1: Score=hyderabadMenu(Score); break;
                case 2: Score=bangaloreMenu(Score); break;
                case 3: Score=vizagMenu(Score); break;
                case 4: 
                    typeEffect(PURPLE + "Closing Application... Goodbye!" + RESET);
                    System.exit(0);
                default: System.out.println(RED + "INVALID CHOICE" + RESET);
            }
	break;
        }
	return Score;
    }

    public  int main1(int Score) {
        System.out.println(CYAN + "=================================" + RESET);
        typeEffect(YELLOW + "   WELCOME TO HOTEL BOOKING APP  " + RESET);
        System.out.println(CYAN + "=================================" + RESET);

        System.out.print(WHITE_BOLD + "ENTER YOUR NAME: " + RESET);
        customername = sc.next(); 

        typeEffect(GREEN + "Login successful..." + RESET);
        typeEffect("Welcome, " + WHITE_BOLD + customername + RESET);
        
        startBooking(Score);
	return Score;
    }
}