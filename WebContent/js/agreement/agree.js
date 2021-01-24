
function createFeed() {
	const body = document.querySelector("body");
    const feed = document.createElement('div');
    feed.setAttribute('class', 'feed');
	
    const logo = document.createElement('img');
    logo.setAttribute('class', 'logo');
    logo.setAttribute('img', '')

    const content = document.createElement('div');
    content.setAttribute('class', 'content');
    content.innerHTML = '당사는 고객님의 개인정보를 소중하게 생각하고 있습니다.&nbsp; owls 서비스를 이용하면서 귀중한 정보를 기꺼이 제공해주신 고객님의 믿음에 어긋나지 않도록,&nbsp; 공유해주신 모든 개인정보를 안전하게 보호하는 데 최선을 다할 것임을 약속드립니다.&nbsp; 당사는 고객의 이익을 최우선으로 여기며, 고객님의 개인정보를 언제나 투명하고 공정하게 처리합니다.';

    const del = document.createElement('button');
    del.setAttribute('class', 'delete');
    del.innerHTML = '나가기';
    del.style.color = "red";
    del.addEventListener('click',()=>{
        feed.removeChild(content);
        body.removeChild(feed);
    });

    feed.appendChild(content);
    content.appendChild(del);
    body.appendChild(feed);
    return feed; 
}
