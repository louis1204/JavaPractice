class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int max = 0;
        int emp = -1;
        for (int i = 0; i < logs.length; i++) {
            int id = logs[i][0];
            int endTime = logs[i][1];
            if (i == 0) {
                max = endTime;
                emp = id;
            } else {
                int timeTaken = endTime - logs[i - 1][1];
                if (timeTaken > max) {
                    max = timeTaken;
                    emp = id;
                }
                if (timeTaken == max) {
                    emp = Math.min(id, emp);
                }
            }
        }
        return emp;
    }
}
