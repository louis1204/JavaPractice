class Solution {
    public int[][] imageSmoother(int[][] img) {
        // Simply simulate
        int[][] res = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                res[i][j] = getAvg(img, i, j); 
            }
        }
        return res;
    }

    private int getAvg(int[][] img, int i, int j) {
        int[][] dirs = new int[][] {{0, 0}, {0, -1}, {0,  1}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 0}, {1, -1}, {1, 1}};
        int m = img.length;
        int n = img[m - 1].length;
        int count = 0;
        int sum = 0;
        for (int [] dir : dirs) {
            int a = i + dir[0];
            int b = j + dir[1];
            if (a < 0 || a >= m ||  b < 0 || b >= n) {
                continue;
            }
            count++;
            sum += img[a][b];
        }
        if (count == 0) {
            return 0;
        }
        return (int) Math.floor(sum / count);
    }
}
