Reveal.addEventListener( 'slidechanged', function( event ) {
    $(event.previousSlide).find("pre").each((i, x) => {
        let codeContainer = $(x)
        if(codeContainer.hasClass("maximized")){
            codeContainer.removeClass("maximized");
        }
    });
});
$(document).on("keypress", function (e) {
    let tild = 96;
    if(e.which != tild){
        return;
    }
    
    let currentSlide = Reveal.getCurrentSlide();
    $(currentSlide).find("pre").each((i, x) => {
        let codeContainer = $(x)
        if(codeContainer.hasClass("maximized")){
            codeContainer.removeClass("maximized");
        } else {
            codeContainer.addClass("maximized");
        }
    });
});
