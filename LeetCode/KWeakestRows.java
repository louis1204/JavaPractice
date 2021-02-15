class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int strength = 0;
            for (int j = 0; j < mat[i].length; j++) {
                strength += mat[i][j];
            }
            rows.add(new Row(strength, i));
        }
        rows.sort((a, b) -> a.compareTo(b));
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = rows.get(i).num;
        }
        return res;
    }
    
    class Row implements Comparable {
        int strength;
        int num;
        
        public Row(int strength, int num) {
            this.strength = strength;
            this.num = num;
        }
        
        @Override
        public int compareTo(Object o) {
            Row other = (Row) o;
            return this.strength - other.strength;
        }
    }
}
