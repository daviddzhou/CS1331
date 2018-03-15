/**
 * The main driver for User
 *
 * @author David Zhou
 * @version 1.0
 */
public abstract class User implements Comparable<User> {
    private String name;
    private int id;
    private static int assign = 0;

    public String getType() {
        String className = this.getClass().getName();
        return className;
    }

	/**
	* Default empty User constructor
	*/
	public User() {
	}

    // what does it mean by users are not concrete objects -> does it mean they are abstract
    /**
	* Default User constructor
	*/
	public User(String name) {
		this.name = name;
        assign++;
        this.id = assign;
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
        if (id > other.getId()) {
            return 1;
        } else if (id < other.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

}
