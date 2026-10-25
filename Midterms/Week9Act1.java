import java.util.Scanner;

public class Week9Act1 {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        for (int opt = 1; opt <= 3; opt++) {

            repeatName(opt);

        }

    }

    static void repeatName(int opt) {

        System.out.print("Enter your name: ");
        String nme = scanner.nextLine();
        int left = 5;
        switch (opt) {

            case 1:
                while (left-- > 0) {

                    System.out.println(nme);

                }
                break;
            case 2:
                do {

                    System.out.println(nme);

                } while (--left > 0);
                break;
            case 3:
                for (; left > 0; left--) {

                    System.out.println(nme);

                }
                break;
            default:
                throw new IllegalArgumentException("Unknown loop type.");

        }

    }

}
