import java.math.BigInteger;
import java.util.Scanner;

public class Week7Act1 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        prog1();

    }

    public static int prog1(){

        for (; ; ) {

            System.out.print("Enter an integer: ");
            String line = scanner.nextLine().trim();
            try {

                boolean odd = new BigInteger(line).testBit(0);
                System.out.println("It's an " + (odd ? "odd" : "even") + " number!");

                return 0;

            } catch (NumberFormatException e) {

                System.out.println("That is not a valid integer.");

            }

        }

    }

}
