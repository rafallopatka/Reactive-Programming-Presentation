$("code")
.filter((i, x) => {
    return x.hasAttribute("data-include")
})	
.map((i, x) => {
    return {
        element: x,
        file: x.getAttribute("data-include")
    }
})
.map((i, x) => {
    fetch(x.file)
        .then((response) => {
            if (response.status !== 200) {
                console.log('Looks like there was a problem. Status Code: ' +
                response.status);
                return;
            }

            response.text().then((text) => {
                var escapedText = text.replace(/</gi, "&lt");
                escapedText = escapedText.replace(/>/gi, "&gt");
                x.element.innerHTML = escapedText;
            });
    });
});