package Main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.io.IOException;

/**
 * The DialogBox class represents a custom control for displaying user input and Duke's responses in a dialog box.
 * It handles the display of both text and images, with an option to flip the dialog box to position the image
 * on either side. The profile picture of each dialog can be displayed as a circular image.
 */
public class DialogBox extends HBox {

    @FXML
    private Label dialog;


    @FXML
    private Circle displayPicture;

    // Predefined images for different emotions
    private Image sadJoy = new Image(this.getClass().getResourceAsStream("/images/sadJoy.png"));
    private Image angryJoy = new Image(this.getClass().getResourceAsStream("/images/angryJoy.png"));
    private Image anxiousJoy = new Image(this.getClass().getResourceAsStream("/images/Anxiety.png"));
    private Image happyJoy = new Image(this.getClass().getResourceAsStream("/images/happyJoy.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/Joy.png"));


    /**
     * Constructs a DialogBox object that displays the specified text and image.
     * The image is displayed inside a circular container.
     *
     * @param s The text to display in the dialog.
     * @param i The image to display as the profile picture.
     */
    public DialogBox(String s, Image i) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(s);
        // Create a circle and set the ImagePattern to display the profile picture
        displayPicture.setRadius(40);  // Adjust the radius as needed
        displayPicture.setFill(new ImagePattern(i));  // Set the image in the circle
    }


    /**
     * Creates and returns an error dialog box with the specified message and image.
     * The dialog box is styled to indicate an error.
     *
     * @param message The error message to display.
     * @param image   The image to display as the profile picture.
     * @return A DialogBox representing an error message.
     */
    public static DialogBox getErrorDialog(String message, Image image) {
        var db = new DialogBox(message, image);
        db.applyErrorStyle();
        db.flip(); // If needed to position the image correctly
        return db;
    }

    /**
     * Applies the error style to the dialog box.
     * This method ensures that the dialog box is styled to highlight error messages.
     */
    private void applyErrorStyle() {
        dialog.getStyleClass().add("error-label");
        // Ensure other styles are removed if necessary
        dialog.getStyleClass().removeAll("add-label", "marked-label", "delete-label", "unmark-label", "due-label");
    }



    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        this.setAlignment(Pos.TOP_LEFT);
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        FXCollections.reverse(tmp);
        this.getChildren().setAll(tmp);
        dialog.getStyleClass().add("reply-label");
    }

    /**
     * Creates and returns a dialog box for the user with the specified text and image.
     * The dialog box is styled to represent the user's input.
     *
     * @param s The text to display.
     * @param i The user's profile picture.
     * @return A DialogBox representing the user's input.
     */
    public static DialogBox getUserDialog(String s, Image i) {
        var db = new DialogBox(s, i);
        db.dialog.getStyleClass().add("user-label");
        return db;
    }

    /**
     * Changes the dialog style and profile picture based on the type of command executed.
     * Different command types will change the appearance of the dialog.
     *
     * @param commandType The type of command executed by the user.
     * @return The corresponding image to display based on the command type.
     */
    private void changeDialogStyle(String commandType) {
        switch (commandType) {
            case "ToDoCommand":
            case "DeadlineCommand":
            case "EventCommand":
                dialog.getStyleClass().add("add-label");
                displayPicture.setFill(new ImagePattern(sadJoy));
                break;
            case "MarkCommand":
                dialog.getStyleClass().add("marked-label");
                displayPicture.setFill(new ImagePattern(happyJoy));
                break;
            case "DeleteCommand":
                dialog.getStyleClass().add("delete-label");
                displayPicture.setFill(new ImagePattern(happyJoy));
                break;
            case "UnmarkCommand":
                dialog.getStyleClass().add("unmark-label");
                displayPicture.setFill(new ImagePattern(angryJoy));
                break;
            case "DueCommand":
                dialog.getStyleClass().add("due-label");
                displayPicture.setFill(new ImagePattern(anxiousJoy));
                break;
            default:
                displayPicture.setFill(new ImagePattern(dukeImage));
                break;
        }
    }

    /**
     * Creates and returns a dialog box for Duke with the specified text, image, and command type.
     * This method flips the dialog box and changes the style based on the command type.
     *
     * @param text The text to display.
     * @param img The initial image to display.
     * @param commandType The type of command executed, used to determine the style.
     * @return A DialogBox representing Duke's response with the appropriate style and image.
     */
    public static DialogBox getEmoteXDialog(String text, Image img, String commandType) {
        var db = new DialogBox(text, img);
        // Update the existing dialog style and image
        db.changeDialogStyle(commandType);
        db.flip();
        return db;
    }
}
