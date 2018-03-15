/**
 * Represents a User class object
 * @author John Ryu
 * @version 1.0
 */

public abstract class User implements Comparable<User> {

    private String name;
    private int id;
    private static int assign;

    /**
     * Empty constructor in case of empty input.
     */

    public User() {

    }

    /**
     * Passes in an instructor name and assings an id.
     * @param name Name of instructor
     */

    public User(String name) {
        this.name = name;
        assign++;
        this.id = assign;
    }

    /**
     * Method returns the class type
     * @return class type
     */

    public String getType() {
        return this.getClass().getName();
    }

    /**
     * Method returns the name of the Instructor
     * @return name
     */

    public String getName() {
        return name;
    }

    /**
     * Method returns the id of User
     * @return id
     */

    public int getId() {
        return id;
    }

    /**
     * Overrides compareTo method in Comparable
     * @param other User object
     */

    @Override
    public int compareTo(User other) {
        if (id > other.id) {
            return 1;
        } else if (id < other.id) {
            return -1;
        } else {
            return 0;
        }
    }
}
