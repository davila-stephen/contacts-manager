package ContactManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class contactsClass {

    // View contacts method
    public static void printContacts(Path filePath) throws IOException {
        List<String> fileContents = Files.readAllLines(filePath);
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%s\n", fileContents.get(i));
        }
    }

    // Search Method
    public static void searchMethod() throws IOException {
        Scanner sc = new Scanner(System.in);
        Path PathToContact = Paths.get("./src/ContactManager/contacts.txt");
        List<String> contactList = Files.readAllLines(PathToContact);

        String contactString = "";

        for (int a1 = 0; a1 < contactList.size(); a1 += 1){
            contactString += contactList.get(a1) + " ";
        }
        boolean looper2 = true;
        while (looper2) {
            System.out.println("Please type in the name of who you want search up.");
            String searchFirstName = sc.next();
            String searchLastName = sc.next();
            String searchFullName = searchFirstName + " " + searchLastName;

         if (!contactString.toLowerCase().contains(searchFullName.toLowerCase())){
                //for (int a = 0; a < contactList.size(); a += 1) {
                    //if (!contactList.get(a).toLowerCase().contains(searchFullName.toLowerCase())) {
                        System.out.println("Contact not found. Would you like to try and search again? Please input yes or no.");
                        boolean looper3 = true;
                        while (looper3) {
                            String option3YesNo = sc.next();
                            if (option3YesNo.equalsIgnoreCase("yes")) {
                                looper3 = false;
                                searchMethod();
                            } else if (option3YesNo.equalsIgnoreCase("no")) {
                                looper2 = false;
                                looper3 = false;
                            } else {
                                System.out.println("Try again.");
                                looper3 = true;
                            }
                        }
                    //}
                //}
            }
            if (contactString.toLowerCase().contains(searchFullName.toLowerCase())) {
                for (int i = 0; i < contactList.size(); i += 1) {
                    if (contactList.get(i).toLowerCase().contains(searchFullName.toLowerCase())) {
                        System.out.println(contactList.get(i));
                        System.out.println("There's your contact! would you like to search for a different one? Please type in yes or no.");
                        boolean looper4 = true;
                        while (looper4) {
                            String option3YesNo = sc.next();
                            if (option3YesNo.equalsIgnoreCase("yes")) {
                                looper4 = false;
                                searchMethod();
                            } else if (option3YesNo.equalsIgnoreCase("no")) {
                                looper2 = false;
                                looper4 = false;
                            } else {
                                System.out.println("Try again.");

                                looper4 = true;
                            }
                        }
                    }
                }
            }
        }
    }


    // Add a new contact


    public static void main(String[] args) throws IOException {
        Path PathToContact = Paths.get("./src/ContactManager/contacts.txt");

        System.out.println("Files.exists(PathToContact) = " + Files.exists(PathToContact));

        List<String> contactList = Files.readAllLines(PathToContact);


        System.out.println(contactList);
        Scanner sc = new Scanner(System.in);
        // Main Menu
        boolean looper = true;
        while (looper) {
            System.out.println("Main Menu:");
            System.out.println("1 - View contacts.");
            System.out.println("2 - Add a new contact.");
            System.out.println("3 - Search a contact by name.");
            System.out.println("4 - Delete an existing contact.");
            System.out.println("5 - Exit");
            int yOrN = sc.nextInt();
            if (yOrN == 1) {
                System.out.println("Name    | Phone Number");
                System.out.println("----------------------");
                printContacts(PathToContact);
            }
            else if (yOrN == 2) {
                System.out.println("Please type in contact first and last name");
                String contactFirstName = sc.next();
                String contactLastName = sc.next();
                System.out.println("Please enter phone number");
//                int userNumInput = sc.nextInt();
                long contactNumber = sc.nextLong();

                String contactFullName = contactFirstName + " " + contactLastName;
                String newContact =  contactFullName + " " + contactNumber;
                Files.write(PathToContact, Arrays.asList(newContact), StandardOpenOption.APPEND);
            }
            else if(yOrN == 3) {
                searchMethod();
//                System.out.println("option 3");
            }
            else if (yOrN == 4) {
                System.out.println("option 4");
            }
            else if (yOrN == 5) {
                looper = false;
            }
            else {
                System.out.println("Try again.");
            }
        }


    }


}
