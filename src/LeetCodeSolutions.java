import java.util.Arrays;
import java.util.HashMap;

public class LeetCodeSolutions {

    // LeetCode Problem #88
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] tempNums = new int[m];
        int i = 0;
        int j = 0;
        int k = 0;

        for (int l = 0; l < m; l++) {
            tempNums[l] = nums1[l];
        }

        while (i < m || j < n) {
            if (i >= m) {
                nums1[k] = nums2[j];
                j++;
                k++;
            } else if (j >= n) {
                nums1[k] = tempNums[i];
                i++;
                k++;
            } else {
                if (tempNums[i] <= nums2[j]) {
                    nums1[k] = tempNums[i];
                    i++;
                    k++;
                } else {
                    nums1[k] = nums2[j];
                    j++;
                    k++;
                }
            }
        }
    }

    // LeetCode Problem #905
    public int[] sortArrayByParity(int[] nums) {
        int m = nums.length;
        int[] temp = new int[m];

        int i = 0;
        while (i < m) {
            for (int j = 0; j < m; j++) {
                if (nums[j] % 2 == 0) {
                    temp[i] = nums[j];
                    i++;
                }
            }
            for (int k = 0; k < m; k++) {
                if (nums[k] % 2 != 0) {
                    temp[i] = nums[k];
                    i++;
                }
            }
        }
        return temp;
    }

    // LeetCode Problem #1122
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] tempArr = new int[arr1.length];
        int[] notIn = new int[arr1.length];
        HashMap map = new HashMap();

        for (int i = 0; i < arr2.length; i++) {
            map.put(arr2[i], 0);
        }

        int n = 0;
        for (int j = 0; j < arr1.length; j++) {
            if (map.containsKey(arr1[j])) {
                map.put(arr1[j], ((Integer) map.get(arr1[j]) + 1));
            } else {
                notIn[n] = arr1[j];
                n++;
            }
        }

        int p = 0;
        for (int k = 0; k < arr2.length; k++) {
            int count = (Integer) map.get(arr2[k]);
            for (int l = 0; l < count; l++) {
                tempArr[p] = arr2[k];
                p++;
            }
        }

        Arrays.sort(notIn, 0, n);
        for (int m = 0; m < n; m++) {
            tempArr[p] = notIn[m];
            p++;
        }
        return tempArr;
    }
}
