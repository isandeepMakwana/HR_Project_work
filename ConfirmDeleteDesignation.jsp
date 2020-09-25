<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION' />
<jsp:useBean id='designationBean' scope='request' class='stunning.programmer.hr.beans.DesignationBean' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/DesignationAddForm.js'></script>

<h2>Designation (Delete Module)</h2>
<p>Are you sure to Delete <strong>${designationBean.title} ?</strong></p>
<form method='post' action='/styletwo/DeleteDesignation.jsp'>
<input type ='hidden' name ='code' id ='code' value='${designationBean.code}'>
<button type='submit' >Yes</button>
<button type='Button' onclick='CancelAddition()'>NO</button>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />