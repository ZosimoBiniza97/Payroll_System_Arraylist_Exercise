package payroll_system;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Menu_ extends JFrame {

	private JPanel contentPane;


	public Menu_(LinkedList<list_model> list) {
		setTitle("Payroll System");
		setResizable(false);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 221, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//This button calls the class responsible for adding employees
		JButton btnNewButton = new JButton("Add Employee");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Add_employee add = new Add_employee(list);
				add.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(10, 41, 193, 23);
		contentPane.add(btnNewButton);
		
		//This button calls the class responsible for removing an employee
		JButton btnRemoveEmployee = new JButton("Remove Employee");
		btnRemoveEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				RemoveEmployee re = new RemoveEmployee(list);
				re.setVisible(true);
			}
		});
		btnRemoveEmployee.setBounds(10, 76, 193, 23);
		contentPane.add(btnRemoveEmployee);
		
		//This button calls the class responsible for displaying the payroll
		JButton btnDisplayPayroll = new JButton("Display Payroll");
		btnDisplayPayroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Display_ dum = new Display_(list);
				dum.setVisible(true);
		}
		});
		btnDisplayPayroll.setBounds(10, 144, 193, 23);
		contentPane.add(btnDisplayPayroll);
		
		//This button closes the application
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		button.setBounds(10, 212, 193, 23);
		contentPane.add(button);
		
		//This button calls the class responsible for displaying the promotion query
		JButton button_1 = new JButton("Promotion Pool");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				PromotionPool promote = new PromotionPool(list);
				promote.setVisible(true);
				
			}
		});
		button_1.setBounds(10, 178, 193, 23);
		contentPane.add(button_1);
		
		//This button calls the class responsible for editing employees
		JButton Edit = new JButton("Edit Employee");
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EditEmployee edit = new EditEmployee(list);
				edit.setVisible(true);
				
				
			}
		});
		Edit.setBounds(10, 110, 193, 23);
		contentPane.add(Edit);
		
		JLabel lblPayrollSystem = new JLabel("Payroll System");
		lblPayrollSystem.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPayrollSystem.setBounds(53, 11, 118, 23);
		contentPane.add(lblPayrollSystem);
	}
}
