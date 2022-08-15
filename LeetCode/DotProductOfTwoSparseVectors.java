class SparseVector {
    HashMap<Integer, Integer> indToNum = new HashMap<>();
    
    SparseVector(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            indToNum.put(i, nums[i]);
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        int res = 0;
        for (Map.Entry<Integer, Integer> entry : vec.indToNum.entrySet()) {
            if (this.indToNum.containsKey(entry.getKey())) {
                res += indToNum.get(entry.getKey()) * entry.getValue();
            }
        }
        return res;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);
