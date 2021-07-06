package dev.namtx.leetcode.laststoneweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MaxHeap {
    List<Integer> harr;

    int heapSize;

    MaxHeap() {
        harr = new ArrayList<>();
        heapSize = 0;
    }

    public void insert(int k) {
        harr.add(heapSize, k);
        int i = heapSize;
        heapSize++;

        while (i != 0 && harr.get(i) > harr.get(parent(i))) {
            int tmp = harr.get(i);
            harr.set(i, harr.get(parent(i)));
            harr.set(parent(i), tmp);
            i = parent(i);
        }
    }

    public int removeMax() {
        int val = harr.get(0);

        if (heapSize == 1) {
            heapSize--;
            harr.remove(0);
            return val;
        }

        harr.set(0, harr.get(heapSize - 1));
        heapSize--;
        harr.remove(heapSize);
        heapify(0);

        return val;
    }

    public void heapify(int i) {
        if (heapSize <= 1) return;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        int largest = i;

        if (left < heapSize && harr.get(largest) < harr.get(left)) largest = left;

        if (right < heapSize && harr.get(largest) < harr.get(right)) largest = right;

        if (largest != i) {
            int tmp = harr.get(largest);
            harr.set(largest, harr.get(i));
            harr.set(i, tmp);

            heapify(largest);
        }
    }

    public static int parent(int i) {
        return (i - 1) / 2;
    }

    public List<Integer> getHarr() {
        return harr;
    }

    public int getHeapSize() {
        return heapSize;
    }

}

class Solution {
    public int lastStoneWeight(int[] stones) {
        int[] arr = new int[1001];
        Arrays.fill(arr, 0);
        for (int stone: stones) {
            arr[stone]++;
        }

        int right = 1000;
        int left;

        while (right >= 1) {
            if (arr[right] % 2 == 0) {
                arr[right--] = 0;
            } else {
                left = right - 1;
                while (left >= 1 && arr[left] == 0) left--;
                if (left > 0) {
                    arr[right - left]++;
                    arr[right]--;
                    arr[left]--;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i < 1001; i++) {
            if (arr[i] !=0) {
                return i;
            }
        }

        return 0;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lastStoneWeight(new int[]{3,7,2}));
    }
}
