import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        String entry = s.next();
        LocalDateTime dateTime = LocalDateTime.parse(entry);
        int nMinuets = s.nextInt();
        dateTime = dateTime.plusMinutes(nMinuets);
        System.out.print(dateTime.getYear() + " " + dateTime.getDayOfYear()+ " " + dateTime.toLocalTime());
    }
}
