// 아이디 입력
// 비번 6글자 이상
// 비번 같아야 함
// 이름 입력
// 폰번호 입력
// 이메일 입력
// 생일(현재보다 과거)

console.log("member join")

const checks = [false,false,false,false,false,false,false]

const username = document.getElementById("username")

username.addEventListener("blur", function(){
    console.log("start")
	let num="";
	fetch(`./idCheck?username=${username.value}`)
	.then(res => res.text())
	.then(res => {
		if(res.trim()==='1'){
			//--- 사후 처리
			console.log("중복 아님")
			num = res;
		}else {
			//---- 
			console.log("중복입니다")
			num=res;
		}
	})
	console.log(num)
	console.log("finish")

})