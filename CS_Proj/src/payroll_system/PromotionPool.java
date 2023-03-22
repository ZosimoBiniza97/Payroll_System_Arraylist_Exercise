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
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
import javax.swing.DefaultComboBoxModel;

public class PromotionPool extends JFrame {

	private JPanel contentPane;

	private JTable table_1;
	private JTextField filename;
	private JTextField Gtotal;
	private JTextField avg;
	private JTextField search;
	private JTextField EmpCount;
	public int empcount=0;
	public float subtotal=0;
	public float avgsub=0;
	public float grandtotal=0;
	private JTextField empid;
	private JTextField ln;
	private JTextField fn;
	private JTextField cs;
	private JTextField ns;
	private JTextField cp;
	private JTextField dept;



	public PromotionPool(LinkedList<list_model> list) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1300, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Copying the original list to a temporary list to avoid alterations
		LinkedList<list_model> list2 = list;
		//Re-sorts the list based on the promotion date (descending)
		SortByDate sort = new SortByDate();
		sort.quickSort(list2);
		//Reverses the list using stacks
		Stack<list_model> stacks = new Stack();
		Stacker stack = new Stacker();
		stack.Stacker(stacks, list2);	
		//Inserts the list2 elements inside a queue
		Queue<list_model> Que = new LinkedList();
		Queue_ queue = new Queue_();
		queue.Queue_(Que, stacks);
		
		//Initialize the table
		final Object[][] rowData = {};
		final Object[] columnNames = {"ID", "Lastname","Firstname","Hire Date","Department","Position","Hourly Salary","Total Pay","Promotion Date"};
		DefaultTableModel listTableModel;
	    listTableModel = new DefaultTableModel(rowData, columnNames);
	    for (list_model e: Que) {
	        listTableModel.addRow(new Object[]{e.getEmp_id(),e.getLast_name(),e.getFirst_name(),String.format("%02d", e.getMonth())+"/"+String.format("%02d", e.getDay())+"/"+e.getYear(),e.getDepartment(),e.getPosition(),e.getSalary(),e.getTotalpay(),String.format("%02d", e.getPmonth())+"/"+String.format("%02d", e.getpDay())+"/"+e.getpYear()});
		//Calculate grand totals
	    empcount++;
		grandtotal +=e.getTotalpay();
	}
		//Calculate average of grand total
	    avgsub = grandtotal/empcount;   
        JTable table = new JTable(listTableModel);

        table.setPreferredScrollableViewportSize(new Dimension(1100,600));
        table.setFillsViewportHeight(true);
        table.setAutoCreateRowSorter(true);
        JScrollPane js=new JScrollPane(table);
        js.setBounds(439, 10, 843, 652);
        js.setVisible(true);
        contentPane.setLayout(null);
        getContentPane().add(js);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(22, 381, 401, 10);
        contentPane.add(separator);
        
        ButtonGroup group = new ButtonGroup();
        
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
        
        //Button used to save the table to an excel file
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
        label_15.setBounds(26, 567, 165, 20);
        contentPane.add(label_15);
        
        Label label_17 = new Label("Average Total Salary");
        label_17.setFont(new Font("Dialog", Font.BOLD, 15));
        label_17.setBounds(40, 619, 151, 20);
        contentPane.add(label_17);
        
        Label label_18 = new Label("Grand Total Pay");
        label_18.setFont(new Font("Dialog", Font.BOLD, 15));
        label_18.setBounds(72, 593, 123, 20);
        contentPane.add(label_18);
        
        Gtotal = new JTextField();
        Gtotal.setEditable(false);
        Gtotal.setColumns(10);
        Gtotal.setBounds(204, 593, 189, 20);
        contentPane.add(Gtotal);
        Gtotal.setText(String.format("%.2f", grandtotal));
        
        avg = new JTextField();
        avg.setEditable(false);
        avg.setColumns(10);
        avg.setBounds(204, 619, 189, 20);
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
        
        EmpCount = new JTextField();
        EmpCount.setEditable(false);
        EmpCount.setColumns(10);
        EmpCount.setBounds(204, 567, 189, 20);
        contentPane.add(EmpCount);
        EmpCount.setText(empcount+""); 
        JComboBox NP = new JComboBox();
        NP.setModel(new DefaultComboBoxModel(new String[] {"Entry Level Contributor", "Experienced Contributor", "Manager", "Senior Professional", "Director", "General Manager"}));
        NP.setBounds(136, 279, 258, 22);
        contentPane.add(NP);
        
        //Button used to promote an employee
        //Functionalities: Change Position, department, and salary of employees
        //Also gives the user an overview of employees up for promotion
        JButton btnPromote = new JButton("Promote");
        btnPromote.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        		int x=0;
        		try{
        		for(list_model c: Que)
        		{
        			if(Integer.parseInt(empid.getText())==c.getEmp_id())
        			{
        				x=1;
        				DateFormat dateFormat = new SimpleDateFormat("MM");
        				DateFormat dateFormat1 = new SimpleDateFormat("dd");
        				DateFormat dateFormat2 = new SimpleDateFormat("YYYY");
        				Date date = new Date(System.currentTimeMillis());
        				int pmo=Integer.parseInt(dateFormat.format(date));
        				int pd=Integer.parseInt(dateFormat1.format(date));
        				int py=Integer.parseInt(dateFormat2.format(date));

        				c.setSalary(Float.parseFloat(ns.getText()));
        				c.setPosition((String) NP.getSelectedItem());
        				c.setPmonth(pmo);
        				c.setpDay(pd);
        				c.setpYear(py);
        				JOptionPane.showMessageDialog(null, "Successfully Updated");
        				list_model temp = c;
        				Que.remove(c);
        				Que.add(temp);
        				
        				listTableModel.setRowCount(0);

                		for (list_model e: Que) {
                	        listTableModel.addRow(new Object[]{e.getEmp_id(),e.getLast_name(),e.getFirst_name(),String.format("%02d", e.getMonth())+"/"+String.format("%02d", e.getDay())+"/"+e.getYear(),e.getDepartment(),e.getPosition(),e.getSalary(),e.getTotalpay(),String.format("%02d", e.getPmonth())+"/"+String.format("%02d", e.getpDay())+"/"+e.getpYear()});
                		empcount++;
                		grandtotal +=e.getTotalpay();
                	}	
                		table.revalidate();
        			}
        			}
        		if(x==0)
        		{
    				JOptionPane.showMessageDialog(null, "Employee ID does not exist");

        		}
        		}
        		catch(NumberFormatException n)
        		{
        			
    				JOptionPane.showMessageDialog(null, "Invalid Input");

        		}
        		
