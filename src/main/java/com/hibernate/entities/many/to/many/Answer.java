package com.hibernate.entities.many.to.many;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ans251")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansId;
	
	private String answerName;
	
	private String postedBy;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name = "qsnAns251", 
	joinColumns = {@JoinColumn(name = "ansId")},
	inverseJoinColumns = {@JoinColumn(name = "qsnId")}
	)
	private List<Question> questions;

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Answer(int ansId, String answerName, String postedBy, List<Question> questions) {
		super();
		this.ansId = ansId;
		this.answerName = answerName;
		this.postedBy = postedBy;
		this.questions = questions;
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
