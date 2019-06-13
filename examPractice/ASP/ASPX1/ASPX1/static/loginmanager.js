$(document).ready(function () {


    function loginData(start, end) {

        $.post("/Main/ValidateData", { username: document.forms["customSearchForm"]["username"].value, password: document.forms["customSearchForm"]["password"].value },
            function (data, status) {
                if (data == 'success') {
                    $(location).attr("href", "http://localhost:52536/Main/Application");
                } else {
                    alert("Incroect user");
                }
            });
    }

    $("#search-button").click(() => {
        try {
            loginData();
        } catch (e) {
            alert(e)
        }
    });


});