<!--FOOT Include Begins -->
<!-- /main -->
</div>
<!-- /wrapper -->

<script src="resources/scripts/validate.min.js"></script>
<script>
  var validator = new FormValidator('scheduleSearch', [{
      name: 'number',
      display: 'Course Number',
      rules: 'callback_course_format'
  },
  {
      name: 'instructor',
      display: 'Instructor',
      rules: 'callback_instructor_format'
  }
  ], function(errors, event) {
      for(var field in validator.fields){
        validator.fields[field].errorElem.innerHTML = "";
      }

      if (errors.length > 0) {
          // Prevent form submission
          event.preventDefault();

          // TODO: Reset error messages on submit
          document.getElementById("main-error-msg").innerHTML = "Please correct errors below";
          

          // Show the errors
          for (var i = 0, errorLength = errors.length; i < errorLength; i++) {
            var msgBox = validator.fields[errors[i].name].errorElem;
            msgBox.innerHTML = "";
            console.log(errors[i].name + " has an error.");
            msgBox.innerHTML += errors[i].message;
        }
      }
  });

  // Grab error field elements and attach to validator fields
  for(var field in validator.fields){
    validator.fields[field].errorElem = document.getElementById(field + "-error-msg");
  }

  validator.registerCallback('course_format', function(value) {
    if (validateNumber(value)) {
        return true;
    }
    return false;
  })
  .setMessage('course_format', '%s must be 4 digits or 4 digits and 1 letter.');

  validator.registerCallback('instructor_format', function(value) {
    if (/^[a-zA-Z ]*$/.test(value)) {
        return true;
    }
    return false;
  })
  .setMessage('instructor_format', '%s must be only letters and spaces.');

function validateNumber(value) {
      console.log(value.length);
      // Match 4 digits only
      var validNumberRegEx1 = new RegExp('[\\d]{4}');
      // // Match 4 digits and one char
      var validNumberRegEx2 = new RegExp('[\\d]{4}[\\w]', 'i');
      
      // Not 4 or 5 chars - Set error to "Course number must be 4 digits or 4 digits and 1 letter."
      if(
          // Don't check if it's empty
          value.length <= 0 ||
          // Course number must be at least 4 digits long
          value.length < 4 ||
          // the first 4 chars must be digits
          value.length === 4 && !validNumberRegEx1.test(value) ||
          // If 5 chars, it must be 4 digits and then a letter
          value.length === 5 && !validNumberRegEx2.test(value)
        ) {
        return false;
      }
      else {
        return true;
      }

      
  }
</script>


<script>
  function validate()
       {
         var mainErrMsgElem = document.getElementById('main-error-msg');
         setElemText(mainErrMsgElem, ""); // Reset error message

         var isValid = false;


         // Validate number
         isValid = validateNumber();

         // Validate instructor
         isValid = validateInstructor();
        
         if(!isValid){
           setElemText(mainErrMsgElem, "Please correct errors below.");
         }
         return isValid;
       }
  
/*    function validateNumber() {
      
       var errorMsgElem = document.getElementById('number-error-msg');
       setElemText(errorMsgElem, ""); // Reset error message

       // Match 4 digits only
       var validNumberRegEx1 = new RegExp('[\\d]{4}');
       // Match 4 digits and one char
       var validNumberRegEx2 = new RegExp('[\\d]{4}[\\w]', 'i');

       var courseNumber = document.forms["scheduleSearch"]["number"];
      
       // Not 4 or 5 chars - Set error to "Course number must be 4 digits or 4 digits and 1 letter."
       if(
           // Don't check if it's empty
           courseNumber.value.length <= 0 ||
           // Course number must be at least 4 digits long
           courseNumber.value.length < 4 ||
           // the first 4 chars must be digits
           courseNumber.value.length === 4 && !validNumberRegEx1.test(courseNumber.value) ||
           // If 5 chars, it must be 4 digits and then a letter
           courseNumber.value.length === 5 && !validNumberRegEx2.test(courseNumber.value)
         ) {
         setElemText(errorMsgElem, "Course Number must be 4 numbers or 4 numbers and 1 letter. Ex: 4444 or 4444A");
         courseNumber.focus(); 
         return false;
       }
       else {
         console.log("FORM OK");
         return true;
       }
   } */

   function validateInstructor() {
       var errorMsgElem = document.getElementById('instructor-error-msg');
       setElemText(errorMsgElem, ""); // Reset error message


       var validNumberRegEx1 = new RegExp('[a-z]', 'gi');
       return false;
   }

   function setElemText(elem, newText) {
     elem.innerHTML = newText;
   }
</script>
</body>
</html>
<!--FOOT Include Ends -->