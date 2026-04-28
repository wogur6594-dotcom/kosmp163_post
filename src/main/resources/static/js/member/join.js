// 아이디 입력
// 비번 6글자 이상
// 비번 같아야 함
// 이름 입력
// 폰번호 입력
// 이메일 입력
// 생일(현재보다 과거)

const username = document.getElementById("username");
const username_result = document.getElementById("username_result");
const password = document.getElementById("password");
const password_result = document.getElementById("password_result");
const passwordcheck = document.getElementById("passwordcheck");
const passwordcheck_result = document.getElementById("passwordcheck_result");
const name = document.getElementById("name");
const phone = document.getElementById("phone");
const email = document.getElementById("email");
const email_result = document.getElementById("email");
const email_result2 = document.getElementById("email");
const birth = document.getElementById("birth");
const button = document.getElementById("button");




flag1 = false;
flag2 = false;
flag3 = false;

username.addEventListener("blur", function() {
    if (username.value.trim()=="") {
        username_result.innerText = "username 입력"
    } else {
        username_result.innerText = ""
        flag1 = true;
    }
});

password.addEventListener("blur", function() {
    if (password.value.length < 6) {
        password_result.innerText = "password는 최소 6자리"
    } else {
        password_result.innerText = ""
        flag2 = true;

    }
});
passwordcheck.addEventListener("blur", function() {
    if (passwordcheck.value != password.value) {
        passwordcheck_result.innerText = "password와 일치해야함"
    } else {
        passwordcheck_result.innerText = ""
        flag3 = true;
    }
});
button.addEventListener("click", function() {
    if (username.value.trim() != "" && flag2 && flag3==true) {
        alert("성공")
    } else {
        alert("실패")
    }
username.addEventListener("blur",function(){
    fetch(`./idCheck?username=${username.value}`)
    .then(res => res.text())
    .then(res => console.log(res))
})
});


