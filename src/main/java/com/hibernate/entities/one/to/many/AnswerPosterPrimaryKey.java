package com.hibernate.entities.one.to.many;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class AnswerPosterPrimaryKey {
	
	@Column(name = "ANSWER_ID")
	private long answerId;
	
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "POSTED_ID")
	private Poster poster;
	
	public long getAnswerId() {
		return answerId;
	}

	public void setAnswerId(long answerId) {
		this.answerId = answerId;
	}

	public Poster getPoster() {
		return poster;
	}

	public void setPoster(Poster poster) {
		this.poster = poster;
	}

	
	public AnswerPosterPrimaryKey() {
		super();
	}

	public AnswerPosterPrimaryKey(long answerId, Poster poster) {
		super();
		this.answerId = answerId;
		this.poster = poster;
	}
	
	
}
