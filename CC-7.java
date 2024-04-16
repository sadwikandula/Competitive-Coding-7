
// Problem1 
// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

// Time Complexity : O(nlogn)
// Space Complexity : 0(n) where n is the number of rows of matrix
// Did this code successfully run on Leetcode : yes

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(
                (a, b) -> Integer.compare(matrix[a[0]][a[1]], matrix[b[0]][b[1]]));

        // Insert the first element of each row into the heap
        for(int i=0; i<matrix.length;i++) 
        {
            heap.add(new int[]{i,0});
        }
        int result=0;
        // Extract the smallest element from the heap, k times
        for(int i=0;i<k;i++) 
        {
            int[] element = heap.poll();
            result = matrix[element[0]][element[1]];

            // Move to the next element in the same row
            if (element[1]+1 < matrix.length) {
                heap.add(new int[]{ element[0], element[1] + 1 });
            }
        }
        return result;
    }
}





// Problem 2
//https://leetcode.com/problems/meeting-rooms-ii/description/

// Time Complexity : O(nlogn)
// Space Complexity : 0(n) where n is the number of rows of intervals matrix
// Did this code successfully run on Leetcode : yes


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> e=new PriorityQueue<>();
        for(int[] interval:intervals)
        {
            e.add(interval[1]);
        }
        for(int[] interval:intervals)
        {
            if(interval[0]>=e.peek())
                e.poll();
        }
        return e.size();   
    }
}
