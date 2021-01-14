const ckpoint = document.querySelector("#ckpoint");

function Pdelete() {
    
    if(confirm("정말로 삭제하시겠습니까?") == true){
        ckpoint.submit();
    }
}