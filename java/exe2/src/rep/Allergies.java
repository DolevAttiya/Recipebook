package rep;

public class Allergies {
	int x;
	private static int maxAllergies=0;
	private int allergieId;
	private String  allergieName;
	public Allergies(int allergieId, String allergieName) {
		this.allergieId=allergieId;
		this.allergieName=allergieName;
		setMaxAllergies(getMaxAllergies() + 1);
	}
	public int getAllergieId() {
		return this.allergieId; 
	}
	public String getAllergieName() {
		return this.allergieName; 
	}
	private void SetAllergieName(String allergieName ) {
		 this.allergieName=allergieName; 
	}
	private void SetAllergieId(int allergieId ) {
		 this.allergieId=allergieId; 
	}
	public static int getMaxAllergies() {
		return maxAllergies;
	}
	private static void setMaxAllergies(int maxAllergies) {
		Allergies.maxAllergies = maxAllergies;
	}
}
