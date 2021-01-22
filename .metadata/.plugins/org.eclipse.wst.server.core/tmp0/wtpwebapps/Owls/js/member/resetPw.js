const ckpoint = document.querySelector("#ckpoint")

function validateCheck() {
    const pw = document.querySelector("#pw");
    const cpw = document.querySelector("#cpw");

    if(!pw.value){
        alert("비밀번호를 입력해주세요.");
        pw.focus();
        return
    }
    if(!cpw.value){
        alert("비밀번호를 재확인하세요.");
        cpw.focus();
        return
    }

    if(pw.value != cpw.value){
        alert("비밀번호가 일치하지 않습니다.");
        pw.focus();
        return
    }

    ckpoint.submit();
}

ckpoint.addEventListener('submit', (event)=>{
    validateCheck();
    event.preventDefault();
});