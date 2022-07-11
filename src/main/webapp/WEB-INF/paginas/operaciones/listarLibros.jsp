<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="es_AR"/>
<section id="libros">
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Libros</h4>
                    </div>
                    <table class="table table-striped table-dark">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Autor</th>
                                <th>Cantidad de Paginas</th>
                                <th>Precio</th>
                                <th>Copias</th>
                                <th>Accion</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="libro" items="${pepe}">
                                <tr>
                                    <td>${libro.idLibros}</td>
                                    <td>${libro.nombre}</td>
                                    <td>${libro.autor}</td>
                                    <td>${libro.cantPaginas}</td>
                                    <td><fmt:formatNumber value="${libro.precio}" type="currency"/></td>
                                    <td>${libro.copias}</td>
                                    <!-- COMPLETAR HREF CUANDO ESTE TERMINADO JSP EDITAR -->
                                    <td>
                                        <a href="${pageContext.request.contextPath}/servletControlador?accion=editar&idLibro=${libro.idLibros}" 
                                           class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i>
                                            Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-4">
                <div class="card text-center bg-danger text-white mb-3">
                    <div class="card-body">
                        <h3>Cantidad de libros</h3>
                        <h4 class="display-4">
                            ${cantidadLibros}
                        </h4>
                    </div>
                </div>
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Precio Total de libros</h3>
                        <h4 class="display-4">
                            <i class="fas fa-book-dead"></i>
                            <fmt:formatNumber value="${precioTotal}" type="currency"/>
                        </h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<jsp:include page="/WEB-INF/paginas/operaciones/agregarLibros.jsp"/>