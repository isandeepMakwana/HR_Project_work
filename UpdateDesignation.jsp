<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Restriction />
<jsp:useBean id='designationBean' scope='request' class='stunning.programmer.hr.beans.DesignationBean' />
<tm:Module name='DESIGNATION' />
<jsp:setProperty name='designationBean' property='*' />
<jsp:forward page='/updateDesignation' />