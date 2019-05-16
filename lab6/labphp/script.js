var nr=0;
var uid=null;
function next(){
    clear();
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            var response=request.responseText;
            response=response.split(";");
            var k=1;
            for(var i in response){
                if(response[i]!=""){
                    var person=response[i].split("#");
                    document.getElementById("Nume"+k).innerHTML=person[0];
                    document.getElementById("Categorie"+k).innerHTML=person[1];
                    document.getElementById("Pret"+k).innerHTML=person[2];
                    document.getElementById("Cantitate"+k).innerHTML=person[3];
                    k+=1;
                }            
            }
        nr+=k-1;
        if((k-1)%4!=0){
            console.log("Am intrat");
            document.getElementById("btnNext").setAttribute("disabled","disabled");
            }
        }
    }
    request.open('GET','next.php'+'?'+'nr='+nr+'&'+'cat='+document.getElementById("Producator").value,true);
    request.send('');
    console.log(nr);
    document.getElementById("btnPrev").removeAttribute("disabled");
}

function clear(){
    for(var i=1;i<=4;i++){
            document.getElementById("Nume"+i).innerHTML="";
            document.getElementById("Categorie"+i).innerHTML="";
            document.getElementById("Pret"+i).innerHTML="";
            document.getElementById("Cantitate"+i).innerHTML="";
        }
}

function prev(){
    clear();
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            var response=request.responseText;
            response=response.split(";");
            var k=1;
            for(var i in response){
                if(response[i]!=""){
                    var person=response[i].split("#");
                    document.getElementById("Nume"+k).innerHTML=person[0];
                    document.getElementById("Categorie"+k).innerHTML=person[1];
                    document.getElementById("Pret"+k).innerHTML=person[2];
                    document.getElementById("Cantitate"+k).innerHTML=person[3];
                    k+=1;
                }    
            }
        nr=nr-(k-1);
        if(k==1){
            nr=0;
            console.log("Am intrat");
            document.getElementById("btnPrev").setAttribute("disabled","disabled");
            }
        }
    }
    console.log(nr);
    request.open('GET','prev.php'+'?'+'nr='+nr+'&'+'cat='+document.getElementById("Producator").value,true);
    request.send('');
    document.getElementById("btnNext").removeAttribute("disabled");
}

function foo(){
    nr=0;
}

function vcart(){
    window.location="http://localhost:8000/labphp/Cart.html";
}

function vshop(){
    window.location="http://localhost:8000/labphp/Index.html";
}

$(document).ready(function(){
    $(document).on('click','td',function() {
        console.log("da");
        var request=new XMLHttpRequest();
        request.onreadystatechange=function(){
            if(request.readyState==4 && request.status==200){
                var response=request.responseText;
                uid=response;
            }
        }
        request.open('GET','getID.php'+'?'+'name='+$(this).text(),true);
        request.send();
        });
});

function addToCart(){
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            console.log("am trimis");
        }
    }
    request.open('GET','addItem.php'+'?'+'uid='+uid,true);
    request.send();
}

function removeFromCart(){
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            console.log("am trimis");
            var response=request.responseText;
            console.log(response);
        }
    }
    request.open('GET','removeItem.php'+'?'+'uid='+uid,true);
    request.send();
}

function showContents(){
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            var response=request.responseText;
            response=response.split(";");
            var k=1;
            for(var i in response){
                if(response[i]!=""){
                    var person=response[i].split("#");
                    document.getElementById("cartTable").innerHTML += "<tr><td id='Nume"+k+"'></td><td id='Categorie"+k+"'></td><td id='Pret"+k+"'></td><td id='Cantitate"+k+"'></td></tr>" 

                    document.getElementById("Nume"+k).innerHTML=person[0];
                    document.getElementById("Categorie"+k).innerHTML=person[1];
                    document.getElementById("Pret"+k).innerHTML=person[2];
                    document.getElementById("Cantitate"+k).innerHTML=person[3];
                    
                    k+=1;
                }            
            }
        }
    }
    request.open('GET','showContents.php',true);
    request.send('');
    calculateTotal();
}

function calculateTotal(){
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            console.log("am trimis");
            var response=request.responseText;
            console.log(response);
            document.getElementById("totalCart").innerHTML = "Total: "+response+" lei";
        }
    }
    request.open('GET','computeTotal.php'+'?'+'uid='+uid,true);
    request.send();
}