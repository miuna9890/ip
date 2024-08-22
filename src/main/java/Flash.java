import java.util.Scanner;

public class Flash {
    public static void main(String[] args) {
        /* create an instance of scanner class */
        Scanner scanner = new Scanner(System.in);

        //Horizontal line for better readability
        String line = "    __________________________________________";

        System.out.println(line);
        System.out.println("    Hey! I'm Flash");
        System.out.println("    What can I do for ya?");
        System.out.println(line);

        String userInput = scanner.nextLine();


        while (!userInput.equals("bye")) {
            //If user types anything other than Bye, repeat it
            System.out.println(line);
            System.out.println("    " + userInput);
            System.out.println(line);
            userInput = scanner.nextLine();
        }

        System.out.println(line);
        System.out.println("    Bye. Hope to see ya again soon!");
        System.out.println(line);
        scanner.close();
    }
}

