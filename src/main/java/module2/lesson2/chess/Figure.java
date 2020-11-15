package module2.lesson2.chess;

import javax.swing.*;

public abstract class Figure extends JButton {

    protected int x;
    protected int y;
    private Icon figureIcon;

    public Figure(int x, int y, Icon figureIcon) {
        this.x = x;
        this.y = y;
        this.figureIcon = figureIcon;
        setFigureIcon(figureIcon);
    }
    // 8 * 8
    public boolean preCheck(int x, int y) {
        return x >= 1 && x <= 8 && y >= 1 && y <= 8;
    }

    public abstract boolean check(int x, int y);

    public void moveFigure(int x, int y) {
        if (preCheck(x, y) && check(x, y)) {
            this.x = x;
            this.y = y;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Icon getFigureIcon() {
        return figureIcon;
    }

    public void setFigureIcon(Icon icon) {
        this.figureIcon = icon;
        setIcon(icon);
    }
}
