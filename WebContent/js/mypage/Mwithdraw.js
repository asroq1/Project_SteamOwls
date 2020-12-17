function checkleave() {
    if (confirm("정말 삭제하시겠습니까??") == true) {
        document.form.submit();
    } else { //취소
       return false;
    }
}