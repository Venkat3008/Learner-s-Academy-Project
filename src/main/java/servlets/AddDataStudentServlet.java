package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addDataStudentServlet")
public class AddDataStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stu_1 = request.getParameter("student_1");
		String stu_2 = request.getParameter("student_2");
		String stu_3 = request.getParameter("student_3");
		String stu_4 = request.getParameter("student_4");
		String stu_5 = request.getParameter("student_5");
		
		HttpSession session = request.getSession();
		session.setAttribute("student_1", stu_1);
		session.setAttribute("student_2", stu_2);
		session.setAttribute("student_3", stu_3);
		session.setAttribute("student_4", stu_4);
		session.setAttribute("student_5", stu_5);
		
		request.getRequestDispatcher("addDataSubject.html").include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
