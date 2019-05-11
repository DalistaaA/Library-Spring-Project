package com.sgic.rlp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public BookController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		Integer AuthorId = Integer.parseInt(request.getParameter("author_id"));
//		String AuthorName = request.getParameter("author_name");
//		
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
//		AuthorService authorService = ctx.getBean("authorService", AuthorServiceImpl.class);
//		
//		Author author = new Author();
//		
//		author.setAuthorId(AuthorId);
//		author.setAuthorName(AuthorName);
//		
//		authorService.addAuthor(author);
		doGet(request, response);
	}

}
