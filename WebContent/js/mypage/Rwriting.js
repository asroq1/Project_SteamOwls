const checkPoint = document.querySelector('#checkPoint');
const submitBtn = document.querySelector('#submit__btn');
const review__subject = document.querySelector('#review__subject');
const rating__star = document.querySelectorAll('.rating__star');
const detail__form = document.querySelector('#detail__form');

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

submitBtn.addEventListener('click', (e) => {
    e.preventDefault();

    if (!review__subject.value) {
        alert('제목을 입력해주세요');
        return;
    }
    if (!detail__form.value) {
        alert('이용후기를 입력해주세요.');
        return;
    }

    checkPoint.submit();

});