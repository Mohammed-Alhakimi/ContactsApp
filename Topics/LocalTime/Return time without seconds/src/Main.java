import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        LocalTime time = LocalTime.parse(s.next());
        time = time.minusSeconds(time.getSecond());
        System.out.println(time);

    }
}