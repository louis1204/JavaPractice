class UndergroundSystem {

    HashMap<Pair<String, String>, int[]> totals = new HashMap<>();
    HashMap<Integer, Pair<String, Integer>> checkIns = new HashMap<>();
    
    public UndergroundSystem() {
        
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInData = checkIns.get(id);
        Pair<String, String> stations = new Pair<>(checkInData.getKey(), stationName);
        
        int[] existing = totals.getOrDefault(stations, new int[2]);
        existing[0] += t - checkInData.getValue();
        existing[1]++;
        
        totals.put(stations, existing);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        int[] total = totals.get(new Pair<>(startStation, endStation));
        return total[0] / (double)total[1];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
