class Solution {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> folders = new Stack<>();
        for (String folder : split) {
            if (folder.isEmpty() || ".".equals(folder)) {
                continue;
            }
            if ("..".equals(folder)) {
                if (!folders.isEmpty()) {
                    folders.pop();
                }
                continue;
            }
            folders.push(folder);
        }
        if (folders.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        while (!folders.isEmpty()) {
            sb.insert(0, "/" + folders.pop());
        }
        return sb.toString();
    }
}
