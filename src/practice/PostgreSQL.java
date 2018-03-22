package practice;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
 
public class PostgreSQL {
    
    public static void main(String[] args) {
        //TestSQL m = new TestSQL();
        //m.TestDatabase();
        System.out.println(showEvent());
        
    }
    
    public static void createEvent(String nameEvent, String object){
        Connection c;
        Statement stmt;
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generaldb","postgres", "postgres");
            c.setAutoCommit(false);
            String sql;
            int id = 0;
            
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT ID FROM EVENT;" );
            while ( rs.next() ) {
                id = rs.getInt("id")+1;
            }
            
            stmt = c.createStatement();
            sql = "INSERT INTO EVENT (ID,NAMEEVENT,OBJECT) VALUES ("+id+", '"+nameEvent+"', '"+object+"');";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
    }    
    
    }
    
    public static ArrayList showEvent(){
        Connection c;
        Statement stmt;
        ArrayList result = new ArrayList();;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generaldb","postgres", "postgres");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT NAMEEVENT FROM EVENT;" );
            while ( rs.next() ) {
                //int id = rs.getInt("id");
                String  nameevent = rs.getString("nameevent");
                //String  object = rs.getString("object");
                //result.add(String.format("ID=%s NAMEEVENT=%s OBJECT=%s",id,nameevent,object));
                result.add(String.format("NAMEEVENT = %s",nameevent));
                result.add("");
        }
        rs.close();
        stmt.close();
        c.commit();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
    }    
    return result;
    }        
            
            
    public static void TestDatabase() {
 
     Connection c;
        Statement stmt;
 
    try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generaldb","postgres", "postgres");
        c.setAutoCommit(false);
        System.out.println("-- Opened database successfully");
        String sql;
 
        //-------------- CREATE TABLE ---------------
        
        stmt = c.createStatement();
        sql = "CREATE TABLE EVENT" +
                "(ID INT PRIMARY KEY     NOT NULL," +
                " NAMEEVENT           TEXT    NOT NULL," +
                " OBJECT           TEXT    NOT NULL)";
        stmt.executeUpdate(sql);
        stmt.close();
        c.commit();
        System.out.println("-- Table created successfully");
 
        //--------------- INSERT ROWS ---------------
        stmt = c.createStatement();
        sql = "INSERT INTO EVENT (ID,NAMEEVENT,OBJECT) VALUES (1, 'РЕГИСТРАЦИЯ', '1231111');";
        stmt.executeUpdate(sql);
 
        /* sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (2, 'Allen', 25, 'Texas', 15000.00 );";
        stmt.executeUpdate(sql);
        
        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );";
        stmt.executeUpdate(sql);
        
        sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );";
        stmt.executeUpdate(sql);*/
 
        stmt.close();
        c.commit();
        System.out.println("-- Records created successfully");
        
         //-------------- UPDATE DATA ------------------
/*        stmt = c.createStatement();
        sql = "UPDATE COMPANY set SALARY = 25000.00 where ID=1;";
        stmt.executeUpdate(sql);
        c.commit();
        stmt.close();
 
        System.out.println("-- Operation UPDATE done successfully");
 
 */
        //--------------- SELECT DATA ------------------
        stmt = c.createStatement();
        ResultSet rs = stmt.executeQuery( "SELECT * FROM EVENT;" );
        while ( rs.next() ) {
            int id = rs.getInt("id");
            String  nameevent = rs.getString("nameevent");
            String  object = rs.getString("object");
            System.out.println(String.format("ID=%s NAMEEVENT=%s OBJECT=%s",id,nameevent,object));
        }
        rs.close();
        stmt.close();
        c.commit();
        System.out.println("-- Operation SELECT done successfully");
 
 /*
        //-------------- DELETE DATA ----------------------
        stmt = c.createStatement();
        sql = "DELETE from COMPANY where ID=2;";
        stmt.executeUpdate(sql);
        c.commit();
        stmt.close();
        System.out.println("-- Operation DELETE done successfully");
 
 
        c.close();
 */
    } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
    }
    System.out.println("-- All Operations done successfully");
 
}
}