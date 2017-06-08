checkparam.onclick = function() {
    $.ajax({
        type: 'POST',
        url: '/Controller',
        data: 'command=check_admin_user',
        success: function(data){
            console.log(data);
            if (data==1){
                document.getElementById("result").innerHTML="Выполнено";
            } else {
                document.getElementById("result").innerHTML="Не выполнено";
            }
            setTimeout(func, 3000);
        }
    });
};

function func() {
    location.href = '/Controller?command=load_content';
}
