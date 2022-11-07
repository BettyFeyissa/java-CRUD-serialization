
import java.util.Scanner;

public class Menu {
    //Class attributes
    static Scanner scan = new Scanner(System.in);

    //Creating a new instance of our StudyGuid
    static StudyGuide java = new StudyGuide();

    //storing the users input
    static String option = "";

    static void presentMenu(){
        // print options for the user to select
        //step 1: define the message for the options
        String optionsMessage = "\nType C to create a new topic \n" + "Type R to read all topics \n" + "Type U to update a topic \n" + "Type D to delete a topic \n" + "Type Q to quit \n";

        // step 2: print options for the user
        System.out.println(optionsMessage);

        //step 1: scan in user input
        option = scan.nextLine();
        System.out.println("The user selected " + option);

        //check which option user selected
        if (option.equalsIgnoreCase("C")) {
            java.createTopics();

        } else if (option.equalsIgnoreCase("R")){
            // print the products
            java.printTopics();

        }else if (option.equalsIgnoreCase("U")){
            System.out.println("Should update ");
            java.updateTopic();

        }else if (option.equalsIgnoreCase("D")){
            System.out.println("Should delete ");
            java.deleteTopic();

        }else if (option.equalsIgnoreCase("Q")){
            System.out.println("Goodbye! ");
            System.exit(0);
        }
        else
            System.out.println("\nPlease enter proper input! \n");
        presentMenu();
    }

    public static void main(String[] args) {

        // print a welcome menu for the user
        //step 1: define the message for the user
        String welcome = "Welcome to Java Class\n";

        // step 2: print message for the user
        System.out.println(welcome);

        //step 3: create loop for the program menu
        while(option.equalsIgnoreCase("Q") == false)
            presentMenu();
    }
}