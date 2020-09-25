<jsp:useBean id='messageBean' scope='request' class='stunning.programmer.hr.beans.MessageBean' />
<!DOCTYPE html>
<html lang='en'>
<head><title>HR Application </title>
<link rel='stylesheet' type='text/css' href='/styletwo/css/styles.css'>
</head>
<body>
<!-- main container starts here -->
<div class='main-container'>
<!-- header starts here -->
<div class='header'>
<img src='/styletwo/images/logo.jpg' class='logo'>
<div class='brand-name'>&nbsp;&nbsp; Stunning Programmer
</div>
</div>
<!-- header ends here -->
<!-- content-section starts here -->
<div class='content'>
<!-- left panels ends here -->
<div class='content-left-panel'>
<b>Designations</b><br>
<a href='/styletwo/Employees.jsp'>Employees</a><br><br>
<a href='/styletwo/index.html'>Home</a>
</div>
<!-- left panel ends here -->
<!-- right panel starts here -->
<div class='content-right-panel'>
<h2>${messageBean.message}</h2>
${messageBean.message}
<%
if(messageBean.getGenerateButton()==true)
{
%>
<table>
<tr>
<td>
<form action='/styletwo/${messageBean.buttonOneAction}'>
<button>${messageBean.buttonOneText}</button>
</form>
</td>
<%
if(messageBean.getGenerateTwoButton()==true)
{
%>
<td>
<form action='/styletwo/${messageBean.buttonTwoAction}'>
<button>${messageBean.buttonTwoText}</button>
</form>
</td>
<%
}
%>
</tr>
</table>
<%
}
%></div>
<!-- right endss here -->
</div><!-- content-section ends here -->
<!-- footer starts here -->
<div class='footer'>
&copy; Stunning Programer 2020 
</div>
</div>
<!-- main containers end here -->
</body>
</html>
