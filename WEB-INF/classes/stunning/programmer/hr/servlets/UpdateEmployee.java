package stunning.programmer.hr.servlets;
import stunning.programmer.hr.beans.*;
import stunning.programmer.hr.dl.*;
import java.math.*;
import java.text.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class UpdateEmployee extends HttpServlet
{
public void doPost(HttpServletRequest request , HttpServletResponse response)
{
try{
EmployeeBean employeeBean=(EmployeeBean)request.getAttribute("employeeBean");
EmployeeDTO employeeDTO=new EmployeeDTO();

employeeDTO.setEmployeeId(employeeBean.getEmployeeId());
employeeDTO.setName(employeeBean.getName());
employeeDTO.setDesignationCode(employeeBean.getDesignationCode());
employeeDTO.setDesignation(employeeBean.getDesignation());
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
employeeDTO.setDateOfBirth(simpleDateFormat.parse(employeeBean.getDateOfBirth()));
employeeDTO.setGender(employeeBean.getGender());
employeeDTO.setIsIndian(employeeBean.getIsIndian());
employeeDTO.setBasicSalary(new BigDecimal(employeeBean.getBasicSalary()));
employeeDTO.setPANNumber(employeeBean.getPanNumber());
employeeDTO.setAadharCardNumber(employeeBean.getAadharCardNumber());
EmployeeDAO employeeDAO = new EmployeeDAO();
try{
employeeDAO.update(employeeDTO);
MessageBean messageBean;
messageBean = new MessageBean();
messageBean.setHeading("Employee (Edit Module) ");
messageBean.setMessage("Employee Updated ");
messageBean.setGenerateButton(true);
messageBean.setButtonOneText("OK");
messageBean.setButtonOneAction("Employees.jsp");
request.setAttribute("messageBean" , messageBean);

RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/Notification.jsp");
try{
requestDispatcher.forward(request, response);
}catch(Exception e){}
}
catch(DAOException daoException){
System.out.println(daoException.getMessage());
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("Employees.jsp");
try{
requestDispatcher.forward(request, response);
}catch(Exception e){}
}
}
catch(Exception exception){
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

public void doGet(HttpServletRequest request, HttpServletResponse response)
{
HttpSession ss = request.getSession();
if(ss.getAttribute("userName")==null)
{
RequestDispatcher requestDispatcher;
requestDispatcher = request.getRequestDispatcher("/LoginForm.jsp");
try{
requestDispatcher.forward(request, response);
}
catch(Exception e){}
}

}
}