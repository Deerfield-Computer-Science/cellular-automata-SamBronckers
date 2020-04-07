import java.awt.Color;

public abstract class Animals extends LifeForm {
	
	public Animals(Location loc, World w) {
		super(loc,w);
		myColor = Color.red;
	}
}
