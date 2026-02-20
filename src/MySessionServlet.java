import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class MySessionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException {


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Perform authentication logic here
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
            HttpSession session = request.getSession(true);
            // Set a value in the session
            session.setAttribute("user", username);
            response.sendRedirect("dashboard.jsp");
        } else {

            // If authentication fails, send an error message
            response.setContentType("text/html");
            response.getWriter().println("<html><body>");
            response.getWriter().println("<h1>Invalid credentials</h1>");
            response.getWriter().println("</body></html>");
        }
    }

    private boolean authenticate(String username, String password) {
        // Replace this with your actual authentication logic
        return username.equals("admin") && password.equals("password");
    }
}
