package stunning.programmer.hr.bl;
import stunning.programmer.hr.dl.*;
import stunning.programmer.hr.beans.*;
import java.util.*;
public class EmployeeBL
{
public List<EmployeeBean> getAll()
{
List<EmployeeBean> employees=new LinkedList<>();
try
{
EmployeeDAO employeeDAO = new EmployeeDAO();
List<EmployeeDTO> dlEmployees=employeeDAO.getAll();
EmployeeBean employeeBean;
for(EmployeeDTO dlEmployee:dlEmployees)
{
employeeBean=new EmployeeBean();
employeeBean.setEmployeeId(dlEmployee.getEmployeeId());
employeeBean.setName(dlEmployee.getName());
employeeBean.setDesignation(dlEmployee.getDesignation());
employeeBean.setDesignationCode(dlEmployee.getDesignationCode());
employeeBean.setDateOfBirth(dlEmployee.getDateOfBirth().toString());
employeeBean.setGender(dlEmployee.getGender());
employeeBean.setIsIndian(dlEmployee.getIsIndian());
employeeBean.setBasicSalary(dlEmployee.getBasicSalary());
employeeBean.setPanNumber(dlEmployee.getPANNumber());
employeeBean.setAadharCardNumber(dlEmployee.getAadharCardNumber());
employees.add(employeeBean);
}
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
return employees;
}
}