class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        // Sort by end times
        // Use a tree map with end times to max profit
        // Start with first job, get the lower of the tree map of start time + 1
        // Add that max to the current job's profit
        // Place in the tree map, current end time and the current profit, if it's greater than current
        // Keep track of the profits we can have, and return that as the result
        TreeMap<Integer, Integer> endTimeToMax = new TreeMap<>();
        List<Job> jobList = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            jobList.add(new Job(startTime[i], endTime[i], profit[i]));
        }
        jobList.sort(Job::compareTo);
        
        // System.out.println(jobList.toString());
        
        int max = Integer.MIN_VALUE;
        
        for (Job job : jobList) {
            Integer lowerMax = endTimeToMax.lowerKey(job.start + 1);
            if (lowerMax == null) {
                lowerMax = 0;
            } else {
                lowerMax = endTimeToMax.get(lowerMax);
            }
            int curr = lowerMax + job.profit;
            max = Math.max(max, curr);
            // Account for jobs with same endtimes
            Integer existingMax = endTimeToMax.lowerKey(job.end + 1);
            if (existingMax == null)  {
                existingMax = 0;
            } else {
                // Account for jobs that may have better maxes that overlap this job
                existingMax = endTimeToMax.get(existingMax);
            }
            endTimeToMax.put(job.end, Math.max(curr, existingMax));
        }
        return max;
    }
    
    private class Job implements Comparable {
        int start;
        int end;
        int profit;
        
        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
        
        @Override
        public int compareTo(Object o) {
            Job other = (Job)o;
            return this.end - other.end;
        }
        
        @Override
        public String toString() {
            return "start: " + start + " end: " + end + " profit: " + profit;
        }
    }
}
