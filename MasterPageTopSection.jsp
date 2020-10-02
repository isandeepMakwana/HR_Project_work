<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/LoginForm.jsp' />
</tm:Guard>
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
<div class='username'>
<img src='/styletwo/images/userlogo.jpg'  style="width:30px;height:30px;">
${userName}&nbsp;
<a href='/styletwo/logout' style='text-decoration:none'>logout</a></div>
</div>
</div>
<!-- header ends here -->
<!-- content-section starts here -->
<div class='content'>
<!-- left panels ends here -->
<div class='content-left-panel'>
<!-- Designation -->
<tm:If condition ='${module==DESIGNATION}'>
<b>Designations</b><br>
</tm:If>
<tm:If condition ='${module!=DESIGNATION}'>
<a href='/styletwo/Designations.jsp'>Designations</a><br>
</tm:If>
<!-- Employee -->
<tm:If condition='${module==EMPLOYEE}'>
<b>Employee</b><br><br>
</tm:If>
<tm:If condition='${module!=EMPLOYEE}'>
<a href='/styletwo/Employees.jsp'>Employees</a><br><br>
</tm:If>
<tm:If condition='${module!=HOME}'>
<a href='/styletwo/index.jsp'>Home</a>
</tm:If>
</div>
<!-- left panel ends here -->
<!-- right panel starts here -->
<div class='content-right-panel'>
