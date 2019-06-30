package model;

import java.util.ArrayList;

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
	@Override
	protected String Class() {
		return "IngredientType";
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
	protected String getEntitieKey() {
		// TODO Auto-generated method stub
		return "ingredientTypeId";
	}
	@Override
	protected String getEntitieKeyValue() {
		// TODO Auto-generated method stub
		return this.getIngredientTypeId().toString();
	}
	@Override
	protected String getEntitieAttributesNames() {
		// TODO Auto-generated method stub
		return "ingredientTypeId , ingredientTypeName , ingredientTypeValue";
	}
	@Override
	protected String getEntitieAttributesValues() {
		// TODO Auto-generated method stub
		return " "+ this.getIngredientTypeId().toString()+ " , "+
		this.getIngredientTypeName()+ " , "+
		this.getIngredientTypeValue()+" ";
	}
	@Override
	protected String getEntitieAttributesNamesValues() {
		// TODO Auto-generated method stub
		return  "ingredientTypeId = "+ this.getIngredientTypeId().toString()+ " , "+
		" ingredientTypeName = "+this.getIngredientTypeName()+ " , "+
		" ingredientTypeValue = "+this.getIngredientTypeValue()+" ";
	}
	/*@Override
	public void getPsmtmt(PreparedStatement pstmt) {
		try {

			pstmt.setInt(1, ingredientTypeId);
			pstmt.setString(2, ingredientTypeName);
			pstmt.setInt(3, ingredientTypeValue);
			} catch (SQLException e) {
			e.printStackTrace();
		}		
	}*/
	@Override
	protected String getAllergenInsert(int place) {
		return null;
	}
	@Override
	protected String getIngredientInsert(int place) {
		return null;
	}
	@Override
	protected Integer[] getAllergenArray() {
		return null;
	}
	@Override
	protected ArrayList<Integer> getIngredientArray() {
		return null;
	}
	@Override
	protected int getmaxIngredieantCount() {
		return 0;
	}
	@Override
	protected String getIngredientDelete(int place) {
		// TODO Auto-generated method stub
		return null;
	}
}
