<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE' />
<jsp:useBean id='employeeBean' scope='request' class='stunning.programmer.hr.beans.EmployeeBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/DesignationAddForm.js'></script>

<h2>Employee (Delete Module)</h2>

<form method='post' action='/styletwo/DeleteEmployee.jsp'>
<input type ='hidden' name ='employeeId' id ='employeeId' value='${employeeBean.employeeId}'>
Name : <strong>${employeeBean.name}</strong><br>
Designation :<b> ${employeeBean.designation}</b><br>
Date Of Birth : <b>${employeeBean.dateOfBirth}</b><br>
Gender : <b>${employeeBean.gender}</b><br>
Nationality : <b>${employeeBean.isIndian}</b><br>
Basic salary : <b>${employeeBean.basicSalary}</b><br>
PAN Number : <b>${employeeBean.panNumber}</b><br>
Aadhar Card Number : <b>${employeeBean.aadharCardNumber}</b><br>
Are you sure you want to delete this Employee ?<br><br><br>
<button type='submit' >Yes</button>
<button type='Button' onclick='CancelAddition()'>NO</button>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />