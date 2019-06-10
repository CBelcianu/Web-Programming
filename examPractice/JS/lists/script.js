function foo1(elm){
    document.getElementById("first").removeChild(elm);
    document.getElementById("second").appendChild(elm);
}

function foo2(elm){
    document.getElementById("second").removeChild(elm);
    document.getElementById("first").appendChild(elm);
}