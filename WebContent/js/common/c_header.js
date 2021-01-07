
const toggle_btn = document.querySelector('.toggle_btn');
const toggle_bar = document.querySelector('.toggle_bar');
const bar_btn = document.querySelector('.bar_btn');
const overlay  = document.querySelector('.overlay');

toggle_btn.addEventListener('click',()=>{ 
	 toggle_bar.classList.toggle('active');
});
