<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.LinkedHashMap, java.util.Iterator"%>
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

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="PasaAtributoAJSP" method="post">
  <label for="pais">País</label><%=salida %>
  <input type="submit" value="Enviar" />
</form>

</body>
</html>