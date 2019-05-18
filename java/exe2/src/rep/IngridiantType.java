package rep;

public class IngridiantType {
	
	/*Attributes*/
	private int ingridiantTypeId;
	private int ingridiantTypeValue;
	private String  ingridiantTypeName;
	
	 /*Contractor*/
	public IngridiantType(int ingridiantTypeId, String ingridiantTypeName) {
		this.ingridiantTypeId=ingridiantTypeId;
		this.ingridiantTypeName=ingridiantTypeName;
	}
	public int getIngridiantTypeId() {
		return this.ingridiantTypeId; 
	}
	public String getIngridiantTypeName() {
		return this.ingridiantTypeName; 
	}
	public void SetIngridiantTypeName(String ingridiantTypeName ) {
		 this.ingridiantTypeName=ingridiantTypeName; 
	}
	public void SetIngrdiantTypeId(int ingridiantTypeId ) {
		 this.ingridiantTypeId=ingridiantTypeId; 
	}
	public int getIngridiantTypeValue() {
		return ingridiantTypeValue;
	}
	public void setIngridiantTypeValue(int ingridiantTypeValue) {
		this.ingridiantTypeValue = ingridiantTypeValue;
	}
}
