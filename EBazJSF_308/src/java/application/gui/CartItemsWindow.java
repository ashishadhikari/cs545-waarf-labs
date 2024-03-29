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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JWindow;

import application.BrowseSelectController;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This window represents a user's shopping cart. 
 * Students:  See the readdata method for where data is put into the table.
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
 *      <td>Modified comments for readdata and updatemodel</td>
 * </tr>
 * </table>
 *
 */
public class CartItemsWindow extends JWindow implements ParentWindow {
	BrowseSelectController bsController;
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
	private final boolean USE_DEFAULT_DATA = false;

    /**
	 * @uml.property  name="iTEM"
	 */
    private final String ITEM = "Item";
    /**
	 * @uml.property  name="qUANTITY"
	 */
    private final String QUANTITY = "Quantity";
    /**
	 * @uml.property  name="uNIT_PRICE"
	 */
    private final String UNIT_PRICE = "Unit Price";
    /**
	 * @uml.property  name="tOTAL"
	 */
    private final String TOTAL = "Total Price";
    /**
	 * @uml.property  name="mAIN_LABEL"
	 */
    private final String MAIN_LABEL = "Cart Items";
    
    //button labels
    /**
	 * @uml.property  name="pROCEED_BUTN"
	 */
    private final String PROCEED_BUTN = "Proceed To Checkout";
    /**
	 * @uml.property  name="cONTINUE"
	 */
    private final String CONTINUE = "Continue Shopping";
    /**
	 * @uml.property  name="sAVE_CART"
	 */
    private final String SAVE_CART = "Save Cart";
    /**
	 * @uml.property  name="eXIT_BUTN"
	 */
    private final String EXIT_BUTN = "Exit E-Bazaar";
    
    //table data and config
	/**
	 * @uml.property  name="dEFAULT_COLUMN_HEADERS" multiplicity="(0 -1)" dimension="1"
	 */
	private final String[] DEFAULT_COLUMN_HEADERS = {ITEM,QUANTITY,UNIT_PRICE,TOTAL};
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
    	{0.4f, 0.2f, 0.2f, 0.2f};

    	
    	
	public CartItemsWindow(BrowseSelectController bsCont) {
		bsController = bsCont;
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
		JButton proceedButton = new JButton(PROCEED_BUTN);
		proceedButton.addActionListener(new ProceedListener());
		
		
		//continue button
		JButton continueButton = new JButton(CONTINUE);
		continueButton.addActionListener(new ContinueListener());
		
		//save button
		JButton saveButton = new JButton(SAVE_CART);
		saveButton.addActionListener(new SaveCartListener());
		
		//exit button
		JButton exitButton = new JButton(EXIT_BUTN);
		exitButton.addActionListener(new ExitButtonListener(CartItemsWindow.this));	
		
		//create lower panel
		JButton [] buttons = {proceedButton,continueButton,saveButton,exitButton};
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
        	//DefaultData data = DefaultData.getInstance();			        	
			//theData = data.getCartItemsData();
        	String[] cartItems1 = new String[4];
        	cartItems1[0] = "umbrella";
        	cartItems1[1] = "$5";
        	cartItems1[2] = "10";
        	cartItems1[3] = "$50";
			theData.add(cartItems1);	
			
        	String[] cartItems2 = new String[4];
        	cartItems2[0] = "galoshes";
        	cartItems2[1] = "$50";
        	cartItems2[2] = "1";
        	cartItems2[3] = "$50";
			theData.add(cartItems2);			
			
        }
        else {
        	/* get thedata from controller */
        	theData = bsController.getCartDisplayList();
        	
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
	class ProceedListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
        	ShippingBillingWindow s = new ShippingBillingWindow();
        	s.setVisible(true);
        	s.setParentWindow(CartItemsWindow.this);
        }
	}
	class ContinueListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {        	
        	if(parent != null) {
        		setVisible(false);
        	    ParentWindow grandparent = (ParentWindow)(((ParentWindow)parent).getParentWindow());
        	    ParentWindow greatgrandparent = (ParentWindow)grandparent.getParentWindow();
        	    greatgrandparent.setVisible(true);
        	}
        	else {
				setVisible(false);
        	    CatalogListWindow w = CatalogListWindow.getInstance();
        	    w.setVisible(true);
        	}

        }
	}
	class SaveCartListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {

        }
	}	
	
	public static void main(String[] args) {
		//(new CartItemsWindow()).setVisible(true);
	}	
	private static final long serialVersionUID = 1L;	
}
