package com.sgic.rlp.controller;

import java.io.IOException;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer SubClassificationId = Integer.parseInt(request.getParameter("sub_classification_id"));
		String SubclassificationName = request.getParameter("sub_classification_name");
		String ClassificationId = request.getParameter("classification_id");
		
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("Beans.xml");
		SubClassificationService subclassificationService = ctx.getBean("subclassificationService", SubClassificationServiceImpl.class);
		
		SubClassification subClassification = new SubClassification();
		
		subClassification.setSubclassificationId(SubClassificationId);
		subClassification.setSubclassificationName(SubclassificationName);
		subClassification.setClassificationId(ClassificationId);
		
		subclassificationService.addSubClassification(subClassification);
		doGet(request, response);
	}

}
