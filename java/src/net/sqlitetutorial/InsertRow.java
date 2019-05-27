package net.sqlitetutorial;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
 
/**
 *
 * @author sqlitetutorial.net
 */
public class InsertRow {
 public String table;
    /**
     * Connect to the test.db database
     *
     * @return the Connection object
     */
    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/yuval/Documents/GitHub/Recipebook/java/database.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
 
    /**
     * Insert a new row into the table
     *
     * @param name
     * @param capacity
     */
    switch(table) {
    case "Allergen":
    
    public void insert(String name, double capacity) {
        String sql = "INSERT INTO Allergen(allergenId,allergenName) VALUES(?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInteger(1, allergenId);
            pstmt.setString(2, allergenName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    break;
    case "Ingredient":
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
 
        InsertRow app = new InsertRow();
        // insert three new rows
        app.insert("Raw Materials", 3000);
        app.insert("Semifinished Goods", 4000);
        app.insert("Finished Goods", 5000);
    }
 
}