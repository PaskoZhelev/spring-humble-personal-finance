
<%@ include file="common/header.jsp"%>
<body>
    <div class="row no-gutters min-h-fullscreen bg-white">
      <div class="col-md-6 col-lg-7 col-xl-8 d-none d-md-block bg-img" style="background-image: url(img/gallery/register-background.jpg)" data-overlay="5">

        <div class="row h-100 pl-50">
          <div class="col-md-10 col-lg-8 align-self-end">
            <img src="img/humble-small-white.png" alt="...">
            <br><br><br>
            <h4 class="text-white">Humble is the personal finance application that you need.</h4>
            <p class="text-white">Track your expenses and incomes easily.</p>
            <br><br>
          </div>
        </div>

      </div>



      <div class="col-md-6 col-lg-5 col-xl-4 align-self-center">
        <div class="px-80 py-30">
          <h3>Register an account</h3>
          <p><small>All fields are required.</small></p>
          <br>
		<form:form class="form-type-material" method="POST" action="register" modelAttribute="newUserForm">
            <div class="form-group">             
			  <form:label path="username">Username</form:label>
			  <form:input class="form-control" path="username" cssErrorClass="form-control is-invalid"  required="required"/>
			  <form:errors cssClass="invalid-feedback" path="username"  />
            </div>

            <div class="form-group">             
			  <form:label path="password">Password</form:label>
			  <form:password class="form-control" path="password" cssErrorClass="form-control is-invalid" required="required"/>
			  <form:errors cssClass="invalid-feedback" path="password"  />
            </div>

            <div class="form-group">
              <form:label path="email">Email</form:label>
			  <form:input type="email" class="form-control" path="email" cssErrorClass="form-control is-invalid" required="required"/>
			  <form:errors cssClass="invalid-feedback" path="email"  />
            </div>

            <div class="form-group">
              <form:label path="ammount">Initial Balance</form:label>
			  <form:input type="number" class="form-control" path="ammount" cssErrorClass="form-control is-invalid" required="required"/>
			  <form:errors cssClass="invalid-feedback" path="ammount"  />
            </div>

			<div class="form-group">
			<form:label path="currency">Currency</form:label>
			<form:select class="form-control" path="currency" required="required">
  				 <form:option value="1" label="US Dollar"/>
  				 <form:option value="2" label="Euro"/>
  				 <form:option value="3" label="British Pound"/>
  				 <form:option value="4" label="Canadian Dollar"/>	
  				 <form:option value="5" label="Chinese Yuan"/>	
  				 <form:option value="6" label="Japanese Yen"/>	
  				 <form:option value="7" label="Swiss Frank"/>	
  				 <form:option value="8" label="Indian Rupee"/>	
  				 <form:option value="9" label="Russian Ruble"/>
  				 <form:option value="10" label="Bulgarian Lev"/>						 
			</form:select>
			</div>				

			 <c:if test="${not empty usernameExists}">
      			  <div class="alert alert-danger" role="alert">
                  	<h6>This <strong>username</strong> already exists!</h6>
                </div>
    		</c:if>

            <br>
            <button class="btn btn-bold btn-block btn-primary" type="submit">Register</button>
          </form:form>

          <hr class="w-30px">

          <p class="text-center text-muted fs-13 mt-20">Already have an account? <a class="text-primary fw-500" href="login-page">Sign in</a></p>
        </div>
      </div>
    </div>


<%@ include file="common/footer.jsp"%>