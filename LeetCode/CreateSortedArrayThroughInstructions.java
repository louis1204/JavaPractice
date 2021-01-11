class Solution {
    int[] c;
    public int createSortedArray(int[] instructions) {
        int[] BIT = new int[100001];
        int res = 0;
        for (int i = 0; i < instructions.length; i++) {
            int inst = instructions[i];
            res = (res + Math.min(getLower(BIT, inst - 1),
                            i - getLower(BIT, inst))) % ((int)1e9 + 7);
            add(BIT, inst);
        }
        return res % ((int)1e9 + 7);
    }
    
    private int getLower(int[] BIT, int num) {
        int res = 0;
        while (num > 0) {
            res += BIT[num];
            num -= num & -num;
        }
        return res;
    }
    
    private void add(int[] BIT, int num) {
        while (num < BIT.length) {
            BIT[num]++;
            num += num & -num;
        }
    }
}
//https://www.hackerearth.com/practice/notes/binary-indexed-tree-or-fenwick-tree/
//https://leetcode.com/problems/create-sorted-array-through-instructions/discuss/927531/JavaC%2B%2BPython-Binary-Indexed-Tree
