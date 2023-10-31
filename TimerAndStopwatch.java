import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimerAndStopwatch {

    private static Timer timer;
    private static long startTime;
    private static long elapsedTime = 0;
    private static JLabel label;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Timer and Stopwatch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);
        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        label = new JLabel("00:00:00");
        label.setBounds(100, 20, 100, 25);
        panel.add(label);

        JButton startTimerButton = new JButton("Start Timer");
        startTimerButton.setBounds(30, 60, 100, 25);
        panel.add(startTimerButton);

        JButton stopTimerButton = new JButton("Stop Timer");
        stopTimerButton.setBounds(150, 60, 100, 25);
        panel.add(stopTimerButton);

        startTimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTimer();
            }
        });

        stopTimerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopTimer();
            }
        });

        JButton startStopwatchButton = new JButton("Start Stopwatch");
        startStopwatchButton.setBounds(30, 100, 120, 25);
        panel.add(startStopwatchButton);

        JButton stopStopwatchButton = new JButton("Stop Stopwatch");
        stopStopwatchButton.setBounds(160, 100, 120, 25);
        panel.add(stopStopwatchButton);

        startStopwatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startStopwatch();
            }
        });

        stopStopwatchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopStopwatch();
            }
        });
    }

    private static void startTimer() {
        elapsedTime = 0;
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime++;
                label.setText(formatTime(elapsedTime));
            }
        });
        timer.start();
    }

    private static void stopTimer() {
        if (timer != null) {
            timer.stop();
        }
    }

    private static void startStopwatch() {
        startTime = System.currentTimeMillis();
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                elapsedTime = System.currentTimeMillis() - startTime;
                label.setText(formatTime(elapsedTime / 1000));
            }
        });
        timer.start();
    }

    private static void stopStopwatch() {
        if (timer != null) {
            timer.stop();
        }
    }

    private static String formatTime(long elapsedSeconds) {
        int hours = (int) (elapsedSeconds / 3600);
        int minutes = (int) ((elapsedSeconds % 3600) / 60);
        int seconds = (int) (elapsedSeconds % 60);
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }
}
