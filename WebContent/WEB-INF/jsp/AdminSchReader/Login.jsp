<!--head.jsp include Goes Here -->
<!--body.jsp include Goes Here -->

<BODY BGCOLOR="white">
<center>
  	 <H1><font color="red">User ID and Password does not match!</font></H1>
<H2>Please Enter your User ID and Password</H2>
<br>
 
<FORM ACTION="update.jsp">
  User  ID: 
  <INPUT TYPE="TEXT" NAME="userId" VALUE=""><p>
  Password:
  <INPUT TYPE="password" NAME="password" VALUE=""><p>
  <label>Department ID:
	<select name="deptId">
	<option selected="selected">Select Dept </option>
	<option value="1">Registrar</option>
	<option value="2">BCTC</option>
	<option value="3">Zicklin</option>

	</select>
  </label>
  <P>
  <INPUT TYPE="SUBMIT" value="Log In"> <!-- Press this button to submit form -->
</FORM>
</CENTER>

<!--foot.jsp include Goes Here -->


