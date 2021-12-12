/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author lenovo
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ConnectionDB {
  String protocole =  "jdbc:mysql:" ;
  String ip =  "localhost" ;  // dépend du contexte
  String port =  "3306" ;  // port MySQL par défaut
  String nomBase =  "gestionstock" ; 
  String nomConnexion =  "root" ;  // dépend du contexte
  String motDePasse =  "" ;  // dépend du contexte
   String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;

    public ConnectionDB() {
    }
   
  public Connection getConnection () throws ClassNotFoundException{
      Connection con=null;
      try {
          Class.forName("com.mysql.cj.jdbc.Driver");  
           con = DriverManager.getConnection(
                  conString, nomConnexion, motDePasse) ;
      } catch (SQLException ex) {
          Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
      }
      return con;
  }
    
}
