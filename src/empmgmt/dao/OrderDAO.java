/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dao;

import empmgmt.dbutil.DBConnection;
import empmgmt.pojo.ProductPojo;
import empmgmt.pojo.UserProfile;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import static javax.swing.UIManager.getString;

/**
 *
 * @author saumy
 */
public class OrderDAO {
    public static String getNextOrderID()throws SQLException
    {
    Connection conn= DBConnection.getConnection();
    Statement st=conn.createStatement();
    ResultSet rs=st.executeQuery("select max(order_id)from orders");
    rs.next();
    String ordId=getString(1);
    if(ordId==null)
        return "O-101";
    int ordno=Integer.parseInt(ordId.substring(2));
    ordno++;
    return "O"+ordno ;
    
    } 
     public static boolean addOrder(ArrayList<ProductPojo>al,String ordId)throws SQLException
     {
          Connection conn= DBConnection.getConnection();
          PreparedStatement ps=conn.prepareStatement("Insert orders value (?,?,?,?)");
          int count=0;
          for(ProductPojo p:al)
          {
              ps.setString(1, ordId);
              ps.setString(2, p.getProductId());
              ps.setInt(3, p.getQuantity());
              ps.setString(4, UserProfile.getUserid());
              count=count+ps.executeUpdate();
          }
          return count==al.size();
     }
}
