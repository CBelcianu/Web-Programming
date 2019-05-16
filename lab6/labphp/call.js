function prop(){ 
    console.log("AM intera");
    getProducator();
}

function getProducator(){
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
                    document.getElementById("Producator").appendChild(newOps);
                }
            }
        }
    }
    request.open('GET','getProp.php'+'?'+'prop='+'Category',true);
    request.send('');
}