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
    
    public static void main(String[] args) {
        int n = 5; // Example input
        int[] beautifulArr = beautifulArray(n);
        System.out.println(Arrays.toString(beautifulArr));
    }
}
