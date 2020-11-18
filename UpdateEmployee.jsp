<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/LoginForm.jsp' />
</tm:Guard>
<tm:Module name='Employee' />
<jsp:useBean id='employeeBean' scope='request' class='stunning.programmer.hr.beans.EmployeeBean' />
<jsp:setProperty name='employeeBean' property='*' />
<jsp:forward page='/updateEmployee' />
