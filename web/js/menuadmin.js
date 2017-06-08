var elements = document.querySelectorAll(".wrapper-content>.content-page>div");


function func () {
    for(i = 0; i < elements.length; i++)
    {
        elements[i].style.display = "none";
    }
};


menuaddpoll.onclick = function() {
    func();
    addpollcontainer.style.display = "block";
};

menustatistic.onclick = function(){
    func();
    statpoll.style.display = "block";
    statuser.style.display = "block";
};

menustatopinionpoll.onclick = function(){
    func();
    statpoll.style.display = "block";
};

menustatpeople.onclick = function(){
    func();
    statuser.style.display = "block";
};