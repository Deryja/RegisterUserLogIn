

function HoppTilLogin() {
    window.location.href = "login.html";
}






//Når det gjelder funksjonen som tar inn API fra Controller om å remove sessionAttribute, så er det kun hvis man vil at
//Man innenfor samme index.html fil på nettsiden får status om innlogging, og når man trykker på logg ut, så gjør man en
//reload i funksjonen her i Javascript som gir status om at man ikke er logget inn.

//Hvis man derimot vil at ingen kan kunne se index.html med mindre man er logget inn, så trenger man ikke det, da trenger
//Man bare en enkel funksjon her i Javascript som endrer location når man trykker på knappen.
//For å gå tilbake til index.html igjen etter å ha trukket på logg ut og endra location til login.html, så må man uansett
//Taste inn riktig brukernavn og passord for å kunne logge inn og endre location til index.html igjen


function logout() {
    window.location.href = "opprett.html";
}



