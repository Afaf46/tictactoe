
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Main {

    private static char turn = 'X';
    private static JLabel title2;
    private static ArrayList<JLabel> labels = new ArrayList<JLabel>();
    private static String winner = " ";
    private static char[][] chars = new char[3][3];
    private static boolean enabled = true;

    public static void main(String[] args) {

        JFrame frame = new JFrame("Tic Tac Toe");
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setBackground(new Color(34, 45, 50));

        JLabel title = new JLabel("Tic Tac Toe");
        title.setBackground(new Color(34, 45, 50));
        title.setForeground(new Color(235, 235, 235));
        title.setOpaque(true);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        title.setFont(new Font("Arial", Font.BOLD, 36));
        frame.add(title, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, 10, 10));
        panel.setBackground(new Color(34, 45, 50));

        title2 = new JLabel("Player 1, it's your turn");
        title2.setHorizontalAlignment(SwingConstants.CENTER);
        title2.setBackground(new Color(34, 45, 50));
        title2.setForeground(new Color(235, 235, 235));
        title2.setOpaque(true);
        title2.setFont(new Font("Arial", Font.BOLD, 28));
        title2.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JLabel label = new JLabel(" ");
                label.setOpaque(true);
                label.setBackground(new Color(60, 63, 65));
                label.setForeground(new Color(255, 255, 255));
                label.setFont(new Font("Arial", Font.BOLD, 72));
                label.setHorizontalAlignment(SwingConstants.CENTER);
                int m = i;
                int n = j;
                label.addMouseListener(new MouseListener() {
                    @Override
                    public void mouseReleased(MouseEvent e) {
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                    }

                    @Override
                    public void mouseEntered(MouseEvent e) {
                    }

                    @Override
                    public void mouseClicked(MouseEvent e) {
                        if (enabled) {
                            if (label.getText().toString().equals(" ")) {
                                label.setText(String.valueOf(turn));
                                chars[m][n] = turn;
                                if (turn == 'X') {
                                    label.setForeground(new Color(0, 120, 215));
                                    turn = 'O';
                                    title2.setText("Player 2, it's your turn");
                                } else {
                                    label.setForeground(new Color(255, 99, 71));
                                    turn = 'X';
                                    title2.setText("Player 1, it's your turn");
                                }
                            } else {
                                title2.setText("Position taken!");
                            }
                            if (checkWinner() && winner.equals("X")) {
                                title2.setText("Player 1 wins!");
                                title2.setForeground(new Color(0, 120, 215));
                                enabled = false;
                            } else if (checkWinner() && winner.equals("O")) {
                                title2.setText("Player 2 wins!");
                                title2.setForeground(new Color(255, 99, 71));
                                enabled = false;
                            } else if (!draw()) {
                                title2.setText("Game Over!");
                                enabled = false;
                            }
                        }
                    }
                });
                labels.add(label);
                panel.add(label);
            }
        }
        frame.add(panel, BorderLayout.CENTER);

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 1));
        p.setBackground(new Color(34, 45, 50));
        p.add(title2);

        JButton btn = new JButton("New Game");
        btn.setBackground(new Color(0, 120, 215));
        btn.setForeground(Color.white);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reboot();
            }
        });
        p.add(btn);

        frame.add(p, BorderLayout.SOUTH);
        frame.setVisible(true);

    }

    private static boolean checkWinner() {
        boolean win = false;
        if (chars[0][0] == chars[0][1] && chars[0][0] == chars[0][2] && chars[0][0] != 0) {
            win = true;
            winner = String.valueOf(chars[0][0]);
        } else if (chars[1][0] == chars[1][1] && chars[1][0] == chars[1][2] && chars[1][0] != 0) {
            win = true;
            winner = String.valueOf(chars[1][0]);
        } else if (chars[2][0] == chars[2][1] && chars[2][0] == chars[2][2] && chars[2][0] != 0) {
            win = true;
            winner = String.valueOf(chars[2][0]);
        } else if (chars[0][0] == chars[1][0] && chars[0][0] == chars[2][0] && chars[0][0] != 0) {
            win = true;
            winner = String.valueOf(chars[0][0]);
        } else if (chars[0][1] == chars[1][1] && chars[0][1] == chars[2][1] && chars[0][1] != 0) {
            win = true;
            winner = String.valueOf(chars[0][1]);
        } else if (chars[0][2] == chars[1][2] && chars[0][2] == chars[2][2] && chars[0][2] != 0) {
            win = true;
            winner = String.valueOf(chars[0][2]);
        } else if (chars[0][0] == chars[1][1] && chars[0][0] == chars[2][2] && chars[0][0] != 0) {
            win = true;
            winner = String.valueOf(chars[0][0]);
        } else if (chars[2][0] == chars[1][1] && chars[2][0] == chars[0][2] && chars[2][0] != 0) {
            win = true;
            winner = String.valueOf(chars[2][0]);
        }
        return win;
    }

    private static void reboot() {
        chars = new char[3][3];
        winner = " ";
        title2.setText("Player 1, it's your turn");
        title2.setForeground(new Color(235, 235, 235));
        turn = 'X';
        enabled = true;
        for (JLabel label : labels) {
            label.setText(" ");
            label.setForeground(new Color(255, 255, 255));
        }
    }

    private static boolean draw() {
        boolean draw = false;
        for (char[] a : chars) {
            for (char b : a) {
                if (b == 0) {
                    draw = true;
                    break;
                }
            }
        }
        return draw;
    }
}
