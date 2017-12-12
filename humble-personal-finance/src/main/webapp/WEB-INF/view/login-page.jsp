  	<%@ include file="common/header.jsp" %>
 <body>
    <div class="row no-gutters min-h-fullscreen bg-white">
      <div class="col-md-6 col-lg-7 col-xl-8 d-none d-md-block bg-img" style="background-image: url(img/gallery/login-background.jpg)" data-overlay="5">

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
          <h3>Login</h3>
          <p><small>Sign into your account</small></p>
          <br>

          <form:form class="form-type-material" method="POST" action="login-page" modelAttribute="loginUserForm">
          <c:if test="${param.error ne null}">
      			  <div class="alert alert-danger" role="alert">
                  	<h6>Username or password is incorrect</h6>
                </div>
    	  </c:if>

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

            <div class="form-group flexbox">
              <label class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" checked>
                <span class="custom-control-indicator"></span>
                <span class="custom-control-description">Remember me</span>
              </label>

              <!--  <a class="text-muted hover-primary fs-13" href="#">Forgot password?</a>-->
            </div>

            <div class="form-group">
              <button class="btn btn-bold btn-block btn-success" type="submit">Login</button>
            </div>
          </form:form>

          <hr>

          <p class="text-center text-muted fs-13 mt-20">Don't have an account? <a class="text-primary fw-500" href="register" />Sign up</a></p>
        </div>
      </div>
    </div>
    
	<%@ include file="common/footer.jsp" %>