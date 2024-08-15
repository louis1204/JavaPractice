class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = new int[3]; // 5, 10, 20
        // Always try to greedily give the biggest change popssible first
        for (int money : bills) {
            if (money == 5) {
                change[0]++;
            }
            if (money == 10) {
                if (change[0] > 0) {
                    change[0]--;
                    change[1]++;
                } else {
                    return false;
                }
            }
            if (money == 20) {
                if (change[0] > 0 && change[1] > 0) {
                    change[0]--;
                    change[1]--;
                    change[2]++; // technically not needed
                } else if (change[0] > 2) {
                    change[0] -= 3;
                    change[2]++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
