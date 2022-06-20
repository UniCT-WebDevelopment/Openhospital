<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="${lang}">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<#include "/includes/head.shtml" parse=true>
	</head>

	<body class="thank-you bg-light d-flex flex-column vh-100">
		<main class="flex-shrink-0">
		    <#include "/includes/navbar.shtml" parse=true>

            <!-- Page Content-->
            <section class="bg-light py-5">
                <div class="container px-5">
                    <div class="row gx-5">
                        <div class="col-lg-3 mb-5">
                            <picture>
                                <img class="img-fluid" src="/assets/pexels-photo-7430715.jpg" alt="Thank you image">
                            </picture>
                        </div>
                        <div class="col-lg-9 mb-5 align-self-center">
                            <h2 class="fw-bolder mb-3"><@spring.message "thank-you.main.title" /></h2>
                            <span class="fw-bolder mb-5"><@spring.message "thank-you.main.subtitle" /></span>

                        </div>
                    </div>

                    <div class="row gx-5">
                        <!-- Order products -->
                        <div class="col-xl-6 mb-5 mb-lg-0">
		                    <#include "/modules/thank-you/order-detail.shtml" parse=true>
                        </div>

                        <!-- Order data -->
                        <div class="col-xl-6 mb-5 mb-lg-0">
                            <#include "/modules/thank-you/order-data.shtml" parse=true>
                        </div>

                    </div>
                </div>
            </section>
        </main>

		<#include "/includes/modals.shtml" parse=true>
		<#include "/includes/footer.shtml" parse=true>
		<#include "/includes/script.shtml" parse=true>
    </body>
</html>
