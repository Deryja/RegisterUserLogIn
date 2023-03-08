
//Step 1
function login() {
    const Bruker = {
        brukernavn: $("#brukernavn").val(),
        passord: $("#passord").val()
    }

    $("#loggInn").html("Loading...");

    $.get("/login", Bruker, function(data) {
        if(data) {
            window.location.href = "index.html";
        } else {
            $("#feilLogin").html("Du må logge inn");
        }
    }).fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilLogin").html(json.message);
        $("#loggInn").html("Logg inn");
    });
}



//For å hoppe til opprett bruker hvis man vil
function byttTilOpprett() {
    window.location.href = "opprett.html";
}
