$(document).ready(function () {


    function addData() {

        $.post("/Main/AddRecipe", { name: document.forms["crudForm"]["name"].value, category: document.forms["crudForm"]["category"].value },
            function (data, status) {
                if (data == 'success') {
                    $(location).attr("href", "http://localhost:52536/Main/RecipiesManager");
                } else {
                    alert("failed");
                }
            });
    }

    function delData() {

        $.post("/Main/DelRecipe", { name: document.forms["crudForm"]["name"].value, category: document.forms["crudForm"]["category"].value },
            function (data, status) {
                if (data == 'success') {
                    $(location).attr("href", "http://localhost:52536/Main/RecipiesManager");
                } else {
                    alert("failed");
                }
            });
    }

    $("#del-button").click(() => {
        try {
            delData();
        } catch (e) {
            alert(e)
        }
    });

    $("#add-button").click(() => {
        try {
            addData();
        } catch (e) {
            alert(e)
        }
    });


});