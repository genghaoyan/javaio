//import javax.swing.*;
//import java.awt.*;
//
//public class Bar extends JFrame {
//    private int[] data;
//
//    public Bar(int[] data) {
//        this.data = data;
//        setTitle("结果统计");
//        setSize(500, 500);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
//        setVisible(true);
//    }
//
//    @Override
//    public void paint(Graphics g) {
//        super.paint(g);
//        Graphics2D g2d = (Graphics2D) g;
//        int x = 50;
//        int y = 50;
//        int width = 50;
//        int height;
//        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE};
//        String[] names = {"一", "二", "三"};
//        for (int i = 0; i < 3; i++) {
//            height = data[i] * 20;
//            g2d.setColor(colors[i]);
//            g2d.fillRect(x, y + 400 - height, width, height);
//            g2d.setColor(Color.BLACK);
//            g2d.drawRect(x, y + 400 - height, width, height);
//            g2d.drawString(names[i], x + 10, y + 420);
//            g2d.drawString(Integer.toString(data[i]), x + 10, y + 390 - height);
//            x += 150;
//        }
//    }
//
//    public static void main(String[] args) {
//        CoinToss coinToss = new CoinToss();
//        int[] data = coinToss.Coinout(40);
//        Bar bar = new Bar(data);
//    }
//}

import javax.swing.*;
import java.awt.*;

public class Bar extends JPanel {
    private int[] data;

    public Bar(int[] data) {
        this.data = data;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        // 计算柱状图的位置和大小
        int barWidth = width / 3;
        int barHeightScale = height / (data[1] + 1);
        int barMargin = (barWidth - barHeightScale) / 2;

        // 绘制柱状图
        int x = 0;
        for (int i = 0; i < data.length; i++) {
            int y = height - (data[i] + 2) * barHeightScale ;

            // 设置不同颜色的柱子
            if (i == 0) {
                g2d.setColor(Color.RED);
            } else if (i == 1) {
                g2d.setColor(Color.YELLOW);
            } else if (i == 2) {
                g2d.setColor(Color.BLUE);
            }

            g2d.fillRect(x + barMargin, y, 3*barHeightScale, data[i] * barHeightScale);

            g2d.setColor(Color.BLACK);
            g2d.drawRect(x + barMargin, y, 3*barHeightScale, data[i] * barHeightScale);

//            g2d.drawString(Integer.toString(data[i]), x + 10, y - 5);
            g2d.drawString(Integer.toString(data[i]), x + barMargin, y - 5);
            // 绘制下方的数字
            g2d.drawString(Integer.toString(i+1), x + barMargin + 3*barHeightScale/2 - 5, height);

            x += barWidth;
        }
    }



    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

//    public static void main(String[] args) {
//        CoinToss coinToss = new CoinToss();
//        int[] data = coinToss.Coinout(100);
//        JFrame frame = new JFrame("Bar");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.add(new Bar(data));
//        frame.pack();
//        frame.setVisible(true);
//    }
}

