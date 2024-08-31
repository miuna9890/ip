package Commands;

import Exceptions.InvalidIndexException;
import Main.Ui;

public class MarkCommand extends Command {
    String userInput;

    public MarkCommand(String userInput) {

        this.userInput = userInput;
    }

    /**
     * Marks item as completed via method in storelist class
     *
     */
    @Override
    public void execute() throws InvalidIndexException {
        // Split the string by spaces
        String[] words = userInput.split(" ");
        System.out.println(Ui.LINE);
        int itemNum = Integer.parseInt(words[1]);
        storeList.markItem(itemNum);
        System.out.println(Ui.LINE);
    }

    @Override
    public boolean isExit() {

        return false;
    }
}
