class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();
        for (int ast : asteroids) {
            boolean isBroken = false;
            if (ast < 0) {
                while (!list.isEmpty() && list.get(list.size() - 1) > 0) {
                    if (list.get(list.size() - 1) * -1 == ast) {
                        isBroken = true;
                        list.remove(list.size() - 1);
                        break;
                    } else if (list.get(list.size() - 1) * -1 < ast) {
                        isBroken = true;
                        break;
                    } else {
                        list.remove(list.size() - 1);
                    }
                }
            }
            // Add if we're the same signage or empty
            if (!isBroken) {
                list.add(ast);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
