package jsp.controller;

import jsp.model.dataBaseAdaptor;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class puzzleController extends HttpServlet {
    public void writePuzzle(PrintWriter printWriter, String puzzleHtml) {
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>Puzzle JSP</title>");
        printWriter.println("<link rel='stylesheet' type='text/css' href='style.css'>");
        printWriter.println("<script src='scripts/jquery-3.3.1.js'></script>");
        printWriter.println("<script src='scripts/lab9.js'></script> ");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<div id='score'>");
        printWriter.println("</div>");
        printWriter.println("<div id='puzzle'>");
        printWriter.println(puzzleHtml);
        printWriter.println("</div>");
        printWriter.println("<div id='status'>");
        printWriter.println("</div>");
        printWriter.println("<input action='action' onclick='window.location.href=\"/\"' type='button' value='Back' />");
        printWriter.println("<form action='/puzzle' method='post'> ");
        printWriter.println("</form>");
        printWriter.println("</body>");
        printWriter.println("</html>");
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        dataBaseAdaptor db = new dataBaseAdaptor();
        db.connect();
        writePuzzle(res.getWriter(), db.getPuzzle());
        db.disconnect();
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        dataBaseAdaptor db = new dataBaseAdaptor();
        db.connect();
        db.resetGame();
        writePuzzle(res.getWriter(), db.getPuzzle());
        db.disconnect();
    }
    public void doPut(HttpServletRequest req, HttpServletResponse res) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));

        String data = br.readLine();
        System.out.println(data);
        Map<String, String> params = new HashMap<>();
        Stream.of(data.split("&", 2)).forEach((par) -> {
            String[] arr = par.split("=", 2);
            params.put(arr[0], arr[1]);
        });
        int id1 = Integer.valueOf(params.get("id1"));
        int id2 = Integer.valueOf(params.get("id2"));
        dataBaseAdaptor db = new dataBaseAdaptor();
        db.connect();
        db.swap(id1, id2);
        res.getWriter().println(db.getPuzzle());
        db.disconnect();
    }
}
