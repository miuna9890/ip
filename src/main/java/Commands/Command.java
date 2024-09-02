package Commands;

import Data.StoreList;
import Exceptions.InvalidIndexException;

/**
 * Parent class for all types of commands
 */

public abstract class Command {
    protected StoreList storeList;

    public void setData(StoreList storeList) {

        this.storeList = storeList;
    }

    public abstract void execute() throws InvalidIndexException;
    public abstract boolean isExit();
}
