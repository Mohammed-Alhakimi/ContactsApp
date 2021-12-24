import java.util.*;
import java.util.regex.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        // write your code here
        Matcher m = Pattern.compile("\\b[a-zA-Z]{"+size+"}\\b").matcher(line);

        System.out.println(m.find()? "YES" : "NO");



    }
}