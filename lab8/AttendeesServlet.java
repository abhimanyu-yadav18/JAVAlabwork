package servletfolder;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import servletfolder.dataconn;  // Import the dataconn class from servletfolder package

public class AttendeesServlet extends HttpServlet {

    // Method to handle GET requests (Read operation)
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            Connection con = dataconn.getConnection();  // Use dataconn to get the connection
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM attendees");

            out.println("<h1>Attendees List</h1>");
            out.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Attendance Status</th></tr>");

            while (rs.next()) {
                out.println("<tr><td>" + rs.getInt("id") + "</td>");
                out.println("<td>" + rs.getString("name") + "</td>");
                out.println("<td>" + rs.getString("attendance_status") + "</td></tr>");
            }

            out.println("</table>");
            con.close();
        } catch (SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    // Method to handle POST requests (Create operation)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String attendanceStatus = request.getParameter("attendance_status");

        try {
            Connection con = dataconn.getConnection();  // Use dataconn to get the connection
            String query = "INSERT INTO attendees (name, attendance_status) VALUES (?, ?)";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, name);
            pst.setString(2, attendanceStatus);
            int result = pst.executeUpdate();

            if (result > 0) {
                out.println("<h3>Attendance recorded successfully!</h3>");
            } else {
                out.println("<h3>Error in recording attendance.</h3>");
            }

            con.close();
        } catch (SQLException e) {
            out.println("Error: " + e.getMessage());
        }
    }

    // Method to handle PUT requests (Update operation)
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // For PUT, we typically need a form or URL with ID to update.
        // In this case, we'll assume the ID and new attendance status are passed as parameters.

        String id = request.getParameter("id");
        String newStatus = request.getParameter("attendance_status");

        try {
            Connection con = dataconn.getConnection();  // Use dataconn to get the connection
            String query = "UPDATE attendees SET attendance_status = ? WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1, newStatus);
            pst.setInt(2, Integer.parseInt(id));
            int result = pst.executeUpdate();

            if (result > 0) {
                response.getWriter().println("<h3>Attendance updated successfully!</h3>");
            } else {
                response.getWriter().println("<h3>Error updating attendance.</h3>");
            }
            con.close();
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }

    // Method to handle DELETE requests (Delete operation)
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");

        try {
            Connection con = dataconn.getConnection();  // Use dataconn to get the connection
            String query = "DELETE FROM attendees WHERE id = ?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, Integer.parseInt(id));
            int result = pst.executeUpdate();

            if (result > 0) {
                response.getWriter().println("<h3>Attendance record deleted successfully!</h3>");
            } else {
                response.getWriter().println("<h3>Error deleting record.</h3>");
            }
            con.close();
        } catch (SQLException e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}