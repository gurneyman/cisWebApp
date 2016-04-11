<!--head.jsp include Goes Here -->
<%@ include file="head.jsp" %>
<!--body.jsp include Goes Here -->
<%@ include file="body.jsp" %>

<% 
  String semester = request.getParameter("semester");
  String department = request.getParameter("department");
  String discipline= request.getParameter("discipline");

  String div_undr = request.getParameter("div_undr");
  String div_grad = request.getParameter("div_grad");

  String number = request.getParameter("number");
  String week = request.getParameter("week");

  String time_a_b= request.getParameter("time_a_b");
  String time = request.getParameter("time");

  // Basic time processing - Should be in a function or object
  // Need to check instanceof... This is a bad way of doing this.
  if(Integer.parseInt(time) != 0){
  if( Integer.parseInt(time) > 12) {
    time = (Integer.parseInt(time) - 12) + ":00pm";
  }
  else {
    time += ":00am";
  }
  }
  else {
	  time = "All";
  }

  String instructor = request.getParameter("instructor");


%>
  <h1>
  Schedule of Classes Search Results</h1>
  <p>Search results are based on the following keywords:</p>
  <table id="criteria" summary="This table contains the search criteria. Results are listed in next table.">
    <tr>
      <td><strong>Semester</strong>: <% out.print(semester); %></td>
      <td><strong>Days</strong>: <% out.print(week); %></td>
    </tr>
    <tr>
      <td><strong>Department</strong>: <% out.print(department); %></td>
      <td><strong>Time</strong>: <% out.print(time_a_b + " " + time); %></td>
    </tr>
    <tr>
      <td><strong>Discipline</strong>: <% out.print(discipline); %></td>
      <td><strong>Course number</strong>: <% out.print((number == null) ? number : "None entered"); %></td>
    </tr>
    <tr>
      <td><strong>Division</strong>: <%out.print( ((div_undr != null) ? div_undr + " " : "") + ((div_grad != null) ? div_grad : "")); %></td>
      <td><strong>Instructor</strong>: <% out.print((instructor == null) ? instructor : "None entered"); %> </td>
    </tr>
    </table>

    <!-- Removed font and b tags here to maintain structure/style separation of concerns -->
    <section class="alert">
      <p class="alert__copy alert--bold">The schedule was LAST&nbsp; updated at 9:00am on Nov 27th, 2006.</p>
      <p class="alert__copy">Due to the dynamic nature of the registration process, not all courses listed as open will have space for new registrants.</p>
    </section>

  </div>
<table id="results" summary="This table contains the search results for schedule of classes.">
  <thead>
    <tr>
      <th scope="col">Course</th>
      <th scope="col">Code</th>
      <th scope="col">Section</th>
      <th scope="col">Day &amp; Time </th>
      <th scope="col">Dates</th>
      <th scope="col">Bldg &amp; Rm </th>
      <th scope="col">Instructor</th>
      <th scope="col">Seats Avail </th>
      <th scope="col">Comments</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><a href="coursedetails.jsp">BIO 1003</a></td>
      <td>0153</td>
      <td>DK24B</td>
      <td>TTH 4:30pm -  7:15pm,<br />
        F 10:45am-11:35am</td>
      <td>01/26/07 - 06/03/07 </td>
      <td>VC 5160 </td>
      <td>Crane<br />
        Tucker </td>
      <td>0012</td>
      <td>Course has a lab and lecture </td>
    </tr>
  </tbody>
</table>
<!--foot.jsp include Goes Here -->
<%@ include file="foot.jsp" %>
