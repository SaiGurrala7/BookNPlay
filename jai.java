import java.util.Scanner;
class Authentication
{
	private String User_Name;
	private String Email;
	private long Mobile_No;
	private double Balance;
	private String Address;
	private int Age;
	private String Password;
	private String Pin;

	
	Authentication(String User_Name,String Email,long Mobile_No,String Address,int Age,String Password)
	{
		this.User_Name=User_Name;
		this.Email=Email;
		this.Mobile_No=Mobile_No;
		this.Balance=5000;
		this.Address=Address;
		this.Age=Age;
		this.Password=Password;
		this.Pin="0000";
	}

	//Setter Methods

	void setUser_Name(String User_Name)
	{
		this.User_Name=User_Name;	
	}
	void setEmail(String Email)
	{
		this.Email=Email;
	}
	void setMobile_No(long Mobile_No)
	{
		this.Mobile_No=Mobile_No;	
	}
	void setBalance(double Balance)
	{
		this.Balance=Balance;
	}
	void setAge(int Age)
	{
		this.Age=Age;
	}
	void setAddress(String Address)
	{
		this.Address=Address;
	}	
	void setPassword(String Password)
	{
		this.Password=Password;
	}
	
	//getter Methods

	String getUser_Name()
	{
		return User_Name;
	}
	String getEmail()
	{
		return Email;
	}
	long getMobile_No()
	{
		return Mobile_No;
	}
	double getBalance()
	{
		return Balance;
	}
	String getAddress()
	{
		return Address;
	}
	int getAge()
	{
		return Age;
	}
	String getPassword()
	{
		return Password;
	}
	String getPin()
	{
		return Pin;
	}
}
class App
{
	static Scanner sc=new Scanner(System.in);
	Authentication authentication;
void logIn(){
		if(authentication==null){
		 System.out.println("Please Register First to Login");
		 signUp();
		}
		else{
			System.out.println(".... login....");
			System.out.println("Enter UserName:");
			String input1=sc.next();
			//System.out.println("Enter Password:");
			//String input2=sc.next();
			String username=authentication.getUser_Name();
			String password=authentication.getPassword();
			if(input1.equals(username))
			{
				int attempts=3;
				while(attempts>0){
				 System.out.println("Enter Password:");




				 String input2=sc.next();
				 if(input2.equals(password)){
					System.out.println("Login Successful:");	
					System.out.println("Welcome:"+username);
					return;
					}
				else{
					attempts--;
					if(attempts>0){
					 System.out.println("Incorrect password! Attempts left:"+attempts);

					}
				    }
				}
				System.out.println(input1+" Login Failed No more attempts left for you:"); 
			}
			else{
				System.out.println("No User found:"+input1);
				}
			} 
		}
void signUp(){
	System.out.print("User_Name:");
	String User_Name=sc.next();
	System.out.print("Email:");
	String Email=sc.next();
	System.out.print("Mobile_No:");
	Long Mobile_No=sc.nextLong(); 
	System.out.print("Address:");
	String Address=sc.next();
	System.out.print("Age:");
	int Age=sc.nextInt();
	System.out.print("Password:");
	String Password=sc.next();
	System.out.println("Please wait while we sign you up");

	authentication=new Authentication(User_Name,Email,Mobile_No,Address,Age,Password);

	System.out.println("User Registration Successful..");
	System.out.println("Please Login to continue");
	logIn();
	}		
	public static void main(String[] args){
	App app=new App();
	System.out.println("Wlecome to App");
	System.out.println("1. Login \n2. Signup");
	int input = sc.nextInt();
	switch(input){
		case 1:System.out.println("\n\n\nLogin Page");
			app.logIn(); break;
		case 2:System.out.println("\n\n\nSignUp page");
			app.signUp(); break;
		default:System.out.println("Invalid Input, please try again");
				main(args);
		}
	}
}

