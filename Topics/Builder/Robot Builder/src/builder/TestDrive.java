package builder;

public class TestDrive {
    public static void main(String[] args) {
        Phone p1 = new Phone.PhoneBuilder().buildName("Samsung").build();
        System.out.println(p1);
        Phone p2 = new Phone.PhoneBuilder().buildPrice(1000).buildRam(12).buildName("HTC").build();
        System.out.println(p2);
    }
}
