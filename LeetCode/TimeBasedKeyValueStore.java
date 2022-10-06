class TimeMap {

    HashMap<String, List<Pair<Integer, String>>> map = new HashMap<>();

    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        List<Pair<Integer, String>> existing = map.getOrDefault(key, new ArrayList<>());
        existing.add(new Pair<>(timestamp, value));
        map.put(key, existing);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Pair<Integer, String>> list = map.get(key);
        if (timestamp < list.get(0).getKey()) {
            return "";
        }
        if (list.size() == 1) {
            return list.get(0).getValue();
        }
        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            // Find the entry with time <= timestamp
            int mid = (hi + lo) / 2;
            Pair<Integer, String> temp = list.get(mid);
            int currTime = temp.getKey();
            if (currTime == timestamp) {
                return temp.getValue();
            }
            if (currTime < timestamp) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return list.get(lo).getKey() <= timestamp ? list.get(lo).getValue() : list.get(lo - 1).getValue();
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
