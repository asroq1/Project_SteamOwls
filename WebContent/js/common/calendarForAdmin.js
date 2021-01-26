let date = document.querySelector('#basicDate');
let time = document.querySelector('#basicTime');
const form_btn = document.querySelector('.form_input.form_submit');
const ckpoint = document.querySelector('#ckpoint');

date.flatpickr({
    locale: "ko",
    dateFormat: "Y-m-d ",
    minDate: "today",
    disableMobile: "true"
    
});


form_btn.addEventListener('click',(e)=>{
    e.preventDefault();
    if(!date.value){
     	date.focus();
        return;
    }
    ckpoint.submit();
});

const cancelBtn = document.querySelector('#cancel__btn');
cancelBtn.addEventListener('click',(e)=>{
    const confirmBtn = confirm('예약을 취소하시겠습니까?');
    if(confirmBtn === false){
        e.preventDefault();
    }else{
        alert("예약이 취소되었습니다.");
    }
});
