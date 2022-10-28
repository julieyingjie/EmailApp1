import java.util.Map;
import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private String alternateEmail;
    private String companySuffix = "juliecompany.com";
    private int defaultPasswordLength = 10;


    // Constructor to receive the first name and last name
    public Email(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;

//        System.out.println("Email Created: " + this.firstName + " " + this.lastName);

        // call a method asking for the department - return the department
        this.department = setDepartment();
//        System.out.println("Department: " + this.department);

        // call a method that returns a random password
        this.password = randomPassword(defaultPasswordLength);
//        System.out.println("Your password is: " + this.password);

        // combine elements to generate email
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + this.department + "." + companySuffix;
        System.out.println("Your email is: " + this.email);

    }

    // Ask for the department
    private String setDepartment(){
        System.out.println("New worker: " + this.firstName + ". Department codes\n1 for Sales\n2 for Development\n3 for Accounting\n0 for None\n Enter the department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) { return "sales"; }
        else if (depChoice == 2) { return "devlopment"; }
        else if (depChoice == 3) { return "accounting"; }
        else {return "";}
    }

    // Generate a random password
    private String randomPassword(int length){
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
        char[] password = new char[length];
        for (int i = 0; i < length; i++){
           int rand =  (int) (Math.random() * passwordSet.length());
           password[i] = passwordSet.charAt(rand);
        }
        return new String(password);

    }

    // Set the mailbox capacity
    public void setMailboxCapacity(int capacity){
        this.mailboxCapacity = capacity;
    }

    // Set the alternate email
    public void setAlternateEmail(String altEmail){
        this.alternateEmail = altEmail;
    }

    // Change the password
    public void changePassword(String password){
        this.password = password;
    }

    public int getMailboxCapacity(){return this.mailboxCapacity;}
    public String getAlternateEmail(){return this.alternateEmail;}
    public String getPassword(){return this.password;}

    public String showInfo(){
        return "Display name: " + this.firstName + " " + this.lastName +
                "\nComany Email: " + email +
                "\nMailbox Capacity: " + mailboxCapacity + "mb";
    }



}
