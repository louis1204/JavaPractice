class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        for (int width1 = 1; width1 <= 3; width1++) {
            for (int width2 = 1; width2 <= 3; width2++) {
                for (int width3 = 1; width3 <= 3; width3++) {
                    for (int width4 = 1; width4 <= 3; width4++) {
                        int totalWidth = width1 + width2 + width3 + width4;
                        if (totalWidth != s.length()) {
                            continue;
                        }
                        String seg1 = s.substring(0, width1);
                        String seg2 = s.substring(width1, width1 + width2);
                        String seg3 = s.substring(width1 + width2, width1 + width2 + width3);
                        String seg4 = s.substring(width1 + width2 + width3, s.length());
                        // System.out.println(seg1);
                        // System.out.println(seg2);
                        // System.out.println(seg3);
                        // System.out.println(seg4);
                        // System.out.println("done");
                        if (isValid(seg1)
                                && isValid(seg2)
                                && isValid(seg3)
                                && isValid(seg4)) {
                            res.add(seg1 + "." + seg2 + "." + seg3 + "." + seg4);
                        }
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String seg) {
        // Number with a leading zero
        if (seg.charAt(0) == '0' && seg.length() > 1) {
            return false;
        }
        try {
            int num = Integer.parseInt(seg);
            return num >= 0 && num <= 255;
        } catch(Exception e) {
            return false;
        }
    }
}
