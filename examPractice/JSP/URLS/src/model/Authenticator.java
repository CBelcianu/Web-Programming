package model;

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
            con = DriverManager.getConnection("jdbc:mysql://localhost/jsp3", "root", "");

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

    public void register(String username, String password){
        try {
            preparedStatement = con.prepareStatement("insert into users(username,password) values"+
                    "(?,?)");
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getTop10(){
        String result = "";

        try {
            preparedStatement = con.prepareStatement("select * from urls order by rating DESC LIMIT 10");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                result += "<p>URL: "+rs.getString("url")+" | posted by "+rs.getString("username")+"</p>";
                result += "<p>Rating: "+rs.getInt("rating")+"<hr>";
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public String getTopURLs(int nr, String username){
        String result = "";

        try {
            preparedStatement = con.prepareStatement("select * from urls order by rating DESC LIMIT ?");
            preparedStatement.setInt(1,nr);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                if (rs.getString("username").equals(username)) {
                    result += "<p>URL: " + rs.getString("url") + " | posted by " + rs.getString("username") + "</p>";
                    result += "<p>Rating: " + rs.getInt("rating");
                    result += "<form action=\"URLController\" method=\"post\">\n" +
                            "    <input type=\"hidden\" name=\"user\" value=\"" + username + "\"/>" +
                            "    <input type=\"hidden\" name=\"url\" value=\"" + rs.getString("url") + "\"> <BR>\n" +
                            "    <input type=\"submit\" value=\"Up-vote\"/>\n" +
                            "</form>";
                    result += "<form action=\"URLController\" method=\"get\">\n" +
                            "    <input type=\"hidden\" name=\"user\" value=\"" + username + "\"/>" +
                            "    <input type=\"hidden\" name=\"url\" value=\"" + rs.getString("url") + "\"> <BR>\n" +
                            "    <input type=\"submit\" value=\"Delete\"/>\n" +
                            "</form>";
                    result += "<hr>";
                }
                else{
                    result += "<p>URL: " + rs.getString("url") + " | posted by " + rs.getString("username") + "</p>";
                    result += "<p>Rating: " + rs.getInt("rating") + "<hr>";
                    result += "<form action=\"URLController\" method=\"post\">\n" +
                            "    <input type=\"hidden\" name=\"user\" value=\"" + username + "\"/>" +
                            "    <input type=\"hidden\" name=\"url\" value=\"" + rs.getString("url") + "\"> <BR>\n" +
                            "    <input type=\"submit\" value=\"Up-vote\"/>\n" +
                            "</form>";
                    result += "<hr>";
                }
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void delUrl(String url){
        try {
            preparedStatement = con.prepareStatement("delete from urls where url=?");
            preparedStatement.setString(1,url);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addUrl(String url, String username){
        try {
            preparedStatement = con.prepareStatement("insert into urls(url,username,rating) values(?,?,0)");
            preparedStatement.setString(1,url);
            preparedStatement.setString(2,username);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void upVote(String url){
        try {
            preparedStatement = con.prepareStatement("update urls set rating=rating+1 where url=?");
            preparedStatement.setString(1,url);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
