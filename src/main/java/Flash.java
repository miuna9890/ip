import java.util.Scanner;

public class Flash {
    public static void main(String[] args) throws UnknownCommandException {
        /* create an instance of scanner class */
        Scanner scanner = new Scanner(System.in);

        /* create an instance for Store list*/
        StoreList storeList = new StoreList();

        /* load tasks first*/
        storeList.loadTasks();

        //Horizontal line for better readability
        String line = "    __________________________________________";

        // print intro
        System.out.println(line);
        System.out.println("    Hey! I'm Flash");
        System.out.println("    What can I do for ya?");
        System.out.println(line);

        String userInput = scanner.nextLine();

        //loop runs till user says bye
        while (!userInput.equals("bye")) {

            // Split the string by spaces
            String[] words = userInput.split(" ");

            //if user inputs mark, mark task and update file
            if (words[0].equals("mark")) {
                System.out.println(line);
                storeList.markItem(Integer.parseInt(words[1]));
                System.out.println(line);
                storeList.saveTasksToFile();
                userInput = scanner.nextLine();
            }

            //if user inputs unmark, unmark task and update file
            else if (words[0].equals("unmark")) {
                System.out.println(line);
                storeList.UnmarkItem(Integer.parseInt(words[1]));
                System.out.println(line);
                storeList.saveTasksToFile();
                userInput = scanner.nextLine();
            }

            //if user inputs list, display tasks and update file
            else if (userInput.equals("list")) {
                System.out.println(line);
                storeList.displayItems();
                System.out.println(line);
                storeList.saveTasksToFile();
                userInput = scanner.nextLine();
            }

            //if user inputs delete, delete task and update file
            else if (words[0].equals("delete")) {
                System.out.println(line);
                storeList.deleteItem(Integer.parseInt(words[1]));
                System.out.println(line);
                storeList.saveTasksToFile();
                userInput = scanner.nextLine();
            }


            //if user inputs to do, add item of type to do and update file
            else if (words[0].equals("todo")) {
                System.out.println(line);
                storeList.addItem(userInput.substring(4), "todo");
                System.out.println(line);
                storeList.saveTasksToFile();
                userInput = scanner.nextLine();

                //if user inputs deadline, add item of type deadline and update file
            } else if (words[0].equals("deadline")) {
                System.out.println(line);
                storeList.addItem(userInput.substring(8), "deadline");
                System.out.println(line);
                storeList.saveTasksToFile();
                userInput = scanner.nextLine();

                //if user inputs event, add item of type event and update file
            } else if (words[0].equals("event")) {
                System.out.println(line);
                storeList.addItem(userInput.substring(5), "event");
                System.out.println(line);
                storeList.saveTasksToFile();
                userInput = scanner.nextLine();

            } else {
                //random input given, throw exception
                try {
                    throw new UnknownCommandException("     OOPS!!! Sorry leh, but IDK what that means :-");
                } catch (UnknownCommandException e) {
                    System.out.println(line);
                    System.out.println(e.getMessage());
                    System.out.println(line);
                    userInput = scanner.nextLine();
                }
            }
        }

            //if user inputs bye, exit
            System.out.println("    Bye. Hope to see ya again soon!");
            System.out.println(line);
            scanner.close();
        }
    }
