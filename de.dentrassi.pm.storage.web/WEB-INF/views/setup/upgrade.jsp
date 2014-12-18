<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<h:main title="Database Upgrade">

<table>

<tr><th>Database Schema Version</th><td>${databaseSchemaVersion }</td></tr>
<tr><th>Current Schema Version</th><td>${currentVersion }</td></tr>
<tr><th>Service Present</th><td>${servicePresent }</td></tr>

</table>

</h:main>