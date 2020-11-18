package stunning.programmer.hr.servlets;
import stunning.programmer.hr.dl.*;
import stunning.programmer.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*; 
import java.math.*;
import java.util.*;
import java.text.*;
public class AddEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
try{
EmployeeBean employeeBean;
employeeBean = (EmployeeBean)request.getAttribute("employeeBean");
String employeeId;
String name;
int designationCode;
java.util.Date dateOfBirth;
String gender;
boolean isIndian;
BigDecimal basicSalary;
String panNumber;
String aadharCardNumber;

employeeId=employeeBean.getEmployeeId();
name=employeeBean.getName();
designationCode=employeeBean.getDesignationCode();
String designation=employeeBean.getDesignation();
SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
dateOfBirth=simpleDateFormat.parse(employeeBean.getDateOfBirth());
gender=employeeBean.getGender();
isIndian=employeeBean.getIsIndian();
basicSalary=new BigDecimal(employeeBean.getBasicSalary());
panNumber=employeeBean.getPanNumber();
aadharCardNumber=employeeBean.getAadharCardNumber();

EmployeeDTO employeeDTO;
employeeDTO = new EmployeeDTO();

employeeDTO.setEmployeeId(employeeId);
employeeDTO.setName(name);
employeeDTO.setDesignationCode(designationCode);
employeeDTO.setDateOfBirth(dateOfBirth);
employeeDTO.setGender(gender);
employeeDTO.setBasicSalary(basicSalary);
employeeDTO.setPANNumber(panNumber);
employeeDTO.setAadharCardNumber(aadharCardNumber);

EmployeeDAO employeeDAO = new EmployeeDAO();

boolean panNumberExists = employeeDAO.panNumberExists(panNumber);
boolean aadharCardNumberExists = employeeDAO.aadharCardNumberExists(aadharCardNumber);

if (panNumberExists==true|| aadharCardNumberExists==true)
{
EmployeeErrorBean employeeErrorBean;
employeeErrorBean = new EmployeeErrorBean();
if(panNumberExists==true)
employeeErrorBean.setError1("PanNumber is Exists");
if(aadharCardNumberExists==true)
employeeErrorBean.setError2("AadharCardNumber is Exists");
request.setAttribute("employeeErrorBean",employeeErrorBean);
try
{
RequestDispatcher requestDispatcher;
requestDispatcher=request.getRequestDispatcher("/EmployeeAddForm.jsp");
requestDispatcher.forward(request,response);
}catch(Exception e)
{
// do nothing
}
}

try
{
employeeDAO.add(employeeDTO);
MessageBean messageBean;
messageBean = new MessageBean();
messageBean.setHeading("Employee(Add Module)");
messageBean.setMessage("Employee added , add More ? ");
messageBean.setGenerateButton(true);
messageBean.setGenerateTwoButton(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonOneAction("EmployeeAddForm.jsp");
messageBean.setButtonTwoText("No");
messageBean.setButtonTwoAction("Employees.jsp");
request.setAttribute("messageBean", messageBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
requestDispatcher.forward(request, response);
}
catch(DAOException daoException)
{
ErrorBean errorBean;
errorBean = new ErrorBean();
errorBean.setError(daoException.getMessage());
request.setAttribute("errorBean",errorBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/EmployeeAddForm.jsp");
requestDispatcher.forward(request, response);
}
}
catch(Exception exception)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("ErrorPage.jsp");
try{
requestDispatcher.forward(request,response);
}
catch(Exception e){
System.out.println(e);
// do nothing 
}
}
}
}
