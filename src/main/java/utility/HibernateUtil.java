package utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Section;
import entity.Student;
import entity.Subject;
import entity.Teacher;

public class HibernateUtil {

	static SessionFactory sessionFactory = null;

	public static SessionFactory buildSessionFactory() {

		if (sessionFactory != null) {
			return sessionFactory;
		}

		// STEP 1: Create Configuration Object
		Configuration cfg = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Section.class)
				.addAnnotatedClass(Student.class).addAnnotatedClass(Subject.class).addAnnotatedClass(Teacher.class);

		sessionFactory = cfg.buildSessionFactory();

		return sessionFactory;
	}
}
