class Solution {
    public String predictPartyVictory(String senate) {
        int rBans = 0;
        int dBans = 0;
        int amtR = 0;
        int amtD = 0;
        StringBuilder sb = new StringBuilder(senate);
        while (true) {
            StringBuilder next = new StringBuilder();
            amtR = 0;
            amtD = 0;
            for (char ch : sb.toString().toCharArray()) {
                if (ch == 'R') {
                    if (rBans > 0) {
                        rBans--;
                    } else {
                        amtR++;
                        dBans++;
                        next.append(ch);
                    }
                } else {
                    if (dBans > 0) {
                        dBans--;
                    } else {
                        amtD++;
                        rBans++;
                        next.append(ch);
                    }
                }
            }
            if (amtR == 0) {
                return "Dire";
            }
            if (amtD == 0) {
                return "Radiant";
            }
            sb = next;
        }
    }
}
