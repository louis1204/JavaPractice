class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // With the pairs, we can form components if they overlap.
        // Letters in each component can be swapped any number of times
        // Sort the letters in each component
        // Reconstruct
        int[] unionFind = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            unionFind[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int parentA = find(pair.get(0), unionFind);
            int parentB = find(pair.get(1), unionFind);
            if (parentA != parentB) {
                unionFind[parentA] = parentB;
            }
        }
        System.out.println(Arrays.toString(unionFind));
        HashMap<Integer, String> compToString = new HashMap<>();
        int[] compInd = new int[s.length()];
        
        for (int i = 0; i < unionFind.length; i++) {
            int comp = find(i, unionFind);
            compToString.put(comp, compToString.getOrDefault(comp, "") + s.charAt(i));
        }
        for (Map.Entry<Integer, String> entry : compToString.entrySet()) {
            char[] chars = entry.getValue().toCharArray();
            Arrays.sort(chars);
            compToString.put(entry.getKey(), new String(chars));
        }
        String res = "";
        for (int i = 0; i < unionFind.length; i++) {
            int comp = find(i, unionFind);
            int ind = compInd[comp];
            String st = compToString.get(comp);
            res += st.charAt(ind);
            compInd[comp]++;
        }
        return res;
    }
    
    private int find(int node, int[] unionFind) {
        if (node != unionFind[node]) {
            int parent = find(unionFind[node], unionFind);
            unionFind[node] = parent;
            return parent;
        }
        return node;
    }
}
