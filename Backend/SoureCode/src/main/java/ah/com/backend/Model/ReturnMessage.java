package ah.com.backend.Model;

/**
 * @class: ReturnMessage
 * @author: Anes Hodza
 * @version: 28.08.2021
 **/

public class ReturnMessage {

    private String message;
    private boolean hasWorked;

    public ReturnMessage(String message, boolean hasWorked) {
        this.message = message;
        this.hasWorked = hasWorked;
    }

    public String getMessage() {
        return message;
    }

    public boolean isHasWorked() {
        return hasWorked;
    }
}
