
import java.util.Comparator;
import java.io.Serializable;

class ReverseOrder implements Comparator<Person>, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public int compare(Person o1, Person o2) {
        // Compares its two arguments for order by name.  
        return o2.getName().compareTo(o1.getName());
    }  // end compare

    @Override
    public boolean equals(Object obj) {
        // Simply checks to see if we have the same obj ect
        return this == obj;
    }  // end equals
}  // end ReverseOrder
