var prevBrow;

document.addEventListener('DOMContentLoaded', (event) => {
    populateTable();
})

function populateTable(){
    let request=new XMLHttpRequest();
    request.onreadystatechange=function(){
    if(request.readyState==4 && request.status==200){
        let response=request.responseText;
        response=response.split(";");
        let k=1;
        document.getElementById("carsTable").innerHTML="<tr id=\"myTable\"><th>Model</th><th>Horse Power</th><th>Torque</th><th>Fuel</th><th>Color</th><th>Price</th></tr>"
        for(let i in response){
            if(response[i]!=""){
                let person=response[i].split("#");
                document.getElementById("carsTable").innerHTML += "<tr><td id='Model"+k+"'></td><td id='Horse Power"+k+"'></td><td id='Torque"+k+"'></td><td id='Fuel"+k+"'></td><td id='Color"+k+"'></td><td id='Price"+k+"'></td></tr>" 
                document.getElementById("Model"+k).innerHTML=person[0];
                document.getElementById("Horse Power"+k).innerHTML=person[1];
                document.getElementById("Torque"+k).innerHTML=person[2];
                document.getElementById("Fuel"+k).innerHTML=person[3];
                document.getElementById("Color"+k).innerHTML=person[4];
                document.getElementById("Price"+k).innerHTML=person[5];
                
                k+=1;
                }            
            }
        }
    }
    request.open('GET','getCars.php',true);
    request.send('');
}

function brow(){
    var criteria = document.getElementById("searchbar").value;
    if(criteria==null){
        populateTable();
        return;
    }
    let request=new XMLHttpRequest();
    request.onreadystatechange=function(){
    if(request.readyState==4 && request.status==200){
        let response=request.responseText;
        response=response.split(";");
        let k=1;
        document.getElementById("carsTable").innerHTML="<tr id=\"myTable\"><th>Model</th><th>Horse Power</th><th>Torque</th><th>Fuel</th><th>Color</th><th>Price</th></tr>"
        for(let i in response){
            if(response[i]!=""){
                let person=response[i].split("#");
                document.getElementById("carsTable").innerHTML += "<tr><td id='Model"+k+"'></td><td id='Horse Power"+k+"'></td><td id='Torque"+k+"'></td><td id='Fuel"+k+"'></td><td id='Color"+k+"'></td><td id='Price"+k+"'></td></tr>" 
                document.getElementById("Model"+k).innerHTML=person[0];
                document.getElementById("Horse Power"+k).innerHTML=person[1];
                document.getElementById("Torque"+k).innerHTML=person[2];
                document.getElementById("Fuel"+k).innerHTML=person[3];
                document.getElementById("Color"+k).innerHTML=person[4];
                document.getElementById("Price"+k).innerHTML=person[5];
                
                k+=1;
                }            
            }
        }
    }
    request.open('GET','getCarsBrow.php'+'?'+'brow='+criteria,true);
    request.send('');
}

function addCar(){
    let model = document.getElementById("model").value;
    let hp = document.getElementById("horse power").value;
    let torque = document.getElementById("torque").value;
    let fuel = document.getElementById("fuel").value;
    let color = document.getElementById("color").value;
    let price = document.getElementById("price").value;

    let request=new XMLHttpRequest();
    request.onreadystatechange=function(){
    if(request.readyState==4 && request.status==200){
            console.log("am trmis");
            populateTable();
        }
    }
    request.open('GET','addCar.php'+'?'+'model='+model+'&'+'hp='+hp+'&'+'torque='+torque+'&'+'fuel='+fuel+'&'+'color='+color+'&'+'price='+price,true);
    request.send('');
}

function delCar(){
    let model = document.getElementById("model").value;
    let hp = document.getElementById("horse power").value;
    let torque = document.getElementById("torque").value;
    let fuel = document.getElementById("fuel").value;
    let color = document.getElementById("color").value;
    let price = document.getElementById("price").value;

    let request=new XMLHttpRequest();
    request.onreadystatechange=function(){
    if(request.readyState==4 && request.status==200){
            console.log("am trmis");
            populateTable();
        }
    }
    request.open('GET','delCar.php'+'?'+'model='+model+'&'+'hp='+hp+'&'+'torque='+torque+'&'+'fuel='+fuel+'&'+'color='+color+'&'+'price='+price,true);
    request.send('');
}


function updCar(){
    let model = document.getElementById("model").value;
    let hp = document.getElementById("horse power").value;
    let torque = document.getElementById("torque").value;
    let fuel = document.getElementById("fuel").value;
    let color = document.getElementById("color").value;
    let price = document.getElementById("price").value;

    let request=new XMLHttpRequest();
    request.onreadystatechange=function(){
    if(request.readyState==4 && request.status==200){
            console.log("am trmis");
            populateTable();
        }
    }
    request.open('GET','updCar.php'+'?'+'model='+model+'&'+'hp='+hp+'&'+'torque='+torque+'&'+'fuel='+fuel+'&'+'color='+color+'&'+'price='+price,true);
    request.send('');
}

function verify(){
    var criteria = document.getElementById("searchbar").value;
    if(criteria==""){
        populateTable();
        return;
    }
}

function triggerAdd(){
    document.getElementById("crudDiv").innerHTML = "<label>model:</label><input id=\"model\"><br><label>hp:</label><input id=\"horse power\"><br><label>torque:</label><input id=\"torque\"><br><label>fuel:</label><input id=\"fuel\"><br><label>color:</label><input id=\"color\"><br><label>price:</label><input id=\"price\">"
    document.getElementById("crudDiv").innerHTML += "<br><button id=\"btnSave\" onclick=\"addCar()\">Save</button><button id=\"btnDelete\" onclick=\"delCar()\">Delete</button><button id=\"btnUpdate\" onclick=\"updCar()\">Update</button>";
}