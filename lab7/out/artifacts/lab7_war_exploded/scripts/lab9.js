var getPuzzleUrl = '/puzzle';

$(document).ready(function(){
    var prevId = null;
    $('.puzzlepiece').click(function() {
        var id = $(this).attr("id");
        if(prevId == null) {
            prevId = id;
            $("#selected").attr("src", "img/" + id + ".jpeg");
            return ;
        }
        else {
            $.ajax({
                url: getPuzzleUrl,
                type: "PUT",
                data: {
                    "id1": id,
                    "id2": prevId
                },
                success: function() {
                    window.location = window.location.pathname;
                }
            });
            $("#selected").removeAttr("src");
            prevId = null;
        }
    });
    $("#selected").click(function() {
        prevId = null;
        $(this).removeAttr("src");
    });
});