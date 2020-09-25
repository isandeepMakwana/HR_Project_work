<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Restriction />
<tm:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' scope='request' class='stunning.programmer.hr.beans.DesignationBean' />
<jsp:setProperty name='designationBean' property='*' />
<jsp:forward page='/deleteDesignation' />