const add_btn = document.querySelector('.confirm__add');
const delete_btn = document.querySelector('.confirm__delete');
const ckpoint = document.querySelector('#ckpoint');
const nav__container = document.querySelector('.nav__container');
const nav__sub = document.querySelectorAll('.nav__sub');
const sub__wrapper = document.querySelectorAll('.sub__wrapper');

add_btn.addEventListener('click',()=>{
    if(confirm('판매를 시작하시겠습니까?')== true){
        add_btn.setAttribute('action', '/admin/product/PsellingButton');
        ckpoint.submit();
    }
});

delete_btn.addEventListener('click',()=>{
    if(confirm('판매를 중지하시겠습니까?')== true){
        add_btn.setAttribute('action', '/admin/product/PstopButton');
        ckpoint.submit();
    }
});

