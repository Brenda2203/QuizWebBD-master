<%-- 
    Document   : esquema
    Created on : Oct 16, 2017, 11:47:54 AM
    Author     : FiJus
--%>

<%@page import="java.util.List"%>
<%@page import="model.Esquema"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
        <title>Esquema</title>
    </head>
    <body>
        <table border=1>
            <thead>
                <tr>
                    <th>Esquema Id</th>
                    <th>Nombre Esquema</th>
                    <th colspan=2>Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Esquema> esquemas = (List<Esquema>) request.getAttribute("esquemas");
                    if (esquemas != null) {
                        for (Esquema e : esquemas) {
                %>
                <tr>
                    <td><%=e.getId_esquema()%></td>
                    <td><%=e.getNombre_esquema()%></td>

                    <td><a href="Esquema?action=edit&esquemaId=<%=e.getId_esquema()%>">Update</a></td>
                    <td><a href="Esquema?action=delete&esquemaId=<%=e.getId_esquema()%>">Delete</a></td>
                </tr>

                <%
                        }

                    }

                %>

            </tbody>
        </table>
        <p><a href="UserController?action=insert">Add User</a></p>
    </body>
</html>
