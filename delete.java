import java.sql.*;

public class delete {
    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "5261");

            // Create a statement
            st = con.createStatement();

            // SQL command to delete the student named John Doe
            String sql = "DELETE FROM student1 WHERE name = 'John Doe'";

            // Execute the delete command
            int rowsAffected = st.executeUpdate(sql);
            System.out.println("Rows affected: " + rowsAffected);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (st != null) st.close();
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
