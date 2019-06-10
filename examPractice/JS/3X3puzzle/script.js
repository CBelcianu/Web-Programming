let table=[];
let prevSelected = false;
let selectedID;

document.addEventListener('DOMContentLoaded', (event) => {
    scrabmle();
  })

function scrabmle(){
    let x = Math.floor(Math.random() * 9);
    while(table.length<9){
        while(table.includes(x)){
            x = Math.floor(Math.random() * 9);
        }
        table.push(x);
    }
    populate();
}

function populate(){
    console.log(table);
    for(i=0;i<9;i++){
        let id = table[i];
        document.getElementById(i.toString()).src="img/"+id.toString()+".jpeg";
    }
}

function play(element){
    if(prevSelected==false){
        prevSelected=true;
        selectedID=element.id;
    }
    else{
        prevSelected=false;
        let one = document.getElementById(selectedID.toString());
        let two = document.getElementById(element.id.toString());
        let src1 = table[Number(one.id)];
        let src2 = table[Number(two.id)];
        table[Number(one.id)] = src2;
        table[Number(two.id)] = src1;
        populate();
    }
    if(isWon()){
        alert("you won");
        return;
    }
}

function isWon(){
    for(i=0;i<8;i++){
        if(table[i]>table[i+1]){
            return false;
        }
    }
    return true;
}