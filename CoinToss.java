
import java.util.Random;

public class CoinToss {
    int TwoHeads = 0;
    int HeadTail = 0;
    int TwoTails = 0;

    public static int[] Coinout(int count) {
        Random randcoin1 = new Random();
        Random randcoin2 = new Random();
        int[] Coinresult = {0, 0, 0};



        for (int trails = 0; trails < count; trails++ ){

            int coin1 = randcoin1.nextInt(2);
            int coin2 = randcoin2.nextInt(2);

            if(coin1 % 2 == 0 && coin2 % 2 == 0)
                Coinresult[0]++;
            else if (coin1 % 2 == 1 && coin2 % 2 == 1)
                Coinresult[2]++;
            else
                Coinresult[1]++;

        }
        System.out.println(Coinresult );


        return Coinresult;
    }

}
