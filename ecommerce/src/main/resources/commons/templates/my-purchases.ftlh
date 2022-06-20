<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="${lang}">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<#include "/includes/head.shtml" parse=true>
	</head>

	<body class="my-purchases bg-light d-flex flex-column vh-100">
		<main class="flex-shrink-0">
		    <#include "/includes/navbar.shtml" parse=true>

            <!-- Page Content-->
            <section class="bg-light py-5">
				<div class="container px-5">
					<div class="row gx-5">
						<h2 class="fw-bolder mb-3"><@spring.message "my-purchases.main.title"/>, ${(profile.name)!""}</h2>
						<span class="fw-bolder mb-5"><@spring.message "my-purchases.main.subtitle"/></span>

						<div class="col-12 user-menu">
							<a class="btn btn-light" href="/${lang}/user-area/my-data" role="button"><span class="fw-bolder"><@spring.message "my-purchases.menu.my-data"/></span></a>
							<a class="btn btn-light active" href="/${lang}/user-area/my-purchases" role="button"><span class="fw-bolder"><@spring.message "my-purchases.menu.my-purchases"/></span></a>
						</div>

						<hr/>

						<div class="col-12 mb-5 mb-lg-0">
							<!-- Purchase cards -->
							<#include "/modules/my-purchases/purchase-card.shtml" parse=true>
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
