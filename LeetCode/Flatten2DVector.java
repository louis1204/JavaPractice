class Vector2D {
    int i = 0, j = -1;
    int[][] vec;

    public Vector2D(int[][] vec) {
        this.vec = vec;
        while (i < vec.length) {
            j++;
            if (j >= vec[i].length) {
                j = -1;
                i++;
            } else {
                break;
            }
        }
    }
    
    public int next() {
        int res = vec[i][j];
        while (i < vec.length) {
            j++;
            if (j >= vec[i].length) {
                j = -1;
                i++;
            } else {
                break;
            }
        }
        return res;
    }
    
    public boolean hasNext() {
        return vec.length > 0 && i < vec.length && j < vec[i].length;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D obj = new Vector2D(vec);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
