const ckpoint = document.querySelector("#ckpoint");
const product_name = document.querySelector("#product_name");
const product_detail = document.querySelector("#product_detail");
const product_price = document.querySelector("#product_price");




function Padd() {
    if(!product_name.value){
        alert('상품이름을 입력해주세요.');
        return;
    }
    if(!product_detail.value){
        alert('상품설명을 입력해주세요.');
        return;
    }
    if(!product_price.value){
        alert('상품이름을 입력해주세요.');
        return;
    }
    ckpoint.submit();
}