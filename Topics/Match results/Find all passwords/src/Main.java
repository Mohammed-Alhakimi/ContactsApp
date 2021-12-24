import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        // write your code here
        String password = "password\\s*:*";
        String whiteSpaces = "\\s*";
        String allowedChars = "([a-zA-z0-9]+)";
        Pattern pattern = Pattern.compile(password + whiteSpaces + allowedChars, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);


        if (matcher.find()) {
            System.out.println(matcher.group(1));
            while (matcher.find()) {
                System.out.println(matcher.group(1));
            }
        } else {
            System.out.println("No passwords found.");
        }

    }
}
