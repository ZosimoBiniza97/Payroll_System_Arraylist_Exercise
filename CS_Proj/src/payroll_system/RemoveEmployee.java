package payroll_system;

import java.util.LinkedList;

import javax.swing.JOptionPane;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class RemoveEmployee extends JFrame {


	private JPanel contentPane;
	private JTextField lastname;
	private JTextField firstname;
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
	private JTextField empid;
	public String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};  

	
		public RemoveEmployee(LinkedList<list_model> list) {

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 439, 321);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			lastname = new JTextField();
			lastname.setBounds(117, 63, 294, 20);
			contentPane.add(lastname);
			lastname.setColumns(10);
			
			firstname = new JTextField();
			firstname.setBounds(117, 90, 294, 20);
			contentPane.add(firstname);
			firstname.setColumns(10);
			
			JLabel lblFirstname = new JLabel("Last Name");
			lblFirstname.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblFirstname.setBounds(41, 68, 77, 14);
			contentPane.add(lblFirstname);
			
			JLabel lblLastName = new JLabel("First Name");
			lblLastName.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblLastName.setBounds(41, 96, 77, 14);
			contentPane.add(lblLastName);
			
			JComboBox department = new JComboBox();
			department.setModel(new DefaultComboBoxModel(new String[] {"Human Resources", "IT Department", "Accounting and Finance", "Marketing", "Research and Development", "Purchasing"}));
			department.setBounds(117, 143, 294, 20);
			contentPane.add(department);
		


			
			JLabel lblDepartment = new JLabel("Department");
			lblDepartment.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDepartment.setBounds(30, 145, 78, 14);
			contentPane.add(lblDepartment);
			
			JComboBox position = new JComboBox();
			position.setModel(new DefaultComboBoxModel(new String[] {"Entry Level Contributor", "Experienced Contributor", "Manager", "Senior Professional", "Director", "General Manager"}));
			position.setBounds(117, 169, 294, 20);
			contentPane.add(position);


			
			JLabel lblPosition = new JLabel("Position");
			lblPosition.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblPosition.setBounds(59, 170, 57, 14);
			contentPane.add(lblPosition);
			
			hourlysal = new JTextField();
			hourlysal.setColumns(10);
			hourlysal.setBounds(117, 195, 57, 20);
			contentPane.add(hourlysal);
			
			JLabel lblSalaryhourly = new JLabel("Hourly Salary");
			lblSalaryhourly.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblSalaryhourly.setBounds(20, 197, 107, 14);
			contentPane.add(lblSalaryhourly);
			
			JComboBox hoursworked = new JComboBox();
			hoursworked.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"}));
			hoursworked.setBounds(340, 195, 71, 20);
			contentPane.add(hoursworked);
	

			
			JLabel lblHoursWorkedPer = new JLabel("Hours Worked Per Day");
			lblHoursWorkedPer.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHoursWorkedPer.setBounds(184, 197, 161, 14);
			contentPane.add(lblHoursWorkedPer);
			
			JLabel lblDaysWorked = new JLabel("Days Worked");
			lblDaysWorked.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblDaysWorked.setBounds(20, 224, 107, 14);
			contentPane.add(lblDaysWorked);
			
			daysworked = new JTextField();
			daysworked.setColumns(10);
			daysworked.setBounds(117, 222, 81, 20);
			contentPane.add(daysworked);
			
			JLabel lblHoursOfOvertimes = new JLabel("Hours of Overtimes");
			lblHoursOfOvertimes.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHoursOfOvertimes.setBounds(208, 224, 137, 14);
			contentPane.add(lblHoursOfOvertimes);
			
			overtime = new JTextField();
			overtime.setColumns(10);
			overtime.setBounds(340, 221, 71, 20);
			contentPane.add(overtime);
			
			paidleaves = new JTextField();
			paidleaves.setColumns(10);
			paidleaves.setBounds(117, 247, 81, 20);
			contentPane.add(paidleaves);
			
			JLabel lblNumbersOfPaid = new JLabel("Paid Leaves");
			lblNumbersOfPaid.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblNumbersOfPaid.setBounds(30, 249, 77, 14);
			contentPane.add(lblNumbersOfPaid);
			
			JComboBox mnth = new JComboBox();
			mnth.setModel(new DefaultComboBoxModel(new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"}));
			mnth.setBounds(117, 115, 129, 22);
			contentPane.add(mnth);
			
			String[] day_ = new String[31];
			for(int i=0;i<31;i++)
			{
				day_[i]=(i+1)+"";
			}
			
			JComboBox Day = new JComboBox();
			Day.setBounds(253, 115, 71, 22);
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
			Year.setBounds(334, 115, 77, 22);
			Year.setModel(new DefaultComboBoxModel(year_));
			contentPane.add(Year);
			
			JLabel lblHireDate = new JLabel("Hire Date");
			lblHireDate.setFont(new Font("Tahoma", Font.BOLD, 13));
			lblHireDate.setBounds(45, 121, 61, 15);
			contentPane.add(lblHireDate);
			
			//Button to remove an employee
			JButton btnSubmit = new JButton("Remove");
			btnSubmit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					//Just some validations
					try{
					
					if (!empid.getText().matches("[0-9]+") || !(empid.getText().length() > 0)) {
						JOptionPane.showMessageDialog(null, "Invalid Input");
					}

					else{
						
						
					id = Integer.parseInt(empid.getText());
					int index=0;
					int triggered=0;
					//Search for the specified employee ID
					for(list_model l: list)
					{
						if(l.getEmp_id()==id)
						{
							triggered = 1;	
							index=list.indexOf(l);
						}
									
					}
					
					//If the employee exists
					if(triggered == 1)
					{
						
					//Confirmations from the user
					int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
				        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (response == JOptionPane.YES_OPTION) {
						list.remove(index);
						JOptionPane.showMessageDialog(null, "Successfully Removed");
					}
					else  {
					      return;
					    } 
				
				
						
					}
					//If the employee does not exists
					else{
						JOptionPane.showMessageDialog(null, "Employee does not exist. It's just a figment of your imagination");
					}

						
					}
				}
					
					catch(NumberFormatException d)
					{
						JOptionPane.showMessageDialog(null, "Invalid Input");

					}
					
				}
			});
			btnSubmit.setBounds(218, 252, 91, 23);
			contentPane.add(btnSubmit);
			
			JButton btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					dispose();
					
				}
			});
			btnCancel.setBounds(320, 252, 91, 23);
			contentPane.add(btnCancel);
			
			JLabel label = new JLabel("ID");
			label.setFont(new Font("Tahoma", Font.BOLD, 13));
			label.setBounds(148, 26, 15, 14);
			contentPane.add(label);
			
			empid = new JTextField();
			empid.setColumns(10);
			empid.setBounds(168, 24, 110, 20);
			contentPane.add(empid);
			
		    lastname.setEditable(false);
            firstname.setEditable(false);
            hourlysal.setEditable(false);
            daysworked.setEditable(false);
            overtime.setEditable(false);
            paidleaves.setEditable(false);
            position.setEnabled(false);
            department.setEnabled(false);
            hoursworked.setEnabled(false);
            mnth.setEnabled(false);
            Day.setEnabled(false);
            Year.setEnabled(false);
            
            //Displays information about an employee when the user types in a valid and existing employee ID
			 empid.getDocument().addDocumentListener(new DocumentListener(){

		            @Override
		            public void insertUpdate(DocumentEvent e) {
		            	try{ 
							String text = empid.getText();
				                
							 lastname.setText("");
			                 firstname.setText("");
			                 hourlysal.setText("");
			                 daysworked.setText("");
			                 overtime.setText("");
			                 paidleaves.setText("");
			  

				                for(list_model i : list)
				                {
				                	if (i.getEmp_id()==Integer.parseInt(text)) {
				                	    
				                 lastname.setText(i.getLast_name());
				                 firstname.setText(i.getFirst_name());
				                hourlysal.setText(i.getSalary()+"");
				                 daysworked.setText(i.getDayssworked()+"");
				                 overtime.setText(i.getHoursovertime()+"");
				                 paidleaves.setText(i.getPaidleave()+"");
				                 
				                 position.setSelectedItem(i.getPosition());
				                 department.setSelectedItem(i.getDepartment());
				                 hoursworked.setSelectedItem(i.getHoursworked()+"");
				                 mnth.setSelectedItem(months[i.getMonth()+1]);
				                 Day.setSelectedItem(i.getDay()+"");
				                 Year.setSelectedItem(i.getYear()+"");
	   
				                	} 
				                
				           }
							}
							catch(NumberFormatException n) 
							{
								return;
							}
		            }

					@Override
					public void changedUpdate(DocumentEvent arg0) {
						throw new UnsupportedOperationException("Not supported yet.");
						
					}

					@Override
					public void removeUpdate(DocumentEvent arg0) {
						try{ 
						String text = empid.getText();
			                
						 lastname.setText("");
		                 firstname.setText("");
		                 hourlysal.setText("");
		                 daysworked.setText("");
		                 overtime.setText("");
		                 paidleaves.setText("");
		             

			                for(list_model i : list)
			                {
			                	if (i.getEmp_id()==Integer.parseInt(text)) {
			                	
			                 lastname.setText(i.getLast_name());
			                 firstname.setText(i.getFirst_name());
			                hourlysal.setText(i.getSalary()+"");
			                 daysworked.setText(i.getDayssworked()+"");
			                 overtime.setText(i.getHoursovertime()+"");
			                 paidleaves.setText(i.getPaidleave()+"");
			                 
			                 position.setSelectedItem(i.getPosition());
			                 department.setSelectedItem(i.getDepartment());
			                 hoursworked.setSelectedItem(i.getHoursworked()+"");
			                 mnth.setSelectedItem(months[i.getMonth()+1]);
			                 Day.setSelectedItem(i.getDay()+"");
			                 Year.setSelectedItem(i.getYear()+"");
   
			                	} 
			                
			           }
						}
						catch(NumberFormatException n) 
						{
							return;
						}
						
					}
		        });
			
		}
}
	
	
	



