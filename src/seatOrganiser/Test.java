package seatOrganiser;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;

import org.apache.poi.hssf.usermodel.HSSFCell;

@SuppressWarnings("unused")
public class Test extends JFrame implements ActionListener {
/**
	 * 
	 */
	private static final long serialVersionUID = 6005516107419130207L;
	private int clicks = 0;
    private JPanel contentPane;
    JLabel answer = new JLabel("");
    JPanel pane = new JPanel();
    JTextField jtfText1;
    private JTextField jtfText1_1;
    JButton btnGenerate;
    JCheckBox chckbxthGrade;
    JCheckBox chckbxthGrade_1;
    JCheckBox chckbxthGrade_2;
    JCheckBox chckbxthGrade_3;
    JRadioButton rdbtnst;
    JRadioButton rdbtnnd;
    JRadioButton rdbtnrd;
    JRadioButton rdbtnth;
    JRadioButton rdbtnth_1;
    JRadioButton rdbtnth_2;
    JRadioButton rdbtnth_3;
    JRadioButton rdbtnth_4;
    String disp = "";
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Test frame = new Test();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        String[] testArgs={};
        FileChooser.main(testArgs);
    }
    /**
     * Create the frame.
     */
    public Test() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 495, 385);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(176, 196, 222)); // BACKGROUND COLOR
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setLayout(null);
        
        //GRADE BUTTONS
        // Ninth Grade Check Box
        chckbxthGrade = new JCheckBox("9th Grade"); //Freshmen
        chckbxthGrade.setBackground(new Color(220, 220, 220)); // COLOR OF BUTTON
        chckbxthGrade.setBounds(36, 98, 100, 23);
        contentPane.add(chckbxthGrade);
        //tenth grade button
        chckbxthGrade_1 = new JCheckBox("10th Grade");//Sophomores
        chckbxthGrade_1.setBackground(new Color(220, 220, 220));
        chckbxthGrade_1.setBounds(36, 124, 100, 23);
        contentPane.add(chckbxthGrade_1);
        //eleventh grade button
        chckbxthGrade_2 = new JCheckBox("11th Grade");//Juniors
        chckbxthGrade_2.setBackground(new Color(220, 220, 220));
        chckbxthGrade_2.setBounds(36, 150, 100, 23);
        contentPane.add(chckbxthGrade_2);
        //twelfth grade button
        chckbxthGrade_3 = new JCheckBox("12th Grade");//Seniors
        chckbxthGrade_3.setBackground(new Color(220, 220, 220));
        chckbxthGrade_3.setBounds(36, 176, 100, 23);
        contentPane.add(chckbxthGrade_3);
        
        ButtonGroup group = new ButtonGroup(); 
        
        // Class Period Buttons
        rdbtnst = new JRadioButton("1st");//First Period
        rdbtnst.setBackground(new Color(220, 220, 220));
        rdbtnst.setBounds(174, 98, 56, 23);
        group.add(rdbtnst);
        contentPane.add(rdbtnst);
        
        rdbtnnd = new JRadioButton("2nd");// Second PEriod
        rdbtnnd.setBackground(new Color(220, 220, 220));
        rdbtnnd.setBounds(174, 124, 56, 23);
        group.add(rdbtnnd);
        contentPane.add(rdbtnnd);
        
        rdbtnrd = new JRadioButton("3rd");//THird Period
        rdbtnrd.setBackground(new Color(220, 220, 220));
        rdbtnrd.setBounds(174, 150, 56, 23);
        group.add(rdbtnrd);
        contentPane.add(rdbtnrd);
        
        rdbtnth = new JRadioButton("4th");//Fourth PEriod
        rdbtnth.setBackground(new Color(220, 220, 220));
        rdbtnth.setBounds(174, 176, 56, 23);
        group.add(rdbtnth);
        contentPane.add(rdbtnth);
        
        rdbtnth_1 = new JRadioButton("6th");// Sixth Period
        rdbtnth_1.setBackground(new Color(220, 220, 220));
        rdbtnth_1.setBounds(174, 202, 56, 23);
        group.add(rdbtnth_1);
        contentPane.add(rdbtnth_1);
        
        rdbtnth_2 = new JRadioButton("7th");//Seventh PEriod
        rdbtnth_2.setBackground(new Color(220, 220, 220));
        rdbtnth_2.setBounds(174, 228, 56, 23);
        group.add(rdbtnth_2);
        contentPane.add(rdbtnth_2);
        
        rdbtnth_3 = new JRadioButton("8th");//Eighth Period
        rdbtnth_3.setBackground(new Color(220, 220, 220));
        rdbtnth_3.setBounds(174, 254, 56, 23);
        group.add(rdbtnth_3);
        contentPane.add(rdbtnth_3);
        
        rdbtnth_4 = new JRadioButton("9th");//Ninth Period NOT ALWAYS APPLICABLE
        rdbtnth_4.setBackground(new Color(220, 220, 220));
        rdbtnth_4.setBounds(174, 280, 56, 23);
        group.add(rdbtnth_4);
        contentPane.add(rdbtnth_4);

        
        Container container = getContentPane();
        //Creates new Text Field to enter names of rowdy classes
        jtfText1 = new JTextField(10);
        jtfText1_1 = new JTextField(10);
        jtfText1_1.setBounds(258, 98, 177, 23);
        container.add(jtfText1_1);
        jtfText1_1.addActionListener(this);
        chckbxthGrade.addActionListener(this);
        chckbxthGrade_1.addActionListener(this);
        chckbxthGrade_2.addActionListener(this);
        chckbxthGrade_3.addActionListener(this);
        rdbtnst.addActionListener(this);
        rdbtnnd.addActionListener(this);
        rdbtnrd.addActionListener(this);
        rdbtnth.addActionListener(this);
        rdbtnth_1.addActionListener(this);
        rdbtnth_2.addActionListener(this);
        rdbtnth_3.addActionListener(this);
        rdbtnth_4.addActionListener(this);
        //Makes visible (duh)
        setVisible(true);
        // Grade Buttons Header
        JLabel lblGrade = new JLabel("Grade"); //Name
        lblGrade.setFont(new Font("Century Gothic", Font.PLAIN, 20));//Font & Size
        lblGrade.setBounds(36, 54, 100, 25);
        contentPane.add(lblGrade);
        //Rowdy Classes Header
        JLabel lblRowdyClasses = new JLabel("Rowdy Classes");
        lblRowdyClasses.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblRowdyClasses.setBounds(276, 54, 146, 25);
        contentPane.add(lblRowdyClasses);
        //Period Header
        JLabel lblPeriod = new JLabel("Period");
        lblPeriod.setFont(new Font("Century Gothic", Font.PLAIN, 20));
        lblPeriod.setBounds(174, 54, 71, 25);
        contentPane.add(lblPeriod);
        
        //Help user with selection
        JLabel lblSelectOneOr = new JLabel("Select One or More:");
        lblSelectOneOr.setBounds(36, 68, 124, 36);
        contentPane.add(lblSelectOneOr);
        
        JLabel lblSelectOne = new JLabel("Select One:");
        lblSelectOne.setBounds(174, 79, 71, 14);
        contentPane.add(lblSelectOne);
        
        JLabel lblEnter = new JLabel("Enter Names of Teachers:");
        lblEnter.setBounds(271, 79, 150, 14);
        contentPane.add(lblEnter);
        
        // Button that generates the Seating Chart
        btnGenerate = new JButton("Generate Seating Chart");
        btnGenerate.addActionListener(this);
        btnGenerate.setFont(new Font("Century Gothic", Font.PLAIN, 11));
        btnGenerate.setBounds(258, 124, 177, 48);
        contentPane.add(btnGenerate);
        
        contentPane.setVisible(true);
        
        // TITLE OF SOFTWARE THAT WE NEED TO CHANGE
        JLabel lblNameOfSoftware = new JLabel("SEAT ORGANIZER");
        lblNameOfSoftware.setFont(new Font("Century Gothic", Font.BOLD, 32));
        lblNameOfSoftware.setBounds(96, 11, 459, 50);
        contentPane.add(lblNameOfSoftware);
        
        // BC THIS IS ORIGINAL
        JLabel lblRingrInc = new JLabel("\u00A9 Ringr Inc, 2015");
        lblRingrInc.setBounds(207, 321, 100, 14);
        contentPane.add(lblRingrInc);
    }
    public void actionPerformed(ActionEvent e) {
    	List<String> items = new ArrayList<String>();
    	int period = 2;
    	boolean freshmen = false;
    	boolean sophomores = false;
    	boolean juniors = false;
    	boolean seniors = false;
    	String newarr = null;
    	clicks++;
    	
    	if (chckbxthGrade.isSelected()) {
    		freshmen = true;
    	}
    	if (chckbxthGrade_1.isSelected()) {
    		sophomores = true;
    	}
    	if (chckbxthGrade_2.isSelected()) {
    		juniors = true;
    	}
    	if (chckbxthGrade_3.isSelected()) {
    		seniors = true;
    	}
    	if (!chckbxthGrade.isSelected()) {
    		freshmen = false;
    	}
    	if (!chckbxthGrade_1.isSelected()) {
    		sophomores = false;
    	}
    	if (!chckbxthGrade_2.isSelected()) {
    		juniors = false;
    	}
    	if (!chckbxthGrade_3.isSelected()) {
    		seniors = false;
    	}
    	if (rdbtnst.isSelected()) {
    		period = 1;
    	}
    	if (rdbtnnd.isSelected()) {
    		period = 2;
    	}
    	if (rdbtnrd.isSelected()) {
    		period = 3;
    	}
    	if (rdbtnth.isSelected()) {
    		period = 4;
    	}
    	if (rdbtnth_1.isSelected()) {
    		period = 6;
    	}
    	if (rdbtnth_2.isSelected()) {
    		period = 7;
    	}
    	if (rdbtnth_3.isSelected()) {
    		period = 8;
    	}
    	if (rdbtnth_4.isSelected()) {
    		period = 9;
    	}
    	
    	if (e.getSource() == jtfText1_1) {
    		newarr = e.getActionCommand();// e.getActionCommand() is the text that is entered
    		items = Arrays.asList(newarr.split("\\s*,\\s*"));
    		System.out.println(items);
    	}
    	
    	if (e.getSource() == btnGenerate) {
    		ArrayList<ArrayList<HSSFCell>> sheetData = null;
			try {
				sheetData = Sorter.getSheetData("Filemaker.xls", period, freshmen, sophomores, juniors, seniors);
			} catch (IOException e1) {}
    		sheetData = Arranger.sortByTeacher(sheetData);
    		sheetData = Arranger.addTeachers(sheetData);
    		sheetData = Arranger.newTogether(sheetData);
    		sheetData = Arranger.loudToBack(sheetData, items);
    		ArrayList<ArrayList<HSSFCell>> secondShowStudents = new ArrayList<ArrayList<HSSFCell>>();
    		Arranger.breakIfTwo(sheetData, secondShowStudents);
    		String[][][] array3d = Converter.displayNicely(sheetData);
    		array3d = Converter.cleanUp(array3d);
    		System.out.println(Converter.toStr(array3d[0]));
    		System.out.println(Converter.toStr(array3d[1]));
    		System.out.println(Converter.toStr(array3d[2]));
    		if(Sorter.openBackDoors(sheetData)) System.out.println(Converter.toStr(array3d[3]));
    		if(Sorter.openBackDoors(sheetData)) System.out.println(Converter.toStr(array3d[4]));
    	}
    	
    }
}
