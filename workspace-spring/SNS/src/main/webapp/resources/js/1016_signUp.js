let func = function() {

    let userId = document.getElementById('userId').value;
    let userName = document.getElementById('userName').value;
    let userPw = document.getElementById('userPw').value;
    let userPassCheck = document.getElementById('userPassCheck').value;
    let userPhone = document.getElementById('userPhone').value;

    // console.log(userId);
    // console.log(userName);
    // console.log(userPw);
    // console.log(userPassCheck);
    // console.log(userPhone);

    alert('회원가입을 축하합니다!');

    if (!userId) {
        alert('아이디를 입력하세요.')
        document.getElementById('userId').focus();

        return;
    }
    if (!userName) {
        alert('아이디를 입력하세요.')
        document.getElementById('userName').focus();

        return;
    }
    if (!userPw) {
        alert('아이디를 입력하세요.')
        document.getElementById('userPw').focus();

        return;
    }
    if (!userPassCheck) {
        alert('아이디를 입력하세요.')
        document.getElementById('userPassCheck').focus();

        return;
    }

    if (!userPhone) {
        alert('아이디를 입력하세요.')
        document.getElementById('userPhone').focus();

        return;

}

sign.addEventListener('click',func);
}
