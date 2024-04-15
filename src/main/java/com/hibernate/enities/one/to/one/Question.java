package com.hibernate.enities.one.to.one;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "qsn221")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qsnId;

	private String qsn;

	@OneToOne(mappedBy = "question", cascade = CascadeType.ALL)
	private Answer answer;

	public Question(int qsnId, String qsn, Answer answer) {
	super();
	this.qsnId = qsnId;
	this.qsn = qsn;
	this.answer = answer;
}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
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
