package data;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This object sorts an array using an in-place Heap Sort algorithm.
 * @author Patrick Lindsay
 * @version 1.0
 */
public class HeapSort {
    // Fields
    private ArrayList<Movie> movies;
    private int size;

    /**
     * Constructor to initialize a heap sort object
     * @param movies ArrayList containing movies
     */
    public HeapSort(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    /**
     * This method sorts the stored array using the given comparator
     * @param movieComparator Movie Comparator object to order movies based on a movie attribute
     * @return ArrayList of movies sorted using the given comparator
     */
    public ArrayList<Movie> sort(Comparator<Movie> movieComparator) {
        size = movies.size();        // Initialize heap size to include all elements in the array
        buildHeap(movieComparator); // Construct Heap using comparator

        // Remove elements from the heap and place into ordered partition
        for (int i = size - 1; i >= 0; i--) {
            remove(movieComparator);
        }
        return movies;        // Return sorted ArrayList
    }

    // Method to "Heapify" the given array (Or ArrayList)
    private void buildHeap(Comparator<Movie> comparator) {
        // Perform sink() on all nodes with a child
        for (int i = (size/2) - 1; i >= 0; i--) {
            sink(i, comparator);
        }
    }

    // Method to remove the next element from the heap (to be stored in ordered partition)
    private void remove(Comparator<Movie> comparator) {
        // Validate Heap size
        if (size == 0) {
            throw new IllegalStateException("The Heap is empty!");
        }

        swap(0, size - 1);     // Move the value at the root to sorted position
        size--;               // Decrement size of partition
        sink(0, comparator); // Sink and adjust
    }

    private void sink(int currentIndex, Comparator<Movie> comparator) {
        // Sink as long as current index has a child
        if (currentIndex <= (size / 2) - 1) {
            // Child indexes
            int leftChildIndex = (2 * currentIndex) + 1;
            int rightChildIndex = (2 * currentIndex) + 2;

            // Compare the Left and Right children
            int rightLeftDifference;
            if (rightChildIndex < size) { // Current Index has both left and right children
                rightLeftDifference = comparator.compare(movies.get(rightChildIndex), movies.get(leftChildIndex));
            }
            else { // Current index only has left child
                rightLeftDifference = -1;
            }

            // Determine the smallest child
            int smallestChildIndex = rightLeftDifference > 0 ? rightChildIndex : leftChildIndex;

            // Sink 1 level (if applicable)
            if (comparator.compare(movies.get(currentIndex), movies.get(smallestChildIndex)) < 0) {
                swap(currentIndex, smallestChildIndex);
            }

            // Check if order is complete, or keep sinking
            sink(smallestChildIndex, comparator);
        }
    }

    // Swaps elements at indices first and second in the heap array
    private void swap(int firstIndex, int secondIndex) {
        Movie first = movies.get(firstIndex);
        movies.set(firstIndex, movies.get(secondIndex));
        movies.set(secondIndex, first);
    }

    @Override
    public String toString() {
        return movies.toString();
    }
}