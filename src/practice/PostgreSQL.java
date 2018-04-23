package practice;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class PostgreSQL {
    protected static Connection connection;
    //Для использования SQL запросов существуют 3 типа объектов:
    protected static Statement stmt;                               //1.Statement: используется для простых случаев без параметров
    //protected static PreparedStatement preparedStatement = null; //2.PreparedStatement: предварительно компилирует запросы, которые могут содержать входные параметры
    protected static String sql;
    protected static ResultSet rs;
    public static int id;

    public static void setConnection() throws ClassNotFoundException, SQLException {
        //Загрузка драйвера
        Class.forName("org.postgresql.Driver");
        //Создание соединения
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/generaldb","postgres", "postgres");
        connection.setAutoCommit(false);
        setStmt();
    }
    
    public static void setStmt() throws SQLException {
        PostgreSQL.stmt = connection.createStatement();
    }
    
    public static void setSql(String sql) {
        PostgreSQL.sql = sql;
    }
    
    public static void setRs(ResultSet rs) {
        PostgreSQL.rs = rs;
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
    
    //----------------  Создание новой записи --------------------------
    public static void createRecord(String type, String nameRecord, List<String> attribute){ 
        
        ArrayList<String> text = setType(type);
        
        try {
            setConnection();
            //Выполним запрос
            setRs(stmt.executeQuery( "SELECT ID FROM " + text.get(0) + ";"));
            //Поиск последнего id
            while ( rs.next() ) {
                id = rs.getInt("id")+1;
            }
            //Уничтожение записи, вслучае ее существования
            if (PostgreSQL.findRecord(text.get(0),text.get(1),nameRecord)){
                PostgreSQL.removeRecord(text.get(0), text.get(1), nameRecord);
            }
            
            setStmt();
            switch(text.get(0)){
                case "LISTUSERS" :
                    setSql("INSERT INTO "+text.get(0)+" (ID," + text.get(1) + "," + text.get(2) + "," + text.get(3) + ","+ text.get(4) + ","+ text.get(5) + "," + text.get(6) + ") VALUES ("+id+", '"+nameRecord+"','" + attribute.get(0) + "','"+attribute.get(1) + "','" +attribute.get(2) +"','"+attribute.get(3) + "','" +attribute.get(4) + "');");
                    break;
                case "LISTROLE" :
                    setSql("INSERT INTO "+text.get(0)+" (ID," + text.get(1) + "," + text.get(2) + "," + text.get(3) + ","+ text.get(4) + ","+ text.get(5) + ") VALUES ("+id+", '"+nameRecord+"','" + attribute.get(0) + "','"+attribute.get(1) + "','" +attribute.get(2) +"','"+attribute.get(3) + "');");
                    break;
                case "LISTOBJECTS" :
                    setSql("INSERT INTO "+text.get(0)+" (ID," + text.get(1) + "," + text.get(2) + "," + text.get(3) + ","+ text.get(4) + ") VALUES ("+id+", '"+nameRecord+"','" + attribute.get(0) + "','" +attribute.get(1) + "','" +attribute.get(2) + "');");
                    break;
            }
            // Вставить запись
            stmt.executeUpdate(sql);
                   
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
            
        } finally {
            if (connection != null) {
                try {
                    rs.close();
                    stmt.close();
                    connection.commit();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
        }
    }
    
    public static void createEvent(String nameEvent, String object){
        
        try {
            setConnection();
            setRs(stmt.executeQuery( "SELECT ID FROM EVENT;" ));
            
            while ( rs.next() ) {
                id = rs.getInt("id")+1;
            }
            
            setStmt();
            setSql("INSERT INTO EVENT (ID,NAMEEVENT,OBJECT) VALUES ("+id+", '"+nameEvent+"', '"+object+"');");
            stmt.executeUpdate(sql);

            
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        } finally {
            if (connection != null) {
                try {
                    rs.close();
                    stmt.close();
                    connection.commit();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
        }   
    
        
    }
    
    public static void updateSQL(String type, String attribute, String values, String id){
        
        try{
            setConnection();
            
            setStmt();
            setSql("UPDATE "+type+" SET "+attribute+" = "+values+" WHERE id = "+id+";");
            stmt.executeUpdate(sql);
        
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        } finally {
            if (connection != null) {
                try {
                    rs.close();
                    stmt.close();
                    connection.commit();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
        } 
        
        
    }
    
    public static void updateObject(){
               
    }
    
    public static boolean findRecord(String place, String attribute, String findValues){
        boolean resultFind = false;
        String  nameFind;

               
        try {
            setConnection(); 
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

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }    
        return resultFind;
    }
    
    public static ArrayList<String> showRecord(String type, String attributeFind, String rule, int outValues ){
        
        ArrayList result = new ArrayList();
        ArrayList<String> text = setType(type);
        try {
            setConnection();
            
            if (rule.isEmpty()){
                setRs(stmt.executeQuery( "SELECT * FROM "+ text.get(0)+";"));
            } else setRs(stmt.executeQuery( "SELECT * FROM "+ text.get(0)+" WHERE "+attributeFind+" = '"+rule+"';"));
            
            while ( rs.next() ) {
                String  nameuser = rs.getString(text.get(outValues));
                //int id = rs.getInt("id");
                //result.add(String.format("ID=%s NAMEEVENT=%s OBJECT=%s",id,nameevent,object));
                result.add(nameuser);
            }
        
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        
        } finally {
            if (connection != null) {
                try {
                    rs.close();
                    stmt.close();
                    connection.commit();
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }
        }
        return result;
    }        
            
    public static void removeRecord(String removeList, String removePlace, String removeAttribute){
        try {
            setConnection();
            setSql("DELETE FROM "+removeList+" WHERE " + removePlace + " = '" + removeAttribute + "';");
            stmt.executeUpdate(sql);
            
            rs.close();
            stmt.close();
            connection.commit();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(PostgreSQL.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }  
    
  
    
// =================== BACK =================
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