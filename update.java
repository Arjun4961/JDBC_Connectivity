import java.sql.*;

public class update {
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

            // SQL command to update the roll number
            String sql = "UPDATE student1 SET rno = 19 WHERE name = 'Arjun'";

            // Execute the update
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
