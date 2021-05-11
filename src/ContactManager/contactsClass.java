package ContactManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class contactsClass {

    // View contacts method
    public static void printContacts(Path filePath) throws IOException {
        System.out.println();
        List<String> fileContents = Files.readAllLines(filePath);
        for (int i = 0; i < fileContents.size(); i++) {
            System.out.printf("%s\n", fileContents.get(i));
        }
    }

    // Add a new contact


    public static void main(String[] args) throws IOException {
        Path PathToContact = Paths.get("./src/ContactManager/contacts.txt");

        System.out.println("Files.exists(PathToContact) = " + Files.exists(PathToContact));

//        System.out.println("Name    | Phone Number");
//        System.out.println("----------------------");
//        printContacts(PathToContact);

        Scanner sc = new Scanner(System.in);
        // Main Menue
        boolean looper = true;
        while (looper) {
            System.out.println("Main Menue:");
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
                String userInput = sc.next();
                System.out.println("Please enter phone number");
                int userNumInput = sc.nextInt();
                String newContact = userInput + " " + Integer.toString(userNumInput);
                Files.write(PathToContact, Arrays.asList(newContact), StandardOpenOption.APPEND);
                List<String> contactList = Files.readAllLines(PathToContact);

            }
            else if(yOrN == 3) {
                System.out.println("option 3");
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
