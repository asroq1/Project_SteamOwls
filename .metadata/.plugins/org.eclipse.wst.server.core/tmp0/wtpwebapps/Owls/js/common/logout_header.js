
const toggle_btn = document.querySelector('.toggle_btn');
const toggle_bar = document.querySelector('.toggle_bar');
const bar_btn = document.querySelector('.bar_btn');


toggle_btn.addEventListener('click',()=>{ 	
	toggle_btn.classList.toggle('active'); 
	toggle_bar.classList.toggle('clicked');
});

document.addEventListener('click', (e) => {
    if (document.activeElement === document.body) {
        toggle_bar.classList.remove('active');
    }
})
