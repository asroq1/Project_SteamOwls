const infoContainer = document.querySelector('.info-container');
const wrapper = document.querySelector('.wrapper');

// document.addEventListener('wheel', (e) => {
	
//    if (e.pageY >= e.clientY) {
//         wrapper.classList.add('active');
//     }
// });


const SHOWING_CLASS = "showing";
const firstSlide = document.querySelector('.slider__item:first-child');
const lastSlide = document.querySelector('.slider__item:last-child');
const nextBtn = document.querySelector('.next');
const prevBtn = document.querySelector('.prev');

function slideNext() {
    //showing class를 할당
    const currentSlide = document.querySelector(`.${SHOWING_CLASS}`);
    if (currentSlide) {
        currentSlide.classList.remove(SHOWING_CLASS);
        const nextSlide = currentSlide.nextElementSibling; 
         prevBtn.style.background =  "#ed6174";
        if (nextSlide) {
            nextSlide.classList.add(SHOWING_CLASS);
        } else {
            currentSlide.classList.add(SHOWING_CLASS);
            nextBtn.style.pointerEvents = "none";
            nextBtn.style.background = "#e0e0e0";   
        }
    } else {
        firstSlide.classList.add(SHOWING_CLASS);
        
    }
   	
    if (lastSlide) {
        nextBtn.style.pointerEvents = "unset";
    }
}

function slidePrev() {
    //showing class를 할당
    const currentSlide = document.querySelector(`.${SHOWING_CLASS}`);
    if (currentSlide) {
        currentSlide.classList.remove(SHOWING_CLASS);
        const prevSlide = currentSlide.previousElementSibling;
        nextBtn.style.background = "#ed6174";
       
        prevBtn.style.pointerEvents = "unset";
        if (prevSlide) {
            prevSlide.classList.add(SHOWING_CLASS);
        } else {
            currentSlide.classList.add(SHOWING_CLASS);
            prevBtn.style.pointerEvents = "none";
            prevBtn.style.background = "#e0e0e0"; 

        }
    } else {
        firstSlide.classList.add(SHOWING_CLASS); 
      
    }
    if(firstSlide){
        prevBtn.style.pointerEvents = "unset";
    }

}


nextBtn.addEventListener('click', () => {
    slideNext();
});

prevBtn.addEventListener('click', () => {
    slidePrev();
});

slideNext();



