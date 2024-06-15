import java.sql.*;

public class Prepared_stmt {
    public static void main(String[] args) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Load the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "5261");

            // SQL query with placeholders
            String sql = "SELECT * FROM student1 WHERE branch =?";

            // Create a PreparedStatement
            ps = con.prepareStatement(sql);

            // Set the value for the placeholder
            ps.setString(1, "Computer Science");

            // Execute the query
            rs = ps.executeQuery();

            // Process the result set
            while (rs.next()) {
                System.out.println("rno=" + rs.getInt(1));
                System.out.println("name=" + rs.getString(2));
                System.out.println("branch=" + rs.getString(3));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
