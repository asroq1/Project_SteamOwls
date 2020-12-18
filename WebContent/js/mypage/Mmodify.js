
	const pw =  document.querySelector("#pw");
 	const name = document.querySelector("#name");
 	const tel = document.querySelector("#tel");
    const cpw = document.querySelector("#cpw");
 	const checkPoint = document.querySelector("#checkPoint");

	let isTelChecked = false;
	let isNameChecked = false;
	let isPwdChecked = false;
	let isIdChecked = false;
function join() {

	initCheckName();
	initCheckPwd();
	initCheckTel();
	    
    if(!name.value){
        alert("아이디를 입력하세요.");
        id.focus();
        return false;
    }
  
   if (pw.value != cpw.value) {
			alert("비밀번호를 다시 재확인 하세요.");
			pw.focus();
			return false;
		} 
   if (!tel.value) {
			alert("전화번호를 입력하세요.");
			pw.focus();
			return false;
		}

 	checkPoint.submit();
}
function initCheckName() {

    const regExp = new RegExp("^[가-힣]{2,6}$", "g");
    const text = document.querySelector(".name__text");
    if (regExp.exec(name.value) == null) {
       text.innerText = "옳지않은 이름 입니다.";
       isNameChecked = false;
        return;
    } else {
        text.innerText = "";
        isNameChecked = true;
    }
}
function initCheckTel() {
    const regExp = new RegExp("^[01]{2,2}[0-9]{8,9}$", "g");
    const text = document.querySelector(".tel__text");
    if (regExp.exec(tel.value) == null) {
       text.innerText = "휴대전화 번호만 사용가능합니다.";	
       isPhoneChecked = false;
        return;
    } else {
        text.innerText = "";	
        isPhoneChecked = true;
    }
}
function initCheckPwd() {
    const regExp = new RegExp("^[a-zA-Z0-9!@#$%^&*]{4,10}$", "g");
   	 const text = document.querySelector(".pw__text");
    if (regExp.exec(pw.value) == null) {
        text.innerText = "최소 4자리부터 최대 10자리까지 가능합니다.";
        isPwdChecked = false;
        return;
    } else {
        text.innerText = "";
        isPwdChecked = true;
    }
}


pw.addEventListener('keyup',()=>{
    initCheckPwd();
});


name.addEventListener('keyup',()=>{
    initCheckName();
});

tel.addEventListener('keyup',()=>{
    initCheckTel();
});






