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