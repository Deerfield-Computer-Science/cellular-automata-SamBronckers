import java.util.ArrayList;

public class World {
	
	private int width;
	private int height;
	private ArrayList<LifeForm> creatureList;
	
	public World(int width, int height) {
		super();
		this.width = width;
		this.height = height;
		this.creatureList = new ArrayList<LifeForm>();
	}
	
	public void letTimePass(){
		
		makeNewCreatures();
		eatThings();
		creaturesGetOlder();
		purgeTheDead();		
	}
	
	public void eatThings() {
		int currentSizeOfCreatureList = creatureList.size();
		for(int i=0; i< currentSizeOfCreatureList; i++) {
			if (creatureList.get(i) instanceof Cow) {
				boolean hungry = true;
				for (int a =0; a<currentSizeOfCreatureList; a++) {
					if (creatureList.get(a) instanceof Grass && isNearby(a,i)) {
						hungry = false;
						break;
					}
				}
				if (hungry) {
					System.out.println("got in the isDead");
					creatureList.get(i).makeDead();
				}
			}
		}
	}
	
	public boolean isNearby(int a, int i) {
		if ((((creatureList.get(a).getMyLocation().getX() <= (creatureList.get(i).getMyLocation().getX() + 1) && (creatureList.get(a).getMyLocation().getX() >= (creatureList.get(i).getMyLocation().getX() -1) && ((creatureList.get(a).getMyLocation().getY() <= (creatureList.get(i).getMyLocation().getY() + 1) && (creatureList.get(a).getMyLocation().getY() >= (creatureList.get(i).getMyLocation().getY() -1))))))))) {
			return true;
		} else {
			return false;
		}
	}
	
	public void makeNewCreatures() {
		
		int currentSizeOfCreatureList = creatureList.size();
		System.out.println("size of list is "+currentSizeOfCreatureList);
		for(int i=0; i< currentSizeOfCreatureList; i++) {
			creatureList.get(i).reproduce();
		}
	}
	
	public void purgeTheDead(){
		int i=0;
		while(i<creatureList.size()){
			if(creatureList.get(i).isDead()) {
				creatureList.remove(i);
				System.out.println("got removed");
			}
			else
				i++;
		}	
	}
	
	public void creaturesGetOlder(){
		for( LifeForm l:creatureList){
			if (l instanceof Cow && l.myAge >= 20) {
				l.isDead();
			} else {
				l.age(1);
			}
		}
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ArrayList<LifeForm> getCreatureList() {
		return creatureList;
	}
	public void setCreatureList(ArrayList<LifeForm> creatureList) {
		this.creatureList = creatureList;
	}

	@Override
	public String toString() {
		return "World [width=" + width + ", height=" + height
				+ ", creatureList=" + creatureList + "]";
	}
}
