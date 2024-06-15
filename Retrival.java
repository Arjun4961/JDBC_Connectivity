import java.sql.*;

public class Retrival {
    public static void main(String[] args) throws Exception {
        // Load the MySQL driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish the connection
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college", "root", "5261");

        // Create a statement
        Statement st = con.createStatement();

        // Execute the query
        ResultSet rs = st.executeQuery("SELECT * FROM student1");

        // Process the result set
        while (rs.next()) {
            System.out.println("rno=" + rs.getInt(1));
            System.out.println("name=" + rs.getString(2));
            System.out.println("branch=" + rs.getString(3));
        }

        // Close the resources
        rs.close();
        st.close();
        con.close();
    }
}
