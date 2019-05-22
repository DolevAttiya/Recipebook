package rep;

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
			SetAllergenId(rs.getInt("allergenId"));
			SetAllergenName(rs.getString("allergenName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		setMaxAllergen(getMaxAllergen() + 1);
	}
	public Allergen(int allergenId, String allergenName) {
		this.allergenId=allergenId;
		this.allergenName=allergenName;
		setMaxAllergen(getMaxAllergen() + 1);
	}
	public Integer getAllergenId() {
		return this.allergenId; 
	}
	public String getAllergenName() {
		return this.allergenName; 
	}
	private void SetAllergenName(String allergenName ) {
		 this.allergenName=allergenName; 
	}
	private void SetAllergenId(Integer allergieId ) {
		 this.allergenId=allergieId; 
	}
	public static int getMaxAllergen() {
		return maxAllergen;
	}
	private static void setMaxAllergen(int maxAllergen) {
		Allergen.maxAllergen = maxAllergen;
	}
	@Override
     public void getPsmtmt( PreparedStatement pstmt,int i) {
            try {
            	
				pstmt.setInt(1, allergenId);
				if(i==0) {
				pstmt.setString(2, allergenName);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
	@Override
	String getEntitieKey() {
		return "allergieId";
	}
	@Override
	String getEntitieKeyValue() {
		return this.getAllergenId().toString();
	}
	@Override
	String getEntitieAttributesNames() {		
		return "allergieId, allergieName";
	}
	@Override
	String getEntitieAttributesValues() {
		return " "+this.getAllergenId().toString()+", "+this.getAllergenName();
	}
	@Override
	String getEntitieAttributesNamesValues() {
		return "allergieId= "+this.getAllergenId().toString()+", allergieName"+this.getAllergenName();
	}
     
}

