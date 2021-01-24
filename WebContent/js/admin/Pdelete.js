
function Pdelete(sq) {
    
    if(confirm("정말로 삭제하시겠습니까?") == true){
        location.href="/admin/PdeleteProc?product_sq="+sq;
    }
}	