let date = document.querySelector('#basicDate');
let time = document.querySelector('#basicTime');
const form_btn = document.querySelector('.form_input.form_submit');
const ckpoint = document.querySelector('#ckpoint');

date.flatpickr({
    locale: "ko",
    dateFormat: "Y-m-d ",
    minDate: "today"
});

time.flatpickr({
    enableTime: true,
    noCalendar:true,
    locale: "ko",
    dateFormat: "H:i",
    hourincrement: 1,
	//10시 ~ 7시
	//월요일
    minTime: "10:00",
    maxTime: "19:00" 
});

form_btn.addEventListener('click',(e)=>{
    e.preventDefault();
    if(!date.value){
     	date.focus();
        return;
    }
    if(!time.value){
        time.focus();
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
