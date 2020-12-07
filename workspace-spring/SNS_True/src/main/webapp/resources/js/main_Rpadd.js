//댓글 작성

function RpAdd_func(a){
   let postNo = a;
   let data = {rpContent:$(".comment-input[data-postNo="+postNo+"]").val(), rpPostNo:postNo};
   $.ajax({
      type:"POST",
      url:"/rp/add",
      data: JSON.stringify(data),
      dataType:"json",
      contentType: "application/json",
//       data:data, 
      success:function(data){
         $("b.rpCount[data-poNo="+postNo+"]").empty();
         $("b.rpCount[data-poNo="+postNo+"]").append(data.ch +"개의 댓글이 있습니다.");
      }
   });
}



