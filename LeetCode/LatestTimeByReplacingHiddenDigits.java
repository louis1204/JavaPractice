class Solution {
    public String maximumTime(String time) {
        int[] maxAt = new int[5];
        maxAt[0] = 2;
        // maxAt[1] = 9;
        maxAt[3] = 5;
        maxAt[4] = 9;
        StringBuilder sb = new StringBuilder();
        int ptr = 0;
        for (char c : time.toCharArray()) {
            if (c == '?') {
                if (ptr == 1) {
                    if (Integer.parseInt("" + sb.charAt(0)) < 2) {
                        sb.append(9);
                    } else {
                        sb.append(3);
                    }
                } else if (ptr == 0) {
                    if (time.charAt(1) == '?') {
                        sb.append(2);
                    } else if (Integer.parseInt("" + time.charAt(1)) > 3) {
                        sb.append(1);
                    } else {
                        sb.append(2);
                    }
                } else {
                    sb.append(maxAt[ptr]);
                }
            } else {
                sb.append(c);
            }
            ptr++;
        }
        return sb.toString();
    }
}
