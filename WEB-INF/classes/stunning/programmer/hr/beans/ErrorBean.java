package stunning.programmer.hr.beans;
public class ErrorBean implements java.io.Serializable
{
private String error;
public ErrorBean()
{
this.error ="";
}
public void setError(String error)
{
this.error = error;
}
public String getError(){
return this.error;
}
}