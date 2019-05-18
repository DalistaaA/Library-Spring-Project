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

import com.sgic.rlp.models.Author;
import com.sgic.rlp.models.Classification;
import com.sgic.rlp.service.AuthorService;
import com.sgic.rlp.serviceImpl.AuthorServiceImpl;


@WebServlet("/AuthorController")
public class AuthorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AuthorController() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		AuthorService authorService = ctx.getBean("authorService", AuthorServiceImpl.class);
		
		response.setContentType("application/json");
		PrintWriter writter = response.getWriter();

		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder planBuilder = Json.createObjectBuilder();

		for (Author author:authorService.findAllAuthorsInfo()) {
			JsonObject planJson = planBuilder.add("author_id",author.getAuthorId())
					.add("author_name",author.getAuthorName()).build();

			arrayBuilder.add(planJson);
		}
		
		JsonObject root = rootBuilder.add("author", arrayBuilder).build();
		writter.print(root);
		writter.flush();
		writter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Integer AuthorId = Integer.parseInt(request.getParameter("author_id"));
		String AuthorName = request.getParameter("author_name");
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		AuthorService authorService = ctx.getBean("authorService", AuthorServiceImpl.class);
		
		Author author = new Author();
		
		author.setAuthorId(AuthorId);
		author.setAuthorName(AuthorName);
		
		authorService.addAuthor(author);
		
		doGet(request, response);
	}

}
