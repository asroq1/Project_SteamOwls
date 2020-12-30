const ckpoint = document.querySelector('#ckpoint');
const agreement = document.querySelector('#agreement');
ckpoint.addEventListener('click',()=>{
 
    console.log('clicked');
    if(!agreement.checked){
    alert('결제정보 약관에 동의해주세요.');
    return;
    }
    location.href = '/views/booking/bookingSuccess.jsp';
});