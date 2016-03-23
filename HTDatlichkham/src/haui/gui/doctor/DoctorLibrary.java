/**
 * 
 */
package haui.gui.doctor;

import java.util.ArrayList;

import haui.objects.DoctorObject;

/**
 * @author Dinh Hieu
 *
 */
public class DoctorLibrary {

	public static String viewDoctorObject(DoctorObject item) {
		String tmp = " ";
		tmp += "<div class=\"doctor-img\"><img src=\"" + item.getDoctor_img() + "\"></div>";
		tmp += "<div class=\"doctor-infor\">";
		tmp += "<p><label>" + item.getDoctor_name() + "</label></p> ";
		tmp += "<p><label>Tuổi:&nbsp </label>" + item.getDoctor_age() + "</p>";
		tmp += "<p><label>Bằng cấp:&nbsp </label>" + item.getDoctor_degree() + "</p>";
		tmp += "<p><label>Kinh nghiệm:&nbsp </label>" + item.getDoctor_experience() + "</p>";
		tmp += "<p><label>Phòng làm việc:&nbsp </label>" + item.getDoctor_workroom() + "</p>";
		tmp += "</div>";
		return tmp;
	}

	public static String viewDoctorObjects(ArrayList<DoctorObject> items) {
		String tmp = " <div style=\"margin: 0px auto;\"> ";
		
		tmp += " <div id=\"amazingcarousel-container-1\">  ";
		tmp += " <div id=\"amazingcarousel-1\"	style=\"display: block; position: relative; width: 900px; margin: 0px auto 0px;\"> ";
		tmp += " <div class=\"amazingcarousel-list-container\"> ";
		tmp += " <ul class=\"amazingcarousel-list\"> ";
		
		for(DoctorObject item: items){
			
			tmp += " <li class=\"amazingcarousel-item\"> ";
			tmp += " <div class=\"amazingcarousel-item-container\"> ";
			tmp += " <div class=\"amazingcarousel-image\"> ";
			tmp += " <a href=\"#\"> ";
			tmp += " <img src=\""+item.getDoctor_img()+"\" /> ";			
			tmp += " </a> ";
			tmp += " </div> ";
			tmp += " <a href=\"#\"> ";
			tmp += " <div class=\"amazingcarousel-title\">"+item.getDoctor_name()+"</div> ";
			tmp += " </a> ";
			tmp += " <div class=\"amazingcarousel-description\">"+item.getDoctor_experience()+"</div> ";
			tmp += " </div> ";
			tmp += " </li> ";
		}
		
		
		tmp += " </ul> ";
		tmp += " <div class=\"amazingcarousel-prev\"></div>  ";
		tmp += " <div class=\"amazingcarousel-next\"></div> ";
		tmp += " </div> ";
		tmp += " <div class=\"amazingcarousel-nav\"></div> ";
		tmp += " </div> ";
		tmp += " </div>	 ";
		tmp += " </div> ";
		
		
		
			
				
					
						
							
								
									
									
									
								
								
								
							
												
					
					
					
				
				
			
		

	

		
		

		return tmp;
	}
}
