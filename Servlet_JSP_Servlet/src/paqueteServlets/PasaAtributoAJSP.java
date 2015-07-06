package paqueteServlets;

import java.io.IOException;
import java.io.PrintWriter;
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
	private static final String ATRIBUTO_LISTA_PAISES = "listaPaises";
	private static final String VISTA = "/recibeListaPaises.jsp";
	private static final long serialVersionUID = 1L;
	private Map<String, String> arrayPaises;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) {

		iniciarPaises();

		request.setAttribute(ATRIBUTO_LISTA_PAISES, arrayPaises);
		String vista = VISTA;
		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher(vista);
		try {
			dispatcher.forward(request, response);
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	private void iniciarPaises() {
		arrayPaises = new LinkedHashMap<String, String>() {

			private static final long serialVersionUID = 1L;

			{
				put("ES", "Espa�a");
				put("FR", "Francia");
				put("IT", "Italia");
				put("PT", "Portugal");

			}
		};

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) {
		//TODO: Redirigir a una p�gina con la informaci�n de que todo ha ido bien 
		String siglaPais = request.getParameter("pais");
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {
			out.println("Se recibi� la sigla de pa�s: " + siglaPais + "<br />");
			out.println("Correspondiente a : " + arrayPaises.get(siglaPais)
					+ "<br />");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
