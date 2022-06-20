<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="${lang}">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>

		<#include "/includes/head.shtml" parse=true>
	</head>

	<body class="bg-light d-flex flex-column vh-100">
		<main class="flex-shrink-0">
		    <#include "/includes/navbar.shtml" parse=true>
		</main>
        <#if requestBody.productType == "health">
            <#include "/modules/serp/serp-main-health.shtml" parse=true>
        <#elseif requestBody.productType == "doctor">
            <#include "/modules/serp/serp-main-doctor.shtml" parse=true>
        <#else>
            <#include "modules/serp/serp-main-error.shtml" parse=true>
        </#if>

		<#include "/includes/modals.shtml" parse=true>
		<#include "/includes/footer.shtml" parse=true>
		<#include "/includes/script.shtml" parse=true>
	</body>
</html>
