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
    protected static Connection c;
    protected static Statement stmt;
    protected static String sql;
    protected static ResultSet rs;


    
    public static void setRs(ResultSet rs) {
        PostgreSQL.rs = rs;
    }

    public static void setSql(String sql) {
        PostgreSQL.sql = sql;
    }

    public static void setStmt() throws SQLException {
        PostgreSQL.stmt = c.createStatement();
    }
    
    public static void setC() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generaldb","postgres", "postgres");
        c.setAutoCommit(false);
        
        setStmt();
    }
    
    public static Connection getC() {
        return c;
    }
    
    
    public static void main() throws ClassNotFoundException, SQLException {
        
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
        ArrayList<String> text = setType(type);
        int id = 0;
        
        try {
            setC();
            setRs(stmt.executeQuery( "SELECT ID FROM " + text.get(0) + ";"));
            
            
            while ( rs.next() ) {
                id = rs.getInt("id")+1;
            }
            
            if (PostgreSQL.findRecord(text.get(0),text.get(1),nameRecord)){
                PostgreSQL.removeRecord(text.get(0), text.get(1), nameRecord);
            }
                setStmt();
                if (text.size()==5){
                    setSql("INSERT INTO "+text.get(0)+" (ID," + text.get(1) + "," + text.get(2) + "," + text.get(3) + ","+ text.get(4) + ") VALUES ("+id+", '"+nameRecord+"','" + attribute.get(0) + "','" +attribute.get(1) + "','" +attribute.get(2) + "');");
                }else if (text.size() == 7) {setSql("INSERT INTO "+text.get(0)+" (ID," + text.get(1) + "," + text.get(2) + "," + text.get(3) + ","+ text.get(4) + ","+ text.get(5) + "," + text.get(6) + ") VALUES ("+id+", '"+nameRecord+"','" + attribute.get(0) + "','"+attribute.get(1) + "','" +attribute.get(2) +"','"+attribute.get(3) + "','" +attribute.get(4) + "');");
                }else setSql("INSERT INTO "+text.get(0)+" (ID," + text.get(1) + "," + text.get(2) + "," + text.get(3) + ","+ text.get(4) + ","+ text.get(5) + ") VALUES ("+id+", '"+nameRecord+"','" + attribute.get(0) + "','"+attribute.get(1) + "','" +attribute.get(2) +"','"+attribute.get(3) + "');");
                    
                stmt.executeUpdate(sql);
                stmt.close();
                c.commit();
                c.close();
               
            } catch (Exception e) {
                System.err.println(e.getClass().getName()+": "+e.getMessage());
                System.exit(0);
            }   

      
    }
    
    
    public static void createEvent(String nameEvent, String object){
        int id = 0;
        try {
            //setC();
            getC();
            setRs(stmt.executeQuery( "SELECT ID FROM EVENT;" ));
            
            while ( rs.next() ) {
                id = rs.getInt("id")+1;
            }
            
            setStmt();
            setSql("INSERT INTO EVENT (ID,NAMEEVENT,OBJECT) VALUES ("+id+", '"+nameEvent+"', '"+object+"');");
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
    }    
    
        
    }
    
    public static void updateSQL(String type, String attribute, String findValues){
        ArrayList setType = setType(type);
        //findRecord(place, attribute, findValues);
        
    }
    public static void updateObject(){
        
        
    }
    public static boolean findRecord(String place, String attribute, String findValues){
        boolean resultFind = false;
        String  nameFind = "";
        int id = 0;
        
        try {
            setC(); 
  
            setRs(stmt.executeQuery( "SELECT * FROM "+place+";"));
            
            while ( rs.next() ) {
                nameFind = rs.getString(attribute);
                if (nameFind.equals(findValues)){
                    id = rs.getInt("id");
                    resultFind = true;
                }
            }
            
            rs.close();
            stmt.close();
            c.commit();
            c.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
    }    
        return resultFind;
    }
    
    public static ArrayList showEvent(String type, String attributeFind, String rule, int outValues ){
        ArrayList result = new ArrayList();
        try {
            setC();

            ArrayList<String> text = setType(type);
            
            if (rule.isEmpty()){
            setRs(stmt.executeQuery( "SELECT * FROM "+ text.get(0)+";"));
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
        c.close();
    
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
    }    
    return result;
    }        
            
    public static void removeRecord(String removeList, String removeUser, String removeAttribute){
        try {
            //setC();
            getC();
            setSql("DELETE FROM "+removeList+" WHERE " + removeUser + " = '" + removeAttribute + "';");
            
            stmt.executeUpdate(sql);
            c.commit();
            stmt.close();
            c.close();
        //} catch (ClassNotFoundException ex) {
        //    Logger.getLogger(PostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
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