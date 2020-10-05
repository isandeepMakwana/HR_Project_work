function Employee(){
this.employeeId='';
this.name='';
this.designationCode=0;
this.dataOfBirth='';
this.gender='';
this.IsIdian=true;
this.basicSalary=0;
this.panNumber='';
this.addharCardNumber='';
}

var selectedRow=null;
var employees=[];
var employee=new Employee();
employee.employeeId='A100003';
employee.name='Anil Kausmria';
employee.designationCode=15;
employee.designation='Driver';
employee.dateOfBirth='01/04/1988';
employee.gender='M';
employee.isIndian='true';
employee.basicSalary=1500000.00;
employee.panNumber='asdf1245';
employee.addharCardNumber='zxcv2143';
employees[0]=employee;

var employee=new Employee();
employee.employeeId='A100007';
employee.name='imran';
employee.designationCode=20;
employee.designation='Electrition';
employee.dateOfBirth='01/12/1990';
employee.gender='M';
employee.isIndian='true';
employee.basicSalary=2500000.45;
employee.panNumber='IND7824241';
employee.addharCardNumber='UID855646';
employees[1]=employee;

var employee=new Employee();
employee.employeeId='A100002';
employee.name='Neha';
employee.designationCode=11;
employee.designation='Sales Men';
employee.dateOfBirth='27/05/1992';
employee.gender='F';
employee.isIndian='true';
employee.basicSalary=2500000.00;
employee.panNumber='IND09876';
employee.addharCardNumber='UID09876';
employees[2]=employee;

var employee=new Employee();
employee.employeeId='A100004';
employee.name='Rita Gupta';
employee.designationCode=5;
employee.designation='Manager';
employee.dateOfBirth='12/09/1996';
employee.gender='F';
employee.isIndian='true';
employee.basicSalary=500000.00;
employee.panNumber='AB12345';
employee.addharCardNumber='UID123456';
employees[3]=employee;

var employee=new Employee();
employee.employeeId='A100006';
employee.name='Sandeep Makwana';
employee.designationCode=22;
employee.designation='Administration';
employee.dateOfBirth='19/02/2000';
employee.gender='M';
employee.isIndian='true';
employee.basicSalary=16975740.05;
employee.panNumber='IND4885115';
employee.addharCardNumber='UID284506';
employees[4]=employee;

var employee=new Employee();
employee.employeeId='A100008';
employee.name='Vikas';
employee.designationCode=24;
employee.designation='Screen Manger';
employee.dateOfBirth='20/01/2000';
employee.gender='M';
employee.isIndian='true';
employee.basicSalary=56854.00;
employee.panNumber='IND82252';
employee.addharCardNumber='UID15514255';
employees[5]=employee;

function selectEmployee(row, employeeId)
{
if(row==selectedRow)return;
if(selectedRow!=null)
{
selectedRow.style.background='white';
selectedRow.style.color='black';
}
row.style.background='#7C7B7B';
row.style.color='white';
selectedRow=row;

var i;
for(i=0; i<employees.length;i++)
{
if(employees[i].employeeId==employeeId)
{
break;
}
}
var emp=employees[i];
document.getElementById('detailPanel_employeeId').innerHTML=emp.employeeId;
document.getElementById('detailPanel_name').innerHTML=emp.name;
document.getElementById('detailPanel_designation').innerHTML=emp.designation;
document.getElementById('detailPanel_dateOfBirth').innerHTML=emp.dateOfBirth;
document.getElementById('detailPanel_gender').innerHTML=emp.gender;

if(emp.isIndian){
document.getElementById('detailPanel_isIndian').innerHTML='Yes';
}
else
{
document.getElementById('detailPanel_isIdian').innerHTML='NO';
}
document.getElementById('detailPanel_basicSalary').innerHTML=emp.basicSalary;
document.getElementById('detailPanel_panNumber').innerHTML=emp.panNumber;
document.getElementById('detailPanel_addharCardNumber').innerHTML=emp.addharCardNumber;
}
