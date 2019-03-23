function foo(clickedDiv){
    var myDiv = document.getElementById(clickedDiv);
    var htmlstring = myDiv.innerHTML;
    htmlstring = (htmlstring.trim) ? htmlstring.trim() : htmlstring.replace(/^\s+|\s+$/, '');
    if(htmlstring == 'O') {
        myDiv.innerHTML = 'O';
    }
    else if(htmlstring == 'X'){
        myDiv.innerHTML = 'X';
    }
    else{
        myDiv.innerHTML = 'X';
        if(!isWon()){
            think();
            isWon();
        }
    }
}

function think(){
    var arr = document.getElementsByName("box");
    for(i=0; i<arr.length; i++){
        var htmlstring = arr[i].innerHTML;
        htmlstring = (htmlstring.trim) ? htmlstring.trim() : htmlstring.replace(/^\s+|\s+$/, '');
        if(htmlstring == ''){
            arr[i].innerHTML = 'O';
            break;
        }
    }
}

function isWon(){
    var arr = document.getElementsByName("box");
    htmlstring0 = (arr[0].innerHTML.trim) ? arr[0].innerHTML.trim() : arr[0].innerHTML.replace(/^\s+|\s+$/, '');
    htmlstring1 = (arr[1].innerHTML.trim) ? arr[1].innerHTML.trim() : arr[1].innerHTML.replace(/^\s+|\s+$/, '');
    htmlstring2 = (arr[2].innerHTML.trim) ? arr[2].innerHTML.trim() : arr[2].innerHTML.replace(/^\s+|\s+$/, '');
    htmlstring3 = (arr[3].innerHTML.trim) ? arr[3].innerHTML.trim() : arr[3].innerHTML.replace(/^\s+|\s+$/, '');
    htmlstring4 = (arr[4].innerHTML.trim) ? arr[4].innerHTML.trim() : arr[4].innerHTML.replace(/^\s+|\s+$/, '');
    htmlstring5 = (arr[5].innerHTML.trim) ? arr[5].innerHTML.trim() : arr[5].innerHTML.replace(/^\s+|\s+$/, '');
    htmlstring6 = (arr[6].innerHTML.trim) ? arr[6].innerHTML.trim() : arr[6].innerHTML.replace(/^\s+|\s+$/, '');
    htmlstring7 = (arr[7].innerHTML.trim) ? arr[7].innerHTML.trim() : arr[7].innerHTML.replace(/^\s+|\s+$/, '');
    htmlstring8 = (arr[8].innerHTML.trim) ? arr[8].innerHTML.trim() : arr[8].innerHTML.replace(/^\s+|\s+$/, '');

    if(htmlstring0 == htmlstring1 && htmlstring0 == htmlstring2 && htmlstring0!=''){
        var myDiv = document.getElementById("message");
        myDiv.innerHTML="Game won by " + htmlstring0;
        return true;
    }
    else if(htmlstring3 == htmlstring4 && htmlstring3 == htmlstring5 && htmlstring3!=''){
        var myDiv = document.getElementById("message");
        myDiv.innerHTML="Game won by " + htmlstring3;
        return true;
    }
    else if(htmlstring6 == htmlstring7 && htmlstring6 == htmlstring8 && htmlstring6!=''){
        var myDiv = document.getElementById("message");
        myDiv.innerHTML="Game won by " + htmlstring6;
        return true;
    }
    else if(htmlstring0 == htmlstring3 && htmlstring0 == htmlstring6 && htmlstring0!=''){
        var myDiv = document.getElementById("message");
        myDiv.innerHTML="Game won by " + htmlstring0;
        return true;
    }
    else if(htmlstring1 == htmlstring4 && htmlstring1 == htmlstring7 && htmlstring1!=''){
        var myDiv = document.getElementById("message");
        myDiv.innerHTML="Game won by " + htmlstring1;
        return true;
    }
    else if(htmlstring2 == htmlstring5 && htmlstring2 == htmlstring8 && htmlstring2!=''){
        var myDiv = document.getElementById("message");
        myDiv.innerHTML="Game won by " + htmlstring2;
        return true;
    }
    else if(htmlstring0 == htmlstring4 && htmlstring0 == htmlstring8 && htmlstring0!=''){
        var myDiv = document.getElementById("message");
        myDiv.innerHTML="Game won by " + htmlstring0;
        return true;
    }
    else if(htmlstring2 == htmlstring4 && htmlstring2 == htmlstring6 && htmlstring2!=''){
        var myDiv = document.getElementById("message");
        myDiv.innerHTML="Game won by " + htmlstring2;
        return true;
    }
    else if(htmlstring0!='' && htmlstring1!='' && htmlstring2!='' && htmlstring3!='' && htmlstring4!='' && htmlstring5!='' 
            && htmlstring6!='' && htmlstring7!='' && htmlstring8!=''){
                var myDiv = document.getElementById("message");
                myDiv.innerHTML="DRAW";
                return true;
    }
    return false;   
}