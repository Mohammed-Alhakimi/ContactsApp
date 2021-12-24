import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first= scanner.next();
        String second= scanner.next();
        int dif ;
        LocalTime time = LocalTime.parse(first);
        LocalTime time2 = LocalTime.parse(second);
        dif = Math.max(time.toSecondOfDay(),time2.toSecondOfDay())-Math.min(time.toSecondOfDay(),time2.toSecondOfDay());
        System.out.println(dif);
    }
}