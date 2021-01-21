const checkPoint = document.querySelector('#editorForm');
const modifyBtn = document.querySelector('#modifyBtn');
const review__subject = document.querySelector('.review__text');
const detail__form = document.querySelector('.review__detail');

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
        saveContent();
    }
});
