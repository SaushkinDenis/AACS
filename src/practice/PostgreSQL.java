package practice;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class PostgreSQL {
    
    public static void main() throws SQLException {
        //TestSQL m = new TestSQL();
        //m.TestDatabase();
        //createRecord(type, nameRecord);
        
        //removeRecord("LISTUSERS");
    }
    
    public static ArrayList setType(String type){
        ArrayList<String> text = new ArrayList();
        switch(type){
                case "User": 
                    text.add("LISTUSERS");
                    text.add("NAMEUSER");
                    text.add("POSITION");
                    text.add("DEPARTMENT");
                    text.add("ACTIVITIES");
                    text.add("PHONE");
                    text.add("ROLE");
                    break;
                case"Role": 
                    text.add("LISTROLE");
                    text.add("NAMEROLE");
                    text.add("ACCESSOBJECTS");
                    text.add("POSITIONROLE");
                    text.add("DEPARTMENTROLE");
                    text.add("ACTIVITIESROLE");
                    break;
                case "Object": 
                    text.add("LISTOBJECTS");
                    text.add("NAMEOBJECT");
                    text.add("TYPE");
                    text.add("RELATIONS");
                    text.add("ACCESSROLE");
                    break;
                }
        
        return text;
    }
    public static void createRecord(String type, String nameRecord, List<String> attribute){
        Connection c;
        Statement stmt;
        ArrayList<String> text = setType(type);
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generaldb","postgres", "postgres");
            c.setAutoCommit(false);
            String sql;
            int id = 0;
           
            
            
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT ID FROM " + text.get(0) + ";");
            while ( rs.next() ) {
                id = rs.getInt("id")+1;
            }
            
            if (PostgreSQL.findRecord(text.get(0),text.get(1),nameRecord)){
                PostgreSQL.removeRecord(text.get(0), text.get(1), nameRecord);
            }
                stmt = c.createStatement();
                if (text.size()==5){
                    sql = "INSERT INTO "+text.get(0)+" (ID," + text.get(1) + "," + text.get(2) + "," + text.get(3) + ","+ text.get(4) + ") VALUES ("+id+", '"+nameRecord+"','" + attribute.get(0) + "','" +attribute.get(1) + "','" +attribute.get(2) + "');";
                }else if (text.size() == 7) {sql = "INSERT INTO "+text.get(0)+" (ID," + text.get(1) + "," + text.get(2) + "," + text.get(3) + ","+ text.get(4) + ","+ text.get(5) + "," + text.get(6) + ") VALUES ("+id+", '"+nameRecord+"','" + attribute.get(0) + "','"+attribute.get(1) + "','" +attribute.get(2) +"','"+attribute.get(3) + "','" +attribute.get(4) + "');";
                }else sql = "INSERT INTO "+text.get(0)+" (ID," + text.get(1) + "," + text.get(2) + "," + text.get(3) + ","+ text.get(4) + ","+ text.get(5) + ") VALUES ("+id+", '"+nameRecord+"','" + attribute.get(0) + "','"+attribute.get(1) + "','" +attribute.get(2) +"','"+attribute.get(3) + "');";
                    
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
               
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }   

      
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
    public static boolean findRecord(String place, String Attribute, String findValues){
        boolean resultFind = false;
        String  nameFind = "";
        Connection c;
        Statement stmt;
        
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generaldb","postgres", "postgres");
            c.setAutoCommit(false);

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM "+place+";" );
            
            while ( rs.next() ) {
                nameFind = rs.getString(Attribute);
                if (nameFind.equals(findValues)){
                    int id = rs.getInt("id");
                    resultFind = true;
                }
            }
            
            rs.close();
            stmt.close();
            c.commit();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
    }    
        return resultFind;
    }
    
    public static ArrayList showEvent(String type, String attributeFind, String rule, int outValues ){
        Connection c;
        Statement stmt;
        ArrayList result = new ArrayList();
        ResultSet rs;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generaldb","postgres", "postgres");
            c.setAutoCommit(false);
            
             ArrayList<String> text = setType(type);
            stmt = c.createStatement();
            if (rule.isEmpty()){
            rs = stmt.executeQuery( "SELECT * FROM "+ text.get(0)+";" );
            } else rs = stmt.executeQuery( "SELECT * FROM "+ text.get(0)+" WHERE "+attributeFind+" = '"+rule+"';");
            while ( rs.next() ) {
                //int id = rs.getInt("id");
                String  nameuser = rs.getString(text.get(outValues));
                //String  object = rs.getString("object");
                //result.add(String.format("ID=%s NAMEEVENT=%s OBJECT=%s",id,nameevent,object));
                result.add(nameuser);
                //result.add("");
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
            
    public static void removeRecord(String removeList, String removeUser, String removeAttribute){
        Connection c;
        Statement stmt;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generaldb","postgres", "postgres");
            c.setAutoCommit(false);
            String sql;
            int id = 0;
            stmt = c.createStatement();
            sql = "DELETE FROM "+removeList+" WHERE " + removeUser + " = '" + removeAttribute + "';";
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }     

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