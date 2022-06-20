var lang = document.getElementsByTagName('html')[0].getAttribute('lang');

//Switch language by alternate url
let alternateUrls = document.querySelectorAll('link[rel="alternate"]');

alternateUrls.forEach(alternateUrl => {
    if (alternateUrl.hreflang !== lang) {
        let baseSwitchLangID = "switch-lang-";
        let switchLangItem = document.getElementById(baseSwitchLangID + alternateUrl.hreflang);
        switchLangItem.setAttribute('href', alternateUrl.href);
    }
});


$('.datepicker-container input').datepicker({
    todayBtn: "linked",
    todayHighlight: true,
    language: lang,
    format: "dd/mm/yyyy",
    startDate: '0d',
    orientation: "bottom left"
});