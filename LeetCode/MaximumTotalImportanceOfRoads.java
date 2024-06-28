class Solution {
    public long maximumImportance(int n, int[][] roads) {
        // We want to give the highest number to the highest number of connecting roads to a city
        // Count the number of connects for each city
        // Create a hashmap of city to connnections
        // Sort the cities based on number of connections
        // Count down from n and multiply with the next biggest city
        HashMap<Integer, Long> cityToRoads = new HashMap<>();
        for (int[] road : roads) {
            cityToRoads.put(road[0], cityToRoads.getOrDefault(road[0], 0l) + 1l);
            cityToRoads.put(road[1], cityToRoads.getOrDefault(road[1], 0l) + 1l);
        }
        List<Integer> cities = new ArrayList<>();
        cities.addAll(cityToRoads.keySet());
        cities.sort((a, b) -> (int)(cityToRoads.get(b) - cityToRoads.get(a)));
        long res = 0;
        for (int city : cities) {
            res += cityToRoads.get(city) * n--;
        }
        return res;
    }
}
