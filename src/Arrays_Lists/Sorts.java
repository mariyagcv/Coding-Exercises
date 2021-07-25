package Arrays_Lists;

public class Sorts {
    // Examples: https://stackabuse.com/sorting-algorithms-in-java
    // Merge operation source: https://www.baeldung.com/java-merge-sorted-arrays
    public static int[] bubbleSort(int[] arr) {
    // Complexity: O(n^2)
        int tmp;
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i=0; i<arr.length-1; i++) {
                if (arr[i]>arr[i+1]) {
                    tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    sorted = false;
                }
            }
        }
        return arr;
    }


    public static int[] insertionSort(int[] arr) {
        //Complexity: O(n^2)
        /*
        idea is that we have a lefthandside which is sorted and righthandside which is unsorted
        in the beginning, we start from 1 element "sorted" and we take each next element on the right
        we shift the elements on the left until we find a place to put the right element
         */
        for (int i=0; i<arr.length-1; i++) {
            int curr = arr[i];
            int previousIndex = i-1;
            while(previousIndex>=0 && curr < arr[previousIndex]) {
                arr[previousIndex+1] = arr[previousIndex]; //shifting
                previousIndex--;
            }
            arr[previousIndex+1] = curr;
        }
        return arr;
    }

    public static int[] selectionSort(int[] arr) {
        // Complexity: O(n^2)
        for(int i=0; i<arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[j]<min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // after we have found the min from the RHS, swap it with the i
            int tmp;
            tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }
        return arr;
    }
    // --------- merge sort

    public static int[] sort(int[] arr) {
        // Complexity n(logn); logn comes from the breaking down (mergeSort method) and the n
        // comes from worst case comparing n elements (the two halves of the array) at each breakdown
        // level
        // Space complexity: O(n) because of the additional array
        sort(arr, 0, arr.length-1);
        return arr;
    }

    public static void sort(int[] arr, int left, int right) {
        // splitting subroutine
        if (left<right) {
            int mid = (left + right)/2;
            sort(arr, left, mid);
            sort(arr, mid+1, right);
            merge(arr, left, mid, right);
        }

    }

    public static void merge(int[] arr,  int left, int mid, int right) {
        // the actual sort and merge subroutine
        // base case - if the array has length 1, then it's sorted

        // make the left and right arrays and copy the data from the original big array
        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        int leftLength = leftArr.length;
        int rightLength = rightArr.length;

        // copy from the big array
        for(int i=0; i<leftLength; i++) {
            leftArr[i] = arr[left + i];
        }
        for(int j=0; j<rightLength; j++) {
            rightArr[j] = arr[mid + 1 + j];
        }

        int leftIndex, rightIndex, mergedIndex;
        leftIndex = rightIndex = 0;
        mergedIndex = left;


        while(leftIndex < leftLength && rightIndex < rightLength) {
            if (leftArr[leftIndex] < rightArr[rightIndex]) {
                // if left is the smaller, we advance the pointer of the left array
                arr[mergedIndex] = leftArr[leftIndex];
                leftIndex++;
            }
            else {
                arr[mergedIndex] = rightArr[rightIndex];
                // if right is the smaller, we advance the pointer of the right array
                rightIndex++;
            }
            mergedIndex++;
        }

        //copy remaining elements if any from both arrays
        while(leftIndex<leftLength) {
            arr[mergedIndex] = leftArr[leftIndex];
            mergedIndex++;
            leftIndex++;
        }

        while(rightIndex<rightLength) {
            arr[mergedIndex] = rightArr[rightIndex];
            mergedIndex++;
            rightIndex++;
        }
    }

    //------------- end merge sort

    // ------------- Quicksort
    // Complexity: O(NlogN) best, O(n^2) worst;
    // Space complexity is O(logN) best case since it's inplace (so O(1) for each call) but
    // each recursive call has to be stored -> logN
    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length-1);
    }
    public static void quickSort(int[] arr, int left, int right) {
        if (left<right) {
            int pivot = (left + right)/2;
            // it will return the dividing point between the left and the rhs
            // i.e it will return the index of the "tail" at the end of the elements less than the pivot
            int index = partition(arr, left, right, pivot);
            quickSort(arr, left, index-1);
            quickSort(arr, index+1, right);
        }
    }
    public static void swap(int[] arr, int a, int b) {
        int tmp;
        tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static int partition(int[] arr, int left, int right, int pivot) {
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }

            while (arr[right] > pivot) {
                right--;
            }

           if (left <= right) {
               swap(arr, left, right);
               left++;
               right--;
           }
        }
        return left;
    }

    // ------------- end quicksort
    public static void main(String[] args) {
        int[] arr = new int[]{5,-1,3,2,1,9};
        quickSort(arr);
        System.out.println("array is: ");
        for (int i : arr) {
            System.out.print(i);
        }
    }
}
