import java.sql.*;


public class Reserve {

    private static final String DB_URL ="jdbc:mysql://library320.ctolwwjuo2op.eu-central-1.rds.amazonaws.com:3306/sys" ;
    private static final String PASS ="admin" ;
    private static final String USERNAME = "admin123";



    public void reserveUpdate(int productID, String productName, int year, String genre, String Name, boolean isReserved) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASS);

            // Update the book in the Books table
            String sql = "UPDATE Books SET isReserved = ?, productName = ?, year = ?, genre = ?, Name = ? WHERE productID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productID);
            pstmt.setString(2, productName);
            pstmt.setInt(3, year);
            pstmt.setString(4, genre);
            pstmt.setString(5, Name);
            pstmt.setBoolean(6,isReserved);
            pstmt.executeUpdate();

            // Update the movie in the Movies table
            sql = "UPDATE Movies SET isReserved = ?, productName = ?, year = ?, genre = ?, Name = ?  WHERE productID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, productID);
            pstmt.setString(2, productName);
            pstmt.setInt(3, year);
            pstmt.setString(4, genre);
            pstmt.setString(5, Name);
            pstmt.setBoolean(6,isReserved);
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the connection
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void ReserveBook(int productID, String productName, String borrower, String dateBorrowed, String dateDue, boolean isReserved) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306", USERNAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Update the book in the books table
        String sql = "UPDATE Books SET product_id= ?, product_name = ?, borrower = ?, date_borrowed = ? WHERE date_due = ? AND is_reserved = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productID);
            pstmt.setString(2, productName);
            pstmt.setString(3, borrower);
            pstmt.setString(4, dateBorrowed);
            pstmt.setString(5, dateDue);
            pstmt.setBoolean(6, isReserved);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ReserveMovie(int productID, String productName, String borrower, String dateBorrowed, String dateDue, boolean isReserved) {
        // Connect to the database
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306", USERNAME, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Update the book in the books table
        String sql = "UPDATE Movies SET product_id= ?, product_name = ?, borrower = ?, date_borrowed = ? WHERE date_due = ? AND is_reserved = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, productID);
            pstmt.setString(2, productName);
            pstmt.setString(3, borrower);
            pstmt.setString(4, dateBorrowed);
            pstmt.setString(5, dateDue);
            pstmt.setBoolean(6, isReserved);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
