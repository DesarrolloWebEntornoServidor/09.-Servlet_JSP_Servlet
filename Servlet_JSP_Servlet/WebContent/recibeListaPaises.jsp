<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.LinkedHashMap, java.util.Iterator"%>
<%

  LinkedHashMap<String,String> arrayPaises = new LinkedHashMap<String,String>();  
  arrayPaises= (LinkedHashMap<String,String>) request.getAttribute("listaPaises");

  String salida = "";
  salida += "<select name=\"pais\">" + "\n";
  Iterator<String> iteradorConjuntoClaves = arrayPaises.keySet().iterator();
  while (iteradorConjuntoClaves.hasNext()) {
  	String clave = iteradorConjuntoClaves.next();
	String valor = arrayPaises.get(clave);
	salida += "  <option value=\"" + clave + "\">" + valor + "</option>" + "\n";
  }
  salida += "</select>" + "\n";	
%>

<!DOCTYPE html">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>Insert title here</title>
	</head>
	<body>
	
		<form action="PasaAtributoAJSP" method="post">
		  <label for="pais">País</label><%=salida %>
		  <input type="submit" value="Enviar" />
		</form>
	
	</body>
</html>