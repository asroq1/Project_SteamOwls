const ckpoint = document.querySelector('#checkPoint');
const pw = document.querySelector('#pw');
const cpw = document.querySelector('#cpw');
let isPwdChecked = false;

function confirmLeave() {
    initCheckPwd();
    initCheckCpw();

    if (!pw.value) {
        alert("비밀번호를 입력해주세요");
        pw.focus();
        return;
    }
    if (!cpw.value) {
        alert("비밀번호를 재확인하세요.");
        cpw.focus();
        return;
    }
    if (pw.value != cpw.value) {
        
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }

    if (confirm("정말로 탈퇴하시겠습니까?") == true) {
        ckpoint.submit();
    }
}

function initCheckPwd() {
    const regExp = new RegExp("^[a-zA-Z0-9!@#$%^&*]{4,10}$", "g");
    if (regExp.exec(pw.value) == null) {
        isPwdChecked = false;
        return;
    } else {
        isPwdChecked = true;
    }
}

function initCheckCpw() {
    const regExp = new RegExp("^[a-zA-Z0-9!@#$%^&*]{4,10}$", "g");
    if (regExp.exec(cpw.value) == null) {
        isPwdChecked = false;
        return;
    } else {
        isPwdChecked = true;
    }
}