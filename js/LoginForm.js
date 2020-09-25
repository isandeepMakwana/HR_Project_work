function ValidateUser(frm){
var user=frm.userName.value.trim();

if(user.length==0)
{
document.getElementById('error').innerHTML=" Invalid UserName & Password ";
frm.userName.focus();
return false;
}
var pwd=frm.password.value.trim();
if(pwd.length==0)
{
document.getElementById('error').innerHTML="Invalid UserName & Password";
frm.password.focus();
return false;
}
if(pwd.length<=4)
{
document.getElementById('error').innerHTML="Password Cantains must be 4 digits";
frm.password.focus();
return false;
}
return true;
}
