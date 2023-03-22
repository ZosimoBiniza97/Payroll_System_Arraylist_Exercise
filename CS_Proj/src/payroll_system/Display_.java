package payroll_system;
import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.WorkbookUtil;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JScrollBar;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Display_ extends JFrame {

	private JPanel contentPane;

	private JTextField range;
	private JTextField range2;
	private JTextField totalpayrange2;
	private JTextField totalpayrange;
	private JTextField filename;
	private JTextField Gtotal;
	private JTextField avg;
	private JTextField search;
	private Choice dept;
	private JTextField hrs;
	private JTextField hrs2;
	private JTextField days;
	private JTextField days2;
	private JTextField ovt;
	private JTextField ovt2;
	private JTextField EmpCount;
	private JTextField sub;
	public int empcount=0;
	public float subtotal=0;
	public float avgsub=0;
	public float grandtotal=0;



	public Display_(LinkedList<list_model> list) {
		setTitle("Payroll System - Display Payroll");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Using for loop to add and display all linkedlist element into table rows.
		final Object[][] rowData = {};
		final Object[] columnNames = {"ID", "Lastname","Firstname","Department","Position","Hourly Salary","Hours Worked (Daily)","Days Worked","Hours Overtimed","Total Pay"};
		DefaultTableModel listTableModel;
	    listTableModel = new DefaultTableModel(rowData, columnNames);
	    for (list_model e: list) {
	        listTableModel.addRow(new Object[]{e.getEmp_id(),e.getLast_name(),e.getFirst_name(),e.getDepartment(),e.getPosition(),e.getSalary(),e.getHoursworked(),e.getDayssworked(),e.getHoursovertime(),e.getTotalpay()});
		
	    //Counts the number of employees
	    empcount++;
	    //Calculates the total of the salaries if the currently displayed table 
		subtotal +=e.getTotalpay();
	    //Calculates the grand total of the salaries of all the employees
		grandtotal +=e.getTotalpay();
	}
	    //calculates the average of the total salaries of the currently displayed table
	    avgsub = subtotal/empcount;
	    
	    
        JTable table = new JTable(listTableModel);
        table.setPreferredScrollableViewportSize(new Dimension(1100,600));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        JScrollPane js=new JScrollPane(table);
        js.setBounds(439, 10, 843, 652);
        js.setVisible(true);
        contentPane.setLayout(null);
        getContentPane().add(js);
        
        dept = new Choice();
        dept.setBounds(136, 75, 257, 20);
        dept.add("All");
        dept.add("Human Resources");
		dept.add("IT Department");
		dept.add("Accounting and Finance");
		dept.add("Marketing");
		dept.add("Research and Development");
		dept.add("Purchasing");
        contentPane.add(dept);
        
        
        Choice pos = new Choice();
        pos.setBounds(136, 101, 257, 20);
        pos.add("All");
        pos.add("Entry Level Contributor");
		pos.add("Experienced Contributor");
		pos.add("Manager");
		pos.add("Senior Professional");
		pos.add("Director");
		pos.add("General Manager");
        contentPane.add(pos);
        
        Label label = new Label("Department");
        label.setFont(new Font("Dialog", Font.BOLD, 15));
        label.setBounds(36, 75, 97, 20);
        contentPane.add(label);
        
        Label label_1 = new Label("Position");
        label_1.setFont(new Font("Dialog", Font.BOLD, 15));
        label_1.setBounds(60, 101, 63, 20);
        contentPane.add(label_1);
        
        Label label_2 = new Label("Salary Range:");
        label_2.setFont(new Font("Dialog", Font.BOLD, 15));
        label_2.setBounds(72, 127, 107, 20);
        contentPane.add(label_2);
        
        range = new JTextField();
        range.setText("0");
        range.setBounds(184, 127, 86, 20);
        contentPane.add(range);
        range.setColumns(10);
        
        Label label_4 = new Label("To");
        label_4.setFont(new Font("Dialog", Font.BOLD, 15));
        label_4.setBounds(276, 127, 26, 20);
        contentPane.add(label_4);
        
        range2 = new JTextField();
        range2.setText("999");
        range2.setColumns(10);
        range2.setBounds(308, 127, 86, 20);
        contentPane.add(range2);
        
        Label label_5 = new Label("Hours Worked Daily:");
        label_5.setFont(new Font("Dialog", Font.BOLD, 15));
        label_5.setBounds(26, 153, 151, 20);
        contentPane.add(label_5);

        
        Label label_6 = new Label("Days Worked Monthly:");
        label_6.setFont(new Font("Dialog", Font.BOLD, 15));
        label_6.setBounds(14, 179, 164, 20);
        contentPane.add(label_6);
        
        totalpayrange2 = new JTextField();
        totalpayrange2.setText("9999999");
        totalpayrange2.setColumns(10);
        totalpayrange2.setBounds(307, 231, 86, 20);
        contentPane.add(totalpayrange2);
        
        Label label_7 = new Label("To");
        label_7.setFont(new Font("Dialog", Font.BOLD, 15));
        label_7.setBounds(275, 231, 26, 20);
        contentPane.add(label_7);
        
        totalpayrange = new JTextField();
        totalpayrange.setText("0");
        totalpayrange.setColumns(10);
        totalpayrange.setBounds(183, 231, 86, 20);
        contentPane.add(totalpayrange);
        
        Label label_9 = new Label("Total Pay Range:");
        label_9.setFont(new Font("Dialog", Font.BOLD, 15));
        label_9.setBounds(54, 231, 123, 20);
        contentPane.add(label_9);
        
        Label label_10 = new Label("Hours of Overtime:");
        label_10.setFont(new Font("Dialog", Font.BOLD, 15));
        label_10.setBounds(36, 205, 142, 20);
        contentPane.add(label_10);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(22, 381, 401, 10);
        contentPane.add(separator);
        
        Label label_11 = new Label("Sort By");
        label_11.setFont(new Font("Dialog", Font.BOLD, 15));
        label_11.setBounds(70, 257, 63, 20);
        contentPane.add(label_11);
        
        Choice sortby = new Choice();
        sortby.setBounds(136, 257, 257, 20);
        sortby.add("Department");
        sortby.add("Employee ID");
        sortby.add("Hourly Salary");
        sortby.add("Hours worked per day");
        sortby.add("Days Worked");
        sortby.add("Total Hours Overtimed");
        sortby.add("Total Pay");
        sortby.add("First Name");
        sortby.add("Last Name");

        contentPane.add(sortby);
        
        ButtonGroup group = new ButtonGroup();
        
        JRadioButton rdbtnAscending = new JRadioButton("Ascending");
        rdbtnAscending.setSelected(true);
        rdbtnAscending.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnAscending.setBounds(146, 283, 109, 23);
        contentPane.add(rdbtnAscending);
        
        JRadioButton rdbtnDescending = new JRadioButton("Descending");
        rdbtnDescending.setFont(new Font("Tahoma", Font.BOLD, 15));
        rdbtnDescending.setBounds(262, 283, 131, 23);
        contentPane.add(rdbtnDescending);
        
        group.add(rdbtnAscending);
        group.add(rdbtnDescending);
        
        
        //Refresh Button to minimize results by filtering the results
        JButton btnNewButton = new JButton("Refresh");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try{
        		empcount=0;
        		subtotal=0;
        		avgsub=0;
        		
        		//Check whether ascending or descending order is selected
        		int swtch;
        		if(rdbtnAscending.isSelected())
        		{
        			swtch=1;
        		}
        		else
        		{
        			swtch=0;
        		}
        		
        		//Calls the quicksort methods to sort the row by the selected column
        		
        		//Sort by employee ID
        		if(sortby.getSelectedItem().equals("Employee ID"));
        		{
        			SortByEmpID sortempid= new SortByEmpID();
        			sortempid.quickSort(list, swtch);
        		}
        		//Sort by department
        		if(sortby.getSelectedItem().equals("Department"))
        		{
        			SortByDepartment sortdept = new SortByDepartment();
        			sortdept.quickSort(list, swtch);
        		} 
        		//Sort by hourly salary
        		if(sortby.getSelectedItem().equals("Hourly Salary"))
        		{
        			SortBySalary sortsal = new SortBySalary();
        			sortsal.quickSort(list, swtch);
        		}
        		//Sort by hours worked per day
        		if(sortby.getSelectedItem().equals("Hours worked per day"))
        		{
        			SortByHoursWorked sorthrsw = new SortByHoursWorked();
        			sorthrsw.quickSort(list, swtch);
        		}
        		//sort by number of days worked
        		if(sortby.getSelectedItem().equals("Days Worked"))
        		{
        			SortByDaysWorked sortdysw = new SortByDaysWorked();
        			sortdysw.quickSort(list, swtch);
        		}
        		//Sort by the total hours of overtime
        		if(sortby.getSelectedItem().equals("Total Hours Overtimed"))
        		{
        			SortByHoursOvertimed sorthrsovt = new SortByHoursOvertimed();
        			sorthrsovt.quickSort(list, swtch);
        		}
        		//Sort by the total calculated salary of employees
        		if(sortby.getSelectedItem().equals("Total Pay"))
        		{
        			SortByTotalSalary sorttotalsal = new SortByTotalSalary();
        			sorttotalsal.quickSort(list, swtch);
        		}
        		//Sort by the first name of the employee
        		if(sortby.getSelectedItem().equals("First Name"))
        		{
        			SortByFirstname sortfn = new SortByFirstname();
        			sortfn.quickSort(list, swtch);
        		}
        		//Sort by the last name of the employees
        		if(sortby.getSelectedItem().equals("Last Name"))
        		{
        			SortByLastname sortln = new SortByLastname();
        			sortln.quickSort(list, swtch);
        		}
        		listTableModel.setRowCount(0);
        		
        		//This part refreshes the table with the new filter settings depending on the selected options
        		
        		//Displays only selected departments and positions
        		if(!dept.getSelectedItem().equals("All")&&!pos.getSelectedItem().equals("All"))
        		{
        		  for (list_model e: list) {
        			  if(e.getDepartment().equals(dept.getSelectedItem())&&e.getPosition().equals(pos.getSelectedItem())&&e.getSalary()>=Float.parseFloat(range.getText())&&e.getSalary()<=Float.parseFloat(range2.getText())&&e.getHoursworked()>=Integer.parseInt(hrs.getText())&&e.getHoursworked()<=Integer.parseInt(hrs2.getText())&&e.getDayssworked()>=Integer.parseInt(days.getText())&&e.getDayssworked()<=Integer.parseInt(days2.getText())&&e.getHoursovertime()>=Integer.parseInt(ovt.getText())&&e.getHoursovertime()<=Integer.parseInt(ovt2.getText())&&e.getTotalpay()>=Float.parseFloat(totalpayrange.getText())&&e.getTotalpay()<=Float.parseFloat(totalpayrange2.getText())){
        		        listTableModel.addRow(new Object[]{e.getEmp_id(),e.getLast_name(),e.getFirst_name(),e.getDepartment(),e.getPosition(),e.getSalary(),e.getHoursworked(),e.getDayssworked(),e.getHoursovertime(),e.getTotalpay()});
        			 empcount++;
        				subtotal +=e.getTotalpay();
        			  }
        		} 
        		  table.setModel(listTableModel);
      		  table.revalidate();
      		  contentPane.repaint();
        		}
        		//displays all department and selected positions
        		else if(!pos.getSelectedItem().equals("All")&&dept.getSelectedItem().equals("All"))
        		{
        			
        			for (list_model e: list) {
          			  if(e.getPosition().equals(pos.getSelectedItem())&&e.getSalary()>=Float.parseFloat(range.getText())&&e.getSalary()<=Float.parseFloat(range2.getText())&&e.getHoursworked()>=Integer.parseInt(hrs.getText())&&e.getHoursworked()<=Integer.parseInt(hrs2.getText())&&e.getDayssworked()>=Integer.parseInt(days.getText())&&e.getDayssworked()<=Integer.parseInt(days2.getText())&&e.getHoursovertime()>=Integer.parseInt(ovt.getText())&&e.getHoursovertime()<=Integer.parseInt(ovt2.getText())&&e.getTotalpay()>=Float.parseFloat(totalpayrange.getText())&&e.getTotalpay()<=Float.parseFloat(totalpayrange2.getText())){
          		        listTableModel.addRow(new Object[]{e.getEmp_id(),e.getLast_name(),e.getFirst_name(),e.getDepartment(),e.getPosition(),e.getSalary(),e.getHoursworked(),e.getDayssworked(),e.getHoursovertime(),e.getTotalpay()});
          		 	 empcount++;
          			subtotal +=e.getTotalpay();
          			  }

          		}
        			 table.setModel(listTableModel);
           		  table.revalidate();
           		  contentPane.repaint();
        		}
        		//displays all position and selected department
        		else if(pos.getSelectedItem().equals("All")&&!dept.getSelectedItem().equals("All"))
        		{
        			for (list_model e: list) {
          			  if(e.getDepartment().equals(dept.getSelectedItem())&&e.getSalary()>=Float.parseFloat(range.getText())&&e.getSalary()<=Float.parseFloat(range2.getText())&&e.getHoursworked()>=Integer.parseInt(hrs.getText())&&e.getHoursworked()<=Integer.parseInt(hrs2.getText())&&e.getDayssworked()>=Integer.parseInt(days.getText())&&e.getDayssworked()<=Integer.parseInt(days2.getText())&&e.getHoursovertime()>=Integer.parseInt(ovt.getText())&&e.getHoursovertime()<=Integer.parseInt(ovt2.getText())&&e.getTotalpay()>=Float.parseFloat(totalpayrange.getText())&&e.getTotalpay()<=Float.parseFloat(totalpayrange2.getText())){
          		        listTableModel.addRow(new Object[]{e.getEmp_id(),e.getLast_name(),e.getFirst_name(),e.getDepartment(),e.getPosition(),e.getSalary(),e.getHoursworked(),e.getDayssworked(),e.getHoursovertime(),e.getTotalpay()});
          		 	 empcount++;
          			subtotal +=e.getTotalpay();
          			  }

          		}
        			 table.setModel(listTableModel);
           		  table.revalidate();
           		  contentPane.repaint();
        		}
        		//displays all position and all departments
        		else if(pos.getSelectedItem().equals("All")&&dept.getSelectedItem().equals("All"))
        		{
        			for (list_model e: list) {
            			  if(e.getSalary()>=Float.parseFloat(range.getText())&&e.getSalary()<=Float.parseFloat(range2.getText())&&e.getHoursworked()>=Integer.parseInt(hrs.getText())&&e.getHoursworked()<=Integer.parseInt(hrs2.getText())&&e.getDayssworked()>=Integer.parseInt(days.getText())&&e.getDayssworked()<=Integer.parseInt(days2.getText())&&e.getHoursovertime()>=Integer.parseInt(ovt.getText())&&e.getHoursovertime()<=Integer.parseInt(ovt2.getText())&&e.getTotalpay()>=Float.parseFloat(totalpayrange.getText())&&e.getTotalpay()<=Float.parseFloat(totalpayrange2.getText())){
            		        listTableModel.addRow(new Object[]{e.getEmp_id(),e.getLast_name(),e.getFirst_name(),e.getDepartment(),e.getPosition(),e.getSalary(),e.getHoursworked(),e.getDayssworked(),e.getHoursovertime(),e.getTotalpay()});
            		   	 empcount++;
            				subtotal +=e.getTotalpay();
            			  }
             		

            		}
        			 table.setModel(listTableModel);
           		  table.revalidate();
           		  contentPane.repaint();
        			
        		}
        		//validation
        		else{
        			JOptionPane.showMessageDialog(null, "Invalid Input");
        			
        		}
        		//Recalculate the calculations depending on the new rows selected
        		avgsub=subtotal/empcount;
        		 EmpCount.setText(empcount+"");
        	        sub.setText(String.format("%.2f", subtotal));
        	        if(empcount!=0)
        	        {
        	        avg.setText(String.format("%.2f", avgsub));}
        	        else{
        	        	avg.setText("0.00");
        	        }	
        		}
        		
        		catch(NumberFormatException n)
            	{
        			JOptionPane.showMessageDialog(null, "Invalid Input");
        			return;
            	}
        	}
        
        
        	
        });
        btnNewButton.setBounds(179, 335, 91, 23);
        contentPane.add(btnNewButton);
        
        Label label_12 = new Label("Export as Excel File");
        label_12.setFont(new Font("Dialog", Font.BOLD, 15));
        label_12.setBounds(146, 394, 142, 20);
        contentPane.add(label_12);
        
        Label label_13 = new Label("File Name");
        label_13.setFont(new Font("Dialog", Font.BOLD, 15));
        label_13.setBounds(36, 434, 76, 20);
        contentPane.add(label_13);
        
        filename = new JTextField();
        filename.setColumns(10);
        filename.setBounds(121, 434, 272, 20);
        contentPane.add(filename);
        
        //Button to save the table into a excel file in the preset file location
        //Calls the method writeToExcel
        JButton btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				if(!filename.getText().isEmpty())
				{
        		String Destination;
        		String file_name = filename.getText();
				Destination = System.getProperty("user.home")+"/Documents/Payrolls/"+file_name+".xls";
				File f = new File(Destination);
				
				if(!f.getParentFile().exists()){
			        f.getParentFile().mkdirs();
			    }
				if(!f.exists()){
			        try {
			            f.createNewFile();
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			        
			        try {
						writeToExcell(table,Destination);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			    }
				else{
					JOptionPane.showMessageDialog(null, "File name already exists.");
				}
				}
				else{
					JOptionPane.showMessageDialog(null, "            Error: No Input\n           Please Try Again");

					
				}
				
        	}
        });
        btnSave.setBounds(179, 465, 91, 23);
        contentPane.add(btnSave);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(26, 509, 401, 10);
        contentPane.add(separator_1);
        
        Label label_14 = new Label("Payroll Reports");
        label_14.setFont(new Font("Dialog", Font.BOLD, 15));
        label_14.setBounds(171, 524, 117, 20);
        contentPane.add(label_14);
 
        
        Label label_15 = new Label("Number of Employees");
        label_15.setFont(new Font("Dialog", Font.BOLD, 15));
        label_15.setBounds(26, 550, 165, 20);
        contentPane.add(label_15);
        
        Label label_16 = new Label("Subtotal Salary");
        label_16.setFont(new Font("Dialog", Font.BOLD, 15));
        label_16.setBounds(76, 576, 119, 20);
        contentPane.add(label_16);
        
        Label label_17 = new Label("Average Subtotal Salary");
        label_17.setFont(new Font("Dialog", Font.BOLD, 15));
        label_17.setBounds(14, 602, 175, 20);
        contentPane.add(label_17);
        
        Label label_18 = new Label("Grand Total Pay");
        label_18.setFont(new Font("Dialog", Font.BOLD, 15));
        label_18.setBounds(72, 628, 123, 20);
        contentPane.add(label_18);
        
        Gtotal = new JTextField();
        Gtotal.setEditable(false);
        Gtotal.setColumns(10);
        Gtotal.setBounds(204, 628, 189, 20);
        contentPane.add(Gtotal);
        Gtotal.setText(String.format("%.2f", grandtotal));
        
        avg = new JTextField();
        avg.setEditable(false);
        avg.setColumns(10);
        avg.setBounds(204, 602, 189, 20);
        avg.setText(String.format("%.2f", avgsub));
        contentPane.add(avg);
        
        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(22, 57, 401, 10);
        contentPane.add(separator_2);
        
        Label label_19 = new Label("Search");
        label_19.setFont(new Font("Dialog", Font.BOLD, 15));
        label_19.setBounds(71, 22, 57, 20);
        contentPane.add(label_19);
        
        search = new JTextField();
        search.setColumns(10);
        search.setBounds(136, 22, 257, 20);
        contentPane.add(search);

        TableRowSorter<TableModel> rowSorter
        = new TableRowSorter<>(table.getModel());
        
        table.setRowSorter(rowSorter);
        
        hrs = new JTextField();
        hrs.setText("0");
        hrs.setBounds(184, 153, 86, 20);
        contentPane.add(hrs);
        hrs.setColumns(10);
        
        Label label_20 = new Label("To");
        label_20.setFont(new Font("Dialog", Font.BOLD, 15));
        label_20.setBounds(276, 153, 26, 20);
        contentPane.add(label_20);
        
        hrs2 = new JTextField();
        hrs2.setText("15");
        hrs2.setColumns(10);
        hrs2.setBounds(308, 153, 86, 20);
        contentPane.add(hrs2);
        
        days = new JTextField();
        days.setText("0");
        days.setColumns(10);
        days.setBounds(183, 179, 86, 20);
        contentPane.add(days);
        
        Label label_21 = new Label("To");
        label_21.setFont(new Font("Dialog", Font.BOLD, 15));
        label_21.setBounds(275, 179, 26, 20);
        contentPane.add(label_21);
        
        days2 = new JTextField();
        days2.setText("30");
        days2.setColumns(10);
        days2.setBounds(307, 179, 86, 20);
        contentPane.add(days2);
        
        ovt = new JTextField();
        ovt.setText("0");
        ovt.setColumns(10);
        ovt.setBounds(184, 205, 86, 20);
        contentPane.add(ovt);
        
        Label label_22 = new Label("To");
        label_22.setFont(new Font("Dialog", Font.BOLD, 15));
        label_22.setBounds(276, 205, 26, 20);
        contentPane.add(label_22);
        
        ovt2 = new JTextField();
        ovt2.setText("999");
        ovt2.setColumns(10);
        ovt2.setBounds(308, 205, 86, 20);
        contentPane.add(ovt2);
        
        EmpCount = new JTextField();
        EmpCount.setEditable(false);
        EmpCount.setColumns(10);
        EmpCount.setBounds(204, 550, 189, 20);
        contentPane.add(EmpCount);
        EmpCount.setText(empcount+"");
        
        sub = new JTextField();
        sub.setEditable(false);
        sub.setColumns(10);
        sub.setBounds(204, 576, 189, 20);
        contentPane.add(sub);
        sub.setText(String.format("%.2f", subtotal));
        
        //Action listener used to search for strings on the table using regexFilter method
        search.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = search.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }
            
            public void removeUpdate(DocumentEvent e) {
                String text = search.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }@Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

//This method is used to save the table to excel file
	private static void writeToExcell(JTable table, String path) throws FileNotFoundException, IOException {
	    new WorkbookUtil();
	    Workbook wb = new HSSFWorkbook(); //Excell workbook
	    org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet(); //WorkSheet
	    Row row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(2); //Row created at line 3
	    TableModel model = table.getModel(); //Table model


	    Row headerRow = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow(0); //Create row at line 0
	    for(int headings = 0; headings < model.getColumnCount(); headings++){ //For each column
	        headerRow.createCell(headings).setCellValue(model.getColumnName(headings));//Write column name
	    }

	    for(int rows = 0; rows < model.getRowCount(); rows++){ //For each table row
	        for(int cols = 0; cols < table.getColumnCount(); cols++){ //For each table column
	            row.createCell(cols).setCellValue(model.getValueAt(rows, cols).toString()); //Write value
	        }

	        //Set the row to the next one in the sequence 
	        row = ((org.apache.poi.ss.usermodel.Sheet) sheet).createRow((rows + 3)); 
	    }
	    wb.write(new FileOutputStream(path));//Save the file     
	}
	}

