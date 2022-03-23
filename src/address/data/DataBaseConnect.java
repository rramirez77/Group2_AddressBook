package address.data;
import java.sql.*;

public class DataBaseConnect {
    /**
     * @param args
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException{

        // Load the Oracle JDBC driver
        Class.forName ("oracle.jdbc.driver.OracleDriver"); //name of driver may change w/ versions

        //check Oracle documentation online
        // Or could do DriverManager.registerDriver (new oracle.jdbc.OracleDriver());



        // Connect to the database
        // generic host url = jdbc:oracle:thin:login/password@host:port/SID for Oracle SEE Account INFO you
        // were given by our CS tech in an email ---THIS WILL BE DIFFERENT
        //jdbc:oracle:thin:@//adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu
        Connection conn =
                DriverManager.getConnection("jdbc:oracle:thin:mcs1018/z4Boy2Du@adcsdb01.csueastbay.edu:1521/mcspdb.ad.csueastbay.edu");

        // Create a Statement
        Statement stmt = conn.createStatement ();

        //DELETE TABLE

        String sql = "DROP TABLE ADDRESSENTRYTABLE";
        stmt.execute(sql);

        //CREATE TABLE
        String query = "CREATE TABLE ADDRESSENTRYTABLE("
                + "ID VARCHAR (50), "
                + "Name VARCHAR (50), "
                + "Address VARCHAR (50), "
                + "Phone VARCHAR (20), "
                + "Email VARCHAR (50))";

        stmt.execute(query);



        //science

        //stmt.executeUpdate("INSERT INTO TEST " + "VALUES ('Last1111111111First', 'Last,First', '123 Street,City,State,55555', '1111111111', 'name@email')");
        //stmt.executeUpdate("INSERT INTO TEST " + "VALUES ('Washington000-000-0000George', 'Washington,George', '1 Street,Place,AS,00000', '000-000-0000', 'gwsh@email.com')");
        //stmt.executeUpdate("INSERT INTO TEST " + "VALUES ('Davies123-456-7890Greg', 'Davies,Greg', 'address here,Ch4,UK,99999', '123-456-7890', 'greg@greg.greg')");
        //stmt.executeUpdate("DELETE FROM TEST " + "WHERE ID = 'Last1111111111First'");

        // Select the all (*) from the table JAVATEST
        ResultSet rset = stmt.executeQuery("SELECT * FROM ADDRESSENTRYTABLE");

        //printing table
        while (rset.next ()) //get next row of table returned
        {
            for(int i=1; i<=rset.getMetaData().getColumnCount(); i++) { //visit each column

                System.out.print(rset.getString(i) + "\t | ");
            }
            System.out.println();
            System.out.println("========================================");
        }



        //Close access to everything...will otherwise happen when disconnect

        // from database.

        rset.close();

        stmt.close();

        conn.close();

    }

}
