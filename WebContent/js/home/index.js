const infoContainer = document.querySelector('.info-container');
const wrapper = document.querySelector('.wrapper');

document.addEventListener('wheel', (e) => {
	
   if (e.pageY >= e.clientY) {
        wrapper.classList.add('active');
    }
});
