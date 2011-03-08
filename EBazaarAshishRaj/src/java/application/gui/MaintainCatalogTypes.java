package application.gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This class presents a table of all catalogs
 * available in the database, and allows the user to add
 * edit or delete groups. Not all functionality for these buttons
 * is implemented on initial creation of this class.
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
 *<tr>
 * 		<td>19 jan 2005</td>
 *      <td>klevi</td>
 *      <td>modified readdata comment; changed static method, getCatalogtypes, to use class vs instance</td>
 * </tr>
 * </table>
 *
 */
public class MaintainCatalogTypes extends javax.swing.JWindow implements ParentWindow {


	/**
	 * Parent is used to return to main screen
	 * @uml.property  name="parent"
	 */
	private Window parent;

	
	/////////////constants
	
	//should be set to 'false' if data for table is obtained from a database
	//or some external file
	/**
	 * @uml.property  name="uSE_DEFAULT_DATA"
	 */
	private final boolean USE_DEFAULT_DATA = true;
	/**
	 * @uml.property  name="aDD"
	 */
	private final String ADD = "Add";
	/**
	 * @uml.property  name="eDIT"
	 */
	private final String EDIT = "Edit";
	/**
	 * @uml.property  name="dELETE"
	 */
	private final String DELETE = "Delete";
	/**
	 * @uml.property  name="bACK"
	 */
	private final String BACK = "Back";	
	
	/**
	 * @uml.property  name="mAIN_LABEL"
	 */
	private final String MAIN_LABEL = "Maintain Category Types";
	
	//table configuration
	/**
	 * @uml.property  name="headers"
	 */
	private Properties headers;  
	
	/**
	 * @uml.property  name="tABLE_WIDTH"
	 */
	private final int TABLE_WIDTH = Math.round(0.75f*GuiControl.SCREEN_WIDTH);
    /**
	 * @uml.property  name="dEFAULT_TABLE_HEIGHT"
	 */
    private final int DEFAULT_TABLE_HEIGHT = Math.round(0.75f*GuiControl.SCREEN_HEIGHT);
    

	//JPanels
	/**
	 * @uml.property  name="mainPanel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JPanel mainPanel;
	/**
	 * @uml.property  name="upperSubpanel"
	 * @uml.associationEnd  
	 */
	private JPanel upperSubpanel;
	/**
	 * @uml.property  name="lowerSubpanel"
	 * @uml.associationEnd  
	 */
	private JPanel lowerSubpanel;
	
	//other widgets
	/**
	 * @uml.property  name="title"
	 */
	private String title;
	/**
	 * @uml.property  name="tableLabelText"
	 */
	private String tableLabelText;
	/**
	 * @uml.property  name="tableLabel"
	 * @uml.associationEnd  
	 */
	private JLabel tableLabel;
	/**
	 * @uml.property  name="tablePane"
	 * @uml.associationEnd  
	 */
	private JScrollPane tablePane;
	/**
	 * @uml.property  name="table"
	 * @uml.associationEnd  
	 */
	private JTable table;
	/**
	 * @uml.property  name="dEFAULT_COLUMN_HEADERS" multiplicity="(0 -1)" dimension="1"
	 */
	private final String[] DEFAULT_COLUMN_HEADERS = {"Name of Category Group"};
    //these numbers specify relative widths of the columns -- they  must add up to 1
    /**
	 * @uml.property  name="cOL_WIDTH_PROPORTIONS" multiplicity="(0 -1)" dimension="1"
	 */
    private final float [] COL_WIDTH_PROPORTIONS =
    	{1.0f};	
	
