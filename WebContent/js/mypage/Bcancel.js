const cancelBtn = document.querySelector('.bill_submit');
cancelBtn.addEventListener('click',(e)=>{
    const confirmBtn = confirm('예약을 취소하시겠습니까?');
    if(confirmBtn === false){
        e.preventDefault();
    }else{
        alert("예약이 취소되었습니다.");
    }
});