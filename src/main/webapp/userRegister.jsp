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
    
        <title>User Registration</title>
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
    
    <div class="container">
    <div class="sidenav">
        
        <button class="dropdown-btn" > Class Management <i class="fa fa-caret-down"></i></button>
        
            <div class="dropdown-container">
          <a href="CourseCreateController">Course Registration </a>
          <a href="StudentCreateController">Student Registration </a>
          <a href="StudentViewController">Student Search </a>
        </div>
        <a href="UserViewController">Users Management</a>
      </div>
      <div class="main_contents">
    <div id="sub_content">
    <div style="color: red;">${createFail}</div>
        <form action="UserCreateController" method="post">
			
            <h2 class="col-md-6 offset-md-2 mb-5 mt-4">User Registration</h2>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="email" class="col-md-2 col-form-label">Email</label>
                <div class="col-md-4">
                    <input type="email" class="form-control" id="email" name="email">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="Passowrd" class="col-md-2 col-form-label">Password</label>
                <div class="col-md-4">
                    <input type="password" class="form-control" id="name" name="password">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="confirmPassword" class="col-md-2 col-form-label">Confirm Password</label>
                <div class="col-md-4">
                    <input type="password" class="form-control" id="confirmPassword" name="confirmPassword">
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-2"></div>
                <label for="userRole" class="col-md-2 col-form-label">User Role</label>
                <div class="col-md-4">
                    <select class="form-select" aria-label="Education" id="userRole" disabled>
                        <option selected>Need to update</option>
                        <option>Admin</option>
                        <option value="1">User</option>
    					
    
                    </select>
                </div>
            </div>
            <div class="row mb-4">
                <div class="col-md-4"></div>
    
                <div class="col-md-6">
                   
    
                    <button type="submit" class="btn btn-secondary col-md-2" data-bs-toggle="modal" data-bs-target="#exampleModal">Add</button>
                    
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

    
