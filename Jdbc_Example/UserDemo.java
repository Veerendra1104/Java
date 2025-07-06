package Jdbc.CRUD_JDBC;

import java.sql.*;

public class UserDemo {
    public static final String url = "jdbc:sqlite:D://SQLiteDatabases//mydatabase.db"; // update path

    void fetchData(){
         try{
             Connection cn = DriverManager.getConnection(url);
             Statement st = cn.createStatement();
             ResultSet res = st.executeQuery("Select * from users");
             while (res.next()){
                 int id = res.getInt("id");
                 String username = res.getString("username");
                 String pass = res.getString("password");
                 System.out.println("   "+id+ "       |      " + username + "        |       " + pass);
             }
         } catch (SQLException e) {
             throw new RuntimeException(e);
         }
    }

    void insertData(String name, String password){
        try {
            Connection c = DriverManager.getConnection(url);
            Statement  st = c.createStatement();
            String sql =  "INSERT INTO users(username, password) VALUES('" + name + "', '" + password + "')"; ;
            int  res = st.executeUpdate(sql);
            if(res > 0){
                System.out.println(name + " inserted succesfully");
            }

        } catch (SQLException e) {
            if(e.getMessage().contains("UNIQUE constraint failed")){
                System.out.println("The user " + name + "is already present !!!");
            }else {
                e.printStackTrace();
            }
        }
    }

    void UpdateData(int id, String newpass){
        try {
            Connection c = DriverManager.getConnection(url);

            String sql = "UPDATE users SET password = ? WHERE id = ?";

            PreparedStatement pre = c.prepareStatement(sql);
            pre.setString(1, newpass);
            pre.setInt(2, id);
            int res = pre.executeUpdate();
            if(res > 0){
                System.out.println(newpass + " updated succesfully");
            }else {
                System.out.println("Updated failled");
            }

        } catch (SQLException e) {
           e.printStackTrace();
        }
    }


    void deleteUserById(int id) {
        String sql = "DELETE FROM users WHERE id = ?";

        try (Connection c = DriverManager.getConnection(url);
             PreparedStatement pre = c.prepareStatement(sql)) {

            pre.setInt(1, id);
            int res = pre.executeUpdate();

            if (res > 0) {
                System.out.println("User with ID " + id + " deleted successfully.");
            } else {
                System.out.println("Deletion failed. No user found with ID: " + id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}



