<%@page import="model.Columna"%>
<%@page import="model.Tabla"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Esquema"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Listar Columnas</title>
        <!--
        Ocean Theme
        http://www.templatemo.com/tm-484-ocean
        -->

        <!-- load stylesheets -->

        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400"><!-- Google web font "Open Sans", https://www.google.com/fonts/specimen/Open+Sans -->
        <link rel="stylesheet" href="font-awesome-4.5.0/css/font-awesome.min.css"> <!-- Font Awesome, https://fortawesome.github.io/Font-Awesome/ -->
        <link rel="stylesheet" href="css/bootstrap.min.css">                       <!-- Bootstrap style, http://v4-alpha.getbootstrap.com/ -->
        <link rel="stylesheet" href="css/templatemo-style.css">                    <!-- Templatemo style -->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
          <![endif]-->
    </head>

    <body>

        <!-- About -->
        <div class="row tm-section tm-blue-bg-row">

            <section>

                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12 text-xs-center">
                    <h2 class="tm-section-title">Lista de Columnas</h2>
                    <br>
                </div>

                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Id Columna </th>
                                <th>Nombre Columna</th>
                                <th>Tipo de Dato</th>
                                <th>Id Tabla</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%if (request.getAttribute("respuesta") != null) {

                                    ArrayList<Columna> array = (ArrayList<Columna>) request.getAttribute("respuesta");

                                    for (Columna columna : array) {

                            %>

                            <tr>
                                <th scope="row"><%=columna.getId_columna()%></th>
                                <td><%=columna.getNombre_columna()%></td>
                                <td><%=columna.getData_type()%></td>
                                <td><%=columna.getId_tabla()%></td>
                            </tr>

                            <%      }
                                }
                            %>

                        </tbody>
                    </table>

                </div>

            </section>
            <p align="center"><a class="btn btn-primary btn-lg" href="menu.html" role="button">Volver</a></p>
        </div> 

    </body>
</html>
