package module2.lesson2.chess;

import javax.swing.*;

public class Knight extends Figure {

    public Knight(int x, int y, Icon icon) {
        super(x, y, icon);
    }

    @Override
    public boolean check(int x, int y) {
        return (this.x - x) * (this.x - x) +
                (this.y - y) * (this.y - y) == 5;
    }
}
