function ckpoint() {
    if(confirm("정말로 탈퇴하시겠습니까?") == true){
        alert("정상적으로 처리되었습니다.");
        location.href= "/";
    }else{
       return;
    }
}