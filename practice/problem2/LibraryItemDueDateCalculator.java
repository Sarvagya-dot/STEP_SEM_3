import java.time.LocalDate;
import java.util.Scanner;

public class LibraryItemDueDateCalculator {

    private static final LocalDate CURRENT_DATE = LocalDate.of(2023, 10, 26);

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int itemCount = Integer.parseInt(userInputScanner.nextLine().trim());

        for (int itemIndex = 0; itemIndex < itemCount; itemIndex++) {
            String line = userInputScanner.nextLine().trim();
            int firstSpaceIndex = line.indexOf(' ');

            String itemType = line.substring(0, firstSpaceIndex);
            String rawTitle = line.substring(firstSpaceIndex + 1).trim();
            String itemTitle = stripQuotes(rawTitle);

            LibraryItem libraryItem = createLibraryItem(itemType);
            LocalDate dueDate = CURRENT_DATE.plusDays(libraryItem.getBorrowDays());

            System.out.println(itemTitle + ": " + dueDate);
        }

        userInputScanner.close();
    }

    private static String stripQuotes(String rawTitle) {
        if (rawTitle.length() >= 2 && rawTitle.startsWith("\"") && rawTitle.endsWith("\"")) {
            return rawTitle.substring(1, rawTitle.length() - 1);
        }
        return rawTitle;
    }

    private static LibraryItem createLibraryItem(String itemType) {
        switch (itemType) {
            case "BOOK":
                return new BookItem();
            case "DVD":
                return new DvdItem();
            case "MAGAZINE":
                return new MagazineItem();
            default:
                throw new IllegalArgumentException("Unknown item type: " + itemType);
        }
    }
}

abstract class LibraryItem {
    abstract int getBorrowDays();
}

class BookItem extends LibraryItem {
    int getBorrowDays() {
        return 14;
    }
}

class DvdItem extends LibraryItem {
    int getBorrowDays() {
        return 7;
    }
}

class MagazineItem extends LibraryItem {
    int getBorrowDays() {
        return 3;
    }
}
