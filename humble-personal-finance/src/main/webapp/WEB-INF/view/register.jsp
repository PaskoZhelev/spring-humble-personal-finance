
<%@ include file="common/header.jsp"%>

    <div class="row no-gutters min-h-fullscreen bg-white">
      <div class="col-md-6 col-lg-7 col-xl-8 d-none d-md-block bg-img" style="background-image: url(img/gallery/register-background.jpg)" data-overlay="5">

        <div class="row h-100 pl-50">
          <div class="col-md-10 col-lg-8 align-self-end">
            <img src="img/logo-light-lg.png" alt="...">
            <br><br><br>
            <h4 class="text-white">The admin is the best admin framework available online.</h4>
            <p class="text-white">Credibly transition sticky users after backward-compatible web services. Compellingly strategize team building interfaces.</p>
            <br><br>
          </div>
        </div>

      </div>



      <div class="col-md-6 col-lg-5 col-xl-4 align-self-center">
        <div class="px-80 py-30">
          <h4>Register an account</h4>
          <p><small>All fields are required.</small></p>
          <br>
		<form:form class="form-type-material" method="POST" action="register" modelAttribute="newUserForm">
            <div class="form-group">             
			  <form:label path="username">Username</form:label>
			  <form:input class="form-control" path="username" cssErrorClass="form-control is-invalid"/>
			  <form:errors cssClass="invalid-feedback" path="username"  />
            </div>

            <div class="form-group">             
			  <form:label path="password">Password</form:label>
			  <form:password class="form-control" path="password" cssErrorClass="form-control is-invalid"/>
			  <form:errors cssClass="invalid-feedback" path="password"  />
            </div>

            <div class="form-group">
              <form:label path="email">Email</form:label>
			  <form:input type="email" class="form-control" path="email" cssErrorClass="form-control is-invalid"/>
			  <form:errors cssClass="invalid-feedback" path="email"  />
            </div>

            <div class="form-group">
              <form:label path="ammount">Initial Balance</form:label>
			  <form:input type="number" class="form-control" path="ammount" cssErrorClass="form-control is-invalid"/>
			  <form:errors cssClass="invalid-feedback" path="ammount"  />
            </div>

            <div class="form-group">
              <label class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input">
                <span class="custom-control-indicator"></span>
                <span class="custom-control-description">I agree to all <a class="text-primary" href="#">terms</a></span>
              </label>
            </div>

            <br>
            <button class="btn btn-bold btn-block btn-primary" type="submit">Register</button>
          </form:form>

          <hr class="w-30px">

          <p class="text-center text-muted fs-13 mt-20">Already have an account? <a class="text-primary fw-500" href="#">Sign in</a></p>
        </div>
      </div>
    </div>




<form:form method="POST" action="register" modelAttribute="newUserForm">
	<table>
		<tr>
			<td><form:errors path="username"  /></td>
			<td><form:label path="username">Username</form:label></td>
			<td><form:input path="username" /></td>
		</tr>
		<tr>
			<td><form:errors path="password"  /></td>
			<td><form:label path="password">Password</form:label></td>
			<td><form:password path="password" /></td>
		</tr>
		<tr>
			<td><form:errors path="username"  /></td>
			<td><form:label path="email">Email</form:label></td>
			<td><form:input path="email" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>

<%@ include file="common/footer.jsp"%>