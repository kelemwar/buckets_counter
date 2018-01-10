import java.util.Scanner;

/**
 * Created by Banner on 08.12.2017.
 */

public class Main {

    public static void main(String[] args) {

        CalcWater calcWater = new CalcWater();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount water :");
        int amountWater = sc.nextInt();

        calcWater.allWays(amountWater).forEach(System.out::println);
        System.out.println("count = "+calcWater.allWays(amountWater).size());




    }
}
