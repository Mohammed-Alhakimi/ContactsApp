import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class FindTheKeys {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String consonantsKey = "[b-d][f-h][j-n][p-t][v-z][0-9]";
        String vowelsKey = "aeiou\\?!#";
        Pattern p = Pattern.compile("(the\\s*key\\s*is\\s*" +
                        "([" + consonantsKey + "]*|[" + vowelsKey + "]*)(\\s|\\n\\r)+)", 
                        Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(text);
        while (m.find()) {
            System.out.println(m.group(2));
        }
    }
}
