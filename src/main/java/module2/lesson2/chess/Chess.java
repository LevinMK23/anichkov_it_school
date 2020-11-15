package module2.lesson2.chess;

import javax.swing.*;
import java.awt.*;

public class Chess extends JFrame {

    private Figure [][] map = new Figure[9][9];
    private final static Icon EMPTY_ICON = new ImageIcon("empty.jpg");
    private final static Icon KNIGHT_ICON = new ImageIcon("knight.jpg");
    private final static Icon CHECK_ICON = new ImageIcon("check.jpg");

    public Chess() throws HeadlessException {
        setSize(560, 560);
        setLocation(300, 300);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map[i][j] = new Empty(i, j, EMPTY_ICON);
            }
        }
        map[1][2] = new Knight(1, 2, KNIGHT_ICON);
        JPanel panel = new JPanel(new GridLayout(8, 8));
        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                panel.add(map[i][j]);
                setVisible(true);
                int finalI = i;
                int finalJ = j;
                map[i][j].addActionListener(a -> {
                    System.out.println(map[finalI][finalJ].getClass());
                    for (int x = 1; x < 9; x++) {
                        for (int y = 1; y < 9; y++) {
                            setVisible(true);
                            if (map[finalI][finalJ].check(x, y)) {
                                System.out.println("+");
                                map[x][y].setFigureIcon(CHECK_ICON);
                                setVisible(true);
                                Figure figure = map[finalI][finalJ];
                                int finalX = x;
                                int finalY = y;
                                map[x][y].addActionListener(e -> {
                                    map[finalX][finalY] = new Knight(finalI, finalJ, KNIGHT_ICON);
                                    map[finalX][finalY].setFigureIcon(map[finalX][finalY].getFigureIcon());
                                    map[finalI][finalJ] = new Empty(finalX, finalY, EMPTY_ICON);
                                    map[finalI][finalJ].setIcon(EMPTY_ICON);
                                    for (int k = 0; k < 9; k++) {
                                        for (int l = 0; l < 9; l++) {
                                            if (map[k][l].getFigureIcon().equals(CHECK_ICON)) {
                                                System.out.println("****");
                                                map[k][l] = new Empty(k, l, EMPTY_ICON);
                                                setVisible(true);
                                            }
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            }
        }
        panel.setVisible(true);
        //panel.repaint();
        add(panel);
        setVisible(true);
        //repaint();
    }

    public static void main(String[] args) {
        new Chess();
    }
}
