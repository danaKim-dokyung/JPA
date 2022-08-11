let index={
    init:function() {
        $("#btn-save").on("click", () => {
            this.save();
        });
    },

    save:function(){

        let data = {
            memberUsername:$("#memberUsername").val(),
            password:$("#password").val(),
            memberName:$("#memberName").val(),
            memberPhone:$("#memberPhone").val(),
        };

        $.ajax({
            type:"POST",
            url:"../auth/joinProc",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf=8",
            dataType:"json"

        }).done(function(resp){
            alert("회원가입이 완료되었습니다.");
            location.href="/";
        }).fail(function(error){

        });
    }
}

index.init();