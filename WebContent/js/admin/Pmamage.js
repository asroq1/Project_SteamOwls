
function selling(sq) {

    const reconfirm = confirm('상품을 판매하시겠습니까?');
    if(reconfirm === false){
        return;
    }else{
        location.href="/admin/PdeleteProc?product_sq="+sq;
    }
}
   

function stopSelling(sq) {
 
    const reconfirm = confirm('상품판매를 중지하시겠습니까?');
    if(reconfirm === false){
        return;
    }else{
        location.href="/admin/PstopButton?product_sq="+sq;
    }
}

