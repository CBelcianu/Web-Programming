$(document).ready(function () {
    $('#dialog').hide();
    $('#closebtn').click(function () {
        $('#dialog').hide();
    });
    $('#opener').click(function () {
        $('#dialog').show();
    });
});

$(document).ready(function () {
    var divid = $('#dialog').get(0);
    var move = function(divid,xpos, ypos){
        divid.style.left = xpos + 'px';
        divid.style.top = ypos + 'px';
    };
    $('#dialog').mousedown( () => {
        $(document).unbind('mousemove');
        evt = window.event;
        var posX = evt.clientX, posY = evt.clientY, divTop = divid.style.top, divLeft = divid.style.left,
            eWi = parseInt(divid.style.width), eHe = parseInt(divid.style.height),
            cWi = parseInt($('#dialog').get(0).style.width), cHe = parseInt($('#dialog').get(0).style.height);
        $('#dialog').get(0).style.cursor='move';
        divTop = divTop.replace('px','');
        divLeft = divLeft.replace('px','');
        var diffX = posX - divLeft, diffY = posY - divTop;
        $(document).mousemove( (evt) =>{
            evt = evt || window.event;
            var posX = evt.clientX,
                posY = evt.clientY,
                aX = posX - diffX,
                aY = posY - diffY;
                if (aX < 0) aX = 0;
                if (aY < 0) aY = 0;
                if (aX + eWi > cWi) aX = cWi - eWi;
                if (aY + eHe > cHe) aY = cHe -eHe;
            move(divid,aX,aY);
        });
    });
    $('#dialog').mouseup( () => {
        //var a = document.createElement('script');
        $(document).unbind('mousemove');
        $('#dialog').get(0).style.cursor='default';
        $(document).mousemove( () => {});
    });
});