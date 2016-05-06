//Các xử lý cho user.html

function generatePermis(){//sinh ra danh sách quyền cho hệ thống
	var permis = new Array();//không khai báo kích thước nên size= chỉ số lớn nhất + 1
													// các chỉ số không cần lần lượt và không cần theo thứ tự
	
	permis[0] = "---chọn quyền---" ;
	permis[1] = "Tác giả (Author)" ;
	permis[2] = "Quản lý (Manager)" ;
	permis[3] = "Quản trị (Administrator)" ;
	permis[4] = "Quản trị cấp cao (Super Admin)" ;
	
	var opt = "<select name=\"slcUserPermis\" onChange=\"refreshPermis(this.form)\">";
	for(var i=0; i<permis.length; i++){
		opt += "<option value="+i+">";
		opt += permis[i];
		opt += "</option>";
	}
	
	opt += "</select>";
	
	//in ra
	document.write(opt);
}

function generateRoles(){
	var roles = new Array();
	
	roles[0]= "Người sử dụng";
	roles[1]= "Chuyên mục tin bài";
	roles[2]= "Thể loại tin bài";
	roles[3]= "Tin bài";
	roles[4]= "Hệ sản phẩm";
	roles[5]= "Nhóm sản phẩm";
	roles[6]= "Loại sản phẩm";
	roles[7]= "Sản phẩm";
	roles[8]= "Hóa đơn";
	roles[9]= "Khách hàng";
	
	var role="";
	
	for(var i=0;i<roles.length;i++){
		if(i%3 == 0){
			role += "<tr>";
		}
		role += "<td>";
		role += "<input type=checkbox name=chks id=chk"+i+" disabled >";
		role += "<label for=chk"+i+" >";
		role += " Quản lý "+roles[i];
		role += "</label>";
		role += "</td>";		
				
		if(i%3 == 2 || i == roles.length-1){
			role += "</tr>";
		}
	}
	
	//in ra
	document.write(role);
}


function setCheckBox(fn, dis, check){
	//Duyệt các phần tử của form
	for(var i=0; i<fn.elements.length; i++){//element là đối tượng chứa tất cả các phần tử của form
		if(fn.elements[i].type == "checkbox" && fn.elements[i].name == "chks"){
			fn.elements[i].disabled = dis;
			fn.elements[i].checked = check;
		}
	}
}

function refreshPermis(fn){
	var permis = parseInt(fn.slcUserPermis.value);
	
	if(permis==3 || permis==4){
		this.setCheckBox(fn, true, true);
	}else if(permis==2){
		this.setCheckBox(fn, false, true);
	}else if(permis==1){
		this.setCheckBox(fn, false, false);
	}else{
		this.setCheckBox(fn, true, false);
	}	
	
}

function setFirstTime(fn){
	this.setCheckBox(fn, true, false);
	fn.reset();
}

function checkValidUser(fn){
	//Lấy thông tin
	var username = fn.txtUserName.value;
	var userpass = fn.txtUserPass.value;
	var useremail = fn.txtUserEmail.value;
	var userpermis = parseInt(fn.slcUserPermis.value);
	
	//Các biến xác nhận sự hợp lệ
	var validUserName = true;
	var validUserPass = true;
	var validUserEmail = true;
	var validUserPermis = true;
	
	//Biến lưu trữ thông báo
	var message = "";
	
	//Kiểm tra sự hợp lệ của 4 giá trị
	if(username.trim() == ""){
		message = "Thiếu tên đăng nhập cho tài khoản.";
		validUserName = false;
	}
	
	if(userpass.trim() == ""){
		message += "\nThiếu mật khẩu cho tài khoản."; 
		validUserPass = false;
	}else{
		if(userpass.length<6){
			message += "\nMật khẩu quá ngắn, cần phải lớn hơn 5 kí tự.";
			validUserPass = false;
		}
	}
	
	if(useremail.trim() == ""){
		message += "\nThiếu hộp thư cho tài khoản.";
		validUserEmail = false;		
	}else{
		var pattern = /\w+@\w+[.]\w/
		if(!useremail.match(pattern)){
			message += "\nKhông đúng cấu trúc hộp thư.";
			validUserEmail = false;
		}
	}
	
	if(userpermis == 1 || userpermis == 2){	
		for(var i=0; i<fn.elements.length; i++){
			if(fn.elements[i].type=="checkbox" && fn.elements[i].name == "chks"){					
				if(fn.elements[i].checked){
					validUserPermis = true;
					break;
				}else{
					validUserPermis = false;
				}
			}	
		}
	}
	
	if(!validUserPermis){
		message += "\nCần có ít nhất 1 vai trò cho quyền này."; 
	}
	
	//Xuất thông báo
	if(message != ""){
		alert(message);
		
		if(!validUserName){
			fn.txtUserName.focus();
		}else if (!validUserPass){
			fn.txtUserPass.focus();
			fn.txtUserPass.select();
		}else if (!validUserEmail){
			fn.txtUserEmail.focus();
			fn.txtUserEmail.select();
		}else if (!validUserPermis){
			fn.slcUserPermis.focus();			
		}
	}
	
	//Trả về kết quẩ kiểm tra
	return validUserName && validUserPass && validUserEmail && validUserPermis;
}

function saveUser(fn){
	if(this.checkValidUser(fn)){
		fn.method = "POST"; //gọi vào doPost()
		fn.action="/adv/user/ae";
		fn.submit();
	}
}

function refreshViewNumber(fn, url){
	fn.method = "POST";
	fn.action = url;
	fn.submit();
}
