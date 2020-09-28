<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Guard>
<jsp:forward page='/LoginForm.jsp' />
</tm:Guard>
<!-- <tm:Restriction /> -->
<tm:FormResubmitted>
<tm:Module name='HOME' />
<jsp:forward page='/notifyFormResubmitted' />
</tm:FormResubmitted>
<tm:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' scope='request' class='stunning.programmer.hr.beans.DesignationBean' />
<jsp:setProperty name='designationBean' property='*' />
<jsp:forward page='/addDesignation' />
