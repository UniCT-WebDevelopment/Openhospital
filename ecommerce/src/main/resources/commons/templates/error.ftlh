<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="${lang}">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<#include "/includes/head.shtml" parse=true>
	</head>

	<body class="error bg-light d-flex flex-column vh-100">
		<main class="flex-shrink-0">
		    <#include "/includes/navbar.shtml" parse=true>

            <!-- Page Content-->
			<section class="bg-light py-5 cart">
				<div class="container px-5">
					<div class="row justify-content-center">
						<div class="col-9">
							<!-- Add something -->
							<picture>
								<img class="img-fluid" src="/assets/pexels-alleksana-4271937.jpg" alt="Error image" style="width:auto;">
							</picture>
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
