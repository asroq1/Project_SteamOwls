const checkPoint = document.querySelector('#checkPoint');
const submitBtn = document.querySelector('#submit__btn');
const review__subject = document.querySelector('#review__subject');
const rating__star = document.querySelectorAll('.rating__star');
const detail__form = document.querySelector('#detail__form');
submitBtn.addEventListener('click', (e) => {
    e.preventDefault();

    // for (let i = 0; i < rating__star.length; i++) {
    //     if (!rating__star[i].checked) {
    //         alert('������ �Է����ּ���');
    //         return;
    //     }
    //     if(rating__star[i].checked) {
    //        alert('����');
    //     }
    // }��
    if (!review__subject.value) {
        alert('������ �Է����ּ���');
        return;
    }
    if (!detail__form.value) {
        alert('�̿��ı⸦ �Է����ּ���.');
        return;
    }

    checkPoint.submit();

});
