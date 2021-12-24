import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner s = new Scanner(System.in);
        int entry = s.nextInt();
        LocalTime time = LocalTime.ofSecondOfDay(entry);
        System.out.println(time);
    }
}
