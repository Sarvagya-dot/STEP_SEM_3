import java.util.Scanner;

public class FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        System.out.print("Enter filename: ");
        String filename = userInputScanner.nextLine();

        System.out.println(validateFileExtension(filename));

        userInputScanner.close();
    }

    static String validateFileExtension(String filename) {
        int lastDotIndex = filename.lastIndexOf('.');

        if (lastDotIndex == -1 || lastDotIndex == filename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = filename.substring(lastDotIndex + 1);

        for (String acceptedExtension : ACCEPTED_EXTENSIONS) {
            if (extension.equalsIgnoreCase(acceptedExtension)) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }
}
