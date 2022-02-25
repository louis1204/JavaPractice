class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        // System.out.println(Arrays.toString(v1));
        // System.out.println(Arrays.toString(v2));
        for (int i = 0; i < Math.max(v1.length, v2.length); i++) {
            int v1Val = 0;
            if (i < v1.length) {
                v1Val = Integer.parseInt(v1[i]);
            }
            int v2Val = 0;
            if (i < v2.length) {
                v2Val = Integer.parseInt(v2[i]);
            }
            // System.out.println(v1Val);
            // System.out.println(v2Val);
            if (v1Val > v2Val) {
                return 1;
            } else if (v1Val < v2Val) {
                return -1;
            }
        }
        return 0;
    }
}
