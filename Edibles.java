package assignment4;

public class Edibles {

	private int foodWidth;
	private int foodHeight;

	private int poisonWidth;
	private int poisonHeight;

	// Initializes a normal game-mode where ONLY food spawns
	public void normalEdibles() {
		spawnFood();
	}

	// Initializes an expert game-mode where BOTH food and poison spawn
	public void expertEdibles() {
		spawnFood();
		spawnPoison();
	}

	// Spawns a food at a random location within the gameboard grid
	public void spawnFood() {
		this.foodWidth = 35 + (int) (Math.random() * 19) * 35;
		this.foodHeight = 35 + (int) (Math.random() * 11) * 35;
	}

	// Spawns a poison at a random location within the gameboard grid
	public void spawnPoison() {
		do {
			this.poisonWidth = 35 + (int) (Math.random() * 19) * 35;
			this.poisonHeight = 35 + (int) (Math.random() * 11) * 35;
		} while (foodWidth == poisonWidth && foodHeight == poisonHeight);
	}

	// Getters for food height and width
	public int getFoodWidth() {
		return foodWidth;
	}

	public int getFoodHeight() {
		return foodHeight;
	}

	// Getters for poison height and width
	public int getPoisonWidth() {
		return poisonWidth;
	}

	public int getPoisonHeight() {
		return poisonHeight;
	}
}
