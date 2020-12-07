function RpList_func(a){
   let rpPostNo = a
   let data = {rpPostNo:rpPostNo};
   $.ajax({
      type:"POST",
      url: "/rp/rpList",
      data: JSON.stringify(data),//XMLHttpRequest의 응답 데이터를 처리할 때 사용되는 함수
      dataType:"json", //서버 응답으로 받는 타입
      contentType: "application/json", //서버로 보내지는 데이터의 content-type기본값은 “application/x-www-form-urlencoded"
      success:function(data){

         //html을 삽입하는걸로 바꾸고 거기에서 세션아이디와 작성자의 아이디가 일치하는 경우에만 수정 삭제 기능 추가
         $(".RpList[data-poNo="+rpPostNo+"]").empty()
         for(let i=0;i<data.list.length;i++){
         $(".RpList[data-poNo="+rpPostNo+"]").append("<li data-bookid="+data.list[i].rpPostNo +"><b>"+data.list[i].rpId+"</b> "+ data.list[i].rpContent+" "+ data.list[i].rpDate+ "</li>")
}
         
         
//아이디로는 삽입이 되지 않음
         },
   error:{
    }
   });
}

