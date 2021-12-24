import java.util.Scanner;

class Main {
    public static void main(String[] args) {


        String invalidIp2 = "(((25[0-5])|(2[0-4][0-9])|([01]?[0-9][0-9]?))\\." +
                "((25[0-5])|(2[0-4][0-9])|([01]?[0-9][0-9]?))\\." +
                "((25[0-5])|(2[0-4][0-9])|([01]?[0-9][0-9]?))\\." +
                "((25[0-5])|(2[0-4][0-9])|([01]?[0-9][0-9]?)))";
        Scanner scanner = new Scanner(System.in);
        // start coding here
        String ipEntry = scanner.next();

        if (ipEntry.matches(invalidIp2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}