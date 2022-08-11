let index={
    init:function() {
        $("#btn-save").on("click", () => {
            this.save();
        });
        $("#btn-delete").on("click", () => {
            this.deleteById();
        });
        $("#btn-update").on("click", () => {
            this.update();
        });
        $("#btn-response").on("click", () => {
            this.responseSave();
        });
    },

    save:function(){

        let data = {
            qnaTitle:$("#title").val(),
            qnaContent:$("#content").val(),
        };

        $.ajax({
            type:"POST",
            url:"../api/qna",
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf=8",
            dataType:"json"

        }).done(function(resp){
            alert("문의 작성이 완료되었습니다.");
            location.href="/";
        }).fail(function(error){

        });
    },

    deleteById:function(){
        let id = $("#id").text();

        $.ajax({
            type:"DELETE",
            url:"../api/qna"+id,
            dataType:"json"
        }).done(function(resp){
            alert("삭제가 완료되었습니다.");
            location.href="/";
        }).fail(function(error){

        });
    },

    update:function(){
        let id = $("#id").val();

        let data = {
            qnaTitle:$("#title").val(),
            qnaContent:$("#content").val(),
        };

        $.ajax({
            type:"PUT",
            url:"../api/qna/"+id,
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf=8",
            dataType:"json"

        }).done(function(resp){
            alert("문의 수정이 완료되었습니다.");
            location.href="/";
        }).fail(function(error){

        });
    },

    responseSave:function(){

        console.log("done");

        let data = {
            qnaResponseContent:$("#responseContent").val(),
        };

        let qndId=$("#qnaId").val();


       $.ajax({
            type:"POST",
            url:`../api/qna/${qndId}/response`,
            data: JSON.stringify(data),
            contentType:"application/json; charset=utf=8",
            dataType:"json"

        }).done(function(resp){
            alert("댓글 작성이 완료되었습니다.");
            location.href=`/qna/${qndId}`;
        }).fail(function(error){

        });
    },

}

index.init();