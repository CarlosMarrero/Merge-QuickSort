
import java.util.*;

@SuppressWarnings("hiding")
public class QuickSort<Person extends Comparable<? super Person>> {

    private <Person extends Comparable<? super Person>> void choosePivot(
            Vector<Person> theVector, int first, int last) {
        // ---------------------------------------------------------
        // Chooses a pivot for quicksort' s partition algorithm and
        // swaps it with the first item in an array.
        // Precondition: theArray[ first. . last] where first <= last.
        // Postcondition: theVector[ first] is the pivot.
        // ---------------------------------------------------------
        Person center = theVector.get((first + last) / 2);
        if (theVector.get(first).compareTo(center) > 0) {
            theVector.setElementAt(center, first);
        }
        // swap(theVector, left, center)
        if (theVector.get(first).compareTo(theVector.get(last)) > 0) {
            theVector.setElementAt(theVector.elementAt(last), first);
        }
        // swap(theVector, left, right)
        if (center.compareTo(theVector.get(last)) > 0) {
            theVector.setElementAt(center, last);
        }
        // swap(theVector, center, right)
        theVector.setElementAt(center, last - 1);
    } // end choosePivot

    private <Person extends Comparable<? super Person>> int partition(
            Vector<Person> theVector, int first, int last) {
        // ---------------------------------------------------------
        // Partitions a vector for quicksort.
        // Precondition: theVector[ first. . last] where first <= last.
        // Postcondition: Returns the index of the pivot element of
        // theVector[ first. . last] . Upon completion of the method,
        // this will be the index value lastS1 such that
        // S1 = theVector[ first. . lastS1-1] < pivot
        //	    theVector[ lastS1]           == pivot
        // S2 = theVector[ lastS1+1. . last] >= pivot
        // Calls: choosePivot.
        // ---------------------------------------------------------
        // tempItem is used to swap elements in the vector
        Person tempItem;
        // place pivot in theVector[ first]
        choosePivot(theVector, first, last);
        Person pivot = theVector.get(first);// reference pivot initially,
        // everything but pivot is in
        // unknown
        int lastS1 = first; // index of last item in S1
        // move one item at a time until unknown region is empty
        for (int firstUnknown = first + 1; firstUnknown <= last; ++firstUnknown) {
            // Invariant: theVector[ first+1. . lastS1] < pivot
            //			  theVector[lastS1 + 1 . . firstUnknown - 1] >= pivot
            // move item from unknown to proper region
            if (theVector.get(firstUnknown).compareTo(pivot) < 0) {
                // item from unknown belongs in S1
                ++lastS1;
                tempItem = theVector.get(firstUnknown);
                theVector.setElementAt(theVector.get(lastS1),
                        firstUnknown);
                theVector.setElementAt(tempItem, lastS1);
            } // end if
            // else item from unknown belongs in S2
        } // end for
        // place pivot in proper position and mark its location
        tempItem = theVector.get(first);
        theVector.setElementAt(theVector.elementAt(lastS1), first);
        theVector.setElementAt(tempItem, lastS1);
        return lastS1;
    } // end partition

    public <Person extends Comparable<? super Person>> void quickSort(
            Vector<Person> theVector, int first, int last) {
        // ---------------------------------------------------------
        // Sorts the items in an vector into ascending order.
        // Precondition: theVector[ first. . last] is an vector.
        // Postcondition: theVector[ first. . last] is sorted.
        // Calls: partition.
        // ---------------------------------------------------------
        int pivotIndex;
        if (first < last) {
            // create the partition: S1, Pivot, S2
            pivotIndex = partition(theVector, first, last);
            // sort regions S1 and S2
            quickSort(theVector, first + 1, pivotIndex);
            quickSort(theVector, pivotIndex, last - 1);
        } // end if
    } // end quickSort
}
