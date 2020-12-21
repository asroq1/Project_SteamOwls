const checkPoint = document.querySelector("#checkPoint");
let isPwdChecked = false;

function join() {

    initCheckPwd();

    const pw = document.querySelector("#pw");
    if (!pw.value) {
        alert("비밀번호를 입력하세요.");
        pw.focus();
        return false;
    }
  
}

function initCheckPwd() {
    const regExp = new RegExp("^[a-zA-Z0-9!@#$%^&*]{4,10}$", "g");
    const text = document.querySelector(".pw__text");
    if (regExp.exec(pw.value) == null) {
        isPwdChecked = false;
        return;
    } else {
        text.innerText = "";
        isPwdChecked = true;
    }
}
document.addEventListener('keydown', (e)=>{
    if(e.key == "Enter"){
        join();
    }
});