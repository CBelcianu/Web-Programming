package jsp.model;

import java.sql.*;
import java.util.Random;

public class DataBaseAdaptor {
    private String driver;
    private String connectionString;
    private String username;
    private String password;
    private Connection connection;
    private int score = 0;
    private int n = 3;

    public DataBaseAdaptor() {
        this.driver = "org.gjt.mm.mysql.Driver";
        this.connectionString = "jdbc:mysql://localhost/lab8jsp";
        this.username = "root";
        this.password = "";
    }

    public void connect() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(connectionString, username, password);
        } catch(Exception ex) {
            System.out.println("Error while connecting: "+ex.getMessage());
        }
    }

    public void disconnect(){
        try{
            connection.close();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void swap(int id1, int id2) {
        try {
            System.out.println("swap (" + id1 + ", " + id2 + ")");
            PreparedStatement pStmtSelect = this.connection.prepareStatement("SELECT SUM(Position) FROM puzzle WHERE ID IN (?, ?)");
            pStmtSelect.setInt(1, id1);
            pStmtSelect.setInt(2, id2);
            ResultSet rs = pStmtSelect.executeQuery();
            rs.next();
            int sum = Integer.parseInt(rs.getString(1));
            PreparedStatement pStmt = this.connection.prepareStatement("UPDATE puzzle SET Position = ? - Position WHERE ID IN (?, ?)");
            pStmt.setInt(1, sum);
            pStmt.setInt(2, id1);
            pStmt.setInt(3, id2);
            pStmt.executeUpdate();
            PreparedStatement us = this.connection.prepareStatement("UPDATE score SET m=m+1");
            us.execute();
        } catch(SQLException e) {
            System.out.println("Error while swapping");
            e.printStackTrace();
        }
    }

    public void resetGame() {
        shufflePuzzle();
    }

    private static void shuffleArray(int[] ar) {
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }

    private void shufflePuzzle() {
        Random r = new Random();
        int [] pos = new int[n * n];
        for(int i = 0; i < n * n; ++ i)
            pos[i] = i;
        shuffleArray(pos);
        try {
            PreparedStatement stmt2 = connection.prepareStatement("DELETE FROM puzzle");
            PreparedStatement stmt3 = connection.prepareStatement("DELETE FROM score");
            stmt2.execute();
            stmt3.execute();
            PreparedStatement stmt1 = connection.prepareStatement("INSERT INTO score values (0)");
            stmt1.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            for (int i = 0; i < n * n; ++i) {
                PreparedStatement pStmt = this.connection.prepareStatement("INSERT INTO puzzle (ID, Position) VALUES(?, ?) ON DUPLICATE KEY UPDATE Position = values(Position)");
                pStmt.setInt(1, i);
                pStmt.setInt(2, pos[i]);
                pStmt.executeUpdate();
            }
        }catch(SQLException e) {
            System.out.println("SqlException: " + e.toString());
            e.printStackTrace();
        }
    }

    public String getPuzzle() {
        String res = new String();
        try {
            PreparedStatement psss = connection.prepareStatement("SELECT * FROM score");
            ResultSet rsss = psss.executeQuery();
            rsss.next();
            score = rsss.getInt("m");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        res+="<p>Moves:"+score+"</p>";
        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT  * FROM puzzle where ID >= 0 and ID < ?");
            stmt.setInt(1, n * n);
            ResultSet rs = stmt.executeQuery();
            int where[] = new int[n * n];
            while(rs.next()) {
                where[rs.getInt("position")] = rs.getInt("id");
            }
            boolean solved = true;
            for(int i = 0; i < n * n; ++ i) {
                if(where[i] != i)
                    solved = false;
                res += "<img id = '" + where[i] + "' class='puzzlepiece' src='img/" + where[i] + ".jpeg'/>";
            }
            if(solved) {
                res += "<p>Congratulations, you finished the puzzle in: " + this.score + "!</p>";
                res += "<link rel='stylesheet' type='text/css' href='lock.css'>";
            }
        } catch(Exception ex) {
            System.out.println("Error on get Puzzle: " + ex.getMessage());
        }
        return res;
    }
}
