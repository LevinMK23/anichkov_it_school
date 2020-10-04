import javax.swing.*;
import java.util.Random;

public class Win {

    static Random rnd = new Random();

    static void genWin(int[] x,  int[] y) {
        JFrame frame = new JFrame();
        frame.setSize(200, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(x[0], y[0]);
        int[] dx = new int[]{(int) (20 * Math.cos(rnd.nextDouble() * Math.PI))},
                dy =new int[] {(int) (20 * Math.sin(rnd.nextDouble() * Math.PI))};
        new Thread(() -> {
            while (true) {
                x[0] += dx[0];
                y[0] += dy[0];
                if (x[0]<= 0 || x[0] >= 1700) {
                    dx[0] *= -1;
                }
                if (y[0]<= 0 || y[0] >= 920) {
                    dy[0] *= -1;
                }
                frame.setLocation(x[0], y[0]);
                //frame.setVisible(true);
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 50; i++) {
            genWin(new int[]{0}, new int[]{0});
        }
    }
}
