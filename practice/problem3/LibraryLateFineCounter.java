import java.util.Scanner;

public class LibraryLateFineCounter {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int itemCount = Integer.parseInt(userInputScanner.nextLine().trim());

        double totalFines = 0;

        for (int itemIndex = 0; itemIndex < itemCount; itemIndex++) {
            String[] tokens = userInputScanner.nextLine().trim().split("\\s+");

            LibraryItem libraryItem = createLibraryItem(tokens);
            double fine = libraryItem.calculateFine();

            System.out.printf("%s: %.2f%n", libraryItem.getTitle(), fine);
            totalFines += fine;
        }

        System.out.printf("Total Fines: %.2f%n", totalFines);

        userInputScanner.close();
    }

    private static LibraryItem createLibraryItem(String[] tokens) {
        String itemType = tokens[0];
        String title = tokens[1];
        int daysLate = Integer.parseInt(tokens[2]);

        switch (itemType) {
            case "BOOK":
                return new BookItem(title, daysLate);
            case "DVD":
                return new DvdItem(title, daysLate);
            case "MAGAZINE":
                return new MagazineItem(title, daysLate);
            default:
                throw new IllegalArgumentException("Unknown item type: " + itemType);
        }
    }
}

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    abstract double calculateFine();

    String getTitle() {
        return title;
    }
}

class BookItem extends LibraryItem {
    private static final double RATE_PER_DAY = 2;

    BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * RATE_PER_DAY;
    }
}

class DvdItem extends LibraryItem {
    private static final double RATE_PER_DAY = 5;
    private static final double MAX_FINE = 50;

    DvdItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return Math.min(daysLate * RATE_PER_DAY, MAX_FINE);
    }
}

class MagazineItem extends LibraryItem {
    private static final double RATE_PER_DAY = 1;

    MagazineItem(String title, int daysLate) {
        super(title, daysLate);
    }

    double calculateFine() {
        return daysLate * RATE_PER_DAY;
    }
}
