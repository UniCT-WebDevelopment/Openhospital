<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="${lang}">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<#include "/includes/head.shtml" parse=true>
	</head>

	<body class="cart bg-light d-flex flex-column vh-100">
		<main class="flex-shrink-0">
		    <#include "/includes/navbar.shtml" parse=true>

            <!-- Page Content-->
			<section class="bg-light py-5 cart">
				<div class="container px-5">
					<div class="row justify-content-center">
						<#if cart.getTotalElements() == 0>
							<#include "/modules/cart/cart-empty-main.shtml" parse=true>
						<#else>
							<#include "/modules/cart/cart-main.shtml" parse=true>
						</#if>
					</div>
				</div>
			</section>
        </main>

		<#include "/includes/modals.shtml" parse=true>
		<#include "/includes/footer.shtml" parse=true>
		<#include "/includes/script.shtml" parse=true>
    </body>
</html>
