package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Section;
import utility.HibernateUtil;

@WebServlet("/showDataServlet")
public class ShowDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session session = sf.openSession();
		List<Section> sections = session.createQuery(" from Section ").list();
		
		PrintWriter pw = response.getWriter();
		
		pw.println("<html><body>");
		
		if(sections!=null && sections.size()>0) {
			
			pw.println(" <style> table,td,th { border:2px solid green; padding:10px; } </style> ");
			pw.println("<table>");
			
			pw.println("<tr>");
			pw.println("<th> Class Section </th>");
			pw.println("<th> Student List </th>");
			pw.println("<th> Subject List </th>");
			pw.println("<th> Teacher List </th>");			
			pw.println("</tr>");

			for(Section section : sections) {
				pw.println("<tr>");
				pw.println("<td>"+section.getSection()+"</td>");
				pw.println("<td>"+section.getStudents()+"</td>");
				pw.println("<td>"+section.getSubjects()+"</td>");
				pw.println("<td>"+section.getTeachers()+"</td>");
				pw.println("</tr>");
			}
			
			pw.println("</table>");
			
			
		} else {
			pw.println("No Records find in the DB, Please insert first!");
		}
		 
		
		pw.println("<br><br><a href=\"homepage.html\">Homepage</a>");
		
		pw.println("</body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	
	
}





