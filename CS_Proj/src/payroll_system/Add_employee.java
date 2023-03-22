package payroll_system;

import java.util.LinkedList;

import javax.swing.JOptionPane;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Add_employee extends JFrame {


	private JPanel contentPane;
	private JTextField lastname;
	private JTextField firstname;
	private JTextField empid;
	private JLabel lblId;
	private JTextField hourlysal;
	private JTextField daysworked;
	private JTextField overtime;
	private JTextField paidleaves;

	int id;
	String lname;
	String fname;
	String dep;
	String pos;
	float sal;
	int pdlv;
	int hrswrkd;
	float totalpay;
	int dayswrkd;
	int hrsovrtm;
	int mo;
	int dys;
	int yrs;

	
		public Add_employee(LinkedList<list_model> list) {
			setTitle("Payroll System - Add Employee");

			
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 425, 289);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			lastname = new JTextField();
			lastname.setBounds(107, 35, 294, 20);
			contentPane.add(lastname);
			lastname.setColumns(10);
			
			firstname = new JTextField();
			firstname.setBounds(107, 62, 154, 20);
			contentPane.add(firstname);
			firstname.setColumns(10);
			
			JLabel lblFirstname = new JLabel("Last Name");
			lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblFirstname.setBounds(31, 40, 77, 14);
			contentPane.add(lblFirstname);
			
			JLabel lblLastName = new JLabel("First Name");
			lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblLastName.setBounds(31, 68, 77, 14);
			contentPane.add(lblLastName);
			
			empid = new JTextField();
			empid.setColumns(10);
			empid.setBounds(291, 62, 110, 20);
			contentPane.add(empid);
			
			lblId = new JLabel("ID");
			lblId.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblId.setBounds(271, 64, 15, 14);
			contentPane.add(lblId);
			
			Choice department = new Choice();
			department.setBounds(107, 115, 294, 20);
			contentPane.add(department);
			department.add("Human Resources");
			department.add("IT Department");
			department.add("Accounting and Finance");
			department.add("Marketing");
			department.add("Research and Development");
			department.add("Purchasing");


			
			JLabel lblDepartment = new JLabel("Department");
			lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDepartment.setBounds(20, 117, 78, 14);
			contentPane.add(lblDepartment);
			
			Choice position = new Choice();
			position.setBounds(107, 141, 294, 20);
			contentPane.add(position);
			position.add("Entry Level Contributor");
			position.add("Experienced Contributor");
			position.add("Manager");
			position.add("Senior Professional");
			position.add("Director");
			position.add("General Manager");

			
			JLabel lblPosition = new JLabel("Position");
			lblPosition.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPosition.setBounds(49, 142, 57, 14);
			contentPane.add(lblPosition);
			
			hourlysal = new JTextField();
			hourlysal.setColumns(10);
			hourlysal.setBounds(107, 167, 57, 20);
			contentPane.add(hourlysal);
			
			JLabel lblSalaryhourly = new JLabel("Hourly Salary");
			lblSalaryhourly.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSalaryhourly.setBounds(10, 169, 107, 14);
			contentPane.add(lblSalaryhourly);
			
			Choice hoursworked = new Choice();
			hoursworked.setBounds(330, 167, 71, 20);
			contentPane.add(hoursworked);
			hoursworked.add("1");
			hoursworked.add("2");
			hoursworked.add("3");
			hoursworked.add("4");
			hoursworked.add("5");
			hoursworked.add("6");
			hoursworked.add("7");
			hoursworked.add("8");
			hoursworked.add("9");
			hoursworked.add("10");
			hoursworked.add("11");
			hoursworked.add("12");
			hoursworked.add("13");
			hoursworked.add("14");
			hoursworked.add("15");

			
			JLabel lblHoursWorkedPer = new JLabel("Hours Worked Per Day");
			lblHoursWorkedPer.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHoursWorkedPer.setBounds(174, 169, 161, 14);
			contentPane.add(lblHoursWorkedPer);
			
			JLabel lblDaysWorked = new JLabel("Days Worked");
			lblDaysWorked.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDaysWorked.setBounds(10, 196, 107, 14);
			contentPane.add(lblDaysWorked);
			
			daysworked = new JTextField();
			daysworked.setColumns(10);
			daysworked.setBounds(107, 194, 81, 20);
			contentPane.add(daysworked);
			
			JLabel lblHoursOfOvertimes = new JLabel("Hours of Overtimes");
			lblHoursOfOvertimes.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHoursOfOvertimes.setBounds(198, 196, 137, 14);
			contentPane.add(lblHoursOfOvertimes);
			
			overtime = new JTextField();
			overtime.setColumns(10);
			overtime.setBounds(330, 193, 71, 20);
			contentPane.add(overtime);
			
			paidleaves = new JTextField();
			paidleaves.setColumns(10);
			paidleaves.setBounds(107, 219, 81, 20);
			contentPane.add(paidleaves);
			
			JLabel lblNumbersOfPaid = new JLabel("Paid Leaves");
			lblNumbersOfPaid.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNumbersOfPaid.setBounds(20, 221, 77, 14);
			contentPane.add(lblNumbersOfPaid);
			
			JComboBox mnth = new JComboBox();
			mnth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
			mnth.setBounds(107, 87, 129, 22);
			contentPane.add(mnth);
			
			String[] day_ = new String[31];
			for(int i=0;i<31;i++)
			{
				day_[i]=(i+1)+"";
			}
			
			JComboBox Day = new JComboBox();
			Day.setBounds(243, 87, 71, 22);
			contentPane.add(Day);
			Day.setModel(new DefaultComboBoxModel(day_));
			
			String[] year_ = new String[38];
			int x=0;
			for(int i=1980;i<=2017;i++)
			{
				year_[x]=i+"";
				x++;
			}
			JComboBox Year = new JComboBox();
			Year.setBounds(324, 87, 77, 22);
			Year.setModel(new DefaultComboBoxModel(year_));
			contentPane.add(Year);
			
			JLabel lblHireDate = new JLabel("Hire Date");
			lblHireDate.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHireDate.setBounds(35, 93, 61, 15);
			contentPane.add(lblHireDate);
			
			JButton btnSubmit = new JButton("Submit");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				try{
					
					//Validation of inputs. Ensures data inserted is correct.
					if (!empid.getText().matches("[0-9]+") || !(empid.getText().length() > 0)||!(hourlysal.getText().matches("[0-9]+")||hourlysal.getText().contains(".")) || !(hourlysal.getText().length() > 0)||!daysworked.getText().matches("[0-9]+") || !(daysworked.getText().length() > 0)||!overtime.getText().matches("[0-9]+") || !(overtime.getText().length() > 0)||!paidleaves.getText().matches("[0-9]+") || !(paidleaves.getText().length() > 0)) {
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}

					else{
						
						
						//Ensures that the employee ID chosen does not exist yet.
						int temp = Integer.parseInt(empid.getText());
						int temp1 = 0;
						for(list_model d: list)
						{
							if(d.getEmp_id()==temp)
							{
								temp1=d.getEmp_id();
							}
						}
						
						if(temp1==temp)
						{
							JOptionPane.showMessageDialog(null, "Employee ID already taken");

						}
						
						else{
					id = Integer.parseInt(empid.getText());
					lname = lastname.getText();
					fname = firstname.getText();
					dep = department.getSelectedItem();
					pos = position.getSelectedItem();
					sal = Float.parseFloat(hourlysal.getText());
					pdlv = Integer.parseInt(paidleaves.getText());
					hrswrkd = Integer.parseInt(hoursworked.getSelectedItem());
					dayswrkd = Integer.parseInt(daysworked.getText());
					hrsovrtm = Integer.parseInt(overtime.getText());
					totalpay = ((dayswrkd+pdlv)*hrswrkd+hrsovrtm)*sal;
				
					//Converts months into number
					if(mnth.getSelectedItem().equals("January"))
					{
						mo=1;
					}
					else if(mnth.getSelectedItem().equals("February"))
					{
						mo=2;
					}
					else if(mnth.getSelectedItem().equals("March"))
					{
						mo=3;
					}
					else if(mnth.getSelectedItem().equals("April"))
					{
						mo=4;
					}
					else if(mnth.getSelectedItem().equals("May"))
					{
						mo=5;
					}
					else if(mnth.getSelectedItem().equals("June"))
					{
						mo=6;
					}
					else if(mnth.getSelectedItem().equals("July"))
					{
						mo=7;
					}
					else if(mnth.getSelectedItem().equals("August"))
					{
						mo=8;
					}
					else if(mnth.getSelectedItem().equals("September"))
					{
						mo=9;
					}
					else if(mnth.getSelectedItem().equals("October"))
					{
						mo=10;
					}
					else if(mnth.getSelectedItem().equals("November"))
					{
						mo=11;
					}
					else if(mnth.getSelectedItem().equals("December"))
					{
						mo=12;
					}
					dys=Integer.parseInt((String) Day.getSelectedItem());
					yrs=Integer.parseInt((String) Year.getSelectedItem());
					
			//Add the inputs to the linked list class using linkedlist add method
						LinkedList<list_model> list2 = list;
						list2.add(new list_model(id,lname,fname,dep,pos,sal,pdlv,hrswrkd,totalpay,dayswrkd,hrsovrtm,mo,dys,yrs,mo,dys,yrs));
						list.equals(list2);
						JOptionPane.showMessageDialog(null, "Successfully Added");
						dispose();
						}
						}
				}
				catch(NumberFormatException d)
				{
					JOptionPane.showMessageDialog(null, "Invalid Input");

				}
				}
			});
			btnSubmit.setBounds(208, 224, 91, 23);
			contentPane.add(btnSubmit);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					dispose();
					
				}
			});
			btnCancel.setBounds(310, 224, 91, 23);
			contentPane.add(btnCancel);
			
			JLabel lblNewLabel = new JLabel("Add Employee");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblNewLabel.setBounds(162, 6, 124, 20);
			contentPane.add(lblNewLabel);
				
			
		}
}


