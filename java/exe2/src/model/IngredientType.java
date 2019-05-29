package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IngredientType extends Entities {
	
	/*Attributes*/
	private Integer ingredientTypeId;
	private Integer ingredientTypeValue;
	private String  ingredientTypeName;
	
	 /*Contractor*/
	public IngredientType(int ingredientTypeId, String ingredientTypeName, Integer ingredientTypeValue) {
		this.setIngredientTypeId(ingredientTypeId);
		this.setIngredientTypeName(ingredientTypeName);
		this.setIngredientTypeValue(ingredientTypeValue);
	}
	public IngredientType(ResultSet rs) {
		try {
			setIngredientTypeId(rs.getInt("ingredientTypeId"));
			setIngredientTypeValue(rs.getInt("ingredientTypeValue"));
			setIngredientTypeName(rs.getString("ingredientTypeName"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public Integer getIngredientTypeId() {
		return this.ingredientTypeId; 
	}
	public String getIngredientTypeName() {
		return this.ingredientTypeName; 
	}
	public void setIngredientTypeName(String ingredientTypeName ) {
		 this.ingredientTypeName=ingredientTypeName; 
	}
	public void setIngredientTypeId(Integer ingredientTypeId ) {
		 this.ingredientTypeId=ingredientTypeId; 
	}
	public Integer getIngredientTypeValue() {
		return ingredientTypeValue;
	}
	public void setIngredientTypeValue(Integer ingredientTypeValue) {
		this.ingredientTypeValue = ingredientTypeValue;
	}
	@Override
	String getEntitieKey() {
		// TODO Auto-generated method stub
		return "ingredientTypeId";
	}
	@Override
	String getEntitieKeyValue() {
		// TODO Auto-generated method stub
		return this.getIngredientTypeId().toString();
	}
	@Override
	String getEntitieAttributesNames() {
		// TODO Auto-generated method stub
		return "ingredientTypeId , ingredientTypeName , ingredientTypeValue";
	}
	@Override
	String getEntitieAttributesValues() {
		// TODO Auto-generated method stub
		return " "+ this.getIngredientTypeId().toString()+ " , "+
		this.getIngredientTypeName()+ " , "+
		this.getIngredientTypeValue()+" ";
	}
	@Override
	String getEntitieAttributesNamesValues() {
		// TODO Auto-generated method stub
		return  "ingredientTypeId = "+ this.getIngredientTypeId().toString()+ " , "+
				 " ingredientTypeName = "+this.getIngredientTypeName()+ " , "+
				 " ingredientTypeValue = "+this.getIngredientTypeValue()+" ";
	}
	@Override
	public void getPsmtmt(PreparedStatement pstmt) {
		try {
	       	
			pstmt.setInt(1, ingredientTypeId);
			pstmt.setString(2, ingredientTypeName);
			pstmt.setInt(3, ingredientTypeValue);
			} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
