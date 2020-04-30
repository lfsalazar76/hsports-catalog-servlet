package com.lfsalazar.servlet;

import java.io.PrintWriter;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CatalogServlet
 */
@WebServlet(urlPatterns="/CatalogServlet") /*, asyncSupported=true)*/
public class CatalogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CatalogServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append(request.getParameter("name"));
		/* TODO Auto-generated method stub
		   response.getWriter().append("Served at: ").append(request.getContextPath());*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name = request.getParameter("name");
		String manufacturer = request.getParameter("manufacturer");
		String sku = request.getParameter("sku");
		
		response.setHeader("SomeHeader", "SomeHeaderValue");
		response.addCookie(new Cookie("someCookie","someCookieValue"));
		
		Catalog.addItem(new CatalogItem(name,manufacturer,sku));
		
		request.setAttribute("items", Catalog.getItems());
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		dispatcher.forward(request, response);
		
		/*AsyncContext asyncContext = request.startAsync();
		
		asyncContext.start(new Runnable() {
			
			@Override
			public void run() {
				try
				{
					Thread.sleep(5000);
					System.out.println("print the response...");
					System.out.println("Response returned by: "+Thread.currentThread().getName());
					returnResponse(request, response);
					asyncContext.complete();
				}
				catch (InterruptedException e) {
					e.printStackTrace();
				}
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		
		System.out.println("Initial Request "+Thread.currentThread().getName());*/
		
		/* TODO Auto-generated method stub
		doGet(request, response);*/
	}

	/*
	private void returnResponse(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		
		
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head></head>");
		out.println("<body>");
		out.println("<table>");
		for (CatalogItem item: Catalog.getItems()) {
			out.println("<tr>");
			out.println("<td>");
			out.println(item.getName());
			out.println("</td>");
			out.println("<td>");
			out.println(item.getManufacturer());
			out.println("</td>");
			out.println("<td>");
			out.println(item.getSku());
			out.println("</td>");
			out.println("</tr>");
		}//for
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
	*/
	

}
