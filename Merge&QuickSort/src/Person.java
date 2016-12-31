
public class Person implements Comparable<Person> {

    private String name;// Will be used as the Search Key.
    private String phoneNumber; // Format xxx-xxx-xxxx, where every x is in the range 0-9.

    public Person() {
        name = "no name";
        phoneNumber = "xxx-xxx-xxxx";
    }

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }// ends constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return " PhoneNumber: " + phoneNumber + " Name: " + name;
    } // end toString

    @Override
    public int compareTo(Person o1) {
        return getName().compareTo(o1.getName());
    }  // end compareTo

    @Override
    public boolean equals(Object obj) {
        // Simply checks to see if we have the same obj ect
        return this == obj;
    }  // end equals
} // end Person
