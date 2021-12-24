import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stringWithNumbers = scanner.nextLine();
        Matcher matcher = Pattern.compile("\\d{10,}").matcher(stringWithNumbers);

        MatchResult matcherResults ;

        while (matcher.find()) {
            matcherResults=matcher.toMatchResult();
            String bigNumber = matcherResults.group();
            System.out.println(bigNumber + ":" + bigNumber.length());
        }

        // write your code here
    }
}