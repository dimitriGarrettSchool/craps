import java.util.Random;
import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args)
    {
        boolean looping = true;

        while (looping)
        {
            int roll1 = roll();
            int roll2 = roll();

            System.out.println("Your first roll was: " + roll1);
            System.out.println("Your second roll was: " + roll2);

            int sum = points(roll1, roll2);

            System.out.println("You rolled a sum of: " + sum);

            if (sum == 2 || sum == 3 || sum == 12)
            {
                System.out.println("You lost!");
            }

            else if (sum == 7 || sum == 11)
            {
                System.out.println("You win!");
            }

            else
            {
                System.out.println("Now rolling to get a sum of " + sum + " to win, or 7 to lose!");
                int sum1 = 0;
                while (sum1 != 7 && sum1 != sum)
                {
                    int roll11 = roll();
                    int roll21 = roll();

                    System.out.println("Your first roll was: " + roll11);
                    System.out.println("Your second roll was: " + roll21);

                    sum1 = points(roll11, roll21);

                    System.out.println("You rolled a sum of: " + sum1);

                    if (sum1 == 7)
                    {
                        System.out.println("You rolled 7, you lose!");
                    }

                    else if (sum1 == sum)
                    {
                        System.out.println("You win!");
                    }
                }
            }

            looping = SafeInput.getYN(scanner, "Do you want to play again: ");
        }
    }

    private static int roll()
    {
        return random.nextInt(6) + 1;
    }

    private static int points(int roll1, int roll2)
    {
        return roll1 + roll2;
    }
}