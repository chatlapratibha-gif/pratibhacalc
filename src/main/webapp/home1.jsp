<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/empstyle.css"/>
</head>
<body>

<div class="topnav">
  <a class="active" href="#home">CustomerList</a>
  <a href="#about">About</a>
  <a href="#contact">Contact</a>
  <div class="search-container">
    <form action="/action_page.php">
      <input type="text" placeholder="Search.." name="search">
      <button type="submit"><i class="fa fa-search"></i></button>
    </form>
  </div>
</div>

<div style="padding-left:16px">
  <h2>Responsive Search Bar</h2>
  <p>Navigation bar with a search box and a submit button inside of it.</p>
  <p>Resize the browser window to see the responsive effect.</p>
</div>

</body>
</html>
