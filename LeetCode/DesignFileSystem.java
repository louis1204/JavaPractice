class FileSystem {

    Trie root = new Trie("/", -1);
    HashMap<String, Integer> pathToVal = new HashMap<>();
    
    public FileSystem() {
        
    }
    
    public boolean createPath(String path, int value) {
        String[] splitPath = path.split("/");
        
        HashMap<String, Trie> children = root.children;
        
        for (int i = 1; i < splitPath.length; i++) {
            String curr = splitPath[i];
            if (i != splitPath.length - 1) {
                if (children.containsKey(curr)) {
                    children = children.get(curr).children;
                } else {
                    return false;
                }
            }
            if (i == splitPath.length - 1) {
                if (children.containsKey(curr)) {
                    return false;
                } else {
                    children.put(curr, new Trie(curr, value));
                    pathToVal.put(path, value);
                    return true;
                }
            }
        }
        return true;
    }
    
    public int get(String path) {
        return pathToVal.getOrDefault(path, -1);
    }
    
    private class Trie {
        String curr = null;
        int val = -1;
        
        HashMap<String, Trie> children = new HashMap<>();
        
        public Trie(String curr, int val) {
            this.curr = curr;
            this.val = val;
        }
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */
