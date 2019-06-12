package ro.model;

import java.sql.*;

public class Authenticator {
    private PreparedStatement preparedStatement;
    private Connection con;

    public Authenticator() {
        connect();
    }

    public void connect() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/jsp1", "root", "");

        } catch(Exception ex) {
            System.out.println("eroare la connect:"+ex.getMessage());
            ex.printStackTrace();
        }
    }

    public boolean authenticate(String username, String password) {

        ResultSet rs;
        boolean result = false;
        System.out.println(username+" "+password);
        try {
            preparedStatement = con.prepareStatement("select * from users where username=?");
            preparedStatement.setString(1, username);
            rs = preparedStatement.executeQuery();
            if (rs.next() && rs.getString("password").equals(password)) {
                result = true;
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void register(String username, String password, String email, int age, String town, String photo){
        try {
            preparedStatement = con.prepareStatement("insert into users(username,password,email,age,town,photo) values"+
                    "(?,?,?,?,?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, email);
            preparedStatement.setInt(4, age);
            preparedStatement.setString(5, town);
            preparedStatement.setString(6, photo);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getFromPartialUser(PartialUser partialUser){
        ResultSet rs;
        User user;
        try {
            String qry = "select * from users where username='"+partialUser.getUsername()+"'";
            preparedStatement = con.prepareStatement(qry);
            rs = preparedStatement.executeQuery();
            rs.next();
            user = new User(rs.getString("username"),rs.getString("password"),rs.getString("email"),rs.getInt("age"),rs.getString("town"),rs.getString("photo"));
            rs.close();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateInfo(String username, String password, String email, String town){
        try {
            preparedStatement = con.prepareStatement("update users set password=?,email=?,town=? where username=?");
            preparedStatement.setString(1,password);
            preparedStatement.setString(2,email);
            preparedStatement.setString(3,town);
            preparedStatement.setString(4,username);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getProfiles(String username){
        String result="";
        try {
            preparedStatement = con.prepareStatement("select * from users where username not like ?");
            preparedStatement.setString(1,username);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                result+="<img src="+rs.getString("photo")+" width=\"200px\" height=\"170px\"><br>";
                result+="<p>"+rs.getString("username")+" from " + rs.getString("town")+"</p><br>";
                result+="<p>"+rs.getString("email")+"</p><br>";
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}
