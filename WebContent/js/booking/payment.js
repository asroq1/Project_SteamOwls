const ckpoint = document.querySelector('#ckpoint');
const Pinfo_btn = document.querySelector('#Pinfo_submit');
Pinfo_btn.addEventListener('click',(e)=>{
 	e.preventDefault();
    console.log('clicked');
    if(!agreement.checked){
    alert('결제정보 약관에 동의해주세요.');
    return false;
    }
    // location.href = '/views/booking/bookingSuccess.jsp';
});