<jsp:useBean id='designationBean' scope='request' class='stunning.programmer.hr.beans.DesignationBean' />
<jsp:useBean id='errorBean' scope='request' class='stunning.programmer.hr.beans.ErrorBean' />
<%@taglib uri='/WEB-INF/mytags/tmtags.tld' prefix='tm' %>
<tm:Module name='DESIGNATION' />
<jsp:include page='/MasterPageTopSection.jsp' />
<script src='/styletwo/js/DesignationAddForm.js'></script>


<h2>Designation (Add Module)</h2>
<span class='error'>
<jsp:getProperty name='errorBean' property='error' />
</span>
<form method='post' action='/styletwo/AddDesignation.jsp' onsubmit='return validateFrom(this)'>
<label>Designation</label>
<tm:FormID />
<input type='text' id='title' name='title' maxlength='35' size='36' value='${designationBean.title}'>
<span id='titleErrorSection' class='error'></span><br>
<button type='submit' >Add</button>
<button type='Button' onclick='CancelAddition()'>Cancel</button>
</form>
<jsp:include page='/MasterPageBottomSection.jsp' />