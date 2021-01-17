const checkPoint = document.querySelector('#checkPoint');
const submitBtn = document.querySelector('#submit__btn');
const review__subject = document.querySelector('#review__subject');
const rating__star = document.querySelectorAll('.rating__star');
const detail__form = document.querySelector('#detail__form');
submitBtn.addEventListener('click', (e) => {
    e.preventDefault();

    // for (let i = 0; i < rating__star.length; i++) {
    //     if (!rating__star[i].checked) {
    //         alert('별점을 입력해주세요');
    //         return;
    //     }
    //     if(rating__star[i].checked) {
    //        alert('성공');
    //     }
    // }ㄴ
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
