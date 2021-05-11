package ContactManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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


        // Main Menue
        boolean looper = true;
        while (looper) {
            System.out.println("Here are some more options to move forward:");
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

                looper = false;
            }
            else if (yOrN == 2) {

            }
            else if(yOrN == 3) {

            }
            else if (yOrN == 4) {

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
