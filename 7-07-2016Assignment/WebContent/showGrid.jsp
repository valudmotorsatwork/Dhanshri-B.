<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="models.City"
	import="models.CountryLanguage"%>

<%@taglib prefix="kendo" uri="http://www.kendoui.com/jsp/tags"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Kendo Jdbc</title>
<link href="styles/kendo.common.min.css" rel="stylesheet">
<link href="styles/kendo.default.min.css" rel="stylesheet">

<script src="js/jquery.min.js"></script>
<script src="js/kendo.all.min.js"></script>
</head>
<body>
	<h3>Country Table</h3>
	<div class="container">
		<div class="row">
			<div class="span12">
				<kendo:grid name="CreateRequest" pageable="true" resizable="true">
					<kendo:grid-editable mode="popup"
						confirmation="Are you sure you want to delete the record??" />
					<kendo:grid-pageable pageSizes="true" refresh="true"
						buttonCount="3" />
					<kendo:grid-toolbar>
						<kendo:grid-toolbarItem name="create" />
					</kendo:grid-toolbar>
					<kendo:dataSource pageSize="5">
						<kendo:dataSource-transport>
							<kendo:dataSource-transport-read url="CityController" />
							<kendo:dataSource-transport-update
								url="CityController?action=update" type="post" />
							<kendo:dataSource-transport-destroy
								url="CityController?action=delete" type="post" />
							<kendo:dataSource-transport-create
								url="CityController?action=insert" type="post" />
						</kendo:dataSource-transport>
						<kendo:dataSource-schema>
							<kendo:dataSource-schema-model id="code">
								                           <kendo:dataSource-schema-model-fields>
                                         <kendo:dataSource-schema-model-field name="city" defaultValue="<%=new City()%>"></kendo:dataSource-schema-model-field>
                                   <kendo:dataSource-schema-model-field name="countryLanguage" defaultValue="<%=new CountryLanguage()%>"></kendo:dataSource-schema-model-field>
                           </kendo:dataSource-schema-model-fields> 

							</kendo:dataSource-schema-model>
						</kendo:dataSource-schema>
					</kendo:dataSource>

					<kendo:grid-columns>

						<kendo:grid-column title="Country Code" field="code" />
						<kendo:grid-column title="Country Name" field="name" template="#: name #" editor="countryName"/>
						<kendo:grid-column title="Continent" field="continent" />
						<kendo:grid-column title="Region" field="region" />
						<kendo:grid-column title="Population" field="population" />
						<kendo:grid-column title="HeadOfState" field="headOfState" />
						<kendo:grid-column title="Capital" field="capital" />
						<kendo:grid-column title="City Name" field="city.name" template="#: city.name #" editor="cityNameEditor" />
						<kendo:grid-column title="District" field="city.district" template="#: city.district #" editor="districtEditor" />
						<kendo:grid-column title="City Population" field="city.population" />
						<kendo:grid-column title="IsOfficial" field="countryLanguage.isOfficial" />
						<kendo:grid-column title="Percentage" field="countryLanguage.percentage" />
						<kendo:grid-column>
							<kendo:grid-column-command>
								<kendo:grid-column-commandItem name="edit" />
								<kendo:grid-column-commandItem name="destroy" />
							</kendo:grid-column-command>
						</kendo:grid-column>
					</kendo:grid-columns>
				</kendo:grid>
			</div>
		</div>
	</div>
	<script type="text/javascript">
       function cityNameEditor(container,options)
       {
              $("<input data-text-field='city.name' data-value-field='city.name' data-bind='value: "+options.field+"'/>'")
              .appendTo(container)
              .kendoDropDownList({
                     dataSource: {
                           transport: {
                                  read:"CityController"
                           }
                     }
              });
       }
       function districtEditor(container,options)
       {
              $("<input data-text-field='city.district' data-value-field='city.district' data-bind='value: "+options.field+"'/>'")
              .appendTo(container)
              .kendoDropDownList({
                     dataSource: {
                           transport: {
                                  read:"CityController"
                           }
                     }
              });
       }
       function languageEditor(container,options)
       {
              $("<input data-text-field='countryLanguage.language' data-value-field='countryLanguage.language' data-bind='value: "+options.field+"'/>'")
              .appendTo(container)
              .kendoDropDownList({
                     dataSource: {
                           transport: {
                                  read:"CityController"
                           }
                     }
              });
       } 
       function countryName(container,options)
       {
              $("<input data-text-field='name' data-value-field='name' data-bind='value: "+options.field+"'/>'")
              .appendTo(container)
              .kendoDropDownList({
                     dataSource: {
                           transport: {
                                  read:"CityController"
                           }
                     }
              });
       } 
       </script>
	
</body>
</html>