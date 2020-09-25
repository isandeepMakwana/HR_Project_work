package stunning.programmer.hr.beans;
public class DesignationBean implements java.io.Serializable
{
private int code;
private String title;
public DesignationBean(){
this.code=0;
this.title="";
}
public int getCode() {
	return code;
}
public void setCode(int code) {
	this.code = code;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
}