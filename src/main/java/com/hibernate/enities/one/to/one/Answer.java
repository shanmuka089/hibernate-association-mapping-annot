package com.hibernate.enities.one.to.one;

import jakarta.persistence.CascadeType;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ans221")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansId;
	
	private String answerName;
	
	private String postedBy;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "qsnId", referencedColumnName = "qsnId")
	private Question question;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer(int ansId, String answerName, String postedBy, Question question) {
		super();
		this.ansId = ansId;
		this.answerName = answerName;
		this.postedBy = postedBy;
		this.question = question;
	}

	public int getAnsId() {
		return ansId;
	}

	public void setAnsId(int ansId) {
		this.ansId = ansId;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Answer(int ansId, String answerName, String postedBy) {
		super();
		this.ansId = ansId;
		this.answerName = answerName;
		this.postedBy = postedBy;
	}

	public Answer() {
		super();
	}
	

}
