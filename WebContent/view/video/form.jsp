<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Aplicación Gestión de Videos</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	 <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: tomato">
                    <div>
                        <a href="#" class="navbar-brand"> Gestión de Videos </a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/video/list" class="nav-link">Videos</a></li>
                    </ul>
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">

                        <c:if test="${object != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${object == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${object != null}">
                                    Editar Video
                                </c:if>
                                <c:if test="${object == null}">
                                    Agregar Video
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${object != null}">
                            <input type="hidden" name="id" value="<c:out value='${object.id}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Nombre de Video</label> <input type="text" value="<c:out value='${object.nombre}' />" class="form-control" name="nombre" required="required">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Descripcion de Video</label> <input type="text" value="<c:out value='${object.descripcion}' />" class="form-control" name="descripcion">
                        </fieldset>

                        <fieldset class="form-group">
                            <label>Enlace de Video</label> <input type="text" value="<c:out value='${object.enlace}' />" class="form-control" name="enlace">
                        </fieldset>

                        <button type="submit" class="btn btn-success">Guardar</button>
                        </form>
                    </div>
                </div>
            </div>
</body>
</html>