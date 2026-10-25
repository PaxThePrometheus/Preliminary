import java.util.ArrayList;
import java.util.Scanner;

public class MidtermAct4 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Runnable[] arr = {

            MidtermAct4::prog18,
            MidtermAct4::prog19,
            MidtermAct4::prog20,
            MidtermAct4::prog21,
            MidtermAct4::prog22,
            MidtermAct4::prog23,
            MidtermAct4::prog24,
            MidtermAct4::prog25

        };
        for (Runnable task : arr) {

            task.run();

        }

    }

    static class Entry {

        String label;
        double amt;

        Entry(String label, double amt) {

            this.label = label;
            this.amt = amt;

        }

    }

    static class Bill {

        String title;
        ArrayList<String> info = new ArrayList<>();
        ArrayList<Entry> rows = new ArrayList<>();

        Bill(String title) {

            this.title = title;

        }

        void add(String label, double amt) {

            if (!Double.isFinite(amt)) {

                throw new IllegalArgumentException("Amount is too large.");

            }
            rows.add(new Entry(label, amt));

        }

        double total() {

            double ttl = 0;
            for (Entry row : rows) {

                ttl += row.amt;

            }
            return ttl;

        }

        void discount(double pct) {

            add("Discount (" + pct + "%)", -total() * pct / 100);

        }

        void display(double paid) {

            System.out.println("\n" + title);
            for (String line : info) {

                System.out.println(line);

            }
            for (Entry row : rows) {

                System.out.printf("%-32s PHP %,.2f%n", row.label, row.amt);

            }
            double ttl = total();
            System.out.printf("Total: PHP %,.2f%nPaid: PHP %,.2f%n", ttl, paid);
            System.out.printf(
                    paid < ttl ? "Balance: PHP %,.2f%n" : "Change: PHP %,.2f%n",
                    Math.abs(ttl - paid));

        }

    }

    static void readInfo(Bill bill, String... labels) {

        for (String label : labels) {

            bill.info.add(label + ": " + readText(label + ": "));

        }

    }

    static void readFees(Bill bill, String... labels) {

        for (String label : labels) {

            bill.add(label, readNum(label + ": ", 0, 1000000000));

        }

    }

    static void readItems(Bill bill) {

        for (int x = 1; x <= 3; x++) {

            String nme = readText("Item " + x + ": ");
            int qty = readInt("Quantity: ", 1, 1000000);
            double prc = readNum("Unit price: ", 0, 1000000000);
            bill.add(nme + " (" + qty + " x " + prc + ")", qty * prc);

        }

    }

    static void settle(Bill bill) {

        bill.discount(readNum("Discount (%): ", 0, 100));
        bill.display(readNum("Amount paid: ", 0, 1000000000000000.0));

    }

    public static int prog18(){

        Bill pay = new Bill("Employee Payslip");
        readInfo(
                pay,
                "Employee name",
                "Employee ID",
                "Department",
                "Period start",
                "Period end",
                "Payout date");
        double bsl = readNum("Basic monthly salary: ", 0, 1000000000);
        double rgh = readNum("Regular hours: ", 0, 744);
        double oth = readNum("Overtime hours: ", 0, 744);
        int abd = readInt("Absent days: ", 0, 31);
        double hrr = bsl / 160;
        pay.add("Regular pay", rgh * hrr);
        pay.add("Overtime pay", oth * hrr * 1.25);
        readFees(pay, "Rice allowance", "Transport allowance", "Communication allowance");
        double grs = pay.total();
        pay.add("Absence deduction", -abd * bsl / 20);
        String[] labels = {"SSS", "PhilHealth", "PAG-IBIG", "Withholding tax", "Other deductions"};
        for (String label : labels) {

            pay.add(label, -readNum(label + ": ", 0, 1000000000));

        }
        pay.info.add(String.format("Gross pay: PHP %,.2f", grs));
        System.out.println("\nEmployee Payslip");
        for (String line : pay.info) {

            System.out.println(line);

        }
        for (Entry row : pay.rows) {

            System.out.printf("%-32s PHP %,.2f%n", row.label, row.amt);

        }
        System.out.printf("Net Pay: PHP %,.2f%n", pay.total());

        return 0;

    }

    public static int prog19(){

        Bill bill = new Bill("Student Tuition Billing");
        readInfo(bill, "Student name", "Student ID", "Course", "Year level");
        int unts = readInt("Units enrolled: ", 0, 100);
        double fpu = readNum("Tuition per unit: ", 0, 1000000000);
        bill.add("Tuition (" + unts + " units)", unts * fpu);
        readFees(bill, "Miscellaneous fee", "Laboratory fee", "Library fee", "Other fees");
        double grs = bill.total();
        double disc = readNum("Scholarship discount: ", 0, grs);
        bill.add("Scholarship discount", -disc);
        bill.display(readNum("Down payment: ", 0, 1000000000000.0));

        return 0;

    }

    public static int prog20(){

        Bill bill = new Bill("Customer Receipt");
        readInfo(bill, "Customer name", "Customer ID");
        readItems(bill);
        settle(bill);

        return 0;

    }

    public static int prog21(){

        Bill bill = new Bill("Event Ticket");
        readInfo(bill, "Customer name", "Customer ID", "Event", "Ticket type");
        int qty = readInt("Ticket quantity: ", 1, 1000000);
        double prc = readNum("Price per ticket: ", 0, 1000000000);
        bill.add("Tickets (" + qty + " x " + prc + ")", qty * prc);
        settle(bill);

        return 0;

    }

    public static int prog22(){

        Bill bill = new Bill("Reservation Billing");
        readInfo(bill, "Customer name", "Customer ID", "Reservation type");
        int dur = readInt("Duration: ", 1, 1000000);
        double rate = readNum("Rate: ", 0, 1000000000);
        bill.add("Reservation (" + dur + " units)", dur * rate);
        readFees(bill, "Food", "Service", "Other charges");
        settle(bill);

        return 0;

    }

    public static int prog23(){

        Bill bill = new Bill("Car Rental Receipt");
        readInfo(
                bill,
                "Customer name",
                "Customer ID",
                "Driver license",
                "Vehicle type",
                "Vehicle model",
                "Pickup date",
                "Return date");
        int days = readInt("Rental days: ", 1, 1000000);
        double rate = readNum("Rate per day: ", 0, 1000000000);
        bill.add("Rental (" + days + " days)", days * rate);
        readFees(bill, "Insurance", "Fuel", "Other charges");
        settle(bill);

        return 0;

    }

    public static int prog24(){

        Bill bill = new Bill("Restaurant Receipt");
        readInfo(bill, "Customer name");
        int typ = readInt("Order type [1 Dine-in | 2 Takeout]: ", 1, 2);
        bill.info.add(typ == 1 ? "Dine-in" : "Takeout");
        readItems(bill);
        readFees(bill, typ == 1 ? "Service charge" : "Packaging fee");
        settle(bill);

        return 0;

    }

    public static int prog25(){

        Bill bill = new Bill("Flower Reservation Receipt");
        readInfo(
                bill,
                "Customer name",
                "Customer ID",
                "Contact number",
                "Flower type",
                "Arrangement",
                "Reservation date",
                "Delivery date");
        int qty = readInt("Quantity: ", 1, 1000000);
        double prc = readNum("Price per arrangement: ", 0, 1000000000);
        bill.add("Arrangements (" + qty + " x " + prc + ")", qty * prc);
        readFees(bill, "Delivery fee", "Customization fee", "Other charges");
        settle(bill);

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
