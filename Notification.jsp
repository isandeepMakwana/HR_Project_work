<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<jsp:useBean id='messageBean' scope='request' class='stunning.programmer.hr.beans.MessageBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<h2>${messageBean.heading}</h2>
${messageBean.message}
<tm:If condition='${messageBean.generateButton}'>
<table>
<tr>
<td>
<form action='/styletwo/${messageBean.buttonOneAction}'>
<button>${messageBean.buttonOneText}</button>
</form>
</td>
<tm:If condition='${messageBean.generateTwoButton}'>
<td>
<form action='/styletwo/${messageBean.buttonTwoAction}'>
<button>${messageBean.buttonTwoText}</button>
</form>
</td>
</tm:If>
</tr>
</table>
</tm:If>
<jsp:include page='/MasterPageBottomSection.jsp' />