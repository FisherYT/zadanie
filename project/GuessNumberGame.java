import java.util.Scanner;

public class GuessNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            int lowerBound = 1;
            int upperBound = 1000;
            boolean numberGuessed = false;

            System.out.println("Загадайте число от 1 до 1000, и я попробую его угадать.");

            while (!numberGuessed) {
                int guess = (lowerBound + upperBound) / 2;
                System.out.println("Ваше число " + guess + "? (введите 'да', если угадал, 'больше', если ваше число больше, 'меньше', если ваше число меньше)");

                String response = scanner.nextLine().trim().toLowerCase();

                switch (response) {
                    case "да":
                        System.out.println("Урааа! Я угадал ваше число.");
                        numberGuessed = true;
                        break;
                    case "больше":
                        lowerBound = guess + 1;
                        break;
                    case "меньше":
                        upperBound = guess - 1;
                        break;
                    default:
                        System.out.println("Пожалуйста, введите 'да', 'больше' или 'меньше'.");
                }

                if (lowerBound > upperBound) {
                    System.out.println("Произошла ошибка. Пожалуйста, убедитесь, что вы отвечаете правильно.");
                    break;
                }
            }

            System.out.println("Хотите сыграть еще раз? (введите 'да' для новой игры, любой другой ввод завершит игру)");
            playAgain = scanner.nextLine().trim().toLowerCase();
        } while (playAgain.equals("да"));

        System.out.println("Спасибо за игру!");
        scanner.close();
    }
}
