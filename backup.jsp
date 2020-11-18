<tr style='cursor:pointer' onclick='selectEmployee(this,"${employeeBean.employeeId}")'>
<td style='text-align:right'>${serialNumber}. </td>
<td>${employeeBean.employeeId}</td>
<td>${employeeBean.name}</td>
<td>${employeeBean.designation}</td>
<td style='text-align:center'><a href='/styletwo/editEmployee?employeeId=${employeeBean.employeeId}'>Edit</a></td>
<td style='text-align:center'><a href='/styletwo/confirmDeleteEmployee?employeeId=${employeeBean.employeeId}'>Delete</a></td>
</tr>
