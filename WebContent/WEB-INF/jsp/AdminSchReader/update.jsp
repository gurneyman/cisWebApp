<!--head.jsp include Goes Here -->
<!--body.jsp include Goes Here -->

<BODY BGCOLOR="white">
<CENTER>
<H1>Welcome to Update Baruch Course Schedule</H1>
<br>

<FORM ACTION="display.jsp">
  <label>Semester:
	<select name="semester">
	<option selected="selected">Semester Select</option>
        %>
	<option value='Spring'>Spring 2007 </option>
			  <option value='January Intersession'>January Intersession 2007 </option>
			  <option value='Fall'>Fall 2006 </option>
			  <option value='Summer ALL'>Summer ALL 2006 </option>
			  <option value='Summer00'>Summer00 2006 (06/01/2006 to 08/17/2006)</option>
			  <option value='Summer02'>Summer02 2006 (07/10/2006 to 08/17/2006)</option>
			  <option value='Summer01'>Summer01 2006 (06/01/2006 to 07/06/2006)</option>
			  

	</select>
  </label>&nbsp;&nbsp;
  Start Date: 
  <INPUT TYPE="TEXT" NAME="startDate" VALUE="">&nbsp;&nbsp;&nbsp;
  End Date:</B>
  <INPUT TYPE="TEXT" NAME="endDate" VALUE=""><br><br><br>
  <INPUT TYPE="SUBMIT" value="Update Schedule"> <!-- Press this button to submit form -->
</FORM>
</CENTER>

<!--foot.jsp include Goes Here -->

