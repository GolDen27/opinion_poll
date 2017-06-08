
var elements = document.querySelectorAll(".wrapper-content>.content-page>div");


function func () {
    for(i = 0; i < elements.length; i++)
    {
        elements[i].style.display = "none";
    }
};

function changeLayer(cont) {
    func();
    cont.style.display = "block";
};

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




menusettings.onclick = function(){
    func();
    usersettingscontainer.style.display = "block";
};

menuopinionpoll.onclick = function(){
    func();
    opinionpollcontainer.style.display = "block";

};



menupeople.onclick = function(){
    func();
    peoplecontainer.style.display = "block";
};

menusupport.onclick = function(){
    func();
    supportcontainer.style.display = "block";
};

menudocaboutdesign.onclick = function() {
    func();
    docaboutdesign.style.display = "block";
};

menudocaboutpoll.onclick = function() {
    func();
    docaboutpoll.style.display = "block";
};


