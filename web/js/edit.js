
questionaddlink.onclick = function(){
    if(questionaddcontainer.style.display=="none") {
        questionaddcontainer.style.display = "block";
    } else {
        questionaddcontainer.style.display = "none";
    }
};

returnbtn.onclick = function(){
    sessionStorage.removeItem("poll");
};

