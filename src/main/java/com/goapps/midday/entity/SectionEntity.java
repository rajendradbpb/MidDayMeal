package com.goapps.midday.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "section")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SectionEntity {

	@Id
	@Column(name = "sectionId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String sectionName;
	
	@Column(nullable = false)
	private long classId;
	

	@Column(nullable = false)
	private long classTeacherId;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getSectionName() {
		return sectionName;
	}


	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}


	public long getClassId() {
		return classId;
	}


	public void setClassId(long classId) {
		this.classId = classId;
	}


	public long getClassTeacherId() {
		return classTeacherId;
	}


	public void setClassTeacherId(long classTeacherId) {
		this.classTeacherId = classTeacherId;
	}
	
	
	
}
