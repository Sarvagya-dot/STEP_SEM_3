public class PasswordCheckerDemo {

    public static void main(String[] args) {
        PasswordChecker firstChecker = new PasswordChecker("abcd");
        System.out.println("\"abcd\" -> " + firstChecker.getStrength());

        PasswordChecker secondChecker = new PasswordChecker("abcdefgh");
        System.out.println("\"abcdefgh\" -> " + secondChecker.getStrength());

        PasswordChecker thirdChecker = new PasswordChecker("abcdefghijkl");
        System.out.println("\"abcdefghijkl\" -> " + thirdChecker.getStrength());
    }
}

class PasswordChecker {
    private final String password;

    public PasswordChecker(String password) {
        this.password = password;
    }

    public String getStrength() {
        int passwordLength = password.length();

        if (passwordLength < 6) {
            return "Weak";
        } else if (passwordLength < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }
}
