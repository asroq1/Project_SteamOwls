const findid__btn = document.querySelector("#findid__btn");
const ckpoint = document.querySelector("#ckpoint");

function  validateCheck() {
    const name = document.querySelector("#name");
    const tel = document.querySelector("#tel");
   
    if(!name.value){
        alert("아이디를 입력하세요");
        name.focus();
        return;
    }

    if(!tel.value){
        alert("전화번호를 입력하세요.");
        tel.focus();
        return;
    }
    
    ckpoint.submit();

}

ckpoint.addEventListener('submit',(event)=>{
    validateCheck();
    event.preventDefault();
});