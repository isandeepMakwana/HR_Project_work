<jsp:useBean id='administrationBean' scope='request' class='stunning.programmer.hr.beans.AdministrationBean' />
<jsp:useBean id='errorBean' scope='request' class='stunning.programmer.hr.beans.ErrorBean' />
<!DOCTYPE html>

<html lang="en">

<head>

<meta charset="UTF-8">

<title>Login for Hr Application</title>

<link rel='stylesheet' type='text/css' href='/styletwo/css/LoginForm.css'>
<script src='/styletwo/js/LoginForm.js'></script>
</head>

<body>

<div class="main-container">

<div class="header">

<a href='/styletwo/LoginForm.jsp'><img src='/styletwo/images/logo.jpg' class="logo"></a>
<div class="brand-name">&nbsp;&nbsp; Stunning Programmer
</div>
</div>

<div class="content">

<center><h2>Administrator Login Page</h2>

<div class="content-box">

<span id="error" class="error">
<jsp:getProperty name='errorBean' property='error' />
</span>

<form method="post" action="/styletwo/Login.jsp" onsubmit="return ValidateUser(this)">

<table >

<tbody>
<tr>
<td style="padding:10px;text-align: left; font-size:20px;">UserName : </td>
                    
<td style="padding:10px;">
<input type="text" name="userName" id="userName" size="35px" value='${administrationBean.userName}' ></td>
 
</tr>
                
<tr>
                    
<td style="padding:10px;text-align: center;font-size:20px;">Password : </td>
                    
<td style="padding:10px;"><input type="password" name="password" id="password" size="35px" ></td>
                
</tr>
                
<tr>
                    
<td></td>
                    
<td style="padding :10px;width: 120px;">
<button type="submit">Login</button>&nbsp;&nbsp;&nbsp;<a href="#">forget Password</a></a></td>
                
</tr>
            
</tbody>
        
</table>

</form>

</div>

</center>

</div>

<div class="footer"> 
<p>&copy; Stunning Programmer 2020</p>

</div>

</div>

</body>

</html>