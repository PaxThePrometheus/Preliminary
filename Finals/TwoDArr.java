import java.util.Scanner;

public class TwoDArr {
    
    public static void main(String[] args) {

        Scanner obj = new Scanner(System.in);

        int[][] tdarr = new int[2][6];

        System.out.println("Enter twelve numbers:");

        for (int x = 0; x < tdarr.length; x++) {

            for (int y = 0; y < tdarr[x].length; y++) {

                tdarr[x][y] = obj.nextInt();

            }

        }

        int search;
        int count = 0;

        System.out.print("Enter a number to search: ");

        search = obj.nextInt();

        for (int x = 0; x < tdarr.length; x++) {

            for (int y = 0; y < tdarr[x].length; y++) {

                if (tdarr[x][y] == search) {

                    count++;
                
                }

            }

        }

        System.out.print("Occurence(s): " + ((count > 0) ? count : "No occurence"));

    }

}
