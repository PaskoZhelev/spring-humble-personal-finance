  	<%@ include file="common/header.jsp" %>
 
    <div class="row no-gutters min-h-fullscreen bg-white">
      <div class="col-md-6 col-lg-7 col-xl-8 d-none d-md-block bg-img" style="background-image: url(img/gallery/login-background.jpg)" data-overlay="5">

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
          <h4>Login</h4>
          <p><small>Sign into your account</small></p>
          <br>

          <form class="form-type-material">
            <div class="form-group">
              <input type="text" class="form-control" id="username">
              <label for="username">Username</label>
            </div>

            <div class="form-group">
              <input type="password" class="form-control" id="password">
              <label for="password">Password</label>
            </div>

            <div class="form-group flexbox">
              <label class="custom-control custom-checkbox">
                <input type="checkbox" class="custom-control-input" checked>
                <span class="custom-control-indicator"></span>
                <span class="custom-control-description">Remember me</span>
              </label>

              <a class="text-muted hover-primary fs-13" href="#">Forgot password?</a>
            </div>

            <div class="form-group">
              <button class="btn btn-bold btn-block btn-primary" type="submit">Login</button>
            </div>
          </form>

          <div class="divider">Or Sign In With</div>
          <div class="text-center">
            <a class="btn btn-square btn-facebook" href="#"><i class="fa fa-facebook"></i></a>
            <a class="btn btn-square btn-google" href="#"><i class="fa fa-google"></i></a>
            <a class="btn btn-square btn-twitter" href="#"><i class="fa fa-twitter"></i></a>
          </div>

          <hr class="w-30px">

          <p class="text-center text-muted fs-13 mt-20">Don't have an account? <a class="text-primary fw-500" href="register" />Sign up</a></p>
        </div>
      </div>
    </div>
    
	<%@ include file="common/footer.jsp" %>