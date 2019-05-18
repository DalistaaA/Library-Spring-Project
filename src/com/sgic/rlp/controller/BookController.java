package com.sgic.rlp.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sgic.rlp.models.Book;
import com.sgic.rlp.models.Classification;
import com.sgic.rlp.service.BookService;
import com.sgic.rlp.service.ClassificationService;
import com.sgic.rlp.serviceImpl.BookServiceImpl;
import com.sgic.rlp.serviceImpl.ClassificationServiceImpl;

@WebServlet("/BookController")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		BookService bookService = ctx.getBean("bookService", BookServiceImpl.class);

		response.setContentType("application/json");
		PrintWriter writter = response.getWriter();

		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder planBuilder = Json.createObjectBuilder();

		for (Book book : bookService.findAllBooksInfo()) {
			JsonObject planJson = planBuilder.add("book_id", book.getBookId())
					.add("book_name", book.getBookName())
					.add("published_date", book.getPublishedDate())
					.add("sub_classification_id", book.getSubClassificationId()).build();

			arrayBuilder.add(planJson);
		}

		JsonObject root = rootBuilder.add("book", arrayBuilder).build();
		writter.print(root);
		writter.flush();
		writter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer BookId = Integer.parseInt(request.getParameter("book_id"));
		String BookName = request.getParameter("book_name");
		String PublishedDate = request.getParameter("published_date");
		Integer SubClassificationId = Integer.parseInt(request.getParameter("subclassification_id"));

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
