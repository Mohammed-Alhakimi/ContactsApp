package contacts;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

abstract class Entity implements Serializable {
    private  transient Scanner s ;
    final LocalDateTime timeCreated;
    LocalDateTime timeEdited;
    String number;

    public abstract Entity createEntity();
    public abstract String displayFullName();
    public abstract Entity modifyEntity();
    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }

    public LocalDateTime getTimeEdited() {
        return timeEdited;
    }

    public void setTimeEdited(LocalDateTime timeEdited) {
        this.timeEdited = timeEdited;
    }

    public String getNumber() {
        return number;
    }

    public Entity() {
        this.timeCreated = LocalDateTime.now();
        this.timeEdited = LocalDateTime.now();
    }

    public void setNumber() {
        this.number = checkValidity();
    }

    private String checkValidity() {
        s = new Scanner(System.in);
        String number = s.nextLine();
        String firstGroup = "\\+?\\d?[\\s]?";
        String secondGroupAndThirdGroup = "((\\(?([a-zA-Z0-9]+)\\)?[\\s-]?([a-zA-Z0-9]{2,})?[\\s-]?)|([a-zA-Z0-9]{2,})?[\\s-]?(\\(?[a-zA-Z0-9]{2,}?\\)?[\\s-]?))";
        String fourthGroup = "([a-zA-Z0-9]{2,})?[\\s-]?";
        String fifthGroup = "([a-zA-Z0-9]{2,})?";
        Pattern pa = Pattern.compile("(^(" + firstGroup + ")?" + secondGroupAndThirdGroup + fourthGroup + fifthGroup + "$)");
        Matcher matcher = pa.matcher(number);
        if (matcher.find()) {
            return number;
        } else {
            System.out.println("Wrong number format!");

            return "[no number]";
        }
    }
}
