package stunning.programmer.hr.beans;
public class MessageBean implements java.io.Serializable
{
private String message;
private String heading;
private boolean generateButton;
private boolean generateTwoButton;
private String buttonOneText;
private String buttonTwoText;
private String buttonOneAction;
private String buttonTwoAction;

public MessageBean()
{
this.message ="";
this.heading="";
this.generateButton=false;
this.generateTwoButton=false;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public String getHeading() {
	return heading;
}

public void setHeading(String heading) {
	this.heading = heading;
}

public boolean getGenerateButton() {
	return generateButton;
}

public void setGenerateButton(boolean generateButton) {
	this.generateButton = generateButton;
}

public boolean getGenerateTwoButton() {
	return generateTwoButton;
}

public void setGenerateTwoButton(boolean generateTwoButton) {
	this.generateTwoButton = generateTwoButton;
}

public String getButtonOneText() {
	return buttonOneText;
}

public void setButtonOneText(String buttonOneText) {
	this.buttonOneText = buttonOneText;
}

public String getButtonTwoText() {
	return buttonTwoText;
}

public void setButtonTwoText(String buttonTwoText) {
	this.buttonTwoText = buttonTwoText;
}

public String getButtonOneAction() {
	return buttonOneAction;
}

public void setButtonOneAction(String buttonOneAction) {
	this.buttonOneAction = buttonOneAction;
}

public String getButtonTwoAction() {
	return buttonTwoAction;
}

public void setButtonTwoAction(String buttonTwoAction) {
	this.buttonTwoAction = buttonTwoAction;
}
}