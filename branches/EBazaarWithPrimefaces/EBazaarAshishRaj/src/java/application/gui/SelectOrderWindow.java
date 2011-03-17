package application.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This screen displays a table of all
 * orders currently stored in the database (on initial
 * creation of this class, fake data from DefaultData, is
 * used to fill out this table). If the user selects a row
 * in the table, and clicks the ViewDetails button, 
 * an instance of ViewOrderDetailsWindow is created, which
 * displays details of the selected order.
 * <p>
 * <table border="1">
 * <tr>
 * 		<th colspan="3">Change Log</th>
 * </tr>
 * <tr>
 * 		<th>Date</th> <th>Author</th> <th>Change</th>
 * </tr>
 * <tr>
 * 		<td>Oct 22, 2004</td>
 *      <td>klevi, pcorazza</td>
 *      <td>New class file</td>
 * </tr>
 * <tr>
 * 		<td>Jan 19, 2005</td>
 *      <td>klevi</td>
 *      <td>modifed the readdata comments</td>
 * </tr>
 * </table>
 *
 */
public class SelectOrderWindow extends JWindow implements ParentWindow {
	/**
	 * @uml.property  name="parent"
	 */
	private Window parent;
	/**
	 * @uml.property  name="model"
	 * @uml.associationEnd  
	 */
	CustomTableModel model;
	/**
	 * @uml.property  name="table"
	 * @uml.associationEnd  
	 */
	JTable table;
	/**
	 * @uml.property  name="tablePane"
	 * @uml.associationEnd  
	 */
	JScrollPane tablePane;
	
	//JPanels
	/**
	 * @uml.property  name="mainPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JPanel mainPanel;
	/**
	 * @uml.property  name="upper"
	 * @uml.associationEnd  
	 */
	JPanel upper;
	/**
	 * @uml.property  name="middle"
	 * @uml.associationEnd  
	 */
	JPanel middle;
	/**
	 * @uml.property  name="lower"
	 * @uml.associationEnd  
	 */
	JPanel lower;
	
	//constants
	/**
	 * @uml.property  name="uSE_DEFAULT_DATA"
	 */
	private final boolean USE_DEFAULT_DATA = true;

    /**
	 * @uml.property  name="oRDER_ID"
	 */
    private final String ORDER_ID = "Order ID";
    /**
	 * @uml.property  name="dATE"
	 */
    private final String DATE = "Date";
    
    /**
	 * @uml.property  name="tOTAL"
	 */
    private final String TOTAL = "Total Cost";
    /**
	 * @uml.property  name="mAIN_LABEL"
	 */
    private final String MAIN_LABEL = "Order History";
    
    //button labels
    /**
	 * @uml.property  name="vIEW_DETAILS_BUTN"
	 */
    private final String VIEW_DETAILS_BUTN = "View Details";
    /**
	 * @uml.property  name="cANCEL_BUTN"
	 */
    private final String CANCEL_BUTN = "Cancel";

    
    //table config
	/**
	 * @uml.property  name="dEFAULT_COLUMN_HEADERS" multiplicity="(0 -1)" dimension="1"
	 */
	private final String[] DEFAULT_COLUMN_HEADERS = {ORDER_ID,DATE,TOTAL};
	/**
	 * @uml.property  name="tABLE_WIDTH"
	 */
	private final int TABLE_WIDTH = Math.round(0.75f*GuiControl.SCREEN_WIDTH);
    /**
	 * @uml.property  name="dEFAULT_TABLE_HEIGHT"
	 */
    private final int DEFAULT_TABLE_HEIGHT = Math.round(0.75f*GuiControl.SCREEN_HEIGHT);

    //these numbers specify relative widths of the columns -- they  must add up to 1
    /**
	 * @uml.property  name="cOL_WIDTH_PROPORTIONS" multiplicity="(0 -1)" dimension="1"
	 */
    private final float [] COL_WIDTH_PROPORTIONS =
    	{0.4f, 0.3f, 0.3f};

