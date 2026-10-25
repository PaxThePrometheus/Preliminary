import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MidtermAct1 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Runnable[] arr = {

            MidtermAct1::prog1,
            MidtermAct1::prog2,
            MidtermAct1::prog3,
            MidtermAct1::prog4,
            MidtermAct1::prog5,
            MidtermAct1::prog6,
            MidtermAct1::prog7

        };
        for (Runnable task : arr) {

            task.run();

        }

    }

    public static int prog1(){

        double sepr = 0;
        double lowest = Double.POSITIVE_INFINITY;
        int nadr = 0;
        ArrayList<Double> astr = new ArrayList<>();

        for (int x = 1; x <= 10; x++) {

            double num = readNum("Enter number " + x + ": ", -Double.MAX_VALUE, Double.MAX_VALUE);
            lowest = Math.min(lowest, num);
            if (num > 0) {

                nadr++;
                sepr += num;

            }
            if (num < 0) {

                astr.add(num);

            }

        }

        System.out.println("Sum of positive values: " + sepr);
        System.out.println("Average of positive values: " + (nadr == 0 ? 0 : sepr / nadr));
        System.out.println("Negative values: " + astr);
        System.out.println("Count of negative values: " + astr.size());
        System.out.println("Minimum value: " + lowest);

        return 0;

    }

    public static int prog2(){

        ArrayList<Integer> dupl = new ArrayList<>();
        for (int x = 1; x <= 8; x++) {

            int num = readInt("Enter number " + x + ": ", Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (!dupl.contains(num)) {

                dupl.add(num);

            }

        }

        System.out.println("Array without duplicates: " + dupl);
        if (dupl.size() >= 2) {

            dupl.sort(null);
            System.out.println("Second smallest element: " + dupl.get(1));
            System.out.println("Second largest element: " + dupl.get(dupl.size() - 2));

        } else {

            System.out.println("There is no second largest or second smallest element.");

        }

        return 0;

    }

    public static int prog3(){

        int[] arr = readArray(5);
        System.out.println("Stored data: " + Arrays.toString(arr));
        int poss = readInt("Position to delete [0-4]: ", 0, arr.length - 1);
        System.arraycopy(arr, poss + 1, arr, poss, arr.length - poss - 1);
        int[] nwar = Arrays.copyOf(arr, arr.length - 1);
        System.out.println("New data: " + Arrays.toString(nwar));

        return 0;

    }

    public static int prog4(){

        int size = readInt("Array size: ", 0, 10000);
        int[] arr = readArray(size);
        StringBuilder even = new StringBuilder();
        StringBuilder odd = new StringBuilder();
        for (int x : arr) {

            StringBuilder part = x % 2 == 0 ? even : odd;
            part.append(x).append(' ');

        }
        System.out.println("Even Elements: " + even.toString().trim());
        System.out.println("Odd Elements: " + odd.toString().trim());

        return 0;

    }

    public static int prog5(){

        String row = "*";
        for (int x = 0; x < 4; x++) {

            System.out.println(row);
            row += "A*";

        }

        return 0;

    }

    static class Student {

        private String studentNo;
        private String studentName;
        private LocalDate dateOfBirth;
        private int tariffPoints;
        private static int noOfStudents;

        Student() {

            this("not known", "not known", LocalDate.of(1995, 1, 1), 20);

        }

        Student(String sno, String nme, LocalDate dob, int pts) {

            update(sno, nme, dob, pts);
            noOfStudents++;

        }

        void update(String sno, String nme, LocalDate dob, int pts) {

            if (sno == null || sno.isBlank() || nme == null || nme.isBlank()) {

                throw new IllegalArgumentException("Student number and name are required.");

            }
            if (dob == null || dob.isAfter(LocalDate.now()) || pts < 20 || pts > 280) {

                throw new IllegalArgumentException("Invalid birth date or tariff points.");

            }
            studentNo = sno.trim();
            studentName = nme.trim();
            dateOfBirth = dob;
            tariffPoints = pts;

        }

        String[] details() {

            return new String[] {studentNo, studentName, dateOfBirth.toString(), "" + tariffPoints};

        }

        static int getNoOfStudents() {

            return noOfStudents;

        }

    }

    public static int prog6(){

        Student[] arr = {

            new Student(),
            new Student("2026-0001", "Sample Student", LocalDate.of(2005, 6, 15), 150)

        };
        for (Student x : arr) {

            System.out.println(String.join(" | ", x.details()));

        }
        System.out.println("Number of students: " + Student.getNoOfStudents());

        return 0;

    }

    public static int prog7(){

        int size = readInt("Number of employees: ", 0, 1000);
        String[][] arr = new String[size][3];
        String[] cols = {"Employee number", "Employee name", "Mobile"};
        for (int x = 0; x < size; x++) {

            System.out.println("Employee " + (x + 1));
            for (int y = 0; y < cols.length; y++) {

                do {

                    arr[x][y] = readText(cols[y] + ": ");

                } while (arr[x][y].isEmpty());

            }

        }
        System.out.printf("%-18s%-28s%-18s%n", cols[0], cols[1], cols[2]);
        for (String[] row : arr) {

            System.out.printf("%-18s%-28s%-18s%n", row[0], row[1], row[2]);

        }
        System.out.println("Records inserted: " + size);

        return 0;

    }

    static int[] readArray(int size) {

        int[] arr = new int[size];
        for (int x = 0; x < size; x++) {

            arr[x] =
                    readInt("Enter number " + (x + 1) + ": ", Integer.MIN_VALUE, Integer.MAX_VALUE);

        }
        return arr;

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
