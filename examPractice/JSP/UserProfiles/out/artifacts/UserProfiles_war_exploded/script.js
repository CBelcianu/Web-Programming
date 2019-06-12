function toRegister() {
    window.location="http://localhost:8080/register.html";
}

function updProf() {
    $.ajax({
        url: "http://localhost:8080/ProfileController",
        type: "GET",
        data: {
            "username": document.getElementById("inputUsername").value,
            "password": document.getElementById("inputPassword").value,
            "email": document.getElementById("inputEmail").value,
            "town": document.getElementById("inputUsername").value
        },
        success: function() {

        }
    });
}