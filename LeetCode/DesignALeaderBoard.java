class Leaderboard {

    int[] scores = new int[10001];
    
    public Leaderboard() {
        
    }
    
    public void addScore(int playerId, int score) {
        scores[playerId] += score;
    }
    
    public int top(int K) {
        int[] copy = Arrays.copyOf(scores, scores.length);
        Arrays.sort(copy);
        int res = 0;
        for (int i = 0; i < K; i++) {
            res += copy[copy.length - 1 - i];
        }
        return res;
    }
    
    public void reset(int playerId) {
        scores[playerId] = 0;
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
