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
@Table(name="Subject_List")
public class Subject {
	
	@Id
	@GeneratedValue
	@Column(name="Subject_Id")
	private int id;
		
	@Column(name="Subject_Name_1")
	private String subject1;
	
	@Column(name="Subject_Name_2")
	private String subject2;
	
	@Column(name="Subject_Name_3")
	private String subject3;
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "subjects")
	private List<Section> sections;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject1() {
		return subject1;
	}

	public void setSubject1(String subject1) {
		this.subject1 = subject1;
	}

	public String getSubject2() {
		return subject2;
	}

	public void setSubject2(String subject2) {
		this.subject2 = subject2;
	}

	public String getSubject3() {
		return subject3;
	}

	public void setSubject3(String subject3) {
		this.subject3 = subject3;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

	
	
}
