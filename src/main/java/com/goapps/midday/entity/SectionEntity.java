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
@Table(name = "class")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SectionEntity {

	@Id
	@Column(name = "iIdSection")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String sectionName;
	
	@Column(nullable = false)
	private long classId;
}