 	/**
	 * @uml.property  name="eRROR_MESSAGE"
	 */
 	final String ERROR_MESSAGE = "Please select a row.";
	/**
	 * @uml.property  name="eRROR"
	 */
	final String ERROR = "Error";   	
    	
	public SelectOrderWindow() {
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
		
		
			
	}
	private void initializeWindow() {
		
		setSize(GuiControl.SCREEN_WIDTH,GuiControl.SCREEN_HEIGHT);		
		GuiControl.centerFrameOnDesktop(this);
		
	}
	
	private void defineMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(GuiControl.FILLER_COLOR);
		mainPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		defineUpperPanel();
		defineMiddlePanel();
		defineLowerPanel();
		mainPanel.add(upper,BorderLayout.NORTH);
		mainPanel.add(middle,BorderLayout.CENTER);
		mainPanel.add(lower,BorderLayout.SOUTH);
			
	}
	//label
	public void defineUpperPanel(){
		upper = new JPanel();
		upper.setBackground(GuiControl.FILLER_COLOR);
		upper.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JLabel mainLabel = new JLabel(MAIN_LABEL);
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		upper.add(mainLabel);					
	}
	//table
	public void defineMiddlePanel(){
		createTableAndTablePane();
		GuiControl.createCustomColumns(table, 
		                               TABLE_WIDTH,
		                               COL_WIDTH_PROPORTIONS,
		                               DEFAULT_COLUMN_HEADERS);
		                   		
		middle = GuiControl.createStandardTablePanePanel(table,tablePane);
				
	}
	//buttons
	public void defineLowerPanel(){
		//proceed button
		JButton detailsButton = new JButton(VIEW_DETAILS_BUTN);
		detailsButton.addActionListener(new ViewDetailsListener());
		
		
		//continue button
		JButton cancelButton = new JButton(CANCEL_BUTN);
		cancelButton.addActionListener(new CancelListener());
		

		
		//create lower panel
		JButton [] buttons = {detailsButton,cancelButton};
		lower = GuiControl.createStandardButtonPanel(buttons);		
	}
	
	private void createTableAndTablePane() {
		updateModel();
		table = new JTable(model);
		tablePane = new JScrollPane();
		tablePane.setPreferredSize(new Dimension(TABLE_WIDTH, DEFAULT_TABLE_HEIGHT));
		tablePane.getViewport().add(table);
		
	}
	public void updateModel(List<String[]> list){
		if(model == null) {
	        model = new CustomTableModel();
    	    
		}
		model.setTableValues(list);		
	}
	
	/**
	 * If default data is being used, this method obtains it
	 * and then passes it to updateModel(List). If real data is
	 * being used, the public updateModel(List) should be called by
	 * the controller class.
	 */
	private void updateModel() {
		List<String[]> theData = new ArrayList<String[]>();
        if(USE_DEFAULT_DATA) {
			DefaultData dd = DefaultData.getInstance();
			theData = dd.getSelectOrderDefaultData();
        }
		updateModel(theData);
 	}	
	
	

	
    private void updateTable() {
        
        table.setModel(model);
        table.updateUI();
        repaint();
        
    }	
	
	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}
	class ViewDetailsListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	int selectedRow = table.getSelectedRow();
        	if(selectedRow >= 0) {
         		setVisible(false);
        		ViewOrderDetailsWindow win = new ViewOrderDetailsWindow();
        		win.setVisible(true);
        		win.setParentWindow(SelectOrderWindow.this);      		
        		
        	}
        	else {
       			JOptionPane.showMessageDialog(SelectOrderWindow.this,         									          
        									  ERROR_MESSAGE,
        									  ERROR, 
        									  JOptionPane.ERROR_MESSAGE);
        		
        	}        	
        	        	

        }
	}
	class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
        	parent.setVisible(true);

        }
	}

	
	public static void main(String[] args) {
		(new SelectOrderWindow()).setVisible(true);
	}
	private static final long serialVersionUID = 3834023675661071921L;
	
}
