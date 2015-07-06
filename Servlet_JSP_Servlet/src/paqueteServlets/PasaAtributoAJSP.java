package paqueteServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PasaAtributoAJSP")
public class PasaAtributoAJSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String,String> arrayPaises = new LinkedHashMap<String,String>() {{
		put("ES", "España");
		put("FR", "Francia");
		put("IT", "Italia");
		put("PT", "Portugal");		

	}}; 
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("listaPaises", arrayPaises);
    	String vista = "/recibeListaPaises.jsp";
    	RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(vista);
        dispatcher.forward(request, response); 
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String siglaPais= request.getParameter("pais");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Se recibió la sigla de país: " + siglaPais + "<br />");
		out.println("Correspondiente a : " + arrayPaises.get(siglaPais) + "<br />");
	}

}
