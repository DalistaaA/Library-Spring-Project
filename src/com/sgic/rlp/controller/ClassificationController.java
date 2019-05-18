package com.sgic.rlp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

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

import com.sgic.rlp.dao.ClassificationDao;
import com.sgic.rlp.models.Classification;
import com.sgic.rlp.service.ClassificationService;
import com.sgic.rlp.serviceImpl.ClassificationServiceImpl;

@WebServlet("/ClassificationController")
public class ClassificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ClassificationController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		ClassificationService classificationService = ctx.getBean("classificationService",
				ClassificationServiceImpl.class);

		response.setContentType("application/json");
		PrintWriter writter = response.getWriter();

		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder planBuilder = Json.createObjectBuilder();

		for (Classification classification : classificationService.findAllClassificationInfo()) {
			JsonObject planJson = planBuilder.add("classification_id", classification.getClassificationId())
					.add("classification_name", classification.getClassificationName()).build();

			arrayBuilder.add(planJson);
		}
		
		JsonObject root = rootBuilder.add("classification", arrayBuilder).build();
		writter.print(root);
		writter.flush();
		writter.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer ClassificationId = Integer.parseInt(request.getParameter("classification_id"));
//		int cid = Integer.parseInt(ClassificationId);
		String ClassificationName = request.getParameter("classification_name");

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		ClassificationService classificationService = ctx.getBean("classificationService",
				ClassificationServiceImpl.class);

		Classification classification = new Classification();

		classification.setClassificationId(ClassificationId);
		classification.setClassificationName(ClassificationName);

		classificationService.addClassification(classification);

		doGet(request, response);

	}

}
