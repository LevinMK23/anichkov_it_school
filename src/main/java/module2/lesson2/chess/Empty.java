package module2.lesson2.chess;

import javax.swing.*;

public class Empty extends Figure {

    public Empty(int x, int y, Icon icon) {
        super(x, y, icon);
    }

    @Override
    public boolean check(int x, int y) {
        return false;
    }
}
