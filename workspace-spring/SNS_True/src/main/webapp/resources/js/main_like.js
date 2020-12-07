function like_func(a,b){
      let postId = b;
      let postNo = a;
      let data= {postId:postId, postNo:postNo}
      console.log(data);
      $.ajax({
         url: "/post/like",
         type:"POST",
         data: JSON.stringify(data),
         dataType:"json",
         contentType: "application/json",
         success:function(data){
            //여기서 a태그에 달린 이미지를 변경해야함
               console.log(data);
            $('.em').remove();
            if (data.likeCh =="0") {
               $(".like_img[data-postNo="+postNo+"]").attr('src', '../../resources/images/iconmonstr-favorite-2-240.png');

               
               $(".like_count2[data-poNo="+postNo+"]").remove();
                let html = "<b class='em'>"+ data.like +"명이 좋아합니다</b>";
                
                $(".like_count1[data-poNo="+postNo+"]").append(html);
            }else if(data.likeCh =="1") {
               
               $(".dislike_img[data-postNo="+postNo+"]").attr('src', '../../resources/images/iconmonstr-favorite-1-240.png');
               $(".like_count2[data-poNo="+postNo+"]").remove();
                let html = "<b class='em'>"+ data.like +"명이 좋아합니다</b>";
               $(".like_count1[data-poNo="+postNo+"]").append(html);
            }
            },
         error:{
            }
      });
      }