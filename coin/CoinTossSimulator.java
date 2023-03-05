package coin;
import java.util.Random;

/**
 * class CoinTossSimulator
 * <p>
 * Simulate trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * <p>
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants,
 * and private methods to the class.  You will also be completing the
 * implementation of the methods given.
 * <p>
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 */

public class CoinTossSimulator {
    int trials = 0;
    int TwoHeads = 0;
    int TwoTails = 0;
    int HeadTail = 0;

    /**
     * Creates a coin toss simulator with no trials done yet.
     */
    public CoinTossSimulator() {
        this.trials = 0;
        this.TwoHeads = 0;
        this.TwoTails = 0;
        this.HeadTail = 0;

        // TODO
    }


    /**
     * Runs the simulation for numTrials more trials. Multiple calls to this method
     * without a reset() between them *add* these trials to the current simulation.
     *
     * @param numTrials number of trials to for simulation; must be >= 1
     */
    public int[] run(int numTrials) {

       numTrials = numTrials + this.trials;


        Random randcoin1 = new Random();
        Random randcoin2 = new Random();
        int[] Coinresult = {0, 0, 0, numTrials};



        for (int trails = 0; trails < numTrials; trails++ ) {

            int coin1 = randcoin1.nextInt(2);
            int coin2 = randcoin2.nextInt(2);

            if (coin1 % 2 == 0 && coin2 % 2 == 0)
                Coinresult[0]++;
            else if (coin1 % 2 == 1 && coin2 % 2 == 1)
                Coinresult[2]++;
            else
                Coinresult[1]++;

        }


        return Coinresult;
    }

        // TODO




    /**
     * Resets the simulation, so that subsequent runs start from 0 trials done.
     */
    public void reset() {
        this.trials = 0;
        this.TwoHeads = 0;
        this.TwoTails = 0;
        this.HeadTail = 0;
        // TODO
    }
}
