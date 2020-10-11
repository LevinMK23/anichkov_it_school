package lesson3;

import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {

    static final ImageIcon xIcon = new ImageIcon("src/main/java/lesson3/x.jpg");
    static final ImageIcon oIcon = new ImageIcon("src/main/java/lesson3/o.jpg");
    static final ImageIcon emptyIcon = new ImageIcon("src/main/java/lesson3/empty.jpg");

    static JButton[][] buttons = new JButton[3][3];

    public Game() throws HeadlessException {
        setSize(730, 730);
        setLocation(300, 300);
        setResizable(false);
        JPanel panel = new JPanel(new GridLayout(3,3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();
                button.setIcon(emptyIcon);
                button.addActionListener(a -> {
                    System.out.println(a);
                    button.setIcon(xIcon);
                    button.setEnabled(false);
                    button.setDisabledIcon(xIcon);
                    // check victory
                    l:
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            if (buttons[k][l].getIcon().equals(emptyIcon)) {
                                buttons[k][l].setIcon(oIcon);
                                buttons[k][l].setEnabled(false);
                                buttons[k][l].setDisabledIcon(oIcon);
                                // check victory
                                break l;
                            }
                        }
                    }
                });
                buttons[i][j] = button;
                panel.add(button);
            }
        }
        add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
