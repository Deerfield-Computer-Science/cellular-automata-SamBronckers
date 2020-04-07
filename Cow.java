
public class Cow extends Animals {
	public Cow(Location l, World w) {
		super(l,w);
		myLifeSpan = 5;
	}
	
	public void reproduce() {
		// this is silly code really, but as an example
		int newX = (int)(Math.random()*20);
		int newY = (int)(Math.random()*20); 
				
		myWorld.getCreatureList().add(new Cow(new Location(newX,newY), myWorld));
	}
}
