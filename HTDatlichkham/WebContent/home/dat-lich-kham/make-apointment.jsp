<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>


<link rel="stylesheet"
	href="${pageContext.request.contextPath}/home/css/jquery-ui.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/home/css/make-apointment.css">
<style type="text/css">
.container {
	width: 980px;
	border: 1px solid #BEBEBE;
	margin-bottom: 40px;
	padding: 20px;
}

.stepwizard-step p {
	margin-top: 10px;
}

.stepwizard-row {
	display: table-row;
}

.stepwizard {
	display: table;
	width: 70%;
	position: relative;
}

.stepwizard-step button[disabled] {
	opacity: 1 !important;
	filter: alpha(opacity = 100) !important;
}

.stepwizard-row:before {
	top: 14px;
	bottom: 0;
	position: absolute;
	content: " ";
	width: 100%;
	height: 1px;
	background-color: #ccc;
	z-order: 0;
}

.stepwizard-step {
	display: table-cell;
	text-align: center;
	position: relative;
}

.btn-circle {
	width: 30px;
	height: 30px;
	text-align: center;
	padding: 6px 0;
	font-size: 12px;
	line-height: 1.428571429;
	border-radius: 15px;
}
</style>


<div class="container">

	<div class="stepwizard col-md-offset-2">
		<div class="stepwizard-row setup-panel">
			<div class="stepwizard-step">
				<a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>
				<p>Thông tin cuộc hẹn</p>
			</div>
			<div class="stepwizard-step">
				<a href="#step-2" type="button" class="btn btn-default btn-circle"
					disabled="disabled">2</a>
				<p>Thông tin cá nhân</p>
			</div>
			<div class="stepwizard-step">
				<a href="#step-3" type="button" class="btn btn-default btn-circle"
					disabled="disabled">3</a>
				<p>Kiểm tra và xác nhận</p>
			</div>
		</div>

	</div>
	<form role="form"
		action="${pageContext.request.contextPath}/home/dat-lich-kham/make-apointment"
		method="post" id="frmApointment">
		<div class="row setup-content" id="step-1">
			<div class="col-xs-8 col-md-offset-2">
				<div class="col-md-12">
					<h3>Thông tin cuộc hẹn</h3>

					<div class="form-group col-xs-6">
						<label class="control-label">Chọn chuyên khoa*</label> <select
							class="form-control" name="slcSpeciality" id="slcSpeciality"
							required>
							<option value="" selected="selected" disabled="disabled">---</option>
							<%
								//tim cau truc hien thi cua chuyen khoa qua session
								String viewSpecialities = (String) session.getAttribute("viewSpecialities");
								if (viewSpecialities != null && !viewSpecialities.equalsIgnoreCase("")) {
									out.print(viewSpecialities);
								}
							%>

						</select>
					</div>

					<div class="form-group col-xs-6">
						<label class="control-label">Chọn bác sĩ *</label> <select
							id="slcDoctor" class="form-control" name="slcDoctor" required>
							<option value="" selected="selected" disabled="disabled">---</option>
						</select>
					</div>
					
					<div id="doctor-infor"></div>

					<div class="form-group col-xs-6">
						<label class="control-label">Ngày bạn muốn đặt hẹn*</label> <input
							maxlength="100" type="text" disabled  required onfocus="blur()"
							class="form-control" id="dpDate" name="txtDate" />
					</div>
					<div class="form-group col-xs-3">
						<label class="control-label">Giờ hẹn*</label> <select required disabled
							class="form-control" name="slcTime" id="slcTime">
							<option value="" selected="selected" disabled>---</option>							
							<option value="7:30">7:30</option>
							<option value="7:45">7:45</option>
							<option value="8:00">8:00</option>
							<option value="8:15">8:15</option>
							<option value="8:30">8:30</option>
							<option value="8:45">8:45</option>
							<option value="9:00">9:00</option>
							<option value="9:15">9:15</option>
							<option value="9:30">9:30</option>
							<option value="9:45">9:45</option>
							<option value="10:00">10:00</option>
							<option value="10:15">10:15</option>
							<option value="10:30">10:30</option>
							<option value="10:45">10:45</option>
							<option value="11:00">11:00</option>
							<option value="11:15">11:15</option>
							<option value="11:30">11:30</option>
							<option value="11:45">11:45</option>
							<option value="" disabled>---</option>
							<option value="13:30">13:30</option>
							<option value="13:45">13:45</option>
							<option value="14:00">14:00</option>
							<option value="14:15">14:15</option>
							<option value="14:30">14:30</option>
							<option value="14:45">14:45</option>
							<option value="15:00">15:00</option>
							<option value="15:15">15:15</option>
							<option value="15:30">15:30</option>
							<option value="15:45">15:45</option>
							<option value="16:00">16:00</option>
							<option value="16:15">16:15</option>
							<option value="16:30">16:30</option>
							<option value="16:45">16:45</option>
							
						</select>
					</div>				


					<div class="form-group col-xs-12">
						<label class="control-label">Nguyên nhân/ Triệu chứng* </label>
						<textarea rows="8" required class="form-control" name="txtSymptom"
							id="txtSymptom"></textarea>
					</div>
					<button class="btn btn-primary nextBtn btn-lg pull-right " id="btnCreateApointment"
						type="button">Tạo cuộc hẹn</button>
				</div>
			</div>
		</div>
		<div class="row setup-content" id="step-2">
			<div class="col-xs-8 col-md-offset-2">
				<div class="col-md-12">
					<h3>Thông tin cá nhân</h3>
					<div class="form-group col-xs-8">
						<label class="control-label">Họ tên*</label> <input
							maxlength="200" type="text" required class="form-control"
							placeholder="Nhập họ tên" id="txtName" name="txtName" />
					</div>

					<div class="form-group col-xs-6">
						<label class="radio inline control-label">Giới tính*</label>
						<div class="col-sm-8">
							<label class="radio-inline" for="rdNam"> <input type="radio"
								name="rdGender" id="rdNam" value="1" required /> Nam
							</label> <label class="radio-inline" for="rdNu"> <input type="radio"
								name="rdGender" id="rdNu" value="0" required /> Nữ
							</label>
						</div>
					</div>

					<div class="form-group col-xs-7">
						<label class="control-label">Ngày sinh*</label> <input
							maxlength="200" type="text" required="required" onfocus="blur()"
							class="form-control" name="txtBirthday" id="dpBirthday" />
					</div>					
					<div class="form-group col-xs-8">
						<label class="control-label">Địa chỉ*</label> <input
							maxlength="200" type="text" required class="form-control"
							placeholder="Nhập địa chỉ" id="txtAddress" name="txtAddress" />
					</div>
					<div class="form-group col-xs-7">
						<label class="control-label">Điện thoại*</label><input
							maxlength="200" type="number" required="required" id="txtPhone"
							class="form-control" name="txtPhone" />
					</div>
					<div class="form-group col-xs-10">
						<label class="control-label">Email*</label> <input maxlength="200"
							type="email" required class="form-control" id="txtEmail"
							placeholder="Nhập email" name="txtEmail"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" />
					</div>
					
					

					<button class="btn btn-primary nextBtn btn-lg pull-right" col-xs-3
						onclick="showInput()" id="btnVerify" type="button">Tiếp
						tục đăng ký</button>
				</div>
			</div>
		</div>
		<div class="row setup-content" id="step-3">
			<div class="col-xs-8 col-md-offset-2">
				<div class="col-md-12">
					<p class="title">
						Thông tin cuộc hẹn bạn yêu cầu:<br />
					</p>
					<p class="title">Thông tin cá nhân:</p>
					<p class="label">
						Họ tên: <label id="name" class="showdata"></label>
					</p>
					<p class="label">
						Giới tính: <label id="gender" class="showdata"></label>
					</p>
					<p class="label">
						Ngày sinh: <label id="birthday" class="showdata"></label>
					</p>
					<p class="label">
						Địa chỉ: <label id="address" class="showdata"></label>
					</p>
					<p class="label">
						Điện thoại: <label id="phone" class="showdata"></label>
					</p>
					<p class="label">
						Email: <label id="email" class="showdata"></label>
					</p>

					<p class="title">Thông cuộc hẹn:</p>
					<p class="label">
						Tên bác sĩ: <label id="doctor" class="showdata"></label>
					</p>
					<p class="label">
						Chuyên khoa: <label id="speciality" class="showdata"></label>
					</p>
					<p class="label">
						Nguyên nhân/ Triệu chứng: <label id="symptom" class="showdata"></label>
					</p>
					<p class="label">
						Ngày: <label id="date" class="showdata"></label> - <label
							id="time" class="showdata"></label>
					</p>


					<button class="btn btn-primary nextBtn btn-lg pull-right"
						type="submit">Tôi muốn đặt lịch hẹn này</button>


				</div>
			</div>
		</div>		
	</form>
	<span><label style="color: red; text-align: center;margin-top: 20px;font-size: 14px"
		id="message"></label></span>

