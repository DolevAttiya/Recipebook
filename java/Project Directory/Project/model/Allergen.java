package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Allergen extends  Entities{
	
	/*Attributes*/
	private static int maxAllergen=0;
	private Integer allergenId;
	private String  allergenName;
	
	 /*Contractor*/
	public Allergen(ResultSet rs) {
		try {
			setAllergenId(rs.getInt("allergenId"));
			setAllergenName(rs.getString("allergenName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setMaxAllergen(getMaxAllergen() + 1);
	}
	public Allergen(int allergenId, String allergenName) {
		this.setAllergenId(allergenId);
		this.setAllergenName(allergenName);
		setMaxAllergen(getMaxAllergen() + 1);
	}
	public Integer getAllergenId() {
		return this.allergenId; 
	}
	public String getAllergenName() {
		return this.allergenName; 
	}
	private void setAllergenName(String allergenName ) {
		 this.allergenName=allergenName; 
	}
	private void setAllergenId(Integer AllergenId ) {
		 this.allergenId=AllergenId; 
	}
	public static int getMaxAllergen() {
		return maxAllergen;
	}
	private static void setMaxAllergen(int maxAllergen) {
		Allergen.maxAllergen = maxAllergen;
	}
	
	@Override
	String getEntitieKey() {
		return "allergenId";
	}
	@Override
	String getEntitieKeyValue() {
		return this.getAllergenId().toString();
	}
	@Override
	String getEntitieAttributesNames() {		
		return "allergenId, allergenName";
	}
	@Override
	String getEntitieAttributesValues() {
		return " "+this.getAllergenId().toString()+", "+this.getAllergenName();
	}
	@Override
	String getEntitieAttributesNamesValues() {
		return "allergenId= "+this.getAllergenId().toString()+", allergenName"+this.getAllergenName();
	}
	@Override
    public void getPsmtmt( PreparedStatement pstmt) {
           try {
				pstmt.setInt(1, allergenId);
				pstmt.setString(2, allergenName);
			} catch (SQLException e) {
				e.printStackTrace();
			}
   }
     
}

