package seedu.address.ui.card;

import java.util.Set;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import seedu.address.model.tasks.TaskSource;


/**
 * An UI component that displays information of a {@code Event}.
 */
public class TaskCard extends Card {

    private static final String FXML = "TaskCard.fxml";

    @FXML
    private StackPane taskCardBase;

    @FXML
    private VBox taskDetails;

    @FXML
    private Label taskName;

    @FXML
    private StackPane taskDueDateBase;

    @FXML
    private Label taskDueDate;

    @FXML
    private StackPane taskTagsBase;

    @FXML
    private HBox taskTags;

    /**
     * Constructor for the TaskCard, which displays the information of a particular task.
     *
     * @param task The given task.
     */
    public TaskCard(TaskSource task) {
        super(FXML);
        taskName.setText(task.getDescription());

        // Due Date
        if (task.getDueDate() != null) {
            taskDueDate.setText(task.getDueDate().toEnglishDateTime());
        } else {
            taskDetails.getChildren().remove(taskDueDateBase);
        }

        // Tags
        if (task.getTags() != null) {
            Set<String> tags = task.getTags();
            for (String tag : tags) {
                CardTag cardTag = new CardTag(tag);
                if (task.isDone()) {
                    cardTag.changeColor("-taskDoneTagColor");
                } else {
                    cardTag.changeColor("-taskTagColor");
                }
                taskTags.getChildren().add(cardTag.getRoot());
            }
        } else {
            taskDetails.getChildren().remove(taskTagsBase);
        }

        // Color
        if (task.isDone()) {
            taskCardBase.setStyle("-fx-background-color: -taskDoneCardColor;");
        }

        taskName.setMinHeight(Region.USE_PREF_SIZE);
    }
}
