public class Star extends AstronomicalObject {
    private Color color;
    private boolean isSun;
    private String isSunString;


	/**
	* Default empty Star constructor
	*/
	public Star() {
		super();
	}

	/**
	* Default Star constructor
	*/
	public Star(String name, int id) {
		super(this.name);
		this.id = id;
	}

    public void getColor() {
        color = Color.getColorById(id);
        if (color = RED(4)) {
            isSun = false;
        } else {
            isSun = true;
        }
    }

	/**
	* Create string representation of Star for printing
	* @return
	*/
	@Override
	public String toString() {
        if (isSun == true) {
            return "Star " + name + "." + "Color: " + color + "." + "This Star can have planets";
        } else {
            return "Star " + name + "." + "Color: " + color + "." + "This Star can't have planets";
        }
	}

	/**
	* Returns value of color
	* @return
	*/
	public Color getColor() {
		return color;
	}

	/**
	* Sets new value of color
	* @param
	*/
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	* Returns value of isSun
	* @return
	*/
	public boolean isIsSun() {
		return isSun;
	}

	/**
	* Sets new value of isSun
	* @param
	*/
	public void setIsSun(boolean isSun) {
		this.isSun = isSun;
	}
}
