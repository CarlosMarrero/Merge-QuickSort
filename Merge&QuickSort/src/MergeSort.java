
import java.util.*;

@SuppressWarnings("hiding")
public class MergeSort<Person extends Comparable<? super Person>> {

    public <Person extends Comparable<? super Person>> void mergesort(
            Vector<Person> theVector) {
        // Declare temporary vector used for merge, must do
        // unchecked cast from Comparable<? >vector to theVector
        Vector<Person> tempVector = new Vector<Person>(theVector.size() - 1);
        mergesort(theVector, tempVector, theVector.size(), 0);
    } // end mergesort

    private <Person extends Comparable<? super Person>> void merge(
            Vector<Person> theVector, Vector<Person> tempVector, int first,
            int mid, int last) {
        // ---------------------------------------------------------
        // Merges two sorted vector segments theVector[ first. . mid] and
        // theVector[ mid+1. . last] into one sorted array.
        // Precondition: first <= mid <= last. The subVectors
        // theVector[ first. . mid] and theVector[ mid+1. . last] are
        // each sorted in increasing order.
        // Postcondition: theVector[ first. . last] is sorted.
        // Implementation note: This method merges the two
        // subVector into a temporary vector and copies the result
        // into the original array theVector.
        // ---------------------------------------------------------
        // initialize the local indexes to indicate the subVector
        int first1 = first; // beginning of first subVector
        int last1 = mid; // end of first subVector
        int first2 = mid + 1; // beginning of second subVector
        int last2 = last; // end of second subVector
        // while both subVectors are not empty, copy the
        // smaller item into the temporary Vector
        int index = first1; // next available location in tempVector
        while ((first1 <= last1) && (first2 <= last2)) {
            // Invariant: tempVector[ first1. . index-1] is in order
            if (theVector.get(first1).compareTo(
                    theVector.get(first2)) < 0) {
                tempVector.setElementAt(theVector.elementAt(first1), index);
                first1++;
            } else {
                tempVector.setElementAt(theVector.elementAt(first2), index);
                first2++;
            } // end if
            index++;
        } // end while
        // finish off the nonempty subVector
        // finish off the first subVector, if necessary
        while (first1 <= last1) {
            // Invariant: tempVector[ first1. . index-1] is in order
            tempVector.setElementAt(theVector.elementAt(first1), index);
            first1++;
            index++;
        } // end while
        // finish off the second subVector, if necessary
        while (first2 <= last2) {
            // Invariant: tempVector[ first1. . index-1] is in order
            tempVector.setElementAt(theVector.elementAt(first2), index);
            first2++;
            index++;
        } // end while
        // copy the result back into the original Vector
        for (index = first; index <= last; ++index) {
            theVector.setElementAt(tempVector.get(index), index);
        } // end for
    } // end merge

    public <Person extends Comparable<? super Person>> void mergesort(
            Vector<Person> theVector, Vector<Person> tempVector, int first,
            int last) {
        // ---------------------------------------------------------
        // Sorts the items in an Vector into ascending order.
        // Precondition: theVector[ first. . last] is an Vector.
        // Postcondition: theVector[ first. . last] is sorted in
        // ascending order.
        // Calls: merge.
        // ---------------------------------------------------------
        if (first < last) {
            // sort each half
            int mid = ((first + last) / 2); // index of midpoint
            // sort left half theVector[ first. . mid]
            mergesort(theVector, tempVector, first, mid);
            // sort right half theVector[ mid+1. . last]
            mergesort(theVector, tempVector, mid + 1, last);
            // merge the two halves
            merge(theVector, tempVector, first, mid, last);
        } // end if
    } // end mergeSort
}
