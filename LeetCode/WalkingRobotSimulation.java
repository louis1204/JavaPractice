class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int dirInd = 0;
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        HashSet<List<Integer>> obsSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obsSet.add(List.of(obs[0], obs[1]));
        }
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        curr.add(0);
        int maxDist = 0;
        for (int com : commands) {
            if (com == -2) {
                dirInd--;
                if (dirInd < 0) {
                    dirInd = 3;
                }
            } else if (com == -1) {
                dirInd++;
                if (dirInd > 3) {
                    dirInd = 0;
                }
            } else {
                // walk
                while (com > 0) {
                    curr.set(0, curr.get(0) + dirs[dirInd][0]);
                    curr.set(1, curr.get(1) + dirs[dirInd][1]);
                    if (obsSet.contains(curr)) {
                        curr.set(0, curr.get(0) - dirs[dirInd][0]);
                        curr.set(1, curr.get(1) - dirs[dirInd][1]);
                        break;
                    } else {
                        int temp = (int) Math.pow(curr.get(0), 2) + (int) Math.pow(curr.get(1), 2);
                        maxDist = Math.max(maxDist, temp);
                    }
                    com--;
                }
            }
        }
        return maxDist;
    }
}
