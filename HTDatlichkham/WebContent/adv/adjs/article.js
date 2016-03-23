//Các xử lý cho article

function setFirstTime(fn) {
	fn.reset();
}

function checkValidArticle(fn) {
	// Lấy thông tin
	var username = fn.txtUserName.value;
	var userpass = fn.txtUserPass.value;
	var useremail = fn.txtUserEmail.value;
	var userpermis = parseInt(fn.slcUserPermis.value);

	// Các biến xác nhận sự hợp lệ
	var validUserName = true;
	var validUserPass = true;
	var validUserEmail = true;
	var validUserPermis = true;

	// Biến lưu trữ thông báo
	var message = "";

	// Kiểm tra sự hợp lệ của 4 giá trị
	if (username.trim() == "") {
		message = "Thiếu tên đăng nhập cho tài khoản.";
		validUserName = false;
	}

	if (userpass.trim() == "") {
		message += "\nThiếu mật khẩu cho tài khoản.";
		validUserPass = false;
	} else {
		if (userpass.length < 6) {
			message += "\nMật khẩu quá ngắn, cần phải lớn hơn 5 kí tự.";
			validUserPass = false;
		}
	}

	if (useremail.trim() == "") {
		message += "\nThiếu hộp thư cho tài khoản.";
		validUserEmail = false;
	} else {
		var pattern = /\w+@\w+[.]\w/
		if (!useremail.match(pattern)) {
			message += "\nKhông đúng cấu trúc hộp thư.";
			validUserEmail = false;
		}
	}

	if (userpermis == 1 || userpermis == 2) {
		for (var i = 0; i < fn.elements.length; i++) {
			if (fn.elements[i].type == "checkbox"
					&& fn.elements[i].name == "chks") {
				if (fn.elements[i].checked) {
					validUserPermis = true;
					break;
				} else {
					validUserPermis = false;
				}
			}
		}
	}

	if (!validUserPermis) {
		message += "\nCần có ít nhất 1 vai trò cho quyền này.";
	}

	// Xuất thông báo
	if (message != "") {
		alert(message);

		if (!validUserName) {
			fn.txtUserName.focus();
		} else if (!validUserPass) {
			fn.txtUserPass.focus();
			fn.txtUserPass.select();
		} else if (!validUserEmail) {
			fn.txtUserEmail.focus();
			fn.txtUserEmail.select();
		} else if (!validUserPermis) {
			fn.slcUserPermis.focus();
		}
	}

	// Trả về kết quẩ kiểm tra
	return validUserName && validUserPass && validUserEmail && validUserPermis;
}

function saveArticle(fn) {
	// if(this.checkValidUser(fn)){
	fn.method = "POST"; // gọi vào doPost()
	fn.action = "/adv/article/ae";
	fn.submit();
	// }
}
