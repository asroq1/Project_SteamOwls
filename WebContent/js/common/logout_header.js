
const toggle_btn = document.querySelector('.toggle_btn');
const toggle_bar = document.querySelector('.toggle_bar');
const test = document.querySelector('#test');

toggle_btn.addEventListener('click',()=>{ 
	 toggle_bar.classList.toggle('active');
});
toggle_btn.addEventListener('blur',(e)=>{ 
	if(e.target != button ){
		toggle_bar.classList.remove('active');
	}
});

test.addEventListener('click',(e)=>{
	e.preventDefault();
});

 document.addEventListener('click',(e)=>{
 	console.log(e);
 });
