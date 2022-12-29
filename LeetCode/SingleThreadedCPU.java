class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<int[]> backlog = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[2] - b[2];
            }
            return a[1] - b[1];
        });
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int previousEnd = 1;
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            queue.offer(new int[] {task[0], task[1], i});
        }
        List<Integer> res = new ArrayList<>();
        // enqueueTime, processingTime, task number
        while (!queue.isEmpty()) {
            int[] queueHead = queue.peek();
            // System.out.println(Arrays.toString(queueHead));
            // System.out.println(previousEnd);
            // System.out.println(backlog.toString());
            if (previousEnd == 1) {
                previousEnd = Math.max(previousEnd, queueHead[0]) + queueHead[1];
                res.add(queueHead[2]);
                queue.poll();
            } else if (queueHead[0] <= previousEnd) {
                backlog.offer(queue.poll());
            } else {
                int[] backlogHead = null;
                if (backlog.isEmpty()) {
                    backlogHead = queue.poll();
                } else {
                    backlogHead = backlog.poll();
                }
                previousEnd = Math.max(previousEnd, backlogHead[0]) + backlogHead[1];
                res.add(backlogHead[2]);
                // System.out.println(backlogHead[2]);
            }
        }
        while (!backlog.isEmpty()) {
            res.add(backlog.poll()[2]);
        }
        int[] actualRes = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            actualRes[i] = res.get(i);
        }
        return actualRes;
    }
}
