import javax.swing.*;
import java.util.Scanner;
public class trydraw {
    public static void main(String[] args) {



        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入试验次数：");
        int n = scanner.nextInt();

        CoinToss coinToss = new CoinToss();
        int[] data = coinToss.Coinout(n);
        JFrame frame = new JFrame("Bar");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Bar(data));
        frame.pack();
        frame.setVisible(true);

//        JFrame frame = new JFrame("Coin Toss Results");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.getContentPane().add(new Bar(result)); // 将result传入Bar类的构造函数中
//        frame.pack();
//        frame.setVisible(true);

    }
}

