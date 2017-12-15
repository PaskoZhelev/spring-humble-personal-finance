	<%@ include file="common/header.jsp" %>
	
	<title>Humble - Personal Finance Application - Home</title>
<body class="topbar-unfix">


    <!-- Topbar -->
    <header class="topbar topbar-expand-lg topbar-secondary topbar-inverse">
      <div class="container">
        <div class="topbar-left">
          <span class="topbar-btn topbar-menu-toggler"><i>&#9776;</i></span>

          <div class="topbar-brand">
            <a href="home"><img src="img/humble-small-white2.png" alt="..."></a>
          </div>

          <div class="topbar-divider d-none d-md-block"></div>

          <nav class="topbar-navigation">
            <ul class="menu">

              <li class="menu-item active">
                <a class="menu-link" href="index.html">
                  <span class="title">Dashboard</span>
                </a>
              </li>

              <li class="menu-item">
                <a class="menu-link" href="category.html">
                  <span class="title">Category</span>
                </a>
              </li>

              <li class="menu-item">
                <a class="menu-link" href="ticket-list.html">
                  <span class="title">Tickets</span>
                </a>
              </li>

              <li class="menu-item">
                <a class="menu-link" href="forum-list.html">
                  <span class="title">Forums</span>
                </a>
              </li>

              <li class="menu-item">
                <a class="menu-link" href="article-list.html">
                  <span class="title">Articles</span>
                </a>
              </li>

            </ul>
          </nav>
        </div>


        <div class="topbar-right">

          <ul class="topbar-btns">
            <li class="dropdown">
              <span class="topbar-btn" data-toggle="dropdown"><img class="avatar" src="img/avatar/1.jpg" alt="..."></span>
              <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="#"><i class="ti-user"></i> Profile</a>
                <a class="dropdown-item" href="#"><i class="ti-settings"></i> Settings</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="#"><i class="ti-power-off"></i> Logout</a>
              </div>
            </li>


            <li>
				<span class="fs-14 fw-500 center-vh text-white" id="username">${user.username}</span>		
			</li>

          </ul>

        </div>
      </div>
    </header>
    <!-- END Topbar -->



    <!-- Main container -->
    <main>

    <div class="main-content">
       <div class="container">
        <div class="row gap-2">
			
            <div class="col-4">	
			
              <div class="card shadow-1">
                <h4 class="card-title text-dark"><strong>Balance</strong></h4>
                <div class="card-body">

                  <div class="text-center my-2">
                    <span id="balanceForFormat"><span id="currency">$ </span><span id="balance">${user.balance}</span></span>
                  </div>
                </div>

                <div class="progress mb-0">
                  <div class="progress-bar bg-success"  style="width: 100%; height: 5px;" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100"></div>
                </div>
              </div>

			  

			<div class="card shadow-1">
                <h4 class="card-title text-dark flexbox"><strong>Monthly Balance</strong><span class="fs-12 fw-600" style="color:#119b5d;padding-top:4px;" id="month">${currentMonth}<span>, </span><span id="year">${currentYear}</span></span></h4>
                <div class="card-body">
                  <div class="text-center my-2">
                    <span class="fs-16 fw-400 text-muted float-left">Income:</span><span class="fs-16 fw-600 text-success float-right" ><span id="currency">$ </span><span id="balance">${monthlyIncome}</span></span>
					<br />
					<span class="fs-16 fw-400 text-muted float-left">Expenses:</span><span class="fs-16 fw-600 text-danger float-right" id="balance"><span id="currency">$ </span>${monthlyExpense}</span>
                  </div>
                </div>				
            </div>	


						
            </div>
			
		 <div class="col-4">										
			<!--
          |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
          | Vertical bar chart 2
          |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
          !-->
            <div class="card">
              <h4 class="card-title"><strong>Monthly Income & Expenses</strong></h4>
              <div class="card-body" style="width:100%">
                <canvas id="chart-vbar-2" width="320" height="260" ></canvas>
              </div>
            </div>		
		 </div>

		<div class="col-4">
			<div class="card">
			 <h4 class="card-title"><strong>Expenses</strong> by Category</h4>

				<div class="card-body">
					<canvas class="mx-auto" id="chart-doughnut" width="260" height="260"></canvas>
				</div>
			</div>
		</div> 
		
	    </div>
			          <!--
          |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
          | Area chart 1
          |‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒‒
          !-->
	  <div class="row gap-2">  
        <div class="col-4">
			<div class="row gap-2">
				<div class="col-6">
				<button class="btn btn-lg btn-block btn-success">
				  <div class="flexbox">
					<span class="ti-plus fs-30"></span>
					<span class="fs-20 fw-500">Income</span>
				  </div>
				</button>
				</div>
				
				<div class="col-6">
				<button class="btn btn-lg btn-block btn-danger">
				  <div class="flexbox">
					<span class="ti-minus fs-30"></span>
					<span class="fs-20 fw-500">Expense</span>
				  </div>		
				</button>
				</div>
			</div>
		
		   <br/>

	        <div class="card">
	            <h4 class="card-title"><strong>Monthly Balance</strong> Chart</h4>
	              <div class="card-body">
	                <canvas id="chart-area-1" width="400" height="250"></canvas>
	              </div>
	        </div>

		</div>

		<!-- TABLE -->		
					
		<div class="col-8">
            <div class="card">
            <div class="card-header">
                <h5 class="card-title"><strong>Last Transactions</strong></h5>

                <div class="btn-group">
                  <button class="btn btn-light dropdown-toggle" type="button" data-toggle="dropdown">Dropdown</button>
                  <div class="dropdown-menu">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <a class="dropdown-item" href="#">Something else here</a>
                  </div>
                </div>
            </div>

              <div class="card-body bl-3 border-success flexbox flex-justified">
                <div>
                  <div class="fs-12 text-muted"><i class="ti-time mr-1"></i> 24 hours</div>
                  <div class="fs-18 text-success">+ $ 150.00</div>
                </div>

                <div>
                  <div class="fs-12 text-muted"><i class="ti-time mr-1"></i> 7 days</div>
                  <div class="fs-18 text-danger">- $ 343.34</div>
                </div>

                
              </div>

              <table class="table table-bordered" style="font-size:13px">
				<thead>
					<col width="130">
					<col width="80">
					<col width="80">
					<tr>              
						<th class="text-muted fw-600 w-80px" >Category</th>
						<th class="text-muted fw-600 w-80px">Date</th>
						<th class="text-muted fw-600 w-80px">Sum</th>
					</tr>
				</thead>
                <tbody>
                  <tr>              
                    <td><span class="badge badge-lg badge-warning">Merchandise</span>&nbsp;&nbsp;&nbsp;<span class="fs-12 text-muted">New T-Shirt</span></td>
					<td class="text-center fw-500 w-80px">27-11-2017</td>
                    <td class="text-success text-center fw-600 w-80px">+ $19</td>
                  </tr>

                  <tr>              
                    <td><span class="badge badge-lg badge-success">Food</span>&nbsp;&nbsp;&nbsp;<span class="fs-12 text-muted">New T-Shirt</span></td>
                    <td class="text-center fw-500 w-80px">27-11-2017</td>
                    <td class="text-success text-center fw-600 w-80px">+ $19</td>
                  </tr>

                  <tr>              
                    <td><span class="badge badge-lg badge-danger">Personal</span>&nbsp;&nbsp;&nbsp;<span class="fs-12 text-muted">New T-Shirt</span></td>
                    <td class="text-center fw-500 w-80px">27-11-2017</td>
                    <td class="text-success text-center fw-600 w-80px">+ $19</td>
                  </tr>

                  <tr>              
                    <td><span class="badge badge-lg badge-primary">Other</span>&nbsp;&nbsp;&nbsp;<span class="fs-12 text-muted">New T-Shirt</span></td>
                    <td class="text-center fw-500 w-80px">27-11-2017</td>
                    <td class="text-success text-center fw-600 w-80px">+ $19</td>
                  </tr>

                  <tr>              
                    <td><span class="badge badge-lg badge-success">Food</span>&nbsp;&nbsp;&nbsp;<span class="fs-12 text-muted">New T-Shirt</span></td>
                    <td class="text-center fw-500 w-80px">27-11-2017</td>
                    <td class="text-success text-center fw-600 w-80px">+ $19</td>
                  </tr>
                </tbody>
              </table>
            </div>
          </div>		
					
					
        </div>
       </div>
    </div>





      <!-- Footer -->
      <footer class="site-footer">
        <div class="container">
          <div class="row">
            <div class="col-md-6">
              <p class="text-center text-sm-left">Designed using <a href="http://thetheme.io/theadmin"><strong>TheAdmin</strong></a></p>
            </div>

            <div class="col-md-6">
              <ul class="nav nav-primary nav-dotted nav-dot-separated justify-content-center justify-content-md-end">
                <li class="nav-item">
                  <a class="nav-link" href="#">Help</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">About</a>
                </li>
                <li class="nav-item">
                  <a class="nav-link" href="#">Contact</a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </footer>
      <!-- END Footer -->


    </main>





    <!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->
    <!-- Quickviews -->


    <!-- Notifications -->
    <div id="qv-notifications" class="quickview">
      <header class="quickview-header quickview-header-lg">
        <h5 class="quickview-title">Notifications</h5>
        <span class="close"><i class="ti-close"></i></span>
      </header>

      <div class="quickview-body">
        <div class="media-list media-list-hover media-list-divided media-sm">
          <a class="media media-new" href="#">
            <span class="avatar bg-success"><i class="ti-user"></i></span>
            <div class="media-body">
              <p>New user registered</p>
              <time datetime="2017-07-14 20:00">Just now</time>
            </div>
          </a>

          <a class="media media-new" href="#">
            <span class="avatar bg-info"><i class="ti-shopping-cart"></i></span>
            <div class="media-body">
              <p>New order received</p>
              <time datetime="2017-07-14 20:00">2 min ago</time>
            </div>
          </a>

          <a class="media media-new" href="#">
            <span class="avatar bg-warning"><i class="ti-face-sad"></i></span>
            <div class="media-body">
              <p>Refund request from <b>Ashlyn Culotta</b></p>
              <time datetime="2017-07-14 20:00">24 min ago</time>
            </div>
          </a>

          <a class="media media-new" href="#">
            <span class="avatar bg-primary"><i class="ti-money"></i></span>
            <div class="media-body">
              <p>New payment has made through PayPal</p>
              <time datetime="2017-07-14 20:00">53 min ago</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-danger"><i class="ti-package"></i></span>
            <div class="media-body">
              <p>Package lost on the way!</p>
              <time datetime="2017-07-14 20:00">1 hour ago</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-success"><i class="ti-user"></i></span>
            <div class="media-body">
              <p>New user registered</p>
              <time datetime="2017-07-14 20:00">1 hour ago</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-purple"><i class="ti-comment"></i></span>
            <div class="media-body">
              <p>New review on <em>iPhone 6s</em></p>
              <time datetime="2017-07-14 20:00">3 hours ago</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-info"><i class="ti-shopping-cart"></i></span>
            <div class="media-body">
              <p>New order received</p>
              <time datetime="2017-07-14 20:00">5 hours ago</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-danger"><i class="fa fa-area-chart"></i></span>
            <div class="media-body">
              <p>CPU usage went above 80%</p>
              <time datetime="2017-07-14 20:00">Yesterday</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-yellow"><i class="fa fa-star"></i></span>
            <div class="media-body">
              <p>New rating on iPhone 6s, 5 star</p>
              <time datetime="2017-07-14 20:00">Yesterday</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-success"><i class="ti-user"></i></span>
            <div class="media-body">
              <p>New user registered</p>
              <time datetime="2017-07-14 20:00">Yesterday</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-primary"><i class="ti-money"></i></span>
            <div class="media-body">
              <p>New payment has made through PayPal</p>
              <time datetime="2017-07-14 20:00">2 days ago</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-info"><i class="ti-shopping-cart"></i></span>
            <div class="media-body">
              <p>New order received</p>
              <time datetime="2017-07-14 20:00">2 days ago</time>
            </div>
          </a>

          <a class="media" href="#">
            <span class="avatar bg-purple"><i class="ti-comment"></i></span>
            <div class="media-body">
              <p>New review on Samsung Galaxy S7</p>
              <time datetime="2017-07-14 20:00">Aug 17</time>
            </div>
          </a>
        </div>
      </div>

      <footer class="quickview-footer flexbox">
        <div>
          <a href="#">View full archive</a>
        </div>
        <div>
          <a href="#" data-provide="tooltip" title="Mark all as read"><i class="fa fa-circle-o"></i></a>
          <a href="#" data-provide="tooltip" title="Update"><i class="fa fa-repeat"></i></a>
          <a href="#" data-provide="tooltip" title="Settings"><i class="fa fa-gear"></i></a>
        </div>
      </footer>
    </div>



    <!-- END Quickviews -->
    <!--++++++++++++++++++++++++++++++++++++++++++++++++++++++++++-->



    <!-- Scripts -->
    <script src="js/core.min.js"></script>
    <script src="js/app.min.js"></script>
    <script src="js/script.js"></script>
    <script src="js/script.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.4.0/Chart.min.js"></script>
	<script>

		$.each($('#balanceForFormat'), function(){
		var price = $(this).html();
		$(this).html(price.replace(/(\D*)(\d*\.)(\d*)/,'<span class="fs-35 fw-800 text-success">$1</span><span class="fs-50 fw-800 text-success">$2</span><span class="fs-20 fw-800">$3</span>'));
		});

	</script>
	<script>
	      app.ready(function() {
		  app.ready(function() {

			new Chart($("#chart-doughnut"), {
          type: 'doughnut',

          // Data
          //
          data: {
            labels: [
              "Food",
			  "Merchandise",
			  "Other",
			  "Personal",
			  "Restaurant",
			  "Transport",
            ],
            datasets: [
              {
                data: [300, 50, 300, 50, 100, 300],
                backgroundColor: [
                  '#15c377',
                  '#faa64b',				  
                  '#33cabb',
				  '#f96868',
                  '#926dde',
				  '#8d6658',
                  
                  
                ]
              }]
          },

          // Options
          //
          options: {
            responsive: false
          }
        });
		
		
		
		    // ==============================================
        // Vertical bar chart 2
        //
        new Chart($("#chart-vbar-2"), {
          type: 'bar',

          // Data
          //
          data: {
          labels: ["January", "February", "March", "April", "May"],
            datasets: [
              {
                label: "Income",
                backgroundColor: "#15C377",
                borderColor: "rgba(0,0,0,0)",
                hoverBackgroundColor: "#11a060",
                hoverBorderColor: "rgba(0,0,0,0)",
                data: [20, 59, 80, 58, 20]
              },
              {
                label: "Expenses",
                backgroundColor: "#d6dbd8",
                borderColor: "rgba(0,0,0,0)",
                hoverBackgroundColor: "#c7c8c9",
                hoverBorderColor: "rgba(0,0,0,0)",
                data: [28, 48, 40, 19, 86]
              }
            ]
          },

          // Options
          //
          options: {
			responsive: false
			
          }
        });
		
		// ==============================================
        // Area chart 1
        //
        new Chart($("#chart-area-1"), {
          type: 'line',

          // Data
          //
          data: {
            labels: ["January", "February", "March", "April", "May", "June", "July"],
            datasets: [
              {
                label: "Revenue",
                backgroundColor: "rgba(21,195,119,0.7)",
                borderWidth: 0,
                borderColor: "rgba(0,0,0,0)",
                data: [0, 59, 80, 58, 20, 55, 40]
              }
            ]
          },

          // Options
          //
          options: {
            legend: {
              display: false
            },
          }
        });
		
		  
		  });
	});
	</script>
	
    </body>
</html>