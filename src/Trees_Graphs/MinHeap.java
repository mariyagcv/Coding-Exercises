package Trees_Graphs;

//todo: this is wrong, doesn't obey the Heap property, you should fix !!
public class MinHeap {
    //A min-heap is 1. a complete binary tree (that is, totally filled other than the rightmost elements on the last
    //level) where 2. each node is smaller than ALL its children. it's NOT a BST so BST property is not kept
    /*
    When we insert into a min-heap, we always start by inserting the element at the bottom. We insert at the
    rightmost spot so as to maintain the complete tree property.
    Then, we "fix" the tree by swapping the new element with its parent, until we find an appropriate spot for
    the element.

    !!!: Since it's a complete tree (i.e all levels are full except for last element on last level),
    IT IS IMPLEMENTED WITH ARRAYS

    example heap: 3, 13, 7, 16, 21, 12, 9
    root of ith node: arr[(i-1)/2]
    left child of ith node: arr[(i*2) + 1]
    right child of ith node: arr[(i*2) + 2]

    Complexities: Insert - O(logn) since when we insert, we might have to do logn operations (up along the depth of the tree)
    to swap elements; Same for Remove;
    O(1) for getting min
    Search: O(n) (since it's a binary tree but not BST)
    Insertion from list: O(nlogn) - n insertions at logn cost each one (because of heapify)
    */

    private int[] minHeap;
    private int size;
    private int lastAvailablePosition;

    public MinHeap(int size) {
        this.size = size;
        minHeap = new int[size];
        lastAvailablePosition = 0;
    }

    private int parentNodeIndex(int i) {
        return (i-1)/2;
    }

    private int leftChildIndex (int i) {
        return (i*2)+1;
    }

    private int rightChildIndex (int i) {
        return (i*2)+2;
    }

    public void swap(int a, int b) {
        int tmp = minHeap[a];
        minHeap[a] = minHeap[b];
        minHeap[b] = tmp;
    }

    public void bubbleUp(int indexOfAddedElement) {
        // swap while the parent is bigger than it
        while (minHeap[parentNodeIndex(indexOfAddedElement)] > minHeap[indexOfAddedElement] && indexOfAddedElement > 0) {
            swap(indexOfAddedElement, parentNodeIndex(indexOfAddedElement));
            indexOfAddedElement = parentNodeIndex(indexOfAddedElement); //it takes the place of the parent so it takes his index
        }
//        parentIndex = rightChildIndex(indexOfAddedElement); // parent becomes its child
    }

    public void insert(int value) {
        if (lastAvailablePosition==size) {
            return; // the heap is full and we can't insert an element
        }

        int currentIndex = lastAvailablePosition;
        // we always insert at the rightmost side; on every insert, lastAvailablePosition is
        // incremented so it will serve always as the correct index for the last position

        //so we just put the element there and then call bubbleUp if it needs to bubble
        minHeap[currentIndex] = value;
        // bubble
        bubbleUp(currentIndex);
        lastAvailablePosition++;
    }

    public void siftDown(int root) { //the index of the root
        // sifting down is like the bubble up but the other way around, since we compare
        // values with children's values, instead of parent's

        //case1: has no children, so we just return (nothing to do)
        if(leftChildIndex(root)>size && rightChildIndex(root)>size)
            return;
        // case 2: has one child
        if (leftChildIndex(root)>size) {
            if (minHeap[rightChildIndex(root)]>root) {
                // if the Heap property is broken
                // we swap the current element with the child
                swap(root, minHeap[rightChildIndex(root)]);
                siftDown(rightChildIndex(root));

            }

            else { // the only child is on the right side, so we swap if needed and we sift down
                if (minHeap[leftChildIndex(root)]>root) {
                    swap(root, minHeap[leftChildIndex(root)]);
                    siftDown(leftChildIndex(root));
                }
            }
        }

        // case 3: it has two children
        else {
            // we find the minimum of the two children and we sift down this node
            if (minHeap[leftChildIndex(root)] < minHeap[rightChildIndex(root)]) {
                if (minHeap[leftChildIndex(root)] > root) {
                    swap(root, leftChildIndex(root));
                    siftDown(leftChildIndex(root));
                }
            }
            else {
                if (minHeap[rightChildIndex(root)] > root) {
                    swap(root, rightChildIndex(root));
                    siftDown(rightChildIndex(root));
                }

            }

        }

    }

    public void removeMin() { //this is similar to pop(), we remove only the top element
                              // and then restore the heap property

        // good source: https://www.algolist.net/Data_structures/Binary_heap/Remove_minimum
        /*
        Copy the last value in the array to the root;
        Decrease heap's size by 1;
        Sift down root's value. Sifting is done as following:
        if current node has no children, sifting is over;
        if current node has one child: check, if heap property is broken, then swap current node's value and child value; sift down the child;
        if current node has two children: find the smallest of them. If heap property is broken, then swap current node's value and selected child value; sift down the child.
         */

        //Copy the last value in the array to the root;
        minHeap[0] = minHeap[size-1]; //size-1 works because we shouldn't have array of 10 and only e.g 3 elements
                                      // it should always be full
        size = size-1;
        //todo: it should be removing the last element tho... I'd have to copy the int array..

        if (size>0)
            siftDown(0);
    }

    public static void main(String[] args) {
        MinHeap h = new MinHeap(7);
        // in: 13, 16, 7, 21, 9, 12, 3
        // out: 3, 9, 7, 21, 16, 13, 12
        h.insert(13);
        h.insert(16);
        h.insert(7);
        h.insert(21);
        h.insert(9);
        h.insert(12);
        h.insert(3);

        // print
        System.out.println("Min heap looks liek dis:");
        printHeap(h);

        // heap for removing top element
        MinHeap h2 = new MinHeap(6);
        // in: 1, 3, 6, 5, 9, 8
        // out: 3, 5, 6, 8, 9
        h2.insert(1);
        h2.insert(3);
        h2.insert(6);
        h2.insert(5);
        h2.insert(9);
        h2.insert(8);
        System.out.println("Min heap before removal:");
        printHeap(h2);
        System.out.println("After removing min element ");
        h2.removeMin();
        printHeap(h2);

        System.out.println("After removing min element of first heap");
        h.removeMin();
        printHeap(h);

    }

    private static void printHeap(MinHeap h) {
        for (int i : h.minHeap) {
            System.out.println(i);
        }
    }
}

