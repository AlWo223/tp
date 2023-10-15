package athleticli.commands.activity;

import athleticli.commands.Command;
import athleticli.data.Data;
import athleticli.data.activity.Activity;
import athleticli.data.activity.ActivityList;
import athleticli.exceptions.AthletiException;
import athleticli.ui.Message;

/**
 * Executes the delete activity command provided by the user.
 */
public class DeleteActivityCommand extends Command {
    private final Integer index;

    /**
     * Constructor for DeleteActivityCommand.
     * @param index Index of activity to be deleted.
     */
    public DeleteActivityCommand(Integer index) {
        this.index = index;
    }

    /**
     * Executes the delete activity command.
     * @param data Data object containing the current list of activities.
     * @return String array containing the messages to be printed to the user.
     * @throws AthletiException If the index provided is out of bounds.
     */
    @Override
    public String[] execute(Data data) throws AthletiException {
        ActivityList activities = data.getActivities();
        try {
            final Activity activity = activities.get(index-1);
            activities.remove(activity);
            return new String[]{Message.MESSAGE_ACTIVITY_DELETED, activity.toString(),
                    String.format(Message.MESSAGE_ACTIVITY_COUNT, activities.size())};
        } catch (IndexOutOfBoundsException e) {
            throw new AthletiException(Message.MESSAGE_ACTIVITY_INDEX_OUT_OF_BOUNCE);
        }
    }


}
