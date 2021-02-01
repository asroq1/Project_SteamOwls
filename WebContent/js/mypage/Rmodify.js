const checkPoint = document.querySelector('#editorForm');
const modifyBtn = document.querySelector('#modifyBtn');
const review__subject = document.querySelector('.review__text');
const detail__form = document.querySelector('.review__detail');

function initCheckXSS() {

    const regExp = /[\{\}\[\]\/.,;:|\)*~`^\-+<>@\#$%&\\\=\(\'\"]/gi;

    if (regExp.test(review__subject.value)) {
        alert('특수문자는 사용하실 수 없습니다.');
        review__subject.focus();
        review__subject.value = review__subject.value.replace(regExp, "");
        return;
    }

    if (regExp.test(detail__form.value)) {
        alert('특수문자는 사용하실 수 없습니다.');
        detail__form.focus();
        detail__form.value = detail__form.value.replace(regExp, "");
        return;
    }
}

review__subject.addEventListener('keydown', () => {
    initCheckXSS();
});

detail__form.addEventListener('keydown', () => {
    initCheckXSS();
});

modifyBtn.addEventListener('click',(e)=>{
	const ask = confirm('수정하시겠습니까?');
	e.preventDefault();
	
	if (!review__subject.value) {
        alert('제목을 입력해주세요');
        return;
    }
    if (!detail__form.value) {
        alert('이용후기를 입력해주세요.');
        return;
    }
    if(ask === true){
    	
        checkPoint.submit();
    }
});
