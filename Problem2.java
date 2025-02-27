import java.util.*;

public class BeautifulArray {
    public static int[] beautifulArray(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        
        while (result.size() < n) {
            List<Integer> temp = new ArrayList<>();
            
            for (int num : result) {
                if (2 * num - 1 <= n) {
                    temp.add(2 * num - 1); // Odd numbers
                }
            }
            
            for (int num : result) {
                if (2 * num <= n) {
                    temp.add(2 * num); // Even numbers
                }
            }
            
            result = temp;
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        
        for (int[] b : buildings) {
            height.add(new int[]{b[0], -b[2]}); // Start of a building
            height.add(new int[]{b[1], b[2]});  // End of a building
        }
        
        height.sort((a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        int prevHeight = 0;
        
        for (int[] h : height) {
            if (h[1] < 0) {
                pq.add(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            
            int currHeight = pq.peek();
            if (currHeight != prevHeight) {
                result.add(new int[]{h[0], currHeight});
                prevHeight = currHeight;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int n = 5; // Example input
        int[] beautifulArr = beautifulArray(n);
        System.out.println(Arrays.toString(beautifulArr));
        
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<int[]> skyline = getSkyline(buildings);
        for (int[] point : skyline) {
            System.out.println(Arrays.toString(point));
        }
    }
}
