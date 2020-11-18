function Employee(){
this.employeeId='';
this.name='';
this.designationCode=0;
this.dataOfBirth='';
this.gender='';
this.IsIdian=true;
this.basicSalary=0;
this.panNumber='';
this.aadharCardNumber='';
}

var selectedRow=null;
var employees=[];


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
document.getElementById('detailPanel_aadharCardNumber').innerHTML=emp.aadharCardNumber;
}
function createDynamicRowClickHandler(rowAddress,employeeId)
{
return function()
{
selectEmployee(rowAddress,employeeId);
};
}

function populateEmployeesGridTable()
{
var employeesGridTable = document.getElementById("employeesGridTable");
var employeesGridTableBody= employeesGridTable.getElementsByTagName("tbody")[0];
var employeesGridTableBodyRowTemplate = employeesGridTableBody.getElementsByTagName("tr")[0];
// remove the ROW from DOM(Document object Model)
employeesGridTableBodyRowTemplate.remove();
var employeesGridTableColumnsTemplateCollection=employeesGridTableBodyRowTemplate.getElementsByTagName("td");
var cellTemplate;
var k;
var dynamicRow;
var dynamicRowCells;
var placeHolderFor;
for (k=0;k<employees.length;k++)
{
dynamicRow= employeesGridTableBodyRowTemplate.cloneNode(true);
employeesGridTableBody.appendChild(dynamicRow);
dynamicRowCells=dynamicRow.getElementsByTagName("td");
for(var i=0;i<dynamicRowCells.length;i++)
{
cellTemplate=dynamicRowCells[i];
placeHolderFor=cellTemplate.getAttribute("placeHolderId");
if(placeHolderFor==null) continue;
if(placeHolderFor=="serialNumberPlaceHolder")cellTemplate.innerHTML=(k+1)+".";
if(placeHolderFor=="employeeId")cellTemplate.innerHTML=employees[k].employeeId;
if(placeHolderFor=="name")cellTemplate.innerHTML=employees[k].name;
if(placeHolderFor=="designationCode")cellTemplate.innerHTML=employees[k].designationCode;
if(placeHolderFor=="designation")cellTemplate.innerHTML=employees[k].designation;
if(placeHolderFor=="dateOfBirth")cellTemplate.innerHTML=employees[k].dateOfBirth;
if(placeHolderFor=="isIndian")cellTemplate.innerHTML=employees[k].isIndian;
if(placeHolderFor=="basicSalary")cellTemplate.innerHTML=employees[k].basicSalary;
if(placeHolderFor=="panNumber")cellTemplate.innerHTML=employees[k].panNumber;
if(placeHolderFor=="aadharCardNumber")cellTemplate.innerHTML=employees[k].aadharCardNumber;
if(placeHolderFor=="editOption")cellTemplate.innerHTML="<a href='/styletwo/editEmployee?employeeId="+employees[k].employeeId+"'>Edit</a>";
if(placeHolderFor=="deleteOption")cellTemplate.innerHTML="<a href='/styletwo/confirmDeleteEmployee?employeeId="+employees[k].employeeId+"'>Delete</a>";
}
dynamicRow.onclick=createDynamicRowClickHandler(dynamicRow,employees[k].employeeId);
}// employees population loop ends
}
window.addEventListener('load',populateEmployeesGridTable);


