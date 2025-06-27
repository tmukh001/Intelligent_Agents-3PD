
public class mukherjee_tathagato_Player extends ThreePrisonersDilemma.Player {

    public int selectAction(int n, int[] myHistory, int[] oppHistory1, int[] oppHistory2) {
        // Grace period to gather behavior data
        if (n < 10) return 0;

        int recentWindow = 5;
        int triggerThreshold = 4;

        int recentDefects1 = countDefections(oppHistory1, n, recentWindow);
        int recentDefects2 = countDefections(oppHistory2, n, recentWindow);

        // Permanent defection trigger if opponent consistently defects
        if (recentDefects1 >= triggerThreshold || recentDefects2 >= triggerThreshold) {
            return 1;
        }

        // If both opponents defected in the last round, retaliate
        if (oppHistory1[n - 1] == 1 && oppHistory2[n - 1] == 1) {
            return 1;
        }

        // If one opponent has been fully cooperative for 20+ rounds, exploit softly
        if (n > 20 && isAlwaysCooperating(oppHistory1, n) || isAlwaysCooperating(oppHistory2, n)) {
            if (n % 25 == 0) return 1; // Defect rarely to gain points without breaking trust
        }

        return 0; // Default to cooperation
    }

    private int countDefections(int[] history, int round, int window) {
        int count = 0;
        for (int i = Math.max(0, round - window); i < round; i++) {
            if (history[i] == 1) {
                count++;
            }
        }
        return count;
    }

    private boolean isAlwaysCooperating(int[] history, int round) {
        for (int i = round - 20; i < round; i++) {
            if (i >= 0 && history[i] == 1) return false;
        }
        return true;
    }
}
