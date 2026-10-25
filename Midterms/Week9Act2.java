import java.util.Scanner;

public class Week9Act2 {

    public static void main(String[] args) {

        prog1();

    }

    public static int prog1(){

        Scanner scanner = new Scanner(System.in);
        String[] wrds = {

            "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"

        };
        boolean contd = true;
        while (contd) {

            System.out.print("Enter a number [1-10]: ");
            try {

                int num = Integer.parseInt(scanner.nextLine().trim()) - 1;
                System.out.println(num >= 0 && num < wrds.length ? wrds[num] : "Invalid Number");

            } catch (NumberFormatException e) {

                System.out.println("Invalid Number");

            }
            String reply;
            do {

                System.out.print("Again? y/n: ");
                reply = scanner.nextLine().trim().toLowerCase();

            } while (!reply.equals("y") && !reply.equals("n"));
            contd = reply.equals("y");

        }
        System.out.println("Goodbye!");

        return 0;

    }

}
