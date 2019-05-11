package com.sgic.rlp.test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sgic.rlp.models.Author;
import com.sgic.rlp.models.Classification;
import com.sgic.rlp.service.AuthorService;
import com.sgic.rlp.service.ClassificationService;
import com.sgic.rlp.serviceImpl.AuthorServiceImpl;
import com.sgic.rlp.serviceImpl.ClassificationServiceImpl;

//import com.sgic.rlp.models.Classification;
//import com.sgic.rlp.service.ClassificationService;
//import com.sgic.rlp.serviceImpl.ClassificationServiceImpl;


public class Test {

	public static void main(String[] args) {
		
		//Start Add Classification		
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
//		
//		ClassificationService classificationService = ctx.getBean("classificationService", ClassificationServiceImpl.class);
//		
//		Classification classification = new Classification();
//		classification.setClassificationId(4);
//		classification.setClassificationName("Tamil");
//		
//		classificationService.addClassification(classification);
//		
//		ctx.close();
		//End Add Classification	
		
		//Start Add Author			
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
//		
//		AuthorService authorService = ctx.getBean("authorService", AuthorServiceImpl.class);
//		
//		Author author = new Author();
//		author.setAuthorId(1);
//		author.setAuthorName("Mr.S.Kunaseelan");
//		
//		authorService.addAuthor(author);
//		
//		ctx.close();		
//		//End Add Author
		
		//Start Add Book			
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
//		
//		AuthorService authorService = ctx.getBean("authorService", AuthorServiceImpl.class);
//		
//		Author author = new Author();
//		author.setAuthorId(1);
//		author.setAuthorName("Mr.S.Kunaseelan");
//		
//		authorService.addAuthor(author);
//		
//		ctx.close();		
//		//End Add Book
		
		//Start List of Classification
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
//	
//		ClassificationService classificationService = ctx.getBean("classificationService", ClassificationServiceImpl.class);
//		
//		for(Classification classification : classificationService.findAllClassificationInfo()) {
//			System.out.println(classification.getClassificationId()+" "+classification.getClassificationName());
//		}
		//End List of Classification
		
		//Start List of ClassificationByID
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
//	
//		ClassificationService classificationService = ctx.getBean("classificationService", ClassificationServiceImpl.class);
//		
//		for(Classification classification : classificationService.fetchClassificationByID(1)) {
//			System.out.println(classification.getClassificationId()+" "+classification.getClassificationName());
//		}
		//End List of ClassificationByID
		
	}

}
