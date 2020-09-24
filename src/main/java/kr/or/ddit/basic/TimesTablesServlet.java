package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter writer = resp.getWriter();
		
		//writer.println("<html>");
		//writer.println("<head></head>");
		writer.println("<style> td{ border:1px solid black; padding: 10px;} </style>");
		//writer.println("<body>");
		writer.println("	<table>");

		for (int i = 1; i < 10; i++) {
			writer.println("	<tr>");
			
			for (int j = 2; j < 10; j++) {
				writer.println("	<td>"+ j + " * "+ i +" = " + i*j +"</td>");
			}
			writer.println("	</tr>");
		}
		
		writer.println("	</table>");
		//writer.println("</body>");
		//writer.println("</html>");
		//writer.flush();
		//writer.close();
	
	
	}
	
}
