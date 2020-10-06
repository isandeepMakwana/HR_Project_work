package stunning.programmer.hr.servlets;
import stunning.programmer.hr.bl.*;
import stunning.programmer.hr.beans.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
public class EmployeeJS extends HttpServlet
{
public void doPost(HttpServletRequest request, HttpServletResponse response)
{
doGet(request,response);
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
// --------------------------------------------------------------
try
{
PrintWriter pw;
pw=response.getWriter();
response.setContentType("text/javaScript");
/*
The follwing is very bad idea, hence commented
*/
// File file = new File("c:\\tomcat9\\webapps\\styletwo\\WEB-INF\\js\\Employees.js");

//use dynamink

ServletContext servletContext= getServletContext();
File file = new File(servletContext.getRealPath("")+File.separator+"WEB-INF"+File.separator+"js"+File.separator+"Employees.js");
RandomAccessFile randomAccessFile = new RandomAccessFile(file ,"r");
while (randomAccessFile.getFilePointer()<randomAccessFile.length())
{
pw.println(randomAccessFile.readLine());
}
randomAccessFile.close();
List<EmployeeBean> employees = new EmployeeBL().getAll();
pw.println("var employee;");
int i=0;
for (EmployeeBean employeeBean:employees){
pw.println("employee=new Employee();");
pw.println("employee.employeeId=\""+employeeBean.getEmployeeId()+"\";");
pw.println("employee.name=\""+employeeBean.getName()+"\";");
pw.println("employee.designationCode="+employeeBean.getDesignationCode()+";");
pw.println("employee.designation=\""+employeeBean.getDesignation()+"\";");
pw.println("employee.dateOfBirth=\""+employeeBean.getDateOfBirth()+"\";");
pw.println("employee.gender=\""+employeeBean.getGender()+"\";");
pw.println("employee.isIndian=\""+employeeBean.getIsIndian()+"\";");
pw.println("employee.basicSalary=\""+employeeBean.getBasicSalary()+"\";");
pw.println("employee.panNumber=\""+employeeBean.getPanNumber()+"\";");
pw.println("employee.aadharCardNumber=\""+employeeBean.getAadharCardNumber()+"\";");
pw.println("employees["+i+"]=employee;");
i++;
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
