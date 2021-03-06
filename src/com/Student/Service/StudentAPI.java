package com.Student.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Student.Service.student;

/**
 * Servlet implementation class StudentAPI
 */
@WebServlet("/StudentAPI")
public class StudentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	student studentObj = new student();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = studentObj.insertStudents(
				request.getParameter("StudentName"),
				request.getParameter("Sex"),
				request.getParameter("Age"),
				request.getParameter("Address"),
				request.getParameter("PhoneNo"),
				request.getParameter("BirthDate"),
				request.getParameter("Email"));
		response.getWriter().write(output);	
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

 Map paras = getParasMap(request);
		
		String output = studentObj.updateStudents(
				paras.get("hidStudentIDSave").toString(),
				paras.get("StudentName").toString(),
				paras.get("Sex").toString(),
				paras.get("Age").toString(),
				paras.get("Address").toString(),
				paras.get("PhoneNo").toString(),
				paras.get("BirthDate").toString(),
				paras.get("Email").toString());
		response.getWriter().write(output);
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub)
	Map paras = getParasMap(request);
	String output= studentObj.deleteStudents(paras.get("StudentID").toString());
	response.getWriter().write(output);
	
	
	}
	
	private static Map getParasMap(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			scanner.close();
			String[] params = queryString.split("&");
			for (String param : params) {

				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
		}
		return map;
	}

}
