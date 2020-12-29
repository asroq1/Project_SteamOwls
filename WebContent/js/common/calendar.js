let date = document.querySelector('#basicDate');
let time = document.querySelector('#basicTime');
const form_btn = document.querySelector('.form_submit');
let test = 1;

date.flatpickr({
    locale: "ko",
    dateFormat: "Y년 F d일 ",
    minDate: "today",
     onChange: function (instance) {
      console.log(instance.element.value);
    }
});

time.flatpickr({
    enableTime: true,
    noCalendar:true,
    locale: "ko",
    dateFormat: "H : i시",
    hourincrement: 1,
	//10시 ~ 7시
	//월요일
    minTime: "10:00",
    maxTime: "19:00", 
    onChange: function (instance) {
    	console.log(instance.element.value);
    }
});
