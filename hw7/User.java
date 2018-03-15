/**
 * The main driver for User
 *
 * @author David Zhou
 * @version 1.0
 */
public abstract class User implements Comparable<User> {
    private String name;
    private int id;
    private static int assign;

	/**
	* Default empty User constructor
	*/
	public User() {
	}

    /**
	* Default User constructor
    * @param name name of the user
	*/
	public User(String name) {
		this.name = name;
        assign++;
        this.id = assign;
	}

    /**
    * @return the class type
    */
    public String getType() {
        return this.getClass().getName();
    }

	/**
	* Returns value of name
	* @return value fo name
	*/
	public String getName() {
		return name;
	}

	/**
	* Returns value of id
	* @return value of id
	*/
	public int getId() {
		return id;
	}

    /**
    *@param other the user defined
    *@return comparable integer
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
