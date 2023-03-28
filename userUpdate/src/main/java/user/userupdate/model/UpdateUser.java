package user.userupdate.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class UpdateUser {

    private User userToChange;
    private User changesMade;

    public UpdateUser() {
    }

    public UpdateUser(User userToChange, User changesMade) {
        this.userToChange = userToChange;
        this.changesMade = changesMade;
    }

    @Override
    public String toString() {
        return "User to change: " + userToChange + "\n Changes made: " + changesMade;
    }
}
