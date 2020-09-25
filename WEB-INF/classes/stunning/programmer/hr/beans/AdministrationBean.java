package stunning.programmer.hr.beans;
public class AdministrationBean implements java.io.Serializable,Comparable<AdministrationBean>
{
private String userName;
private String password;
public AdministrationBean(){
this.userName="";
this.password="";
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public boolean equals(Object object)
{
if(!(object instanceof AdministrationBean)) return false;
AdministrationBean other =(AdministrationBean)object;
return this.userName.equals(other.userName);
}

public int compareTo(AdministrationBean other)
{
return this.userName.compareToIgnoreCase(other.userName);
}
public int hashCode(){
return userName.hashCode();
}
}