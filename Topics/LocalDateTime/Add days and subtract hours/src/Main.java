import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String e = s.next();
        int days = s.nextInt();
        int hours = s.nextInt();
        LocalDateTime time = LocalDateTime.parse(e);
        time = time.plusDays(days).minusHours(hours);
        System.out.println(time);
    }
}