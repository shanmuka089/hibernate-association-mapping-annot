package com.hibernate;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.hibernate.entities.one.to.many.Answer;
import com.hibernate.entities.one.to.many.AnswerPosterPrimaryKey;
import com.hibernate.entities.one.to.many.Poster;
import com.hibernate.entities.one.to.many.Question;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure("hibernate-cfg.xml").build();
        
        Metadata metadata = new MetadataSources(registry).buildMetadata();
        
        SessionFactory sessionFactory = metadata.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction transaction = session.beginTransaction();
        
        Question question = new Question();

		question.setQsn("What is Java?");

		Answer answer = new Answer();

		answer.setAnswerName("Java is a object oriented programming language.");

		Poster poster = new Poster();
		poster.setPosterName("Shanu");
//		poster.setAnswer(answer);
		session.save(poster);
		
		AnswerPosterPrimaryKey answerPosterPrimaryKey = new AnswerPosterPrimaryKey();
		answerPosterPrimaryKey.setAnswerId(1);
		answerPosterPrimaryKey.setPoster(poster);
		
		
		answer.setAnswerPosterPrimaryKey(answerPosterPrimaryKey);
		
		answer.setQuestion(question);
		
		Answer answer2 = new Answer();
		answer2.setAnswerName("Java is a high level language.");
		
		Poster poster2 = new Poster();
		poster2.setPosterName("Vedha");
//		poster2.setAnswer(answer2);
		session.save(poster2);
		
		AnswerPosterPrimaryKey answerPosterPrimaryKey2 = new AnswerPosterPrimaryKey();
		answerPosterPrimaryKey2.setAnswerId(2);
		answerPosterPrimaryKey2.setPoster(poster2);
		
		answer2.setAnswerPosterPrimaryKey(answerPosterPrimaryKey2);
		
		answer2.setQuestion(question);
		
		List<Answer> answers = Arrays.asList(answer, answer2);
		question.setAnswers(answers);
		
		
		session.saveOrUpdate(question);
		
		transaction.commit();
		
		sessionFactory.close();
		
		session.close();
    }
}
