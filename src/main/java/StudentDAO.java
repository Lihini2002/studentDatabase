import java.sql.*;
import java.util.*;

public class StudentDAO {

    // Insert student
	public void addStudent(String name, int age, String email) {
	    String sql = "INSERT INTO students(name, age, email) VALUES (?, ?, ?)";
	    
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, name);
	        stmt.setInt(2, age);
	        stmt.setString(3, email);
	        stmt.executeUpdate();
	        System.out.println("Student added successfully!");

	    } catch (SQLException e) { // Specific catch
	        System.out.println("\n--- Failed to Add Student ---");
	        System.out.println("Message: " + e.getMessage());
	        System.out.println("SQL State: " + e.getSQLState());
	        System.out.println("Vendor Error Code: " + e.getErrorCode());
	        System.out.println("------------------------");
	    }
	}
	
	//view students 

	public void viewStudents() {
	    String sql = "SELECT * FROM students";
	    
	    // Try-with-resources is still correct and good!
	    try (Connection conn = DatabaseConnection.getConnection();
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        System.out.println("ID | Name | Age | Email");
	        System.out.println("------------------------");
	        while (rs.next()) {
	            System.out.println(rs.getInt("id") + " | " +
	                    rs.getString("name") + " | " +
	                    rs.getInt("age") + " | " +
	                    rs.getString("email"));
	        }

	    } catch (SQLException e) { // Catch the SPECIFIC exception
	        // Apply the excellent handling from your ExceptionDemo:
	        System.out.println("\n--- Database Error ---");
	        System.out.println("Message: " + e.getMessage());
	        System.out.println("SQL State: " + e.getSQLState());
	        System.out.println("Vendor Error Code: " + e.getErrorCode());
	        System.out.println("------------------------");
	    }
	}
	
	// Update student
	public void updateStudent(int id, String name, int age, String email) {
	    String sql = "UPDATE students SET name=?, age=?, email=? WHERE id=?";
	    
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setString(1, name);
	        stmt.setInt(2, age);
	        stmt.setString(3, email);
	        stmt.setInt(4, id);
	        
	        int rowsAffected = stmt.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("Student updated successfully!");
	        } else {
	            System.out.println("Update failed: No student found with ID " + id);
	        }

	    } catch (SQLException e) { // Catching the specific SQLException
	        // Applying the excellent, informative handling from your example
	        System.out.println("\n--- Database Update Error ---");
	        System.out.println("Message: " + e.getMessage());
	        System.out.println("SQL State: " + e.getSQLState());
	        System.out.println("Vendor Error Code: " + e.getErrorCode());
	        System.out.println("------------------------------");
	    }
	}

	// Delete student
	public void deleteStudent(int id) {
	    String sql = "DELETE FROM students WHERE id=?";
	    
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, id);
	        
	        int rowsAffected = stmt.executeUpdate();
	        
	        if (rowsAffected > 0) {
	            System.out.println("Student deleted successfully!");
	        } else {
	            System.out.println("Delete failed: No student found with ID " + id);
	        }

	    } catch (SQLException e) { // Catching the specific SQLException
	        // Applying the excellent, informative handling from your example
	        System.out.println("\n--- Database Deletion Error ---");
	        System.out.println("Message: " + e.getMessage());
	        System.out.println("SQL State: " + e.getSQLState());
	        System.out.println("Vendor Error Code: " + e.getErrorCode());
	        System.out.println("---------------------------------");
	    }
	}
	
	///connections are automatically closed. 
} 