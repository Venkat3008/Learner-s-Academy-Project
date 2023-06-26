package entity;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import utility.HibernateUtil;

@Entity
@Table(name = "Classroom_Section")
public class Section {

	@Id
	@Column(name = "Section_Name")
	private String section;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "s")
	private List<Student> students = new ArrayList<>();

	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Subjects", 
				joinColumns = {@JoinColumn(name="Section_Name")},
				inverseJoinColumns = {@JoinColumn(name="Subject_Id")})
	private List<Subject> subjects;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Teachers", 
				joinColumns = {@JoinColumn(name="Section_Name")},
				inverseJoinColumns = {@JoinColumn(name="Teacher_Id")})
	private List<Teacher> teachers;
	
	
	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getStudents() {
		StringBuffer sb = new StringBuffer();

		if (students != null && students.size() > 0) {
			for (Student students : students) {
				sb.append(students.getStudent1() + ", " + students.getStudent2() + ", " + students.getStudent3() + ", "
						+ students.getStudent4() + ", " + students.getStudent5() + ", ");
			}
		}
		return sb.toString();
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getSubjects() {
		
		StringBuffer sb = new StringBuffer();
		
		if(subjects != null && subjects.size()>0)
		{
			for(Subject s: subjects)
			{
				sb.append(s.getSubject1()+", "+s.getSubject2()+", "+s.getSubject3());
			}
		}
		return sb.toString();
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public String getTeachers() {
		
		StringBuffer sb = new StringBuffer();
		
		if(teachers != null && teachers.size()>0)
		{
			for(Teacher t:teachers)
			{
				sb.append(t.getTeacher1()+", "+t.getTeacher2()+", "+t.getTeacher3());
			}
		}
		return sb.toString();
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	

//	public String printingStudents() throws IOException {
//		SessionFactory sf = HibernateUtil.buildSessionFactory();
//		Session session = sf.openSession();
//		List<Section> sections = session.createQuery(" from Section ").list();
//		
//		String p = null;
//		for(Section s:sections)
//		{
//			p = (s.getStudents()+"\n");
//		}
//		return p;
//		
//	}
	
}
