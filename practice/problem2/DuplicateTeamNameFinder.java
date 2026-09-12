public class DuplicateTeamNameFinder {

    public static void main(String[] args) {
        String[] firstSample = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(firstSample));

        String[] secondSample = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(secondSample));
    }

    static String findDuplicateTeam(String[] teamNames) {
        for (int firstIndex = 0; firstIndex < teamNames.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < teamNames.length; secondIndex++) {
                if (teamNames[firstIndex].equals(teamNames[secondIndex])) {
                    return "Duplicate Found: " + teamNames[firstIndex];
                }
            }
        }
        return "No Duplicates Found";
    }
}
