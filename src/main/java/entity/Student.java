package entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Student_List")
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="Student_Id")
	private int id;
	
	@Column(name="Student_Name_1")
	private String student1;
	
	@Column(name="Student_Name_2")
	private String student2;
	
	@Column(name="Student_Name_3")
	private String student3;
	
	@Column(name="Student_Name_4")
	private String student4;
	
	@Column(name="Student_Name_5")
	private String student5;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Section_Id")
	private Section s;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudent1() {
		return student1;
	}

	public void setStudent1(String student1) {
		this.student1 = student1;
	}

	public String getStudent2() {
		return student2;
	}

	public void setStudent2(String student2) {
		this.student2 = student2;
	}

	public String getStudent3() {
		return student3;
	}

	public void setStudent3(String student3) {
		this.student3 = student3;
	}	
	
	public String getStudent4() {
		return student4;
	}

	public void setStudent4(String student4) {
		this.student4 = student4;
	}

	public String getStudent5() {
		return student5;
	}

	public void setStudent5(String student5) {
		this.student5 = student5;
	}

	public Section getS() {
		return s;
	}

	public void setS(Section s) {
		this.s = s;
	}
	
	
	
}
