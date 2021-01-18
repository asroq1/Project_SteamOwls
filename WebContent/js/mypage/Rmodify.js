const checkPoint = document.querySelector('#editorForm');
const modifyBtn = document.querySelector('#modifyBtn');

modifyBtn.addEventListener('click',(e)=>{
	e.preventDefault();
    const ask = confirm('수정하시겠습니까?');
    if(ask === true){
        checkPoint.submit();
    }
});
