

//Step 2
function opprett() {
    const Bruker = {
        brukernavn: $("#brukernavn").val(),
        passord: $("#passord").val()
    }

    $("#opprett").html('Loading...')

    $.post("/opprettBruker", Bruker, function(data) {
        if(data) {
            window.location.href = "login.html";
        }
    }).fail(function(jqXHR) {
        const json = $.parseJSON(jqXHR.responseText);
        $("#feilOpprett").html(json.message);
        $("#opprett").html('opprett');
    });
}