        		x=0;
        		LinkedList<list_model> list2 = new LinkedList(Que);
        		list.equals(list2);
        	}
        });
        btnPromote.setBounds(179, 331, 91, 23);
        contentPane.add(btnPromote);
        
        Label EmpID = new Label("Employee ID");
        EmpID.setFont(new Font("Dialog", Font.BOLD, 15));
        EmpID.setBounds(33, 99, 96, 20);
        contentPane.add(EmpID);
        
        empid = new JTextField();
        empid.setColumns(10);
        empid.setBounds(137, 99, 257, 20);
        contentPane.add(empid);
        
        //Displays information about an employee when the user types in a valid and existing employee ID
        empid.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
            	try{ 
    				String text = empid.getText();
    	             
    				 ln.setText("");
	                 fn.setText("");
	                 cs.setText("");
	                 cp.setText("");
	                 dept.setText("");
    	                for(list_model i : list2)
    	                {
    	                	if (i.getEmp_id()==Integer.parseInt(text)) {
    	                 ln.setText(i.getLast_name());
    	                 fn.setText(i.getFirst_name());
    	                 cs.setText(i.getSalary()+"");
    	                 cp.setText(i.getPosition());
    	                 dept.setText(i.getDepartment());
    	                 NP.setSelectedItem(i.getPosition());
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
	                
				 ln.setText("");
                 fn.setText("");
                 cs.setText("");
                 cp.setText("");
                 dept.setText("");
	                for(list_model i : list2)
	                {
	                	if (i.getEmp_id()==Integer.parseInt(text)) {
	                 ln.setText(i.getLast_name());
	                 fn.setText(i.getFirst_name());
	                 cs.setText(i.getSalary()+"");
	                 cp.setText(i.getPosition());
	                 dept.setText(i.getDepartment());
	                 NP.setSelectedItem(i.getPosition());
	                	} 
	                
	           }
				}
				catch(NumberFormatException n) 
				{
					return;
				}
				
			}
        });
        
        Label label = new Label("Last Name");
        label.setFont(new Font("Dialog", Font.BOLD, 15));
        label.setBounds(48, 125, 81, 20);
        contentPane.add(label);
        
        ln = new JTextField();
        ln.setEditable(false);
        ln.setColumns(10);
        ln.setBounds(137, 125, 257, 20);
        contentPane.add(ln);
        
        fn = new JTextField();
        fn.setEditable(false);
        fn.setColumns(10);
        fn.setBounds(137, 152, 257, 20);
        contentPane.add(fn);
        
        Label label_1 = new Label("First Name");
        label_1.setFont(new Font("Dialog", Font.BOLD, 15));
        label_1.setBounds(48, 152, 81, 20);
        contentPane.add(label_1);
        
        cs = new JTextField();
        cs.setEditable(false);
        cs.setColumns(10);
        cs.setBounds(137, 178, 257, 20);
        contentPane.add(cs);
        
        Label label_2 = new Label("Current Salary");
        label_2.setFont(new Font("Dialog", Font.BOLD, 15));
        label_2.setBounds(23, 178, 106, 20);
        contentPane.add(label_2);
        
        ns = new JTextField();
        ns.setColumns(10);
        ns.setBounds(137, 204, 257, 20);
        contentPane.add(ns);
        
        Label label_3 = new Label("New Salary");
        label_3.setFont(new Font("Dialog", Font.BOLD, 15));
        label_3.setBounds(48, 204, 81, 20);
        contentPane.add(label_3);
        
        Label label_4 = new Label("Current Position");
        label_4.setFont(new Font("Dialog", Font.BOLD, 15));
        label_4.setBounds(10, 255, 123, 20);
        contentPane.add(label_4);
        
        cp = new JTextField();
        cp.setEditable(false);
        cp.setColumns(10);
        cp.setBounds(137, 255, 257, 20);
        contentPane.add(cp);
        
        Label label_5 = new Label("New Position");
        label_5.setFont(new Font("Dialog", Font.BOLD, 15));
        label_5.setBounds(32, 281, 98, 20);
        contentPane.add(label_5);
   
        dept = new JTextField();
        dept.setEditable(false);
        dept.setColumns(10);
        dept.setBounds(137, 229, 257, 20);
        contentPane.add(dept);
        
        Label depta = new Label("Department");
        depta.setFont(new Font("Dialog", Font.BOLD, 15));
        depta.setBounds(39, 230, 90, 20);
        contentPane.add(depta);
        //This code is used in searching rows using regexFilter
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

//Method to save the table to an excel file
	private static void writeToExcell(JTable table, String path) throws FileNotFoundException, IOException {
	    new WorkbookUtil();
	    Workbook wb = new HSSFWorkbook(); //Excel workbook
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

