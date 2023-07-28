package leetcode;
/*
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 */

import java.util.*;

public class MergeSortedArray {


    // [2.3,4,5]    [1,6,7,8]
    // [1,3,4,5]    [2,6,7,8]
    // [1,2,3,5,0,0,0,0]    [3,6,7,8]
    // [1,2,3,5,0,0,0,0]    [3,6,7,8]
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }
        while (p2 >= 0) {
            nums1[p] = nums2[p2];
            p2--;
            p--;
        }
    }

    public static void main(String[] args) {
       //Ввод: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
        //Вывод: [1,2,2,3,5,6]
        int[] nums1={1,2,3,0,0,0}, nums2={2,5,6};
        int m=3,n=3;
        merge(nums1,m,nums2,n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }
}
