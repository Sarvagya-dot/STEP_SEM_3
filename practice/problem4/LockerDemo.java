public class LockerDemo {

    public static void main(String[] args) {
        Locker locker = new Locker(101, "1234");

        boolean firstChange = locker.changeCode("1234", "5678");
        System.out.println("changeCode(\"1234\", \"5678\") -> " + (firstChange ? "success" : "rejected"));

        boolean secondChange = locker.changeCode("0000", "9999");
        System.out.println("changeCode(\"0000\", \"9999\") -> " + (secondChange ? "success" : "rejected"));
    }
}

class Locker {
    private String combinationCode;
    private final int lockerNumber;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String currentCode, String newCode) {
        if (!currentCode.equals(combinationCode)) {
            return false;
        }
        combinationCode = newCode;
        return true;
    }
}
