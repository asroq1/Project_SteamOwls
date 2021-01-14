const slideList = document.querySelector('.slide__list');
const slideContents = document.querySelectorAll('.slide__content');
const slideBtnNext = document.querySelector('.slide__btn__next');
const slideBtnPrev = document.querySelector('.slide__btn__prev');
const pagination = document.querySelector('.slide__pagination');
const slideLen = slideContents.length;
const slideWidth = 300;
const slideSpeed =300;

slideList.style.width = slideWidth * (slideLen) + "px";

let curIndex = 0;

slideBtnNext.addEventListener('click',()=>{
    if(curIndex <= slideLen - 1){
        slideList.style.transition = slideSpeed + "ms";
        slideList.style.transform = "translate3d(-" +(slideWidth * (curIndex + 1)) + "px, 0px , 0px)";
    }
    curSlide = slideContents[++curIndex];
});