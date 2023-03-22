package payroll_system;


import java.util.LinkedList;

import javax.swing.JFrame;



public class Runner {

	public static void main(String[] args)
	{
		JFrame.setDefaultLookAndFeelDecorated(true);

		LinkedList<list_model> payroll_list = new LinkedList<list_model>();
		

		
		payroll_list.add(new list_model(1,"dela Cruz","Juan","Human Resources","Experienced Contributor",151,6,6,20000,16,4,6,4,2009,5,11,1989));
		payroll_list.add(new list_model(2,"White","Walter","IT Department","Experienced Contributor",153,6,12,280000,12,1,8,3,2001,6,15,1989));
		payroll_list.add(new list_model(3,"Grimes","Rick","Accounting and Finance","Experienced Contributor",241,6,5,600000,28,6,9,16,2000,7,12,2017));
		payroll_list.add(new list_model(4,"Getzeflammenwerfer","Hans","Human Resources","Experienced Contributor",161,6,6,20000,16,4,6,4,2009,5,11,1989));
		payroll_list.add(new list_model(5,"Fa Coff","Kanye","IT Department","Experienced Contributor",171,6,12,280000,12,1,8,3,2001,6,15,1989));
		payroll_list.add(new list_model(6,"Doge","Wow","Accounting and Finance","Experienced Contributor",461,6,5,600000,28,6,9,16,2000,7,12,2017));

		
		Menu_ menu = new Menu_(payroll_list);
		menu.setVisible(true);
		


	}
	
	
}
	