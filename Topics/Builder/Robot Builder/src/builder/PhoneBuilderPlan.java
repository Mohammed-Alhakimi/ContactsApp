package builder;

import java.awt.*;

public interface PhoneBuilderPlan {

    Phone.PhoneBuilder buildPrice(int price);
    Phone.PhoneBuilder buildRam(int ram);
    Phone.PhoneBuilder buildName(String name);
    Phone build();
}
