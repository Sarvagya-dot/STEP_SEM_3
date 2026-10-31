import java.util.HashMap;
import java.util.Scanner;

public class EmployeeIdLookup {

    public static void main(String[] args) {
        Scanner userInputScanner = new Scanner(System.in);
        int recordCount = Integer.parseInt(userInputScanner.nextLine().trim());

        String[][] records = new String[recordCount][2];
        for (int recordIndex = 0; recordIndex < recordCount; recordIndex++) {
            String[] parts = userInputScanner.nextLine().trim().split("\\s+", 2);
            records[recordIndex][0] = parts[0];
            records[recordIndex][1] = parts[1];
        }

        HashMap<String, String> lookup = buildLookup(records);

        int queryCount = Integer.parseInt(userInputScanner.nextLine().trim());
        for (int query = 0; query < queryCount; query++) {
            String employeeId = userInputScanner.nextLine().trim();
            System.out.println("\"" + getDepartment(lookup, employeeId) + "\"");
        }

        userInputScanner.close();
    }

    // Time complexity: O(n) one-time build. Space complexity: O(n) for the map.
    static HashMap<String, String> buildLookup(String[][] records) {
        HashMap<String, String> lookup = new HashMap<>();
        for (String[] record : records) {
            lookup.put(record[0], record[1]);
        }
        return lookup;
    }

    // Time complexity after the build: O(1) average per query (O(n) worst case on heavy collisions).
    // Why it fits: queries vastly outnumber updates, so paying O(n) once (and O(1) per rare
    // update) beats scanning the unsorted list in O(n) on every single query. Sorting plus
    // binary search would give O(log n) per query but costs O(n log n) to build and keep sorted.
    static String getDepartment(HashMap<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }
}
