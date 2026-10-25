import java.math.BigInteger;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class MidtermAct3 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Runnable[] arr = {

            MidtermAct3::prog1,
            MidtermAct3::prog2,
            MidtermAct3::prog3,
            MidtermAct3::prog4,
            MidtermAct3::prog5,
            MidtermAct3::prog6,
            MidtermAct3::prog7,
            MidtermAct3::prog8,
            MidtermAct3::prog9,
            MidtermAct3::prog10,
            MidtermAct3::prog11,
            MidtermAct3::prog12,
            MidtermAct3::prog13,
            MidtermAct3::prog14,
            MidtermAct3::prog15,
            MidtermAct3::prog16,
            MidtermAct3::prog17,
            MidtermAct3::prog18,
            MidtermAct3::prog19,
            MidtermAct3::prog20,
            MidtermAct3::prog21,
            MidtermAct3::prog22,
            MidtermAct3::prog23,
            MidtermAct3::prog24,
            MidtermAct3::prog25,
            MidtermAct3::prog26,
            MidtermAct3::prog27,
            MidtermAct3::prog28,
            MidtermAct3::prog29,
            MidtermAct3::prog30,
            MidtermAct3::prog31

        };
        for (Runnable task : arr) {

            task.run();

        }

    }

    public static int prog1(){

        System.out.println("\nActivity 1");
        String ltr = readText("Enter a letter: ");
        if (ltr.length() != 1 || !Character.isLetter(ltr.charAt(0))) {

            System.out.println("Not a letter");

            return 0;

        }
        boolean vowel = "aeiou".indexOf(Character.toLowerCase(ltr.charAt(0))) >= 0;
        System.out.println(vowel ? "VOWEL" : "CONSONANT");

        return 0;

    }

    public static int prog2(){

        System.out.println("\nActivity 2");
        int mnth = readInt("Month: ", 1, 12);
        int dy = readInt("Day: ", 1, 31);
        int yr = readInt("Year: ", 1, 9999);
        try {

            LocalDate dt = LocalDate.of(yr, mnth, dy);
            System.out.println(
                    dt.format(DateTimeFormatter.ofPattern("MMMM d, uuuu", Locale.ENGLISH)));

        } catch (DateTimeException e) {

            System.out.println("Invalid date");

        }

        return 0;

    }

    public static int prog3(){

        System.out.println("\nActivity 3");
        double temp = readNum("Temperature: ", -Double.MAX_VALUE, Double.MAX_VALUE);
        String[] state = {"ICE", "WATER", "STEAM"};
        int idx = temp < 0 ? 0 : temp > 100 ? 2 : 1;
        System.out.println(state[idx]);

        return 0;

    }

    public static int prog4(){

        System.out.println("\nActivity 4");
        double spd = readNum("Speed (km/h): ", 0, Double.MAX_VALUE);
        double lgth = readNum("Length (m): ", 0, Double.MAX_VALUE);
        String rslt = "It's a bird";
        if (spd >= 500 && lgth >= 20) {

            rslt = "Military aircraft";

        }
        if (spd > 1100 && lgth > 52) {

            rslt = "Civilian aircraft";

        }
        System.out.println(rslt);

        return 0;

    }

    public static int prog5(){

        System.out.println("\nActivity 5");
        String cid = readText("Class ID: ").toUpperCase();
        String ids = "BCDF";
        String[] ships = {"Battleship", "Cruiser", "Destroyer", "Frigate"};
        int idx = cid.length() == 1 ? ids.indexOf(cid) : -1;
        System.out.println(idx < 0 ? "Unknown class ID" : ships[idx]);

        return 0;

    }

    public static int prog6(){

        System.out.println("\nActivity 6");
        double rich = readNum("Richter scale: ", 0, Double.MAX_VALUE);
        double[] limits = {5, 5.5, 6.5, 7.5};
        String[] damage = {

            "Little or no damage", "Some damage", "Serious damage", "Disaster", "Catastrophe"

        };
        int idx = 0;
        while (idx < limits.length && rich >= limits[idx]) {

            idx++;

        }
        System.out.println(damage[idx]);

        return 0;

    }

    public static int prog7(){

        System.out.println("\nActivity 7");
        int num = readInt("Number [0-3000]: ", 0, 3000);
        System.out.println(numberWords(num));

        return 0;

    }

    public static int prog8(){

        System.out.println("\nActivity 8");
        int num = readInt("Number [1-3000]: ", 1, 3000);
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] syms = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder rmn = new StringBuilder();
        for (int x = 0; x < vals.length; x++) {

            rmn.append(syms[x].repeat(num / vals[x]));
            num %= vals[x];

        }
        System.out.println(rmn);

        return 0;

    }

    public static int prog9(){

        System.out.println("\nActivity 9");
        double fee = readNum("Tuition fee: ", 0, Double.MAX_VALUE);
        int mode = readInt("Payment [1 Cash | 2 Two installments | 3 Three installments]: ", 1, 3);
        double[] rates = {.90, .95, 1.10};
        System.out.printf("Total tuition fee: %,.2f%n", fee * rates[mode - 1]);

        return 0;

    }

    public static int prog10(){

        System.out.println("\nActivity 10");
        int grd = readInt("Grade: ", 0, 100);
        int[] lower = {98, 95, 92, 89, 85, 82, 80, 77, 75};
        String eqvl = "Out-of-Range";
        for (int x = lower.length - 1; x >= 0; x--) {

            if (grd >= lower[x]) {

                eqvl = String.format(Locale.ROOT, "%.2f", 1 + x * .25);

            }

        }
        System.out.println("Grade equivalent: " + eqvl);

        return 0;

    }

    public static int prog11(){

        System.out.println("\nActivity 11");
        long[] arr = new long[5];
        for (int x = 0; x < arr.length; x++) {

            arr[x] = (x + 1L) * (x + 1L);

        }
        showLoops(arr, "Squares");

        return 0;

    }

    public static int prog12(){

        System.out.println("\nActivity 12");
        long[] arr = new long[10];
        for (int x = 0; x < arr.length; x++) {

            int idx = x / 2;
            arr[x] = x % 2 == 0 ? idx + 1 : 5 - idx;

        }
        showLoops(arr, "Sequence");

        return 0;

    }

    public static int prog13(){

        System.out.println("\nActivity 13");
        long[] arr = new long[10];
        for (int x = 0; x < arr.length; x++) {

            int idx = x / 2;
            arr[x] = x % 2 == 0 ? 5 - idx : idx + 1;

        }
        showLoops(arr, "Sequence");

        return 0;

    }

    public static int prog14(){

        System.out.println("\nActivity 14");
        int num = readInt("Factorial [0-20]: ", 0, 20);
        long fact = 1;
        for (int x = num; x > 1; x--) {

            fact *= x;

        }
        System.out.println("For: " + fact);
        fact = 1;
        int x = num;
        while (x > 1) {

            fact *= x--;

        }
        System.out.println("While: " + fact);
        fact = 1;
        x = Math.max(1, num);
        do {

            fact *= x--;

        } while (x > 1);
        System.out.println("Do while: " + fact);

        return 0;

    }

    public static int prog15(){

        System.out.println("\nActivity 15");
        int num = readInt("Fibonacci terms [1-90]: ", 1, 90);
        long[] arr = new long[num];
        Arrays.fill(arr, 1);
        for (int x = 2; x < arr.length; x++) {

            arr[x] = arr[x - 1] + arr[x - 2];

        }
        showLoops(arr, "Fibonacci series");

        return 0;

    }

    public static int prog16(){

        System.out.println("\nActivity 16");
        int bse = readInt("Base: ", Integer.MIN_VALUE, Integer.MAX_VALUE);
        int expo = readInt("Exponent: ", 0, 1000);
        BigInteger pwr = BigInteger.ONE;
        BigInteger factor = BigInteger.valueOf(bse);
        for (int x = expo; x > 0; x--) {

            pwr = pwr.multiply(factor);

        }
        System.out.println("For: " + pwr);
        int x = expo;
        pwr = BigInteger.ONE;
        while (x-- > 0) {

            pwr = pwr.multiply(factor);

        }
        System.out.println("While: " + pwr);
        x = expo;
        pwr = BigInteger.ONE;
        if (x != 0) {

            do {

                pwr = pwr.multiply(factor);

            } while (--x > 0);

        }
        System.out.println("Do while: " + pwr);

        return 0;

    }

    public static int prog17(){

        System.out.println("\nActivity 17");
        int num = readInt("Sum of squares up to: ", 1, 100000);
        long sm = 0;
        for (int x = num; x >= 1; x--) {

            sm += (long) x * x;

        }
        System.out.println("For: " + sm);
        int x = num;
        sm = 0;
        while (x != 0) {

            sm += (long) x * x;
            x--;

        }
        System.out.println("While: " + sm);
        x = num;
        sm = 0;
        do {

            sm += (long) x * x;

        } while (--x > 0);
        System.out.println("Do while: " + sm);

        return 0;

    }

    public static int prog18(){

        System.out.println("\nActivity 18");
        int num = readInt("Sum up to: ", 1, 1000000);
        long sm = 0;
        for (int x = num; x > 0; x--) {

            sm += x;

        }
        System.out.println("For: " + sm);
        int x = num;
        sm = 0;
        while (x > 0) {

            sm += x--;

        }
        System.out.println("While: " + sm);
        x = num;
        sm = 0;
        do {

            sm += x;

        } while (--x > 0);
        System.out.println("Do while: " + sm);

        return 0;

    }

    public static int prog19(){

        System.out.println("\nActivity 19");
        int num = readInt("Number to reverse: ", 0, Integer.MAX_VALUE);
        String digits = Integer.toString(num);
        StringBuilder rvrs = new StringBuilder();
        for (int x = digits.length() - 1; x >= 0; x--) {

            rvrs.append(digits.charAt(x));

        }
        System.out.println("For: " + Long.parseLong(rvrs.toString()));
        rvrs.setLength(0);
        int x = digits.length();
        while (x > 0) {

            rvrs.append(digits.charAt(--x));

        }
        System.out.println("While: " + Long.parseLong(rvrs.toString()));
        rvrs.setLength(0);
        x = digits.length();
        do {

            rvrs.append(digits.charAt(--x));

        } while (x > 0);
        System.out.println("Do while: " + Long.parseLong(rvrs.toString()));

        return 0;

    }

    public static int prog20(){

        System.out.println("\nActivity 20");
        int num = readInt("Sum of powers up to [1-15]: ", 1, 15);
        long[] terms = new long[num];
        for (int x = 0; x < num; x++) {

            terms[x] = BigInteger.valueOf(x + 1).pow(x + 1).longValueExact();

        }
        long sm = 0;
        for (long x : terms) {

            sm += x;

        }
        System.out.println("For: " + sm);
        int x = terms.length;
        sm = 0;
        while (x > 0) {

            sm += terms[--x];

        }
        System.out.println("While: " + sm);
        x = terms.length;
        sm = 0;
        do {

            sm += terms[--x];

        } while (x > 0);
        System.out.println("Do while: " + sm);

        return 0;

    }

    public static int prog21(){

        System.out.println("\nActivity 21");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(0) + "* ".repeat(x));

        }

        return 0;

    }

    public static int prog22(){

        System.out.println("\nActivity 22");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(0) + binaryRow(x));

        }

        return 0;

    }

    public static int prog23(){

        System.out.println("\nActivity 23");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(2 * (rws - x)) + "* ".repeat(2 * x - 1));

        }

        return 0;

    }

    public static int prog24(){

        System.out.println("\nActivity 24");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(rws - x) + (x + " ").repeat(x));

        }

        return 0;

    }

    public static int prog25(){

        System.out.println("\nActivity 25");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(rws - x) + "* ".repeat(x));

        }

        return 0;

    }

    public static int prog26(){

        System.out.println("\nActivity 26");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(rws - x) + numberRow(x, x * (x - 1) / 2 + 1));

        }

        return 0;

    }

    public static int prog27(){

        System.out.println("\nActivity 27");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(0) + numberRow(x, x * (x - 1) / 2 + 1));

        }

        return 0;

    }

    public static int prog28(){

        System.out.println("\nActivity 28");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(0) + (x + " ").repeat(x));

        }

        return 0;

    }

    public static int prog29(){

        System.out.println("\nActivity 29");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(0) + numberRow(x, 1));

        }

        return 0;

    }

    public static int prog30(){

        System.out.println("\nActivity 30");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(2 * (rws - x)) + "* ".repeat(2 * x - 1));

        }
        for (int x = rws - 1; x >= 1; x--) {

            System.out.println(" ".repeat(2 * (rws - x)) + "* ".repeat(2 * x - 1));

        }

        return 0;

    }

    public static int prog31(){

        System.out.println("\nActivity 31");
        int rws = readInt("Number of rows: ", 1, 100);
        for (int x = 1; x <= rws; x++) {

            System.out.println(" ".repeat(rws - x) + mirrorRow(x));

        }

        return 0;

    }

    static String numberWords(int num) {

        String[] ones = {

            "zero",
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "eight",
            "nine",
            "ten",
            "eleven",
            "twelve",
            "thirteen",
            "fourteen",
            "fifteen",
            "sixteen",
            "seventeen",
            "eighteen",
            "nineteen"

        };
        String[] tens = {

            "", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"

        };
        if (num < 20) {

            return ones[num];

        }
        if (num < 100) {

            return tens[num / 10] + (num % 10 == 0 ? "" : " " + ones[num % 10]);

        }
        int unit = num >= 1000 ? 1000 : 100;
        String suffix = unit == 1000 ? " thousand" : " hundred";
        return numberWords(num / unit)
                + suffix
                + (num % unit == 0 ? "" : " " + numberWords(num % unit));

    }

    static void showLoops(long[] arr, String title) {

        System.out.println(title + " (for)");
        for (long val : arr) {

            System.out.print(val + " ");

        }
        System.out.println("\n" + title + " (while)");
        int x = 0;
        while (x < arr.length) {

            System.out.print(arr[x++] + " ");

        }
        System.out.println("\n" + title + " (do while)");
        x = 0;
        if (arr.length > 0) {

            do {

                System.out.print(arr[x++] + " ");

            } while (x < arr.length);

        }
        System.out.println();

    }

    static String numberRow(int width, int first) {

        StringBuilder row = new StringBuilder();
        for (int x = 0; x < width; x++) {

            row.append(first + x).append(' ');

        }
        return row.toString();

    }

    static String binaryRow(int width) {

        StringBuilder row = new StringBuilder();
        int bit = width % 2;
        for (int x = 0; x < width; x++) {

            row.append(bit).append(' ');
            bit = 1 - bit;

        }
        return row.toString();

    }

    static String mirrorRow(int width) {

        StringBuilder row = new StringBuilder(numberRow(width, 1));
        for (int x = width - 1; x > 0; x--) {

            row.append(x).append(' ');

        }
        return row.toString();

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
