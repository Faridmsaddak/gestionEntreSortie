
package baseDonnee;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

import utils.ConnectionDB;
public class BDD {
 
    Connection connection;
    Statement statement;
    String SQL;
    String url;
    String username;
    String password;
    int port;
    String host;

    public BDD(String url, String username, String password,  String host,int port) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.port = port;
        this.host = host;
    }

  
    
    // fonction ouverir connextion 
    public Connection connextionDataBase () {
      
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");  
           connection = DriverManager.getConnection(
                  url, username, password) ;
      } catch (Exception ex) {
          Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
      }
      return connection;
  }
  // fonction ferme connextion 
    public Connection closeConnextion(){
         try {
          connection.close();
      } catch (Exception ex) {
          Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
      }
      return connection;
        
    }
    
    public ResultSet executeQuery(String sql){
        connextionDataBase();
        ResultSet resultSet=null;
        try {
          statement=connection.createStatement();
          resultSet=statement.executeQuery(sql);
          
        }
        catch (Exception ex) {
          Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
      }
       return resultSet;
    }
    public String  executeUpdate(String sql){
        connextionDataBase();
        String result="";
        try {
          statement=connection.createStatement();
          statement.executeUpdate(sql);
          result=sql;
          
        }
        catch (Exception ex) {
          Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
      }
       return result;
    }
    //requete pour afficher tous les données  
    public ResultSet querySelectAll(String nameTable){
        connextionDataBase();
        SQL="SELECT * FROM "+nameTable;
        return this.executeQuery(SQL);
    }
    
    //requete pour afficher tous les données  selon condition
    public ResultSet querySelectAll(String nameTable,String where){
        connextionDataBase();
        SQL="SELECT * FROM "+nameTable+" WHERE "+where;
        return this.executeQuery(SQL);
    }
    
     //requete pour afficher tous les données  le nom de collones
    public ResultSet querySelectAll(String [] nameColonne ,String nameTable){
        
        connextionDataBase();
        SQL="SELECT ";
        for (int i = 0; i <= nameColonne.length-1; i++) {
            SQL+= nameColonne[i];
                if(i<nameColonne.length){
                  SQL+=","  ;
                }
            SQL+=" FROM "+nameTable;
        }
        return this.executeQuery(SQL);
    }
      //requete pour afficher tous les données  le nom de collones
    public String queryInsert(String nameTable ,String [] contenuTableau){
        
        connextionDataBase();
        SQL="INSERT INTO " + nameTable + " VALUES (";
        for (int i = 0; i <= contenuTableau.length-1; i++) {
            SQL+= ", "+contenuTableau[i];
                if(i<contenuTableau.length-1){
                  SQL+=","  ;
                }
            SQL+=")";
        }
        return this.executeUpdate(SQL);
    }
      public String queryInsert(String nameTable ,String [] nameColonne,String [] contenuTableau){
        
        connextionDataBase();
        SQL="INSERT INTO " + nameTable + "(";
        for (int i = 0; i <= nameColonne.length-1; i++) {
            SQL+= ", "+nameColonne[i];
                if(i<nameColonne.length-1){
                  SQL+=","  ;
                }
            SQL+=") VALUES (";
        }
        for (int i = 0; i <= contenuTableau.length-1; i++) {
            SQL+= ", "+contenuTableau[i];
                if(i<contenuTableau.length-1){
                  SQL+=","  ;
                }
            SQL+=")";
        }
        return this.executeUpdate(SQL);
    }
    
    public String queryDelete(String nameTable){
        
        connextionDataBase();
        SQL="DELET  FROM "+nameTable;
        return this.executeUpdate(SQL);
    }
    
    public String queryDelete(String nameTable,String where){
        
        connextionDataBase();
        SQL="DELET  FROM "+nameTable+" WHERE "+where;
        return this.executeUpdate(SQL);
    }
}
    
    

