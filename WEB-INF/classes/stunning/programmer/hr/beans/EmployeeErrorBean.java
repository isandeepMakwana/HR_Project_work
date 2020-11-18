package stunning.programmer.hr.beans;
public class EmployeeErrorBean implements java.io.Serializable
{
private String error1;
private String error2;
public EmployeeErrorBean()
{
this.error1 ="";
this.error2 ="";
}
public void setError1(String error1)
{
this.error1 = error1;
}
public String getError1(){
return this.error1;
}
public void setError2(String error2)
{
this.error2 = error2;
}
public String getError2(){
return this.error2;
}
}