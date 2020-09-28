package stunning.programmer.hr.servlets;
import stunning.programmer.hr.dl.*;
import stunning.programmer.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class AddEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
try{
EmployeeBean employeeBean;
employeeBean = (EmployeeBean)request.getAttribute("employeeBean");
int employeeId;
String name;
int designationCode;
java.sql.Date dateOfBirth;
String gender;
boolean isIndian;
BigDecimal basicSalary;
String panNumber;
String aadharCardNumber;

employeeId=employeeBean.getEmployeeId();
name=employeeBean.getName();
designationCode=employeeBean.DesignationCode();
dateOfBirth=employeeBean.getDateOfBirth();
gender=employeeBean.getGender();
isIndian=employeeBean.getIsIndian();
basicSalary=employeeBean.getBasicSalary();
panNumber=employeeBean.getPanNumber();
aadharCardNumber=employeeBean.getAadharCardNumber();

EmployeeDTO employeeDTO;
employeeDTO = new EmployeeDTO();

employeeDTO.setEmployeeId(employeeId);
employeeDTO.setName(name);
employeeDTO.setDesignationCode(designationCode);
employeeDTO.setDateOfBirth(dateOfBirth);
employeeDTO.setGender(gender);
employeeDTO.setBasicSalary(basicSalary.toPlainString());
employeeDTO.setPanNumber(panNumber)
employeeDTO.setAadharCardNumber(aadharCardNumber);

EmployeeDAO employeeDAO = new EmployeeDAO();

boolean panNumberExists = employeeDAO.panNumberExists(String panNumber);
boolean aadharCardExists = employeeDAO.aadharNumberExists(String aadharCardNumber);


//-----------------------------------------
DesignationDAO designationDAO = new DesignationDAO();
try
{
designationDAO.add(designation);
designationBean.setCode(designation.getCode());
MessageBean messageBean;
messageBean = new MessageBean();
messageBean.setHeading("Designation(Add Module)");
messageBean.setMessage("Designation added , add More ? ");
messageBean.setGenerateButton(true);
messageBean.setGenerateTwoButton(true);
messageBean.setButtonOneText("Yes");
messageBean.setButtonOneAction("DesignationAddForm.jsp");
messageBean.setButtonTwoText("No");
messageBean.setButtonTwoAction("Designations.jsp");

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
requestDispatcher = request.getRequestDispatcher("/DesignationAddForm.jsp");
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
