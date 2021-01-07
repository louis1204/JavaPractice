class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> contentToPaths = new HashMap<>();
        for (String path : paths) {
            String[] splitOnSpace = path.split(" ");
            // First would be directory
            String directory = splitOnSpace[0];
            for (int i = 1; i < splitOnSpace.length; i++) {
                String file = splitOnSpace[i].substring(0, splitOnSpace[i].indexOf('('));
                String content = splitOnSpace[i].substring(splitOnSpace[i].indexOf('('), splitOnSpace[i].indexOf(')') + 1);
                List<String> existing = contentToPaths.getOrDefault(content, new ArrayList<>());
                existing.add(directory + "/" + file);
                contentToPaths.put(content, existing);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (var entry : contentToPaths.entrySet()) {
            if (entry.getValue().size() > 1) {
                res.add(entry.getValue());
            }
        }
        return res;
    }
}
