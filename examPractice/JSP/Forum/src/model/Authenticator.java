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
            con = DriverManager.getConnection("jdbc:mysql://localhost/jsp2", "root", "");

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

    public String getTopics(String username){
        String result="";
        try {
            preparedStatement = con.prepareStatement("select * from topics");
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                result+="<p> Topic: "+rs.getString("tname")+" created by " + rs.getString("username")+"</p>";
                result+="<p>"+rs.getString("tdescription")+"</p>";
                result+="<form action=\"CommentsController\" method=\"get\">\n" +
                        "    <input type=\"text\" name=\"comment\">"+
                        "    <input type=\"hidden\" name=\"user\" value=\""+username+"\"/>\n" +
                        "    <input type=\"hidden\" name=\"topic\" value=\""+rs.getString("tname")+"\"/>\n" +
                        "    <input id=\"toComment\" type=\"hidden\" name=\"comment\" value=\""+"\"/>\n" +
                        "    <input type=\"submit\" value=\"Comment\"/>\n" +
                        "</form>" +
                        "<form action=\"CommentsController\" method=\"post\">\n" +
                        " <input type=\"hidden\" name=\"topic\" value=\"" + rs.getString("tname") + "\"/>\n" +
                        " <input type=\"hidden\" name=\"user\" value=\"" + rs.getString("username") +
                        "\"/>" + " <input type=\"submit\" value=\"View Comments\"/>\n" +
                        "</form>\n";
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void deleteComment(String username, String comment){
        try {
            preparedStatement = con.prepareStatement("delete from comments where comment=? and username=?");
            preparedStatement.setString(1,comment);
            preparedStatement.setString(2,username);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getComments(String topic, String username){
        String result="";
        try {
            preparedStatement = con.prepareStatement("select * from comments where tname=?");
            preparedStatement.setString(1,topic);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                if(rs.getString("username").equals(username)){
                    result+="<p>"+rs.getString("username")+" commented:</p>";
                    result+="<p>"+rs.getString("comment")+"</p>";
                    result+="<form action=\"CommentController\" method=\"post\">"+
                            "<input type=\"hidden\" name=\"user\" value=\""+username+"\"/>\n" +
                            "<input type=\"hidden\" name=\"comment\" value=\""+rs.getString("comment")+"\"/>\n" +
                            "<input type=\"submit\" value=\"Delete\"/>"+
                            "</form><hr>";
                }
                else{
                    result+="<p>"+rs.getString("username")+" commented:</p>";
                    result+="<p>"+rs.getString("comment")+"</p><hr>";
                }
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public void addComment(String topic, String username, String comment){
        try {
            preparedStatement = con.prepareStatement("insert into comments(tname,comment,username) values"+
                    "(?,?,?)");
            preparedStatement.setString(1,topic);
            preparedStatement.setString(2,comment);
            preparedStatement.setString(3,username);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public String getPasswordFroUser(String username){
        try {
            preparedStatement = con.prepareStatement("select password from users where username=?");
            preparedStatement.setString(1,username);
            ResultSet rs=preparedStatement.executeQuery();
            rs.next();
            return  rs.getString("password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addTopic(String topic, String description, String username){
        try {
            preparedStatement = con.prepareStatement("insert into topics(tname,tdescription,username) "+
                    "values (?,?,?)");
            preparedStatement.setString(1,topic);
            preparedStatement.setString(2,description);
            preparedStatement.setString(3,username);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
