<%@page import="model.ContextoNavegacion"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ModeloNavegacion"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Listar Contexto</title>
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
                    <h2 class="tm-section-title">Lista de Contextos</h2>
                    <br>
                </div>

                <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12 col-xl-12">

                    <table class="table">
                        <thead>
                            <tr>
                                <th>Id Contexto </th>
                                <th>Link</th>
                                <th>Nombre Contexto</th>
                                <th>Id Modelo Nav</th>
                            </tr>
                        </thead>
                        <tbody>

                            <%if (request.getAttribute("respuesta") != null) {

                                    ArrayList<ContextoNavegacion> array = (ArrayList<ContextoNavegacion>) request.getAttribute("respuesta");

                                    for (ContextoNavegacion contexto : array) {

                            %>

                            <tr>
                                <th scope="row"><%=contexto.getId_contexto()%></th>
                                 <th scope="row"><%=contexto.getLink()%></th>
                                <td><%=contexto.getNombre_contexto()%></td>
                                <td><%=contexto.getId_modelo()%></td>
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
