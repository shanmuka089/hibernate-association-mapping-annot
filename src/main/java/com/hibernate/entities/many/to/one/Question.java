package com.hibernate.entities.many.to.one;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "qsn241")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int qsnId;

	private String qsn;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ansId", referencedColumnName = "ansId")
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
