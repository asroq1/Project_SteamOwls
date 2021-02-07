const ckpoint = document.querySelector('#editorForm');
const title = document.querySelector('#title');

function initCheckXSS(){ 
    const regExp = /[\{\}\[\]\/.,;:|\)*~`^\-+<>@\#$%&\\\=\(\'\"]/gi;

    if(regExp.test(title.value)){
        alert('특수문자는 사용하실 수 없습니다.');
        title.value = title.value.replace(regExp,  "");
        return; 
    }
}

function add() {
    if (title.value === null) {
        alert('제목을 입력해주세요.');
        return;
    } else {
        saveContent();
    }
}

title.addEventListener('keydown',()=>{
    initCheckXSS();
});