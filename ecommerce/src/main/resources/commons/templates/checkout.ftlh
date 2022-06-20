<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="${lang}">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<#include "/includes/head.shtml" parse=true>
	</head>

	<body class="checkout bg-light d-flex flex-column vh-100">
		<main class="flex-shrink-0">
		    <#include "/includes/navbar.shtml" parse=true>

            <!-- Page Content-->
            <section class="bg-light py-5">
				<form action="/${lang}/pay" method="POST">
					<div class="container px-5">
						<div class="row gx-5">
							<h2 class="fw-bolder mb-3"><@spring.message "checkout.main.title"/></h2>
							<span class="fw-bolder mb-5"><@spring.message "checkout.main.billing"/></span>

							<div class="col-xl-7 mb-5 mb-lg-0">
								<!-- Checkout data -->
								<#include "/modules/checkout/order-data.shtml" parse=true>

								<!-- Checkout consents -->
								<#include "/modules/checkout/order-consents.shtml" parse=true>

								<!-- Payment methods -->
								<#include "/modules/checkout/order-payments.shtml" parse=true>
							</div>

							<!-- Order detail -->
							<div class="col-xl-5 mb-5 mb-lg-0">
								<#include "/modules/checkout/order-detail.shtml" parse=true>
							</div>
						</div>
					</div>
				</form>
            </section>
        </main>

		<#include "/includes/modals.shtml" parse=true>
		<#include "/includes/footer.shtml" parse=true>
		<#include "/includes/script.shtml" parse=true>
    </body>
</html>
