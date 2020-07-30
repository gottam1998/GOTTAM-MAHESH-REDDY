<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ministatement</title>
 <script src="https://code.jquery.com/jquery-3.3.1.js"></script>
  <script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
  <script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap4.min.js"></script>
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.3/css/bootstrap.css">
  <link rel="stylesheet" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap4.min.css">
</head>
<body>

<div align="center">
<a href="deposit.jsp">Deposit</a>
<a href="withdraw.jsp">Withdraw</a>
<a href="ministatement">Mini Statement</a>
<h2>Mini Statement</h2>
<table id="example" class="table table-striped table-bordered" style="width:100%">
  <thead>
    <tr>
      <th scope="col">TRANSACTION NO</th>
      <th scope="col">CREDIT</th>
      <th scope="col">DEBIT</th>
      <th scope="col">BALANCE</th>
    </tr>
  </thead>
  <tbody>    
        <c:forEach var = "statement" items = "${statement}">
            <tr>
            <td>${statement.transactionNo}</td>
               <td>${statement.credit}</td>
               <td>${statement.debit}</td>
               <td>${statement.balance}</td>
          
            </tr>
         </c:forEach>
         </tbody>
      </table>
      </div>
</body>
</html>