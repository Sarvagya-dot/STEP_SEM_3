public class DuplicatePlayerPickChecker {

    public static void main(String[] args) {
        String[] firstSample = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(firstSample));

        String[] secondSample = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(secondSample));
    }

    static String findDuplicatePick(String[] playerNames) {
        for (int firstIndex = 0; firstIndex < playerNames.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < playerNames.length; secondIndex++) {
                if (playerNames[firstIndex].equals(playerNames[secondIndex])) {
                    return "Duplicate Found: " + playerNames[firstIndex];
                }
            }
        }
        return "No Duplicates Found";
    }
}
