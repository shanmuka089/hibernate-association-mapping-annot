package com.hibernate.entities.one.to.many;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "ans231")
@Entity
public class Answer {

	@EmbeddedId
	private AnswerPosterPrimaryKey answerPosterPrimaryKey;

	@Column(name = "ANSWER_NAME")
	private String answerName;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID")
	private Question question;

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public AnswerPosterPrimaryKey getAnswerPosterPrimaryKey() {
		return answerPosterPrimaryKey;
	}

	public void setAnswerPosterPrimaryKey(AnswerPosterPrimaryKey answerPosterPrimaryKey) {
		this.answerPosterPrimaryKey = answerPosterPrimaryKey;
	}

	public String getAnswerName() {
		return answerName;
	}

	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}

	public Answer(AnswerPosterPrimaryKey answerPosterPrimaryKey, String answerName, Question question) {
		super();
		this.answerPosterPrimaryKey = answerPosterPrimaryKey;
		this.answerName = answerName;
		this.question = question;
	}

	public Answer() {
		super();
	}
}
