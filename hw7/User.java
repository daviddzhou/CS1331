public abstract class User implements Comparable<User> {
    private String name;
    private static int id = 0;

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
        id++;
        User.id = id;
	}


	/**
	* Returns value of name
	* @return
	*/
	public String getName() {
		return name;
	}

	/**
	* Returns value of id
	* @return
	*/
	public static int getId() {
		return id;
	}

    public int compareTo(User other) {
        if (User.id > other.getId()) {
            return 1;
        } else if (User.id < other.getId()) {
            return -1;
        } else {
            return 0;
        }
    }

}
