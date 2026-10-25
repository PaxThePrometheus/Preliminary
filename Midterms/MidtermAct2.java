import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class MidtermAct2 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        prog1();

    }

    static class Reading {

        String nme;
        int ptl;
        int pgn;
        LocalDate isd;
        LocalDate dud;

        long daysLeft(LocalDate today) {

            return ChronoUnit.DAYS.between(today, dud);

        }

        void display(LocalDate today) {

            long drft = daysLeft(today);
            System.out.println("Hello, " + nme + "!");
            System.out.printf("Read: %d of %d pages (%.2f%%)%n", pgn, ptl, pgn * 100.0 / ptl);
            String deadline =
                    drft < 0
                            ? "Overdue by " + -drft + " days."
                            : drft == 0
                                    ? "Return the book today."
                                    : drft + " days left to return the book.";
            System.out.println(deadline);
            if (pgn == ptl) {

                System.out.println("You have finished the book.");
                return;

            }
            if (drft > 0) {

                long pace = (ptl - pgn + drft - 1) / drft;
                System.out.println("Read " + pace + " pages each day to finish on time.");

            }

        }

    }

    public static int prog1(){

        Reading book = new Reading();
        book.nme = readName();
        book.ptl = readInt("Total pages: ", 1, Integer.MAX_VALUE);
        book.pgn = readInt("Pages read: ", 0, book.ptl);
        LocalDate today = LocalDate.now();
        book.isd = readDate("Issue date (dd mm yyyy): ", LocalDate.of(1, 1, 1), today);
        book.dud =
                readDate(
                        "Due date (dd mm yyyy): ",
                        book.isd.plusDays(1),
                        LocalDate.of(9999, 12, 31));
        book.display(today);

        return 0;

    }

    static String readName() {

        String nme;
        do {

            nme = readText("Enter your name: ");
            if (nme.matches(".*[\\p{L}].*") && nme.matches("[\\p{L} .'-]+")) {

                return nme;

            }
            System.out.println("Enter a name using letters.");

        } while (true);

    }

    static LocalDate readDate(String msg, LocalDate min, LocalDate max) {

        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("d M uuuu").withResolverStyle(ResolverStyle.STRICT);
        for (; ; ) {

            try {

                LocalDate dt = LocalDate.parse(readText(msg).replaceAll("\\s+", " "), fmt);
                if (!dt.isBefore(min) && !dt.isAfter(max)) {

                    return dt;

                }

            } catch (DateTimeParseException e) {

            }
            System.out.println("Enter a real date from " + min + " through " + max + ".");

        }

    }

    static String readText(String msg) {

        System.out.print(msg);
        return scanner.nextLine().trim();

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
