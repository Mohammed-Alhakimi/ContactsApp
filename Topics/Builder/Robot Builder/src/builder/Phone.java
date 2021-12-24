package builder;

import java.awt.*;

public class Phone {

    private int ram;
    private int price;
    private String name;

    public Phone(int ram, int price, String name) {
        this.ram = ram;
        this.price = price;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "ram=" + ram +
                ", price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    static class PhoneBuilder implements PhoneBuilderPlan{

        private int ram;
        private int price;
        private String name;

        public PhoneBuilder() {

        }

        @Override
        public PhoneBuilder buildPrice(int price) {
            this.price=price;
            return this;
        }

        @Override
        public PhoneBuilder buildRam(int ram) {
            this.ram=ram;
            return this;
        }

        @Override
        public PhoneBuilder buildName(String name) {
            this.name=name;
            return this;
        }

        @Override
        public Phone build() {
            return new Phone(ram,price,name);
        }
    }
}
