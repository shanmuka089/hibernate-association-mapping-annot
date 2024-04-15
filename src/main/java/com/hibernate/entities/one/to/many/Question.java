package com.hibernate.entities.one.to.many;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "qsn231")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID")
	private int qsnId;

	@Column(name = "QUESTION")
	private String qsn;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "question")
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
