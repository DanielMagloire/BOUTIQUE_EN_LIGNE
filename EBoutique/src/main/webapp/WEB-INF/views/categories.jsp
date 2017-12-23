<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/style.css">
</head>
<div id="formCat" class="cadre">
	<f:form modelAttribute="Categorie" action="saveCat" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>ID Catégorie</td>
				<%-- <td>${categorie.idCategorie}<f:input type="hidden" path="idcategorie" /></td> --%>
				<td><f:input path="idcategorie" /></td>
				<td><f:errors path="idcategorie" cssClass="error"></f:errors></td>
			</tr>
			<tr>
				<td>Nom Catégorie</td>
				<td><f:input path="nomcategorie" /></td>
				<td><f:errors path="nomcategorie"></f:errors></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><f:textarea path="description" /></td>
				<td><f:errors path="description" cssClass="error"></f:errors></td>
			</tr>
			<tr>
				<td>Photo</td>
				<%-- <c:if test="${categorie.idCategorie!=null}">
					<td><img src="photoCat?idCat=${categorie.idCategorie}"></td>
				</c:if> --%>
				<td><input type="file" name="file"></td>
				<td></td>
			</tr>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
		</table>
	</f:form>
</div>
<div id="">
	<!-- Afficher les catégories -->
	<table>
		<tr>
			<th>ID</th><th>NOM CATEGORIE</th><th>DESCRIPTION</th><th>PHOTO</th>
		</tr>
		<c:forEach items="${categories}" var="cat">
			<tr>
				<td>${cat.idCategorie}</td>
				<td>${cat.nomCategorie}</td>
				<td>${cat.description}</td>
				<td></td>
				<%-- <td><img src="photoCat?idCat=${cat.idCategorie}"></td>
				<td><a href="suppCat?idCat=${cat.idCategorie}">Supprimer</a></td>
				<td><a href="editCat?idCat=${cat.idCategorie}">Edit</a></td> --%>
			</tr>
		</c:forEach>
	</table>
</div>
