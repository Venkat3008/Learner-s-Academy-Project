package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import entity.Section;
import entity.Student;
import entity.Subject;
import entity.Teacher;
import utility.HibernateUtil;

@WebServlet("/addDataSubjectServlet")
public class AddDataSubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Section sec = finalCall(request);
		
		
		SessionFactory sf = HibernateUtil.buildSessionFactory();
		Session sess = sf.openSession();
		Transaction trans = sess.beginTransaction();
		
		sess.save(sec);
		
		
		trans.commit();
		
		sess.close();
		
		response.sendRedirect("homepage.html");
		
	}

	public Section finalCall(HttpServletRequest request) {
		String sub_1 = request.getParameter("subject_1");
		String sub_2 = request.getParameter("subject_2");
		String sub_3 = request.getParameter("subject_3");
		
		String teach_1 = request.getParameter("teacher_1");
		String teach_2 = request.getParameter("teacher_2");
		String teach_3 = request.getParameter("teacher_3");
		
		HttpSession session = request.getSession();
//		session.setAttribute("subject_1", sub_1);
//		session.setAttribute("subject_2", sub_2);
//		session.setAttribute("subject_3", sub_3);
//		
//		session.setAttribute("teacher_1", teach_1);
//		session.setAttribute("teacher_2", teach_2);
//		session.setAttribute("teacher_3", teach_3);
		
		String section =  (String) session.getAttribute("section");
		
		String student_1 = (String) session.getAttribute("student_1");
		String student_2 = (String) session.getAttribute("student_2");
		String student_3 = (String) session.getAttribute("student_3");
		String student_4 = (String) session.getAttribute("student_4");
		String student_5 = (String) session.getAttribute("student_5");
		
		System.out.println(section);
		System.out.println(student_1);
		System.out.println(sub_1);
		System.out.println(teach_1);
		
		// Hibernate Logic
		
		//Logic for Section and Students.
		Section sec = new Section();
		
		sec.setSection(section);
		
		List<Student> students = new ArrayList<>();
		

		Student stu = new Student();				
		
		stu.setStudent1(student_1);
		stu.setStudent2(student_2);
		stu.setStudent3(student_3);
		stu.setStudent4(student_4);
		stu.setStudent5(student_5);
		
		students.add(stu);
		
		sec.setStudents(students);
		stu.setS(sec);
		
		//Logic for Subjects.
		List<Section> sections = new ArrayList<>();
		sections.add(sec);
		
		List<Subject> subjects = new ArrayList<>();
				
		Subject sub = new Subject();
		
		sub.setSubject1(sub_1);
		sub.setSubject2(sub_2);
		sub.setSubject3(sub_3);
		
		subjects.add(sub);
		sec.setSubjects(subjects);
		
		// Logic for Teacher
		List<Teacher> teachers = new ArrayList<>();
		
		Teacher t = new Teacher();
		
		t.setTeacher1(teach_1);		
		t.setTeacher2(teach_2);
		t.setTeacher3(teach_3);
		
		teachers.add(t);
		
		sec.setTeachers(teachers);
		
		return sec;
	}


}
