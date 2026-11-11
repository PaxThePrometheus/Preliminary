import java.util.Scanner;
import java.util.Arrays;

public class MinMax {

    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);

        System.out.println("Enter five numbers:");

        int[] n = new int[5];

        for (int x = 0; x < n.length; x++) {

            n[x] = obj.nextInt();

        }

        int mn, mx;

        mn = Arrays.stream(n).min().getAsInt(); // Not needed
        mx = Arrays.stream(n).max().getAsInt();

        System.out.println("The difference from the highest: ");

        for (int x = 0; x < n.length; x++){

            System.out.println(mx + " - " + n[x] + " = " + (mx-n[x]));

        }


    }

}
