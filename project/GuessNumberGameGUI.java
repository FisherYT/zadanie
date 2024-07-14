import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessNumberGameGUI extends JFrame {
    private int lowerBound = 1;
    private int upperBound = 1000;
    private int guess;
    private JLabel promptLabel;
    private JButton yesButton;
    private JButton higherButton;
    private JButton lowerButton;

    public GuessNumberGameGUI() {
        setTitle("Угадай число");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        promptLabel = new JLabel("Загадайте число от 1 до 1000, и я попробую его угадать.", SwingConstants.CENTER);
        add(promptLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 3));

        yesButton = new JButton("Да");
        higherButton = new JButton("Больше");
        lowerButton = new JButton("Меньше");

        buttonPanel.add(yesButton);
        buttonPanel.add(higherButton);
        buttonPanel.add(lowerButton);

        add(buttonPanel, BorderLayout.SOUTH);

        yesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                promptLabel.setText("Урааа! Я угадал ваше число.");
                disableButtons();
            }
        });

        higherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBound = guess + 1;
                makeGuess();
            }
        });

        lowerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upperBound = guess - 1;
                makeGuess();
            }
        });

        JButton playAgainButton = new JButton("Играть снова");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });

        add(playAgainButton, BorderLayout.CENTER);

        resetGame();
    }

    private void makeGuess() {
        if (lowerBound > upperBound) {
            promptLabel.setText("Произошла ошибка. Пожалуйста, убедитесь, что вы отвечаете правильно.");
            disableButtons();
        } else {
            guess = (lowerBound + upperBound) / 2;
            promptLabel.setText("Ваше число " + guess + "?");
        }
    }

    private void disableButtons() {
        yesButton.setEnabled(false);
        higherButton.setEnabled(false);
        lowerButton.setEnabled(false);
    }

    private void resetGame() {
        lowerBound = 1;
        upperBound = 1000;
        guess = (lowerBound + upperBound) / 2;
        promptLabel.setText("Загадайте число от 1 до 1000, и я попробую его угадать.");
        yesButton.setEnabled(true);
        higherButton.setEnabled(true);
        lowerButton.setEnabled(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new GuessNumberGameGUI().setVisible(true);
            }
        });
    }
}