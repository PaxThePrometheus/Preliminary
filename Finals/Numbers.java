import java.util.Scanner;

public class Numbers {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter ten numbers:");

        int[] numbers = new int[10];

        for (int x = 0; x < numbers.length; x++) {

            numbers[x] = input.nextInt();

        }

        System.out.println("Here is the list of evennumbers:");

        for (int x = 0; x < numbers.length; x++) {
            if (numbers[x] % 2 == 0) {

                System.out.print(numbers[x] + " ");

            }

        }


        input.close();

    }

}