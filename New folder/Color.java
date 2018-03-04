/**
 * This enumerated type represents the possible colors a star can have.
 * 
 *
 * @author Karen Taub
 * @version 1.0
 */

public enum Color {

 	WHITE(0), 
 	BLUE(1), 
 	YELLOW(2),
	ORANGE(3),
	RED(4);
 
 	private int id;
 
 	private Color(int c) {
   		id = c;
 	}
 
	public int getId() {
   		return id;
	}

	public static Color getColorById(int i) {
		for (Color c : Color.values()) {
			if (c.getId() == i) {
				return c;
			}
		}
		return Color.YELLOW;
	}
}