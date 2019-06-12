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
                    document.getElementById("City"+k).innerHTML=person[0];
                    document.getElementById("Country"+k).innerHTML=person[1];
                    document.getElementById("Description"+k).innerHTML=person[2];
                    document.getElementById("Cost"+k).innerHTML=person[3];
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
    request.open('GET','next.php'+'?'+'nr='+nr+'&'+'cat='+document.getElementById("BrowCountry").value,true);
    request.send('');
    console.log(nr);
    document.getElementById("btnPrev").removeAttribute("disabled");
}

function clear(){
    for(var i=1;i<=4;i++){
            document.getElementById("City"+i).innerHTML="";
            document.getElementById("Country"+i).innerHTML="";
            document.getElementById("Description"+i).innerHTML="";
            document.getElementById("Cost"+i).innerHTML="";
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
                    document.getElementById("City"+k).innerHTML=person[0];
                    document.getElementById("Country"+k).innerHTML=person[1];
                    document.getElementById("Description"+k).innerHTML=person[2];
                    document.getElementById("Cost"+k).innerHTML=person[3];
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
    request.open('GET','prev.php'+'?'+'nr='+nr+'&'+'cat='+document.getElementById("BrowCountry").value,true);
    request.send('');
    document.getElementById("btnNext").removeAttribute("disabled");
}

function foo(){
    nr=0;
}

function getCountry(){
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            var response=request.responseText;
            response=response.split("#");
            for(var i in response){
                if(response[i]!=""){
                    var newOps=document.createElement("option");
                    newOps.setAttribute("value",response[i]);
                    newOps.innerHTML=response[i];
                    document.getElementById("BrowCountry").appendChild(newOps);
                }
            }
        }
    }
    request.open('GET','getCountry.php'+'?'+'prop='+'country',true);
    request.send('');
}

function addCity(){
    let city = document.getElementById("city").value;
    let country = document.getElementById("country").value;
    let description = document.getElementById("description").value;
    let cost = document.getElementById("cost").value;
    
    let request=new XMLHttpRequest();
    request.onreadystatechange=function(){
    if(request.readyState==4 && request.status==200){
            console.log("am trmis");
        }
    }
    request.open('GET','addCity.php'+'?'+'city='+city+'&'+'country='+country+'&'+'description='+description+'&'+'cost='+cost,true);
    request.send('');
}

function delCity(){
    let city = document.getElementById("city").value;
    let country = document.getElementById("country").value;
    let description = document.getElementById("description").value;
    let cost = document.getElementById("cost").value;
    
    let request=new XMLHttpRequest();
    request.onreadystatechange=function(){
    if(request.readyState==4 && request.status==200){
            console.log("am trmis");
        }
    }
    request.open('GET','delCity.php'+'?'+'city='+city+'&'+'country='+country+'&'+'description='+description+'&'+'cost='+cost,true);
    request.send('');
}

function updCity(){
    let city = document.getElementById("city").value;
    let country = document.getElementById("country").value;
    let description = document.getElementById("description").value;
    let cost = document.getElementById("cost").value;
    
    let request=new XMLHttpRequest();
    request.onreadystatechange=function(){
    if(request.readyState==4 && request.status==200){
            console.log("am trmis");
        }
    }
    request.open('GET','updCity.php'+'?'+'city='+city+'&'+'country='+country+'&'+'description='+description+'&'+'cost='+cost,true);
    request.send('');
}