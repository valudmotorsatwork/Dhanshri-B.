<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="styles/kendo.common.min.css" rel="stylesheet" type="text/css" />
 <link href="styles/kendo.default.min.css" rel="stylesheet" type="text/css" />
 <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
 <script src="js/jquery.min.js"></script>
 <script src="js/kendo.all.min.js"></script>
 <title>Index Page</title>
</head>

<body>
<form action="CityServlet" method="post">
<kendo:grid name="Grid" pageable="true" resizable="true">

<kendo:grid-editable mode="popup" confirmation="Are You Sure You Want To Delete Record?"/>
<kendo:grid-toolbar>
<kendo:grid-toolbarItem name="create"></kendo:grid-toolbarItem>
</kendo:grid-toolbar>
<kendo:dataSource pageSize="5">
<kendo:dataSource-transport>
<kendo:dataSource-transport-read url="CityServlet"/>
<kendo:dataSource-transport-update url="CityServlet?update" type="POST"/>
<kendo:dataSource-transport-create url="CityServlet?create" type="POST"/>
<kendo:dataSource-transport-destroy url="CityServlet?destroy" type="POST"/>
</kendo:dataSource-transport>

<kendo:dataSource-schema >
<kendo:dataSource-schema-model id="id">
<kendo:dataSource-schema-model-fields>
<kendo:dataSource-schema-model-field name="name">
<kendo:dataSource-schema-model-field-validation required="true"/>
</kendo:dataSource-schema-model-field>
<kendo:dataSource-schema-model-field name="countryCode" >
<kendo:dataSource-schema-model-field-validation required="true"/>
</kendo:dataSource-schema-model-field>
<kendo:dataSource-schema-model-field name="district">
<kendo:dataSource-schema-model-field-validation required="true"/>
</kendo:dataSource-schema-model-field>
<kendo:dataSource-schema-model-field name="population" type="number">
<kendo:dataSource-schema-model-field-validation required="true" min="1"/>
</kendo:dataSource-schema-model-field>
</kendo:dataSource-schema-model-fields>
</kendo:dataSource-schema-model>
</kendo:dataSource-schema>
</kendo:dataSource>

<kendo:grid-columns>
<kendo:grid-column title="Name" field="name"></kendo:grid-column>
<kendo:grid-column title="CountryCode" field="countryCode"></kendo:grid-column>
<kendo:grid-column title="District" field="district"></kendo:grid-column>
<kendo:grid-column title="Population" field="population"></kendo:grid-column>
<kendo:grid-column>
<kendo:grid-column-command>
<kendo:grid-column-commandItem name="edit"/>
<kendo:grid-column-commandItem name="destroy"/>
</kendo:grid-column-command>
</kendo:grid-column>
</kendo:grid-columns>

</kendo:grid>
</form>
</body>
</html>