public class PiggyBankDemo {

    public static void main(String[] args) {
        PiggyBank piggyBank = new PiggyBank("PB-1");

        piggyBank.deposit(100);
        System.out.println("After deposit(100): savings = " + piggyBank.getSavings());

        piggyBank.withdraw(30);
        System.out.println("After withdraw(30): savings = " + piggyBank.getSavings());

        piggyBank.withdraw(500);
        System.out.println("After withdraw(500) [rejected]: savings = " + piggyBank.getSavings());
    }
}

class PiggyBank {
    private double savings;
    private final String id;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            savings += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= savings) {
            savings -= amount;
        }
    }

    public double getSavings() {
        return savings;
    }
}
