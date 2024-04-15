package com.hibernate.entities.one.to.many;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "poster231")
public class Poster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "POSTED_ID")
	private int postedId;

	@Column(name = "POSTER_NAME")
	private String posterName;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "answerPosterPrimaryKey.poster")
	private Answer answer;
	
	

	public Poster(int postedId, String posterName, Answer answer) {
		super();
		this.postedId = postedId;
		this.posterName = posterName;
		this.answer = answer;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	public int getPostedId() {
		return postedId;
	}

	public void setPostedId(int postedId) {
		this.postedId = postedId;
	}

	public String getPosterName() {
		return posterName;
	}

	public void setPosterName(String posterName) {
		this.posterName = posterName;
	}

	public Poster() {
		super();
	}
}
