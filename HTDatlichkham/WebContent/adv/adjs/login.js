//các xử lý kịch bản cho login.html

function checkValidUser(fn){
	//Lấy giá trị các thành phần form 
	var username= fn.txtUserName.value;//biến thuần túy lậy giá trị thì viết thường
	var userpass= fn.txtUserPass.value;
	
	//Biến xác nhận sự hợp lệ
	var validUserName = true;
	var validUserPass = true;
	
	//Lưu trữ thông báo
	var message = "";
	
	//Kiểm tra
	if(username == ""){
		validUserName = false;
		message = "Nhập vào tên đăng nhập.";
	}
	
	if(userpass == ""){
		validUserPass = false;
		message += "\nThiếu mật khẩu đăng nhập.";
	}else{
		if(userpass.length<6){
			validUserPass = false;
			message += "\nMật khẩu không chính xác.";
		}
	}
	
	//Xuât thông báo và định vị con trỏ nhập liệu
	if(message != ""){
		alert(message);
		
		if(!validUserName){
			fn.txtUserName.focus();			
		}else if(!validUserPass){
			fn.txtUserPass.focus();
			fn.txtUserPass.select();
		}
	}
	
	//Trả về kết quẩ kiểm tra
	return validUserName && validUserPass;
}



function login(fn){
	if(this.checkValidUser(fn)){
		fn.method="POST";//gọi vào doPost()
		fn.action= "/adv/user/login";//đường dẫn chạy Servlet login
		fn.submit();
	}
	

}