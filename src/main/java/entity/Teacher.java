package entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Teacher_List")
public class Teacher {
	
	@Id
	@GeneratedValue
	@Column(name="Teacher_Id")
	private int id;
	
	@Column(name="Teacher_Name_1")
	private String teacher1;
		
	@Column(name="Teacher_Name_2")
	private String teacher2;
	
	@Column(name="Teacher_Name_3")
	private String teacher3;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "subjects")
	private List<Section> sections;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTeacher1() {
		return teacher1;
	}


	public void setTeacher1(String teacher1) {
		this.teacher1 = teacher1;
	}


	public String getTeacher2() {
		return teacher2;
	}


	public void setTeacher2(String teacher2) {
		this.teacher2 = teacher2;
	}


	public String getTeacher3() {
		return teacher3;
	}


	public void setTeacher3(String teacher3) {
		this.teacher3 = teacher3;
	}


	public List<Section> getSections() {
		return sections;
	}


	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	
	
	
}
