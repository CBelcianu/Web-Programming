$(document).ready(function () {


    function loginData(start, end) {

        $.post("/Main/ValidateData", { username: document.forms["loginForm"]["username"].value, password: document.forms["loginForm"]["password"].value },
            function (data, status) {
                if (data == 'success') {
                    $(location).attr("href", "http://localhost:50991/Main/Application");
                } else {
                    alert("Incroect user");
                }
            });
    }

    $("#login-button").click(() => {
        try {
            loginData();
        } catch (e) {
            alert(e)
        }
    });


});