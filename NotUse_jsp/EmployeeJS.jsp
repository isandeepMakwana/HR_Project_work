<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<script>
var employee;
<tm:EntityList populatorClass='stunning.programmer.hr.bl.EmployeeBL' populatorMethod='getAll' name='employeeBean'>
employee=new Employee();
employee.employeeId="${employeeBean.employeeId}";
employee.name="${employeeBean.name}";
employee.designationCode=${employeeBean.designationCode};
employee.designation="${employeeBean.designation}";
employee.dateOfBirth="${employeeBean.dateOfBirth}";
employee.gender="${employeeBean.gender}";
employee.isIndian="${employeeBean.isIndian}";
employee.basicSalary="${employeeBean.basicSalary}";
employee.panNumber="${employeeBean.panNumber}";
employee.addharCardNumber="${employeeBean.aadharCardNumber}";
employees[${serialNumber-1}]=employee;
</tm:EntityList>
</script>