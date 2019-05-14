package com.sgic.rlp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sgic.rlp.models.Book;
import com.sgic.rlp.service.BookService;
import com.sgic.rlp.serviceImpl.BookServiceImpl;



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
		Integer BookId = Integer.parseInt(request.getParameter("book_id"));
		String BookName = request.getParameter("book_name");
		String PublishedDate = request.getParameter("published_date");
		String SubClassificationId = request.getParameter("subclassification_id");
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		BookService bookService = ctx.getBean("bookService", BookServiceImpl.class);
		
		Book book = new Book();
		
		book.setBookId(BookId);
		book.setBookName(BookName);
		book.setPublishedDate(PublishedDate);
		book.setSubClassificationId(SubClassificationId);
		
		bookService.addBook(book);
		doGet(request, response);
	}

}
