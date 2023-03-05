package coin;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class TryView extends JFrame {

    private int[] values;

    public TryView(int[] values) {
        this.values = values;
        setSize(500, 400);
        setTitle("柱状图");

        add(new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                int width = getWidth();
                int height = getHeight();

                int barWidth = width / 3 - 25; // 柱子宽度
                int maxValue = getMaxValue(values); // 数组中的最大值

                for (int i = 0; i < values.length; i++) {
                    int barHeight = (int) (((double) values[i] / maxValue) * (height * 0.6)); // 计算柱子高度
                    int x = i * width / 3 + 20; // 计算柱子的横坐标
                    int y = (int) (height * 0.8) - barHeight; // 计算柱子的纵坐标

                    switch (i) {
                        case 0:
                            g.setColor(Color.RED);
                            break;
                        case 1:
                            g.setColor(Color.GREEN);
                            break;
                        case 2:
                            g.setColor(Color.BLUE);
                            break;
                    }
                    g.fillRect(x, y, barWidth, barHeight); // 绘制柱子

                    // 绘制柱子下方的标签
                    g.setColor(Color.BLACK);
                    g.drawString(Integer.toString(values[i]), x + barWidth / 2, (int) (height * 0.85));
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // 获取数组中的最大值
    private int getMaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner count = new Scanner(System.in);
        int num;
        while (true) {
            System.out.print("请输入运行次数： ");
            String str = count.nextLine();
            if (str.matches("\\d+")) {  // 判断是否为数字
                num = Integer.parseInt(str);
                if (num >= 0) {  // 判断是否大于等于零
                    break;
                }
            }
            System.out.println("请输入正整数！");
        }

            CoinTossSimulator coinToss = new CoinTossSimulator();

            int[] coinout =  coinToss.run(num);
            int[] value = {0, 0, 0};

            value[0] = coinout[0];
            value[1] = coinout[1];
            value[2] = coinout[2];


            new TryView(values);
    }
}