    /**
	 * @uml.property  name="model"
	 * @uml.associationEnd  
	 */
    private CustomTableModel model;
 

 
	public MaintainCatalogTypes() {
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
		defineLowerPanel();
		mainPanel.add(upperSubpanel,BorderLayout.NORTH);
		mainPanel.add(lowerSubpanel,BorderLayout.SOUTH);
			
	}
	private void defineUpperPanel() {
		upperSubpanel = new JPanel();
		upperSubpanel.setLayout(new BorderLayout());
		upperSubpanel.setBackground(GuiControl.FILLER_COLOR);
		
		//create and add label
		createTableLabel();
		upperSubpanel.add(tableLabel,BorderLayout.NORTH);
		
		//create and add table
		createTableAndTablePane();
		GuiControl.createCustomColumns(table, 
                TABLE_WIDTH,
                COL_WIDTH_PROPORTIONS,
                DEFAULT_COLUMN_HEADERS);		
		JPanel tablePanePanel = GuiControl.createStandardTablePanePanel(table,tablePane);
	
		upperSubpanel.add(tablePanePanel,BorderLayout.CENTER);
		
		
		
	}
	private void createTableLabel() {
		tableLabel = new JLabel(MAIN_LABEL);
		tableLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		Font f = GuiControl.makeVeryLargeFont(tableLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		tableLabel.setFont(f);
		
		
		
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
	

	private void updateModel() {

        if(USE_DEFAULT_DATA) {			        	
			List<String[]> defaultData = DefaultData.getCatalogTypes();
			updateModel(defaultData);
        }

	}	

	
	
    private void updateTable() {
        
        table.setModel(model);
        table.updateUI();
        repaint();
        
    }	

	private void defineLowerPanel() {
		 
		//add button
		JButton addButton = new JButton(ADD);
		addButton.addActionListener(new AddButtonListener());
		
		//edit button
		JButton editButton = new JButton(EDIT);
		editButton.addActionListener(new EditButtonListener());
		
		
		//delete button
		JButton deleteButton = new JButton(DELETE);
		deleteButton.addActionListener(new DeleteButtonListener());
		
		
		//back button
		JButton backButton = new JButton(BACK);
		backButton.addActionListener(new BackButtonListener());
		

		
		
		//create lower panel
		JButton [] buttons = {addButton,editButton,deleteButton,backButton};
		lowerSubpanel = GuiControl.createStandardButtonPanel(buttons);
		
		
	}
	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}
		//data for Listeners
	
	/**
	 * @uml.property  name="eRROR_MESSAGE"
	 */
	final String ERROR_MESSAGE = "Please select a row.";
	/**
	 * @uml.property  name="eRROR"
	 */
	final String ERROR = "Error";
		
	class AddButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
        	
        	AddEditCatalog addType = new AddEditCatalog(GuiControl.ADD_NEW,null);
        	setVisible(false);
        	addType.setParentWindow(MaintainCatalogTypes.this);
        	addType.setVisible(true);
        	
        }        	
 
	
	}
	class EditButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	
        	int selectedRow = table.getSelectedRow();
        	if(selectedRow >= 0) {
        		String selectedType = (String)model.getValueAt(selectedRow,0);
        								       														
        		AddEditCatalog editType = new AddEditCatalog(GuiControl.EDIT,selectedType);
        		editType.setVisible(true);
        		
        		
        	}
        	else {
       			JOptionPane.showMessageDialog(MaintainCatalogTypes.this,         									          
        									  ERROR_MESSAGE,
        									  ERROR, 
        									  JOptionPane.ERROR_MESSAGE);
        		
        	}
        		

        }
	}
	class DeleteButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	int selectedRow = table.getSelectedRow();
        	if(selectedRow >= 0) {
				// Students: code goes here.
				JOptionPane.showMessageDialog(MaintainCatalogTypes.this, 
										  "Need to write code for this!", 
										  "Information", 
										  JOptionPane.INFORMATION_MESSAGE);        		
        		
        	}
        	else {
       			JOptionPane.showMessageDialog(MaintainCatalogTypes.this,         									          
        									  ERROR_MESSAGE,
        									  ERROR, 
        									  JOptionPane.ERROR_MESSAGE);
        		
        	}        	
        	

        }
	}	
	
	
	class BackButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if(parent != null) {
				parent.setVisible(true);
			}
		    dispose();		
		}
	}	
	
	public static void main(String args[]) {
	
		(new MaintainCatalogTypes()).setVisible(true);
	}

	private static final long serialVersionUID = 3258410629793592632L;


}