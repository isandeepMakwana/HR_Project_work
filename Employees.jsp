<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='EMPLOYEE' />
<jsp:include page='/MasterPageTopSection.jsp' />
<link rel='stylesheet' type='text/css' href='/styletwo/css/employees.css'>
<script src='/styletwo/js/Employees.js'></script>
<h2>Employees</h2>
<div class='employeeGrid'>
<table border='1'>
<thead>
<tr>
<th colspan='6' class='employeeGridHeader'>
<a href='/styletwo/EmployeeAddForm.jsp'>Add new Employees</a>
</th>
</tr>
<tr>
<th class='employeeGridSNOColumnTitle'>S.NO</th>
<th class='employeeGridIdColumnTitle'>Id.</th>
<th class='employeeGridNameColumnTitle'>Name</th>
<th class='employeeGridEmployeeColumnTitle'>Designations</th>
<th class='employeeGridEditLinkOptionColumnTitle'>Edit</th>
<th class='employeeGridDeleteLinkOptionColumnTitle'>Delete</th>
</tr>
</thead>
<tbody>
<tm:EntityList populatorClass='stunning.programmer.hr.bl.EmployeeBL' populatorMethod='getAll' name='employeeBean'>
<tr style='cursor:pointer' onclick='selectEmployee(this,"${employeeBean.employeeId}")'>
<td style='text-align:right'>${serialNumber}. </td>
<td>${employeeBean.employeeId}</td>
<td>${employeeBean.name}</td>
<td>${employeeBean.designation}</td>
<td style='text-align:center'><a href='/styletwo/editEmployee?employeeId=${employeeBean.employeeId}'>Edit</a></td>
<td style='text-align:center'><a href='/styletwo/confirmDeleteEmployee?employeeId=${employeeBean.employeeId}'>Delete</a></td>
</tr>
</tm:EntityList>
</tbody>
</table>
</div>
<div style='height:19hv;margin-left:5px;margin-right:5px;margin-bottom:px;margin-top:5px;padding:5px;border:1px solid black;'>
<label style='background-color:gray;color:white;padding-left:5px;padding-right:5px;' onmousedown='background-color:red'>Details</label>
<table border='0' width='100%'>
<tr>
<td>
Employee Id: <span id='detailPanel_employeeId' style='margin-right:30px;'></span></td>
<td>Name :<span id='detailPanel_name' style='margin-right:30px;'></span></td>
<td>Designation : <span id='detailPanel_designation' style='margin-right:30px;'></span></td>
</tr>
<tr>
<td>Date Of Birth : <span id='detailPanel_dateOfBirth' style='margin-right:30px;'></span></td>
<td>Gender :<span id='detailPanel_gender' style='margin-right:30px;'></span></td>
<td>Is Indian: <span id='detailPanel_isIndian' style='margin-right:30px;'></span></td>
</tr>
<tr>
<td>Basic Salary: <span id='detailPanel_basicSalary' style='margin-right:30px;'></span></td>
<td>PAN Number :<span id='detailPanel_panNumber' style='margin-right:30px;'></span></td>
<td>Aadhar card Number : <span id='detailPanel_aadharCardNumber' style='margin-right:30px;'></span></td>
</tr>

</table>
</div>
<jsp:include page='/MasterPageBottomSection.jsp' />