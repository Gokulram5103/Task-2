import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hey Welcome to Number Guessing game------>>\npress 1 to enter\n");
        int choice = scanner.nextInt();

        if (choice == 1) {
            for (int round = 1; round <= 3; round++) {
                System.out.println("Round " + round + "\n");
                int attempts = Attempts(round);
                if (numGuess(attempts)) {
                    System.out.println("You passed Round " + round + ". Proceed to next round.\n");
                } else {
                    System.out.println("You can't move to next round. Try later.\n");
                    break;
                }
            }
        } else {
            System.out.println("Exit");
        }
    }

    static int Attempts(int round) {
        switch (round) {
            case 1:
                return 12;
            case 2:
                return 8;
            case 3:
                return 4;
            default:
                return 0;
        }
    }

    static boolean numGuess(int attempts) {
        int random = new Random().nextInt(100) + 1;
        int score = 100;

        for (int i = 0; i < attempts; i++) {
            System.out.println("Guess the number in between 1 to 100 \n");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.\n");
                scanner.next(); // clear the buffer
                i--;
                continue;
            }

            int user = scanner.nextInt();

            if (user == random) {
                System.out.println("Congratulations!! You Guessed it Correctly in " + (i + 1) + " attempt \n");
                System.out.println("Your Score is :" + (score + ((attempts - i) * (attempts - i))));
                return true;
            } else if (i == attempts - 1) {
                System.out.println("You Failed to guess\n");
                return false;
            } else if (user > random && user < 100) {
                System.out.println("Your number is greater than the generated number\n");
                score -= 5;
            } else if (user < random) {
                System.out.println("Your number is lesser than the generated number\n");
                score -= 5;
            } else {
                System.out.println("Please enter the number in between 1 to 100\n");
                score -= 10;
            }
        }
        return true;
    }
}
