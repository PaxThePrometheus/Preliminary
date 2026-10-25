import java.util.ArrayList;
import java.util.Scanner;

public class MidtermAct5 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        prog1();

    }

    abstract static class Account {

        private String accountNumber;
        private ArrayList<Double> entries = new ArrayList<>();

        Account(String num, double bal) {

            if (!Double.isFinite(bal) || bal < 0) {

                throw new IllegalArgumentException("Invalid opening balance.");

            }
            accountNumber = num;
            entries.add(bal);

        }

        abstract double withdrawalFee();

        abstract String accountType();

        double balance() {

            double bal = 0;
            for (double val : entries) {

                bal += val;

            }
            return bal;

        }

        boolean transact(double amt, boolean debit) {

            if (!Double.isFinite(amt) || amt <= 0) {

                return false;

            }
            double change = debit ? -(amt + withdrawalFee()) : amt;
            double next = balance() + change;
            if (!Double.isFinite(next) || next < 0) {

                return false;

            }
            entries.add(change);
            return true;

        }

        void display() {

            System.out.printf("%s | %s | Balance: %.2f%n", accountNumber, accountType(), balance());

        }

    }

    static class SavingsAccount extends Account {

        SavingsAccount(double bal) {

            super("SAV-101", bal);

        }

        double withdrawalFee() {

            return 0;

        }

        String accountType() {

            return "Savings";

        }

    }

    static class CheckingAccount extends Account {

        CheckingAccount(double bal) {

            super("CHK-202", bal);

        }

        double withdrawalFee() {

            return 10;

        }

        String accountType() {

            return "Checking";

        }

    }

    public static int prog1(){

        double bal = readNum("Opening balance: ", 0, 1000000000000.0);
        Account[] arr = {new SavingsAccount(bal), new CheckingAccount(bal)};
        int idx = 0;
        for (; ; ) {

            arr[idx].display();
            int opt = readInt("1 Withdraw | 2 Deposit | 3 Balance | 4 Switch | 5 Exit: ", 1, 5);
            switch (opt) {

                case 5:
                    System.out.println("Goodbye!");

                    return 0;
                case 4:
                    idx = (idx + 1) % arr.length;
                    break;
                case 3:
                    arr[idx].display();
                    break;
                default:
                    makeTransaction(arr[idx], opt == 1);

            }

        }

    }

    static void makeTransaction(Account acc, boolean debit) {

        double amt = readNum(debit ? "Withdraw amount: " : "Deposit amount: ", 0, 1000000000000.0);
        if (acc.transact(amt, debit)) {

            if (debit) {

                System.out.printf("Withdrawal fee: %.2f%n", acc.withdrawalFee());

            }
            acc.display();

        } else {

            System.out.println("Transaction rejected: invalid amount or insufficient funds.");

        }

    }

    static String readText(String msg) {

        System.out.print(msg);
        return scanner.nextLine().trim();

    }

    static double readNum(String msg, double min, double max) {

        for (; ; ) {

            String line = readText(msg);
            try {

                double num = Double.parseDouble(line);
                if (Double.isFinite(num) && num >= min && num <= max) {

                    return num;

                }

            } catch (NumberFormatException e) {

            }
            System.out.println("Enter a number between " + min + " and " + max + ".");

        }

    }

    static int readInt(String msg, int min, int max) {

        for (; ; ) {

            String line = readText(msg);
            try {

                int num = Integer.parseInt(line);
                if (num >= min && num <= max) {

                    return num;

                }

            } catch (NumberFormatException e) {

            }
            System.out.println("Enter a whole number between " + min + " and " + max + ".");

        }

    }

}
