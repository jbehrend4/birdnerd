import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "ListServlet")
public class ListServlet extends HttpServlet {
    private final String PATH = "/WEB-INF/lib/birdnerd";
    private final String USER = "jbehrend4";
    private final String PW = "000535440";
    private final String DRIVER = "jdbc:derby:";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = null;
        ResultSet rset = null;
        Statement stmt = null;

        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            String path = getServletContext().getRealPath(PATH);

            conn = DriverManager.getConnection(DRIVER + path, USER, PW);

            stmt = conn.createStatement();

            rset = stmt.executeQuery("SELECT * FROM species");

        }
        catch (SQLException | ClassNotFoundException e) {
            response.getWriter().print(e.getException());
            e.printStackTrace();
        }
    }
}
