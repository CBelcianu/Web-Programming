$(document).ready(function () {


    function addData() {

        $.post("/Main/AddReport", { type: document.forms["crudForm"]["type"].value, severity: document.forms["crudForm"]["severity"].value },
            function (data, status) {
                if (data == 'success') {
                    $(location).attr("href", "http://localhost:50991/Main/Application");
                } else {
                    alert("failed");
                }
            });
    }

    function delData() {

        $.post("/Main/DelReport", { type: document.forms["crudForm"]["type"].value, severity: document.forms["crudForm"]["severity"].value },
            function (data, status) {
                if (data == 'success') {
                    $(location).attr("href", "http://localhost:50991/Main/Application");
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