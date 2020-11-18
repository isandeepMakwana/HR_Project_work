<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<jsp:useBean id='employeeBean' scope='request' class='stunning.programmer.hr.beans.EmployeeBean' />
<jsp:useBean id='employeeErrorBean' scope='request' class='stunning.programmer.hr.beans.EmployeeErrorBean' />
<jsp:useBean id='ErrorBean' scope='request' class='stunning.programmer.hr.beans.ErrorBean' />
<tm:Module name ='EMPLOYEE' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/EmployeeAddForm.js'></script>
<form id='cancelAdditionForm' action='/styletwo/Employees.jsp' >
</form>
<h2>Employee (Edit Module)</h2>
<form method='post' action='/styletwo/UpdateEmployee.jsp' onsubmit='return validateFrom(this)'>
<input type="hidden" id='employeeId' name='employeeId' value='${employeeBean.employeeId}'>
<table>
<tr>
<td>Name</td>
<td><input type='text' id='name' name='name' maxlength='50' size='51' value='${employeeBean.name}'>
<span id='nameErrorSection' style='color:red'></span><br></td>
</tr>
<tr>
<td>Designation</td>
<td>
<select id='designationCode' name='designationCode'>
<option value='-1'>&lt;Select Deseignation&gt;</option>
<tm:EntityList populatorClass='stunning.programmer.hr.bl.DesignationBL' populatorMethod='getAll' name='dBean'>
<tm:If condition='${dBean.code!=employeeBean.designationCode}'>
<option value='${dBean.code}'>${dBean.title}</option>
</tm:If>
<tm:If condition='${dBean.code==employeeBean.designationCode}'>
<option selected value='${dBean.code}'>${dBean.title}</option>
</tm:If>
</tm:EntityList>
</select>
<span id='designationCodeErrorSection' style='color:red'></span><br></td>
</td>
</tr>
<tr>

<td>Date of Birth</td>
<td><input type='date' id='dateOfBirth' name='dateOfBirth' value='${employeeBean.dateOfBirth}'>
<span id='dateOfBirthErrorSection' style='color:red'></span><br></td>
</tr>
<tr>
<td>Gender</td>
<td>
<tm:If condition='${employeeBean.isMale()}'>
<input checked type='radio' name='gender' id='male' value='M'>
&nbsp; Male
&nbsp;&nbsp;&nbsp;
<input type='radio' name='gender' id='female' value='F'>&nbsp;Female&nbsp;&nbsp;&nbsp;<span id='genderErrorSection' style='color:red'></span>
</tm:If>
<tm:If condition='${employeeBean.isFeMale()}'>
<input type='radio' name='gender' id='male' value='M'>
&nbsp; Male
&nbsp;&nbsp;&nbsp;
<input checked type='radio' name='gender' id='female' value='F'>&nbsp;Female&nbsp;&nbsp;&nbsp;<span id='genderErrorSection' style='color:red'></span>
</tm:If>
<tm:If condition='${employeeBean.isMale()==false}'>
<tm:If condition='${employeeBean.isFeMale()==false}'>
<input type='radio' name='gender' id='male' value='M'>
&nbsp; Male
&nbsp;&nbsp;&nbsp;
<input type='radio' name='gender' id='female' value='F'>&nbsp;Female&nbsp;&nbsp;&nbsp;<span id='genderErrorSection' style='color:red'></span>
</tm:If>
</tm:If>
<br>

</td>
</tr>
<tr>
<td>Indian ?</td>
<td><input ${employeeBean.checked()} type='checkbox' name='isIndian' id='isIndian'></td>
</tr>
<tr>
<td>Basic Salary</td>
<td><input type='text' name='basicSalary' id='basicSalary' maxlength='12' size='16' value='${employeeBean.basicSalary}' style='text-align: right;'><span id='basicSalaryErrorSection' style='color: red;'><br></span>
</td>
</tr>
<tr>
<td>PAN Number</td>
<td><input type='text' id='panNumber' name='panNumber' maxlength='15' size='16' value='${employeeBean.panNumber}'>
<span id='panNumberErrorSection' style='color:red'>${employeeErrorBean.error1}</span><br></td>
</tr>
<tr>
<td>Aadhar Card Number</td>
<td><input type='text' id='aadharCardNumber' name='aadharCardNumber' maxlength='15' size='16' value='${employeeBean.aadharCardNumber}'>
<span id='aadharCardNumberErrorSection' style='color:red'>${employeeErrorBean.error2}</span><br></td>
</tr>
<tr>
<td colsan='2'>
<button type='submit'>Update</button>&nbsp;&nbsp;<button type='Button' onclick='CencelAddition()'>Cancel</button></td>
</tr>
</table>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />