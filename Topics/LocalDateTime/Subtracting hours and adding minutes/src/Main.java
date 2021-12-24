import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String entry = s.next();
        LocalDateTime time = LocalDateTime.parse(entry);
        int hours = s.nextInt();
        int minutes = s.nextInt();
        time = time.minusHours(hours).plusMinutes(minutes);
        System.out.println(time);

    }
}
