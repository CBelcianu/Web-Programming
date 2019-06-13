$(document).ready(function () {


    function loginData(start, end) {

        $.post("/Main/ValidateData", { username: document.forms["customSearchForm"]["username"].value, password: document.forms["customSearchForm"]["password"].value },
            function (data, status) {
                if (data == 'success') {
                    $(location).attr("href", "https://localhost:44347/Main");
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