var user;

function updPaper(){
    let title = document.getElementById("title").value;
    let content = document.getElementById("content").value;
    let category = document.getElementById("category").value;
    date = new Date();
    var dt = date.getFullYear()+"-"+date.getMonth()+"-"+date.getDay();
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            console.log("am dat");
            populateNews();
        }
    }
    request.open('GET','updPaper.php'+'?'+'title='+title+'&'+'textof='+content+'&'+'category='+category+'&'+'producer='+user+'&'+'date='+dt,true);
    request.send('');
}

function addPaper(){
    let title = document.getElementById("title").value;
    let content = document.getElementById("content").value;
    let category = document.getElementById("category").value;
    console.log(title);
    console.log(user);

    date = new Date();
    var dt = date.getFullYear()+"-"+date.getMonth()+"-"+date.getDay();

    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            console.log("am dat");
            populateNews();
        }
    }
    request.open('GET','addPaper.php'+'?'+'title='+title+'&'+'textof='+content+'&'+'category='+category+'&'+'producer='+user+'&'+'date='+dt,true);
    request.send('');
}

function logIn(){
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    var request=new XMLHttpRequest();
    request.onreadystatechange=function(){
        if(request.readyState==4 && request.status==200){
            var response=request.responseText;
            response = response.replace(/\s+/g, '');
            user = response;
            if(response!=""){
                alert("success");
                document.getElementById("main").innerHTML += "<p>title:</p><input id=\"title\"><br><p>content:</p><textarea id=\"content\"></textarea><p>category:</p>"+
                "<input id=\"category\"><br><button id=\"btnSave\" onclick=\"addPaper()\">Add</button><button id=\"btnUpd\" onclick=\"updPaper()\" >Upd</button><br></br>"
            }
            else{
                alert("invalid username/password!");
            }
        }
    }
    request.open('GET','login.php'+'?'+'username='+username+'&'+'password='+password,true);
    request.send('');
    console.log(user);
}

function populateNews() {
    let request=new XMLHttpRequest();
    request.onreadystatechange=function(){
    if(request.readyState==4 && request.status==200){
        let response=request.responseText;
        response=response.split(";");
        let k=1;
        document.getElementById("newsTable").innerHTML="<tr id=\"myTable\"><th>title</th><th>producer</th><th>category</th><th>date</th></tr>"
        for(let i in response){
            if(response[i]!=""){
                let person=response[i].split("#");
                document.getElementById("newsTable").innerHTML += "<tr><td id='title"+k+"'></td><td id='producer"+k+"'></td><td id='category"+k+"'></td><td id='date"+k+"'></td></tr>" 
                document.getElementById("title"+k).innerHTML=person[0];
                document.getElementById("producer"+k).innerHTML=person[1];
                document.getElementById("category"+k).innerHTML=person[2];
                document.getElementById("date"+k).innerHTML=person[3];
                
                k+=1;
                }            
            }
        }
    }
    request.open('GET','showNews.php',true);
    request.send('');
}