package jdbc;

import java.util.Scanner;
import java.sql.*;

public class JDBC {

/*Connection Part*/
    public static Connection returnsConnection() {
        String path = "jdbc:mysql://localhost/secondCars?useSSL=false";
        String user = "root";
        String password = "";
        Connection conn = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(path, user, password);
            System.out.println("User Connected");
        } catch (SQLException e) {
            System.out.println("SQL Exception Found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not Found Exception");
        }
        System.out.println("----------------");
        return conn;

    }
/*Details Entry to Database*/
    public static void main(String[] args) {

        Connection conn = returnsConnection();
        Scanner scan = new Scanner(System.in);
        String carMake = null, carModel = null, carYear = null;
        int carPrice;
        System.out.println("Enter carMake : ");
        carMake = scan.nextLine();
        System.out.println("Enter carModel : ");
        carModel = scan.nextLine();
        System.out.println("Enter carYear : ");
        carYear = scan.nextLine();
        System.out.println("Enter carPrice : ");
        carPrice = scan.nextInt();
        

        Statement st = null;
        ResultSet re;
        PreparedStatement pstmt = null;
/*Creating Table */
        try {
            String sqlCommand = "create table if not exists allCars( carMake varchar(30), carModel varchar(30), carYear varchar(30), carPrice varchar(30));";
            st = conn.createStatement();
            st.executeUpdate(sqlCommand);
            System.out.println("Values Inserted!");
/*Inserting values to table*/
            String query = "insert into allCars(carMake,carModel,carYear,carPrice) values(?,?,?,?)";
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, carMake);
            pstmt.setString(2, carModel);
            pstmt.setString(3, carYear);
            pstmt.setInt(4, carPrice);
            pstmt.executeUpdate();
            System.out.println("Update Successful!");
/*Displaying year column in table*/
            String show = "Select carYear from allCars";
            re = st.executeQuery(show);
            while (re.next()) {
                int year = re.getInt("carYear");
                System.out.print("\n Car Year: " + year);
/*Summation of Car Price*/
            }
            System.out.print("\n");
            String salesQuery = "SELECT SUM(carPrice) FROM allCars";
            re = st.executeQuery(salesQuery);
            re.next();
            String sales = re.getString(1);
            System.out.print("\n\n Total Sales so far: " + sales + "\n\n");

            conn.close();
/*SQL exception error*/
        } catch (SQLException e) {
            System.out.println("Error!!! SQL Exception.");
        }

    }
}

