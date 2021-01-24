	const id__text = document.querySelector(".id__text");	
	const pw__text = document.querySelector(".pw__text");
	const ckpoint = document.querySelector("#ckpoint");
    const login__submit = document.querySelector(".login__submit");
    
function  validateCheck() {
    
    const id = document.querySelector("#id");
    const pw = document.querySelector("#pw");

    initCheckPwd();
    
    if(!id.value){
        id__text.innerText = "아이디를 입력해주세요.";
        id.focus();
        return false; 
    }

    if(!pw.value){
        pw__text.innerText = "비밀번호를 입력해주세요.";
       	pw.focus();
        return false;
    }
    
  ckpoint.submit();
}

document.addEventListener('keypress',(e)=>{
    if(e.key == "Enter"){
        validateCheck();
    }
});


let isPwdChecked = false;
//init함수는 모두 정규표현식 확인
function initCheckPwd() {
    const regExp = new RegExp("^[a-zA-Z0-9!@#$%^&*]{4,10}$", "g");
    if (regExp.exec(pw.value) == null) {
        pw__text.innerText = "최소 4자리부터 최대 10자리까지 가능합니다.";
        pw__text.style.color = "red";
        isPwdChecked = false;
        return;
    } else {
        isPwdChecked = true;
    }
}

let isIdChecked = false;