import java.util.*;

interface MessagingService {
    
    void sendMessage();
}

class SMSMessagingService implements MessagingService {
    
    Scanner scan = new Scanner(System.in);

    public void sendMessage() {
        String regex = ("[6-9]{1}[0-9]{9}");
        System.out.print("Enter Phone Number : ");
        String number = scan.nextLine();

        if(number.matches(regex)) {
            
            System.out.print("\nEnter your message : ");
            String message = scan.nextLine();
            System.out.print("\nMessage sent \n");
        } else {
            System.out.println("Invalid Phonenumber\n");
        }
    }
}

class EmailMessagingService implements MessagingService {

    Scanner sc = new Scanner(System.in);
    
    public void sendMessage() {
        String mail,reciever,subject,message;
        String regex = ("^[a-zA-Z0-9]+@(.+).(.+)");
        System.out.print("Enter mail from : ");
        mail = sc.nextLine();

        if(mail.matches(regex)) {
            System.out.print("Enter mail To :  ");
            reciever = sc.nextLine();
            if(reciever.matches(regex)) {
                System.out.print("Enter Subject : ");
                subject = sc.nextLine();
                System.out.print("Enter message : ");
                message = sc.nextLine();
                System.out.println("\nmail sent\n");
            }
        } else {
            System.out.println("\nInvalid mail");
        }
    }
}

class WhatsAppMessagingService implements MessagingService {

    Scanner sc = new Scanner(System.in);

    public void sendMessage() {
        String regex = ("[6-9]{1}[0-9]{9}");
        System.out.print("Enter Mobile Number  : ");
        String number = sc.nextLine();
        if(number.matches(regex)) {
            System.out.print("Is the number Available in Whatsapp (y/n): ");
            String check = sc.nextLine();
            if(check.equals("y")) {
                System.out.print("Enter your Message : ");
                String message = sc.nextLine();
                System.out.println("whatsapp sent \n");
            } else {
                System.out.println("\nInvalid Whatsapp number...");
            }
        } else {
            System.out.println("\nInvalid Number");
        }
    }
}

public class Messenger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MessagingService SMS = new SMSMessagingService();
        MessagingService email = new EmailMessagingService();
        WhatsAppMessagingService whatsapp = new WhatsAppMessagingService();

        boolean check = true;
        while(check) {
            System.out.println("\n 1--> SMS service \n 2--> Email Service \n 3--> Whatsapp Service \n 4--> Exit");
            int n = sc.nextInt();

            switch(n) {
                case 1:
                    SMS.sendMessage();
                    break;
                
                case 2:
                    email.sendMessage();
                    break;

                case 3:
                    whatsapp.sendMessage();
                    break;

                case 4:
                    check = false;
                    System.out.println("Thank You");
                    break;
            }
        }
        sc.close();
    }
}
