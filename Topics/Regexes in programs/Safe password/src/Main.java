import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String lengthRegex = "\\w{12,}";
        String lowercaseRegex = ".*[a-z]+.*";
        String uppercaseRegex = ".*[A-Z]+.*";
        String numberRegex = ".*\\d+.*";

        if (input.matches(lengthRegex) && input.matches(lowercaseRegex)
                && input.matches(uppercaseRegex) && input.matches(numberRegex)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}