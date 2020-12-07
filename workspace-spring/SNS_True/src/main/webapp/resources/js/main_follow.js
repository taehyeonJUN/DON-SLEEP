function follow_func(a,b){
         let followI=a;
         let followY=b;
         let data= {followI:followI, followY:followY}
         
         $.ajax({
            url: "/post/follow",
            type:"POST",
            data: JSON.stringify(data),
            dataType:"json",
            contentType: "application/json",
            success:function(data){
               if(data.followCh==0){
                  alert(followY+"님을 팔로우 하셨습니다.");
                  
               }
               else{
                  alert(followY+"님을 팔로우 해지 하셨습니다.");
               }
               
            },
            error:{
              }
             
         });
      }
