
import java.util.Comparator;
import java.io.Serializable;

public class AphabeticalOrder implements Comparator<Person>, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public int compare(Person o1, Person o2) {
        // Compares its two arguments for order by name.  
        return o1.getName().compareTo(o2.getName());
    }  // end compare

    @Override
    public boolean equals(Object obj) {
        // Simply checks to see if we have the same obj ect
        return this == obj;
    }  // end equals
}  // end ReverseOrder