</div>




<script type="text/javascript">
	//date picker
	$(function() {
		$("#dpDate").datepicker({
			minDate : new Date(),
			maxDate : "+1m",
			changeYear : true,
			changeMonth : true,

		});

		var dateToday = new Date();
		$("#dpBirthday").datepicker(
				{
					yearRange : (dateToday.getFullYear() - 100) + ":"
							+ (dateToday.getFullYear()),
					maxDate : new Date(),
					changeYear : true,
					changeMonth : true
				});
	});

	$(document)
			.ready(
					function() {

						//show to select doctor in dropdown list						
						$('#slcSpeciality').change(
								function(event) {
									var specialityId = $("#slcSpeciality").val();								
									$.get('/home/dat-lich-kham/apointment', {
										SpecialityId : specialityId
									}, function(response) {

										var select = $('#slcDoctor');
										select.find('option').remove();
										$("#slcDoctor").append('<option value="" selected disabled>---</option>');
										$.each(response,
												function(index, value) {
													$('<option>').val(value.doctor_id)
															.text(value.doctor_name)
															.appendTo(select);
												});
									});									
									

								});
						
						//show doctor infor
						$('#slcDoctor').change(
								function(event) {
									var doctorId = $("#slcDoctor").val();
									$("#doctor-infor").load('doctor-infor.jsp', {
										"doctorId" : doctorId
									});
									
									//enable txtDate
									$('#dpDate').prop('disabled', false);									
									
								});
						
						//enable slcTime
						$('#dpDate').change(function(event) {
							$('#slcTime').prop('disabled', false);	
						});
						
						//check the time of apointment
						$('#slcTime, #dpDate,#slcDoctor').change(function(event) {							
							var doctorid = $("#slcDoctor").val();	
							var date = $("#dpDate").val();
							var time = $("#slcTime").val();
							
							$.post('/home/dat-lich-kham/apointment', {
								doctorid : doctorid,
								date : date,
								time : time								
							}, function(response) {
									$("#message").html("");	
									if(response=="error"){
										$("#btnCreateApointment").prop('disabled', true);	
										$("#message").html("* Đã có người đặt lịch hẹn với bác sĩ này trong cùng thời điểm, vui lòng chọn ngày giờ khác để tiếp tục đặt hẹn!");	
									}else{
										$("#btnCreateApointment").prop('disabled', false);
										$("#message").html("");	
									}
																		
							});				
						});

						//show data to veryfication				    
						$('#btnVerify')
								.click(
										function() {
											$("#name")
													.html($("#txtName").val());
											
											$("input[type='radio']:checked").each(function() {
										        var idVal = $(this).attr("id");										        
										        $("#gender").html($("label[for='"+idVal+"']").text());
										    });
											
											
											$("#birthday").html(
													$("#dpBirthday").val());
											$("#phone").html(
													$("#txtPhone").val());
											$("#address").html(
													$("#txtAddress").val());
											$("#email").html(
													$("#txtEmail").val());
											$("#doctor").html(
													$("#slcDoctor :selected")
															.text());
											$("#speciality")
													.html(
															$(
																	"#slcSpeciality :selected")
																	.text());
											$("#symptom").html(
													$("#txtSymptom").val());
											$("#date").html($("#dpDate").val());
											$("#time")
													.html($("#slcTime").val());
										});

						var navListItems = $('div.setup-panel div a'), allWells = $('.setup-content'), allNextBtn = $('.nextBtn');

						allWells.hide();

						navListItems
								.click(function(e) {
									e.preventDefault();
									var $target = $($(this).attr('href')), $item = $(this);

									if (!$item.hasClass('disabled')) {
										navListItems.removeClass('btn-primary')
												.addClass('btn-default');
										$item.addClass('btn-primary');
										allWells.hide();
										$target.show();

									}
								});

						allNextBtn
								.click(function() {
									var curStep = $(this).closest(
											".setup-content"), curStepBtn = curStep
											.attr("id"), nextStepWizard = $(
											'div.setup-panel div a[href="#'
													+ curStepBtn + '"]')
											.parent().next().children("a"), curInputs = curStep
											.find("input[type='text'],input[type='url'],textarea,select,input[type='radio'],input[type='number'],input[type='email']"), isValid = true;

									$(".form-group").removeClass("has-error");
									$("#message").html("");
									for (var i = 0; i < curInputs.length; i++) {
										if (!curInputs[i].validity.valid) {
											isValid = false;
											$(curInputs[i]).closest(
													".form-group").addClass(
													"has-error");
											$("#message")
													.html(
															" * Bạn phải điền đầy đủ và chính xác các thông tin bắt buộc");
										}
									}

									if (isValid)
										nextStepWizard.removeAttr('disabled')
												.trigger('click');
								});

						$('div.setup-panel div a.btn-primary').trigger('click');

					});
</script>