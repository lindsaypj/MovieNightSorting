package data;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * This object abstraction sorts an array using a Heap Sort algorithm.
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
        // Construct Heap using comparator
        size = movies.size();
        buildHeap(movieComparator);

        // Remove elements from the heap and place into ordered partition
        for (int i = size - 1; i >= 0; i--) {
            remove(movieComparator);
        }
        // Return sorted ArrayList
        return movies;
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

        // Move the value at the root to sorted position
        swap(0, size - 1);

        // Decrement size of partition
        size--;

        // Sink and adjust
        sink(0, comparator);
    }

    private void sink(int currentIndex, Comparator<Movie> comparator) {
        // Sink as long as current index has a child
        if (currentIndex <= (size / 2) - 1) {
            // Child indexes
            int leftChildIndex = (2 * currentIndex) + 1;
            int rightChildIndex = (2 * currentIndex) + 2;

            // Compare the Left and Right children
            int rightLeftDifference;
            if (rightChildIndex < size) {
                rightLeftDifference = comparator.compare(movies.get(rightChildIndex), movies.get(leftChildIndex));
            }
            else {
                rightLeftDifference = -1;
            }

            // Determine the smallest child
            int smallestChildIndex = rightLeftDifference > 0 ? rightChildIndex : leftChildIndex;

            // sink 1 level
            if (comparator.compare(movies.get(currentIndex), movies.get(smallestChildIndex)) < 0) {
                swap(currentIndex, smallestChildIndex);
            }

            // Check if order is complete, or keep sinking
            sink(smallestChildIndex, comparator);
        }
    }

    // Swaps elements indices first and second in the heap array
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
