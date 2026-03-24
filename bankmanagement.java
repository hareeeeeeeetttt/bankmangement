package proee;
import java.util.*;

class BankSystem {
    private String username = "hari";
    private int password = 123456;
    private double balance = 1000;

    Scanner sc = new Scanner(System.in);

    // Login Method
    boolean login() {
        System.out.print("Enter Username: ");
        String user = sc.nextLine();

        System.out.print("Enter Password: ");
        int  pass = sc.nextInt();

        if (user.equals(username) && pass==(password)) {
            System.out.println("Login Successful!");
            return true;
        } else {
            System.out.println("Invalid Credentials!");
            return false;
        }
    }

    // OTP Generation
    int generateOTP() {
        Random rand = new Random();
        int otp = 1000 + rand.nextInt(9000);
        System.out.println("Generated OTP: " + otp); // In real app, send via SMS/Email
        return otp;
    }

    // OTP Verification
    boolean verifyOTP(int otp) {
        System.out.print("Enter OTP: ");
        int userOTP = sc.nextInt();

        if (userOTP == otp) {
            System.out.println("OTP Verified!");
            return true;
        } else {
            System.out.println("Invalid OTP!");
            return false;
        }
    }

    // Banking Menu
    void menu() {
        while (true) {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount: ");
                    double deposit = sc.nextDouble();
                    balance += deposit;
                    System.out.println("Deposited: " + deposit);
                    break;

                case 2:
                    System.out.print("Enter amount: ");
                    double withdraw = sc.nextDouble();
                    if (withdraw <= balance) {
                        balance -= withdraw;
                        System.out.println("Withdrawn: " + withdraw);
                    } else {
                        System.out.println("Insufficient Balance!");
                    }
                    break;

                case 3:
                    System.out.println("Current Balance: " + balance);
                    break;

                case 4:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
public class bankmanagement {
	   public static void main(String[] args) {
	        BankSystem bank = new BankSystem();

	        if (bank.login()) {
	            int otp = bank.generateOTP();

	            if (bank.verifyOTP(otp)) {
	                bank.menu();
	            } else {
	                System.out.println("Access Denied!");
	            }
	        } else {
	            System.out.println("Login Failed!");
	        }
	    }

}
