class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        String curr = "";
        Integer left = null;
        Integer right = null;
        for (int num : nums) {
            if (left == null) {
                left = num;
                curr += left;
            } else {
                if (right != null && num - 1 != right) {
                    curr += "->" + right;
                    res.add(curr);
                    left = num;
                    curr = "" + num;
                    right = null;
                } else if (left != null && right == null && num - 1 != left) {
                    res.add(curr);
                    left = num;
                    curr = "" + num;
                } else {
                    right = num;
                }
            }
        }
        if (!curr.isEmpty()) {
            if (right != null) {
                curr += "->" + right;
            }
            res.add(curr);
        }
        return res;
    }
}
