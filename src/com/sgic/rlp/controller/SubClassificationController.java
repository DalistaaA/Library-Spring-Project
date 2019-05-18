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

import com.sgic.rlp.models.SubClassification;
import com.sgic.rlp.service.SubClassificationService;
import com.sgic.rlp.serviceImpl.SubClassificationServiceImpl;

@WebServlet("/SubClassificationController")
public class SubClassificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SubClassificationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		SubClassificationService subClassificationService = ctx.getBean("subclassificationService",
				SubClassificationServiceImpl.class);

		response.setContentType("application/json");
		PrintWriter writter = response.getWriter();

		JsonObjectBuilder rootBuilder = Json.createObjectBuilder();
		JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
		JsonObjectBuilder planBuilder = Json.createObjectBuilder();

		for (SubClassification subClassification : subClassificationService.findAllSubClassificationInfo()) {
			JsonObject planJson = planBuilder.add("sub_classification_id", subClassification.getSubclassificationId())
					.add("sub_classification_name", subClassification.getSubclassificationName())
					.add("classification_id", subClassification.getClassificationId()).build();
			arrayBuilder.add(planJson);
		}
		JsonObject root = rootBuilder.add("subClassification", arrayBuilder).build();
		writter.print(root);
		writter.flush();
		writter.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Integer SubClassificationId = Integer.parseInt(request.getParameter("sub_classification_id"));
		String SubclassificationName = request.getParameter("sub_classification_name");
		Integer ClassificationId = Integer.parseInt(request.getParameter("classification_id"));

		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		SubClassificationService subclassificationService = ctx.getBean("subclassificationService",
				SubClassificationServiceImpl.class);

		SubClassification subClassification = new SubClassification();

		subClassification.setSubclassificationId(SubClassificationId);
		subClassification.setSubclassificationName(SubclassificationName);
		subClassification.setClassificationId(ClassificationId);

		subclassificationService.addSubClassification(subClassification);

//		response.getWriter().println("response");
		doGet(request, response);

	}

}
