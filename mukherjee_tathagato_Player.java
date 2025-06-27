public class mukherjee_tathagato_Player extends ThreePrisonersDilemma.Player {

    // Determines the next action based on round number and opponent histories
    public int selectAction(int n, int[] myHistory, int[] oppHistory1, int[] oppHistory2) {

        // Cooperate during the first 10 rounds to establish trust and gather data
        if (n < 10) {
            return 0;
        }

        int recentWindow = 5;           // Number of recent rounds to consider
        int defectThreshold = 3;        // Threshold for switching to defection

        // Count defections by each opponent in the recent window
        int defectCount1 = countDefections(oppHistory1, n, recentWindow);
        int defectCount2 = countDefections(oppHistory2, n, recentWindow);

        // If either opponent defected frequently, switch to permanent defection
        if (defectCount1 >= defectThreshold || defectCount2 >= defectThreshold) {
            return 1;
        }

        // If either opponent defected in the previous round, respond with defection
        if (oppHistory1[n - 1] == 1 || oppHistory2[n - 1] == 1) {
            return 1;
        }

        // Default action is to cooperate
        return 0;
    }

    // Counts the number of defections in the specified window of recent rounds
    private int countDefections(int[] history, int round, int window) {
        int count = 0;
        for (int i = Math.max(0, round - window); i < round; i++) {
            if (history[i] == 1) {
                count++;
            }
        }
        return count;
    }
}

