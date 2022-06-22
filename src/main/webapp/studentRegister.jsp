<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="test.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
    
        <title>Course Registration</title>
</head>

<body>
    <div id="testheader">
        <div class="container">
            <div class=row>        
                <div class="col-md-5 ">
            <a href="menu.jsp"><h3>Student Registration</h3></a>
        </div>  
           <div class="col-md-6">
             <p>User: USR-${sessionScope.userSession.id} ${sessionScope.userSession.email}</p> 
            <p>Current Date : <%@page import="java.util.Date" %>
                  	 		<%=new Date() %> </p>
        </div>  
        <div class="col-md-1" >
            <input type="button" class="btn-basic" id="lgnout-button" value="Log Out" onclick="location.href='login.jsp'">
        </div>        
    </div>
</div>

</div>
    <!-- <div id="testsidebar">Hello World </div> -->
    <div class="container">
    <div class="sidenav">
        
        <button class="dropdown-btn" > Class Management <i class="fa fa-caret-down"></i></button>
        
            <div class="dropdown-container">
          <a href="courseRegister.jsp">Course Registration </a>
          <a href="studentRegister.jsp">Student Registration </a>
          <a href="studentInfo.jsp">Student Search </a>
        </div>
        <a href="UserViewController">Users Management</a>
      </div>
      <div class="main_contents">
    <div id="sub_content">
        <form action="StudentCreateController" method="post">
            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">Student Registration</h2>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="studentID" class="col-md-2 col-form-label">Student ID</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" value="Need to update" id="studentID" disabled>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="name" class="col-md-2 col-form-label">Name</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" name="name" id="name" >
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="birth" class="col-md-2 col-form-label">DOB</label>
                <div class="col-md-4">
                    <input type="date" class="form-control" name="birth" id="birth">
                </div>
            </div>
            <fieldset class="row mb-4">
                <div class="col-md-2"></div>
                <legend class="col-form-label col-md-2 pt-0">Gender</legend>
                <div class="col-md-4">
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" value="Male" id="gridRadios1"
                            checked>
                        <label class="form-check-label" for="gender">
                            Male
                        </label>
                    </div>
                    <div class="form-check-inline">
                        <input class="form-check-input" type="radio" name="gender" id="gridRadios2" value="Female">
                        <label class="form-check-label" for="gender">
                            Female
                        </label>
                    </div>
    
                </div>
            </fieldset>
    
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="phone" class="col-md-2 col-form-label">Phone</label>
                <div class="col-md-4">
                    <input type="text" class="form-control" name="phone" id="phone">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="education" class="col-md-2 col-form-label">Education</label>
                <div class="col-md-4">
                    <select class="form-select" aria-label="Education" name="education" id="education">
                        <option value="Bachelor of Information Technology">Bachelor of Information Technology</option>
                        <option value="Diploma in IT">Diploma in IT</option>
                        <option value="Bachelor of Computer Science">Bachelor of Computer Science</option>
    
                    </select>
                </div>
            </div>
            <fieldset class="row mb-4">
                <div class="col-md-2"></div>
                <legend class="col-form-label col-md-2 pt-0">Attend</legend>
    
                <div class="col-md-4">
                    <div class="form-check-inline col-md-2">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios1" value="option1">
                        <label class="form-check-label" for="gridRadios1">
                            PFC
                        </label>
                    </div>
                    <div class="form-check-inline col-md-2">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios2" value="option2">
                        <label class="form-check-label" for="gridRadios2">
                            JWD
                        </label>
                    </div>
                    <div class="form-check-inline col-md-2">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios2" value="option2">
                        <label class="form-check-label" for="gridRadios2">
                            PHP
                        </label>
                    </div>
                    <div class="form-check-inline col-md-2">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios1" value="option1">
                        <label class="form-check-label" for="gridRadios1">
                            OJT
                        </label>
                    </div>
    
    
                </div>
    
                <div class="col-md-6 offset-md-4 mt-4">
                    <div class="form-check-inline col-md-2">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios1" value="option1">
                        <label class="form-check-label" for="gridRadios1">
                            ASP.Net
                        </label>
                    </div>
    
                    <div class="form-check-inline col-md-2">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios2" value="option2">
                        <label class="form-check-label" for="gridRadios2">
                            Python
                        </label>
                    </div>
                    <div class="form-check-inline col-md-2">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios2" value="option2">
                        <label class="form-check-label" for="gridRadios2">
                            Android
                        </label>
                    </div>
    
                </div>
                <div class="col-md-6 offset-md-4 mt-4">
                    <div class="form-check-inline col-md-2">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios1" value="option1">
                        <label class="form-check-label" for="gridRadios1">
                            Python
                        </label>
                    </div>
    
                    <div class="form-check-inline col-md-2">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios2" value="option2">
                        <label class="form-check-label" for="gridRadios2">
                            JavaScript
                        </label>
                    </div>
                    <div class="form-check-inline col-md-3">
                        <input class="form-check-input" type="checkbox" name="attend" id="gridRadios2" value="option2">
                        <label class="form-check-label" for="gridRadios2">
                            React Native
                        </label>
                    </div>
    
                </div>
            </fieldset>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="name" class="col-md-2 col-form-label">Photo</label>
                <div class="col-md-4">
                    <input type="file" class="form-control" id="name">
                </div>
            </div>
    
            <div class="row mb-4">
                <div class="col-md-4"></div>
    
                <div class="col-md-4">
                    <input type="submit" value="Add" class="btn btn-secondary col-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal">
                </div>

    
            </div>
            </form>
    </div>
     
</div>
</div>

        <div id="testfooter">
            <span>Copyright &#169; ACE Inspiration 2022</span>
        </div>
        <script>
            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;
            
            for (i = 0; i < dropdown.length; i++) {
              dropdown[i].addEventListener("click", function() {
              this.classList.toggle("active");
              var dropdownContent = this.nextElementSibling;
              if (dropdownContent.style.display === "block") {
              dropdownContent.style.display = "none";
              } else {
              dropdownContent.style.display = "block";
              }
              });
            }
            </script>
 
</body>

</html>