//This is the object class which accepts multiple inputs from the user and inserts it into the linkedlist object
	class list_model
	{
		private int emp_id;
		private String last_name;
		private String first_name;
		private String department;
		private String position;
		private float salary;
		private int paidleave;
		private int hoursworked;
		private float totalpay;
		private int dayssworked;
		private int hoursovertime;
		private int month;
		private int Day;
		private int Year;
		private int pmonth;
		private int pDay;
		private int pYear;



		public list_model(int id, String lname, String fname, String dep, String pos, float sal,int paidlve,int hourswrked,float totalpy, int dayswrked,int hrsovrtm,int mon,int dy, int yr,int pmon,int pdy, int pyr)
		{
			this.emp_id = id;
			this.last_name = lname;
			this.first_name = fname;
			this.department = dep;
			this.position = pos;
			this.salary = sal;
			this.paidleave = paidlve;
			this.hoursworked = hourswrked;
			this.totalpay = totalpy;
			this.dayssworked = dayswrked;
			this.hoursovertime = hrsovrtm;
			this.month=mon;
			this.Day=dy;
			this.Year=yr;
			this.pmonth=pmon;
			this.pDay=pdy;
			this.pYear=pyr;
		}
		public int getPmonth() {
			return pmonth;
		}

		public void setPmonth(int pmonth) {
			this.pmonth = pmonth;
		}

		public int getpDay() {
			return pDay;
		}

		public void setpDay(int pDay) {
			this.pDay = pDay;
		}

		public int getpYear() {
			return pYear;
		}

		public void setpYear(int pYear) {
			this.pYear = pYear;
		}

		
		public int getMonth() {
			return month;
		}


		public void setMonth(int month) {
			this.month = month;
		}

		public int getDay() {
			return Day;
		}

		public void setDay(int day) {
			Day = day;
		}

		public int getYear() {
			return Year;
		}

		public void setYear(int year) {
			Year = year;
		}

		public int getHoursovertime() {
			return hoursovertime;
		}

		public void setHoursovertime(int hoursovertime) {
			this.hoursovertime = hoursovertime;
		}
		public int getDayssworked() {
			return dayssworked;
		}

		public void setDayssworked(int dayssworked) {
			this.dayssworked = dayssworked;
		}
		public float getTotalpay() {
			return totalpay;
		}

		public void setTotalpay(float totalpay) {
			this.totalpay = totalpay;
		}

		public int getEmp_id() {
			return emp_id;
		}
		public void setEmp_id(int emp_id) {
			this.emp_id = emp_id;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getDepartment() {
			return department;
		}
		public void setDepartment(String department) {
			this.department = department;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public float getSalary() {
			return salary;
		}
		public void setSalary(float salary) {
			this.salary = salary;
		}
		public int getPaidleave() {
			return paidleave;
		}

		public void setPaidleave(int sickdays) {
			this.paidleave = sickdays;
		}
		public int getHoursworked() {
			return hoursworked;
		}

		public void setHoursworked(int hoursworked) {
			this.hoursworked = hoursworked;
		}
		
		
		   public String toString(){
		        return "employee ID: "+this.emp_id+ "  Name: "+last_name+", "+first_name+"  Salary: "+this.salary;
		    }
		
		
	}



