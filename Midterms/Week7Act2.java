import java.util.Scanner;

public class Week7Act2 {

    public static void main(String[] args) {

        prog1();

    }

    public static int prog1(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter one letter: ");
        String line = scanner.nextLine().trim();
        if (line.length() != 1 || !Character.isLetter(line.charAt(0))) {

            System.out.println("Not a letter.");

            return 0;

        }
        String rslt;
        switch (Character.toLowerCase(line.charAt(0))) {

            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                rslt = "vowel";
                break;
            default:
                rslt = "consonant";

        }
        System.out.println("It's a " + rslt + "!");

        return 0;

    }

}
