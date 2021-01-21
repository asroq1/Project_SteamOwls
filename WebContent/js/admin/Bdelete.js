function bookingDelete(sq) { 
    if(confirm("정말로 취소하시겠습니까?") == true){
        location.href="/admin/Bcancel?booking_sq="+sq;
    }
}	