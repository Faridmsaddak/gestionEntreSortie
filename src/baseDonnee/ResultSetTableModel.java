/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDonnee;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import utils.ConnectionDB;



/**
 *
 * @author lenovo
 */
public class ResultSetTableModel extends AbstractTableModel {
    private ResultSet rs;
    @Override
    public int getRowCount() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getColumnCount() {
       try {
          if(rs==null){
              return 0;
          }else{
              return rs.getMetaData().getColumnCount();
          }
          
       } catch (Exception ex) {
           return 0;
      }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex <0 ||rowIndex >getRowCount() || columnIndex<0 || columnIndex> getColumnCount() ){
            return null;
        }
        try {
                if(rs==null){
                    return null;
                }else{
                    rs.absolute(rowIndex+1);
                    return rs.getObject(columnIndex+1);
                }

             } catch (Exception ex) {
                 return 0;
            }
          }
    @Override
    public String getColumnName(int columnIndex){
        
        try {
          
              return rs.getMetaData().getColumnName(columnIndex+1);
          
          
       } catch (Exception ex) {
         Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
      } 
        return super.getColumnName(columnIndex);
    }
}
