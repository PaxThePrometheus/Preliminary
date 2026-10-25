import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MidtermAct6 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Runnable[] arr = {MidtermAct6::prog1, MidtermAct6::prog2, MidtermAct6::prog3};
        for (Runnable task : arr) {

            task.run();

        }

    }

    static class BankAccount {

        private BigDecimal balance;

        BankAccount(double bal) {

            if (!Double.isFinite(bal) || bal < 0) {

                throw new IllegalArgumentException("Balance must be non-negative.");

            }
            balance = BigDecimal.valueOf(bal);

        }

        boolean apply(double amt, boolean debit) {

            if (!Double.isFinite(amt) || amt <= 0) {

                return false;

            }
            BigDecimal diff = BigDecimal.valueOf(amt);
            BigDecimal next = debit ? balance.subtract(diff) : balance.add(diff);
            if (next.signum() < 0) {

                return false;

            }
            balance = next;
            return true;

        }

        String balanceText() {

            return balance.stripTrailingZeros().toPlainString();

        }

    }

    public static int prog1(){

        BankAccount acc = new BankAccount(readNum("Opening balance: ", 0, 1000000000000.0));
        int opt = readInt("1 Withdraw | 2 Deposit | 3 Exit: ", 1, 3);
        while (opt < 3) {

            double amt = readNum("Amount: ", 0, 1000000000000.0);
            String rslt =
                    acc.apply(amt, opt == 1)
                            ? "Balance: " + acc.balanceText()
                            : "Transaction rejected.";
            System.out.println(rslt);
            opt = readInt("1 Withdraw | 2 Deposit | 3 Exit: ", 1, 3);

        }

        return 0;

    }

    static class Patient {

        private String name;
        private String disease;
        private LocalDate admissionDate;
        private LocalDate dischargeDate;

        Patient(String nme, String illness, LocalDate start, LocalDate end) {

            name = nme;
            disease = illness;
            admissionDate = start;
            dischargeDate = end;

        }

        String details() {

            return name + " | " + disease + " | " + admissionDate + " to " + dischargeDate;

        }

    }

    static class IndoorPatient extends Patient {

        private int age;

        IndoorPatient(String nme, String illness, LocalDate start, LocalDate end, int age) {

            super(nme, illness, start, end);
            this.age = age;

        }

        boolean underAge(int limit) {

            return age < limit;

        }

        String details() {

            return super.details() + " | Age: " + age;

        }

    }

    public static int prog2(){

        ArrayList<IndoorPatient> arr = new ArrayList<>();
        for (; ; ) {

            int opt = readInt("1 New patient | 2 All patients | 3 Under 12 | 4 Exit: ", 1, 4);
            if (opt == 4) {

                return 0;

            }
            if (opt != 1) {

                showPatients(arr, opt == 3 ? 12 : Integer.MAX_VALUE);
                continue;

            }
            if (arr.size() == 100) {

                System.out.println("Database is full.");
                continue;

            }
            arr.add(readPatient());
            System.out.println("Patient record saved.");

        }

    }

    static IndoorPatient readPatient() {

        String nme = readRequired("Patient name: ");
        String illness = readRequired("Disease: ");
        LocalDate start = readDate("Admission date (yyyy-mm-dd): ", LocalDate.of(1, 1, 1));
        LocalDate end = readDate("Discharge date (yyyy-mm-dd): ", start);
        int age = readInt("Age: ", 0, 150);
        return new IndoorPatient(nme, illness, start, end, age);

    }

    static void showPatients(ArrayList<IndoorPatient> arr, int limit) {

        int shown = 0;
        for (IndoorPatient patient : arr) {

            if (!patient.underAge(limit)) {

                continue;

            }
            System.out.println(patient.details());
            shown++;

        }
        System.out.println("Patients shown: " + shown);

    }

    static LocalDate readDate(String msg, LocalDate min) {

        LocalDate dt = null;
        do {

            try {

                dt = LocalDate.parse(readText(msg));
                if (dt.isBefore(min)) {

                    dt = null;

                }

            } catch (DateTimeParseException e) {

                dt = null;

            }
            if (dt == null) {

                System.out.println("Enter a valid date on or after " + min + ".");

            }

        } while (dt == null);
        return dt;

    }

    static String readRequired(String msg) {

        String line;
        do {

            line = readText(msg);

        } while (line.isEmpty());
        return line;

    }

    static class Professor {

        private String name;
        private double salary;

        Professor(String nme, double pay) {

            name = nme;
            salary = pay;

        }

        String rank() {

            return "Professor";

        }

        void display(String dept) {

            System.out.printf("%s | %s | %s | Salary: %.2f%n", rank(), name, dept, salary);

        }

    }

    static class Dean extends Professor {

        private String department;

        Dean(String nme, double pay, String dept) {

            super(nme, pay);
            department = dept;

        }

        String rank() {

            return "Dean";

        }

        void display() {

            super.display(department);

        }

    }

    static class Executive extends Dean {

        Executive(String nme, double pay, String dept) {

            super(nme, pay, dept);

        }

        String rank() {

            return "Executive";

        }

    }

    public static int prog3(){

        Dean[] arr = {

            new Dean("Sample Dean", 25000, "English"),
            new Executive("Sample Executive", 42000, "Computer Science")

        };
        for (Dean x : arr) {

            x.display();

        }

        return 0;

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
