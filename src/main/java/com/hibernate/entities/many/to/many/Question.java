package com.hibernate.entities.many.to.many;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "qsn251")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qsnId;

	private String qsn;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "questions", fetch = FetchType.LAZY)
	private List<Answer> answers;

	
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public Question(int qsnId, String qsn, List<Answer> answers) {
		super();
		this.qsnId = qsnId;
		this.qsn = qsn;
		this.answers = answers;
	}

	public int getQsnId() {
		return qsnId;
	}

	public void setQsnId(int qsnId) {
		this.qsnId = qsnId;
	}

	public String getQsn() {
		return qsn;
	}

	public void setQsn(String qsn) {
		this.qsn = qsn;
	}

	public Question() {
		super();
	}

}
