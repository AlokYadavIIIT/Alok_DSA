class Solution {

    public int[][] kClosest(int[][] points, int k) {

        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();

        PriorityQueue<Integer> maxheap =
            new PriorityQueue<>(Collections.reverseOrder());

        // Store points according to their distance
        for (int[] point : points) {

            int x = point[0];
            int y = point[1];

            int distance = x * x + y * y;

            // If distance is not present, create a new list
            map.putIfAbsent(distance, new ArrayList<>());

            // Add point to that distance's list
            map.get(distance).add(point);

            // Add distance to max heap
            maxheap.add(distance);

            // Keep only k distances
            if (maxheap.size() > k) {
                maxheap.poll();
            }
        }

        int[][] ans = new int[k][2];

        // To keep track of which point of a particular distance
        // has already been taken

        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < k; i++) {

            int distance = maxheap.poll();

            ArrayList<int[]> list = map.get(distance);

            int index = indexMap.getOrDefault(distance, 0);

            ans[i] = list.get(index);

            indexMap.put(distance, index + 1);
        }

        return ans;
    }
}