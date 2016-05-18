<%@ include file="../head.jsp" %>
<!--body.jsp include Goes Here -->
<%@ include file="../body.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<BODY BGCOLOR="white">
<center>
  	 
  	 
  	 <!-- /login?error=true -->
     <c:if test="${param.error == 'true'}">
         <div style="color:red;margin:10px 0px;">
          
                Login Failed!!!<br />
                Reason :  ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                 
         </div>
    </c:if>
<H2>Please Enter your User ID and Password</H2>
<br>
 <form name='f' action="${pageContext.request.contextPath}/j_spring_security_check" method='POST' accept-charset="utf-8">
      <table>
         <tr>
            <td>User:</td>
            <td><input type='text' name='username' value=''></td>
         </tr>
         <tr>
            <td>Password:</td>
            <td><input type='password' name='password' /></td>
         </tr>
         <tr>
            <td><input name="submit" type="submit" value="submit" /></td>
         </tr>
      </table>
      <!-- http://stackoverflow.com/questions/21128058/invalid-csrf-token-null-was-found-on-the-request-parameter-csrf-or-header -->
      <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
  </form>
<!-- <FORM ACTION="update.jsp">
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
  <INPUT TYPE="SUBMIT" value="Log In"> Press this button to submit form
</FORM> -->
</CENTER>

<!--foot.jsp include Goes Here -->
<%@ include file="../foot.jsp" %>


