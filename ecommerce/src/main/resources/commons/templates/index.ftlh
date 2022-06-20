<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="${lang}">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<#include "/includes/head.shtml" parse=true>
	</head>

	<body class="d-flex flex-column h-100">
		<main class="flex-shrink-0">
			<#include "/includes/navbar.shtml" parse=true>
		    <#include "/includes/header.shtml" parse=true>
		</main>

		<!-- Widget Tabs -->
		<#include "/modules/widget/widget.shtml" parse=true>

		<!-- Features section-->
		<section class="py-5" id="features">
			<div class="container px-5 my-5">
				<div class="row gx-5">
					<div class="col-lg-4 mb-5 mb-lg-0"><h2 class="fw-bolder mb-0"><@spring.message "hp.features.title" /></h2></div>
					<div class="col-lg-8">
						<div class="row gx-5 row-cols-1 row-cols-md-2">
							<div class="col mb-5 h-100">
								<div class="row">
									<div class="col-4 col-sm-3 col-md-12">
										<div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-alarm"></i></div>
									</div>
									<div class="col-8 col-sm-9 col-md-12">
										<h2 class="h5"><@spring.message "hp.features.time.title" /></h2>
										<p class="mb-0"><@spring.message "hp.features.time.description" /></p>
									</div>
								</div>
							</div>
							<div class="col mb-5 h-100">
								<div class="row">
									<div class="col-4 col-sm-3 col-md-12">
										<div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-wallet2"></i></div>
									</div>
									<div class="col-8 col-sm-9 col-md-12">
										<h2 class="h5"><@spring.message "hp.features.money.title" /></h2>
										<p class="mb-0"><@spring.message "hp.features.money.description" /></p>
									</div>
								</div>
							</div>
							<div class="col mb-5 h-100">
								<div class="row">
									<div class="col-4 col-sm-3 col-md-12">
										<div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-calendar-date"></i></div>
									</div>
									<div class="col-8 col-sm-9 col-md-12">
										<h2 class="h5"><@spring.message "hp.features.date.title" /></h2>
										<p class="mb-0"><@spring.message "hp.features.date.description" /></p>
									</div>
								</div>
							</div>
							<div class="col mb-5 h-100">
								<div class="row">
									<div class="col-4 col-sm-3 col-md-12">
										<div class="feature bg-primary bg-gradient text-white rounded-3 mb-3"><i class="bi bi-search"></i></div>
									</div>
									<div class="col-8 col-sm-9 col-md-12">
										<h2 class="h5"><@spring.message "hp.features.search.title" /></h2>
										<p class="mb-0"><@spring.message "hp.features.search.description" /></p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<!-- Testimonial section-->
		<div class="py-5 bg-light">
			<div class="container px-5 my-5">
				<div class="row gx-5 justify-content-center">
					<div class="col-lg-10 col-xl-7">
						<div class="text-center">
							<div class="fs-4 mb-4 fst-italic">"Working with Start Bootstrap templates has saved me tons of development time when building new projects! Starting with a Bootstrap template just makes things easier!"</div>
							<div class="d-flex align-items-center justify-content-center">
								<img class="rounded-circle me-3" src="https://dummyimage.com/40x40/ced4da/6c757d" alt="..." />
								<div class="fw-bold">
									Tom Ato
									<span class="fw-bold text-primary mx-1">/</span>
									CEO, Pomodoro
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Blog preview section-->
		<section class="py-5" id="blog">
			<div class="container px-5 my-5">
				<div class="row gx-5 justify-content-center">
					<div class="col-lg-8 col-xl-6">
						<div class="text-center">
							<h2 class="fw-bolder"><@spring.message "hp.blog.title" /></h2>
							<p class="lead fw-normal text-muted mb-5"><@spring.message "hp.blog.subtitle" /></p>
						</div>
					</div>
				</div>

				<#include "/modules/index/news.shtml" parse=true>
				<#include "/modules/index/call-to-action.shtml" parse=true>
			</div>
		</section>

		<#include "/includes/modals.shtml" parse=true>
		<#include "/includes/footer.shtml" parse=true>
		<#include "/includes/script.shtml" parse=true>
	</body>
</html>
