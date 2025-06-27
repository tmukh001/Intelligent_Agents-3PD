
public class mukherjee_tathagato_Player extends ThreePrisonersDilemma.Player {

    public int selectAction(int n, int[] myHistory, int[] oppHistory1, int[] oppHistory2) {
        if (n < 10) return 0;  // Initial cooperation

        double defectScore1 = weightedDefections(oppHistory1, n, 5);
        double defectScore2 = weightedDefections(oppHistory2, n, 5);

        // Soft Grim Trigger
        if (defectScore1 >= 1.5 || defectScore2 >= 1.5) {
            return 1;
        }

        // Occasional exploitation of overly cooperative opponents
        if ((n % 10 == 0) && (isVeryCooperative(oppHistory1, n) || isVeryCooperative(oppHistory2, n))) {
            return 1;
        }

        // Tit-for-tat style reaction
        if (oppHistory1[n - 1] == 1 || oppHistory2[n - 1] == 1) {
            return 1;
        }

        return 0;  // Default to cooperate
    }

    private double weightedDefections(int[] history, int round, int window) {
        double score = 0.0;
        for (int i = 1; i <= window; i++) {
            int idx = round - i;
            if (idx >= 0 && history[idx] == 1) {
                score += (double)(window - i + 1) / window;  // Linearly weighted
            }
        }
        return score;
    }

    private boolean isVeryCooperative(int[] history, int round) {
        int coopCount = 0;
        for (int i = 0; i < round; i++) {
            if (history[i] == 0) coopCount++;
        }
        double rate = round == 0 ? 1.0 : (double)coopCount / round;
        return rate > 0.9;
    }
}
