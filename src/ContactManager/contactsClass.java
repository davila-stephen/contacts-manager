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

    // Add new contact
    public static void addContact() throws IOException {
        Scanner sc = new Scanner(System.in);
        Path PathToContact = Paths.get("./src/ContactManager/contacts.txt");

        boolean contactLooper = true;
        while (contactLooper) {
            System.out.println("Please type in contact first and last name");
            String contactFirstName = sc.next();
            String contactLastName = sc.next();
            System.out.println("Please enter phone number");
            long contactNumber = sc.nextLong();

            // BONUS PORTION for the dashes in the number
            String sNum = Long.toString(contactNumber);
            String dashedNumber = sNum.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");

//            if(sNum.length() == 10){
//               sNum.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
//            }
                System.out.println(dashedNumber);

            String contactFullName = contactFirstName + " " + contactLastName;


            String newContact = contactFullName + " " + dashedNumber;//sNum;//contactNumber;
            Files.write(PathToContact, Arrays.asList(newContact), StandardOpenOption.APPEND);
            System.out.println("Would you like to enter a new contact? enter yes or no");

            boolean looperContact = true;
            while (looperContact) {
                String userResponse = sc.next();
                if (userResponse.equalsIgnoreCase("yes")) {
                    looperContact = false;
                } else if (userResponse.equalsIgnoreCase("no")) {
                    looperContact = false;
                    contactLooper = false;
                }else{
                    System.out.println("Try again!");
                }
            }
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
        boolean looperSearch = true;
        while (looperSearch) {
            System.out.println("Please type in the name of who you want to search up.");
            String searchFirstName = sc.next();
            String searchLastName = sc.next();
            String searchFullName = searchFirstName + " " + searchLastName;

         if (!contactString.toLowerCase().contains(searchFullName.toLowerCase())){
                System.out.println("Contact not found. Would you like to try and search again? Please input yes or no.");
                boolean looper2 = true;
                while (looper2) {
                    String option3YesNo = sc.next();
                    if (option3YesNo.equalsIgnoreCase("yes")) {
                        looper2 = false;
                    } else if (option3YesNo.equalsIgnoreCase("no")) {
                        looperSearch = false;
                        looper2 = false;
                    } else {
                        System.out.println("Try again.");
                        looper2 = true;
                    }
                }
            }
            if (contactString.toLowerCase().contains(searchFullName.toLowerCase())) {
                for (int i = 0; i < contactList.size(); i += 1) {
                    if (contactList.get(i).toLowerCase().contains(searchFullName.toLowerCase())) {
                        System.out.println(contactList.get(i));
                        System.out.println("There's your contact! Would you like to search for a different one? Please type in yes or no.");
                        boolean looper3 = true;
                        while (looper3) {
                            String option3YesNo = sc.next();
                            if (option3YesNo.equalsIgnoreCase("yes")) {
                                looper3 = false;
                            } else if (option3YesNo.equalsIgnoreCase("no")) {
                                looperSearch = false;
                                looper3 = false;
                            } else {
                                System.out.println("Try again.");
                                looper3 = true;
                            }
                        }
                    }
                }
            }
        }
    }

    // Delete contact method

    public static void deleteMethod() throws IOException {
        Scanner sc = new Scanner(System.in);
        Path PathToContact = Paths.get("./src/ContactManager/contacts.txt");
        List<String> contactList = Files.readAllLines(PathToContact);
        List<String> newList = new ArrayList<>();

        boolean looperDelete = true;
        while (looperDelete) {
            System.out.println("Please choose one of the contacts below to delete: ");
            for (int i = 0; i < contactList.size(); i++) {
                System.out.println((i + 1) + ": " + contactList.get(i));
            }
            System.out.println("Type in the number for the contact you would like to delete. If you don't want to delete a contact, type in 0.");
            int userNum = sc.nextInt();
            if (userNum == 0) {
                looperDelete = false;
            } else if (contactList.contains(contactList.get(userNum - 1))) {
                for (String contact : contactList) {
                    if (contact.equals(contactList.get(userNum - 1))) {
                        continue;
                    }
                    newList.add(contact);
                }
                contactList = newList;
                Files.write(PathToContact, contactList);
                System.out.println("Would you like to delete another contact? Please type in yes or no.");
                String yesNo = sc.next();
                boolean yesNoLooper = true;
                while (yesNoLooper) {
                    if (yesNo.equalsIgnoreCase("yes")) {
                        yesNoLooper = false;
                    } else if (yesNo.equalsIgnoreCase("no")) {
                        yesNoLooper = false;
                        looperDelete = false;
                    } else {
                        System.out.println("Try again.");
                        yesNoLooper = true;
                    }
                }
            }
        }
    }


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
//                System.out.println("Please type in contact first and last name");
//                String contactFirstName = sc.next();
//                String contactLastName = sc.next();
//                System.out.println("Please enter phone number");
//                long contactNumber = sc.nextLong();
//
//                String contactFullName = contactFirstName + " " + contactLastName;
//                String newContact =  contactFullName + " " + contactNumber;
//                Files.write(PathToContact, Arrays.asList(newContact), StandardOpenOption.APPEND);
                addContact();
            }
            else if(yOrN == 3) {
                searchMethod();
            }
            else if (yOrN == 4) {
                deleteMethod();
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
