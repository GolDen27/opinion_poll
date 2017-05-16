
var elements = document.querySelectorAll(".wrapper-content>.content-page>div");

elements.onmouseover = function () {
    alert("aaa");
}

function func () {
    for(i = 0; i < elements.length; i++)
    {
        elements[i].style.display = "none";
    }
}

function changeLayer(cont) {
    func();
    cont.style.display = "block";
}

menuhomepage.onclick = function(){
    func();
    homepagecontainer.style.display = "block";
};


menuprofile.onclick = function(){
    func();
    profilecont.style.display = "block";
};

menuactivity.onclick = function(){
    func();
    useractivity.style.display = "block";
};

menubecomeanadmin.onclick = function(){
    func();

};

menudonate.onclick = function(){

};

menusettings.onclick = function(){
    func();
    usersettingscontainer.style.display = "block";
};

menuopinionpoll.onclick = function(){
    func();
    opinionpollcontainer.style.display = "block";

};

menuopfamily.onclick = function(){

};

menuopfriends.onclick = function(){

};

menuoppolitics.onclick = function(){

};

menuopother.onclick = function(){

};

menupeople.onclick = function(){
    func();
    peoplecontainer.style.display = "block";
};

menustatistic.onclick = function(){
    func();
    statisticcontainer.style.display = "block";
};

menustatopinionpoll.onclick = function(){
    func();
    statpoll.style.display = "block";
};

menustatpeople.onclick = function(){
    func();
    statuser.style.display = "block";
};

menusupport.onclick = function(){

};

menudocaboutdesign.onclick = function() {
    func();
    docaboutdesign.style.display = "block";
}

menudocaboutpoll.onclick = function() {
    func();
    docaboutpoll.style.display = "block";
}

