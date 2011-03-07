package application.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 
 * @author klevi, pcorazza 
 * @since Oct 22, 2004
 * <p>
 * Class Description: This class presents a screen that displays
 * shipping and billing fields. The screen provides a Select Shipping
 * AddressImpl button that permits the user to pick, from another
 * screen, one of the customer's addresses, which is then loaded
 * automatically into the shipping fields on the current screen.
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
 * </table>
 *
 */
public class ShippingBillingWindow extends JDialog implements ParentWindow {
	

	/**
	 * @uml.property  name="parent"
	 */
	private Window parent;
	
	//constants
	/**
	 * @uml.property  name="mAIN_LABEL"
	 */
	private final String MAIN_LABEL = "Shipping And Billing Information";
	/**
	 * @uml.property  name="sHIP_LABEL"
	 */
	private final String SHIP_LABEL = "Shipping AddressImpl";
	/**
	 * @uml.property  name="bILL_LABEL"
	 */
	private final String BILL_LABEL = "Billing AddressImpl";
	/**
	 * @uml.property  name="sHIP_METHOD_LABEL"
	 */
	private final String SHIP_METHOD_LABEL = "Shipping Method";
	/**
	 * @uml.property  name="nAME"
	 */
	private final String NAME = "Name";
	/**
	 * @uml.property  name="aDDRESS_1"
	 */
	private final String ADDRESS_1 = "AddressImpl 1";
	/**
	 * @uml.property  name="aDDRESS_2"
	 */
	private final String ADDRESS_2 = "AddressImpl 2";
	/**
	 * @uml.property  name="cITY"
	 */
	private final String CITY = "City";
	/**
	 * @uml.property  name="sTATE"
	 */
	private final String STATE = "State";
	/**
	 * @uml.property  name="zIP"
	 */
	private final String ZIP = "Zip";
	
	//button labels
	/**
	 * @uml.property  name="sELECT_SHIP_ADDR"
	 */
	private final String SELECT_SHIP_ADDR = "Select Shipping AddressImpl";
	/**
	 * @uml.property  name="pROCEED_WITH_CHECKOUT"
	 */
	private final String PROCEED_WITH_CHECKOUT = "Proceed With Checkout"; 
	/**
	 * @uml.property  name="bACK_TO_CART"
	 */
	private final String BACK_TO_CART = "Back To Cart";
	/**
	 * @uml.property  name="gROUND"
	 */
	private final String GROUND = "Pigeon-carrier Ground";
	/**
	 * @uml.property  name="aIR"
	 */
	private final String AIR = "Pigeon-carrier Air";
	/**
	 * @uml.property  name="oVERNIGHT"
	 */
	private final String OVERNIGHT = "Pigeon-carrier Overnight";
	/**
	 * @uml.property  name="cHECK_IF_SAME"
	 */
	private final String CHECK_IF_SAME = "Check if Billing AddressImpl is Same as Shipping";
	
	
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
	
	   //button row
	/**
	 * @uml.property  name="lower"
	 * @uml.associationEnd  
	 */
	JPanel lower;
	
	//upper divisions
	  //contains main label for screen
	/**
	 * @uml.property  name="upperTop"
	 * @uml.associationEnd  
	 */
	JPanel upperTop;
	  //contains address panels
	/**
	 * @uml.property  name="upperMiddle"
	 * @uml.associationEnd  
	 */
	JPanel upperMiddle;
	  //contains checkbox
	/**
	 * @uml.property  name="upperBottom"
	 * @uml.associationEnd  
	 */
	JPanel upperBottom;
	
	//upperMiddle divisions
	  //shipping address
	/**
	 * @uml.property  name="upperMiddleLeft"
	 * @uml.associationEnd  
	 */
	JPanel upperMiddleLeft;
	  //billing address
	/**
	 * @uml.property  name="upperMiddleRight"
	 * @uml.associationEnd  
	 */
	JPanel upperMiddleRight;
	
	//upperMiddleLeft divisions
	  //label for shipping
	/**
	 * @uml.property  name="upperMiddleLeftLabel"
	 * @uml.associationEnd  
	 */
	JPanel upperMiddleLeftLabel;
	  //address fields
	/**
	 * @uml.property  name="upperMiddleLeftFields"
	 * @uml.associationEnd  
	 */
	JPanel upperMiddleLeftFields;
	
	//upperMiddleRight divisions
	  //label for billing
	/**
	 * @uml.property  name="upperMiddleRightLabel"
	 * @uml.associationEnd  
	 */
	JPanel upperMiddleRightLabel;
	  //address fields
	/**
	 * @uml.property  name="upperMiddleRightFields"
	 * @uml.associationEnd  
	 */
	JPanel upperMiddleRightFields;
	
	//middle divisions
	   //shipping method label
	/**
	 * @uml.property  name="middleTop"
	 * @uml.associationEnd  
	 */
	JPanel middleTop;
	   //radio button panel
	/**
	 * @uml.property  name="middleBottom"
	 * @uml.associationEnd  
	 */
	JPanel middleBottom;
	
	//widgets
	
	
	/**
	 * @uml.property  name="shipNameField"
	 * @uml.associationEnd  
	 */
	private JTextField shipNameField;
	/**
	 * @uml.property  name="shipAddressField"
	 * @uml.associationEnd  
	 */
	private JTextField shipAddressField;
	
	/**
	 * @uml.property  name="shipCityField"
	 * @uml.associationEnd  
	 */
	private JTextField shipCityField;
	/**
	 * @uml.property  name="shipStateField"
	 * @uml.associationEnd  
	 */
	private JTextField shipStateField;
	/**
	 * @uml.property  name="shipZipField"
	 * @uml.associationEnd  
	 */
	private JTextField shipZipField;
	
	/**
	 * @uml.property  name="billNameField"
	 * @uml.associationEnd  
	 */
	private JTextField billNameField;
	/**
	 * @uml.property  name="billAddressField"
	 * @uml.associationEnd  
	 */
	private JTextField billAddressField;
	
	/**
	 * @uml.property  name="billCityField"
	 * @uml.associationEnd  
	 */
	private JTextField billCityField;
	/**
	 * @uml.property  name="billStateField"
	 * @uml.associationEnd  
	 */
	private JTextField billStateField;
	/**
	 * @uml.property  name="billZipField"
	 * @uml.associationEnd  
	 */
	private JTextField billZipField;	
	
	/**
	 * @uml.property  name="groundButton"
	 * @uml.associationEnd  
	 */
	private JRadioButton groundButton;
	/**
	 * @uml.property  name="airButton"
	 * @uml.associationEnd  
	 */
	private JRadioButton airButton;
	/**
	 * @uml.property  name="overnightButton"
	 * @uml.associationEnd  
	 */
	private JRadioButton overnightButton;
	
	/**
	 * @uml.property  name="addressesSameCheckbox"
	 * @uml.associationEnd  
	 */
	private JCheckBox addressesSameCheckbox;
	
	/** Used by ShipAddressesWindow to fill in the shipping address */
	public void setShippingAddress(String name, String addr, String city, String state, String zip) {
		if(shipNameField != null) {
			shipNameField.setText(name);
		}
		if(shipAddressField != null) {
			shipAddressField.setText(addr);
		}

		if(shipCityField != null) {
			shipCityField.setText(city);
		}
		if(shipStateField != null) {
			shipStateField.setText(state);
		}
		if(shipZipField != null) {
			shipZipField.setText(zip);
		}
	}
	public ShippingBillingWindow() {
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
		pack();
		
		
			
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
		defineUpper();
		defineMiddle();
		defineLower();
		mainPanel.add(upper,BorderLayout.NORTH);
		mainPanel.add(middle,BorderLayout.CENTER);
		mainPanel.add(lower,BorderLayout.SOUTH);
			
	}
	/** Use BorderLayout */
	private void defineUpper(){
		upper = new JPanel();
		upper.setLayout(new BorderLayout());
		upper.setBackground(GuiControl.FILLER_COLOR);
		
		defineUpperTop();
		defineUpperMiddle();
		defineUpperBottom();
		
		upper.add(upperTop,BorderLayout.NORTH);
		upper.add(upperMiddle,BorderLayout.CENTER);
		upper.add(upperBottom,BorderLayout.SOUTH);		
		
	}
	
	/** FlowLayout center, to place label */
	private void defineUpperTop() {
		upperTop = new JPanel();
		upperTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		upperTop.setBackground(GuiControl.FILLER_COLOR);
		JLabel mainLabel = new JLabel(MAIN_LABEL);
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		upperTop.add(mainLabel);		
	}
	
	/** FlowLayout center, to place address panels */
	private void defineUpperMiddle() {
		upperMiddle = new JPanel();
		upperMiddle.setLayout(new FlowLayout(FlowLayout.CENTER));
		upperMiddle.setBackground(GuiControl.FILLER_COLOR);
		defineUpperMiddleLeft();
		defineUpperMiddleRight();
		upperMiddle.add(upperMiddleLeft);
		upperMiddle.add(upperMiddleRight);
				
	}
	
	/** BorderLayout to place label and address fields */
	private void defineUpperMiddleLeft() {
		upperMiddleLeft = new JPanel();
		upperMiddleLeft.setLayout(new BorderLayout());
		upperMiddleLeft.setBackground(GuiControl.FILLER_COLOR);	
		defineUpperMiddleLeftLabelPanel();
		defineUpperMiddleLeftFieldsPanel();

		upperMiddleLeft.add(upperMiddleLeftLabel,BorderLayout.NORTH);
		upperMiddleLeft.add(upperMiddleLeftFields,BorderLayout.CENTER);			
		
	}
	/** FlowLayout center, for label */
	private void defineUpperMiddleLeftLabelPanel() {
		upperMiddleLeftLabel = new JPanel();
		upperMiddleLeftLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
		upperMiddleLeftLabel.setBackground(GuiControl.FILLER_COLOR);		
		
		JLabel shipLabel = new JLabel(SHIP_LABEL);
		Font f = GuiControl.makeLargeFont(shipLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		shipLabel.setFont(f);
		upperMiddleLeftLabel.add(shipLabel);	
	}
	
	private void makeLabel(JPanel p, String s) {
		JLabel l = new JLabel(s);
		p.add(leftPaddedPanel(l));
	}
	
	/** GridLayout for address fields */
	private void defineUpperMiddleLeftFieldsPanel(){
		upperMiddleLeftFields = new JPanel();
		upperMiddleLeftFields.setLayout(new FlowLayout(FlowLayout.CENTER));
		upperMiddleLeftFields.setBackground(GuiControl.FILLER_COLOR);
		
		
		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		gridPanel.setBackground(GuiControl.SCREEN_BACKGROUND);
		GridLayout gl = new GridLayout(5,2);
		gl.setHgap(10);
		gridPanel.setLayout(gl);
		
		upperMiddleLeftFields.add(gridPanel);
		
		JPanel paddedPanel = null;
		
		//ship name
		makeLabel(gridPanel,NAME);
		shipNameField = new JTextField(10);		
		gridPanel.add(shipNameField);				

		//shipping address 
		makeLabel(gridPanel,ADDRESS_1);
		shipAddressField = new JTextField(10);
		gridPanel.add(shipAddressField);	
				


		//shipping city
		makeLabel(gridPanel,CITY);
		shipCityField = new JTextField(10);
		gridPanel.add(shipCityField);	

		//shipping state
		makeLabel(gridPanel,STATE);
		shipStateField = new JTextField(10);
		gridPanel.add(shipStateField);	


		//shipping zip
		makeLabel(gridPanel,ZIP);
		shipZipField = new JTextField(10);
		gridPanel.add(shipZipField);	

	}
	/** BorderLayout to place label and address fields */
	private void defineUpperMiddleRight() {
		upperMiddleRight = new JPanel();
		upperMiddleRight.setLayout(new BorderLayout());
		upperMiddleRight.setBackground(GuiControl.FILLER_COLOR);	
		defineUpperMiddleRightLabelPanel();
		defineUpperMiddleRightFieldsPanel();


		upperMiddleRight.add(upperMiddleRightLabel,BorderLayout.NORTH);
		upperMiddleRight.add(upperMiddleRightFields,BorderLayout.CENTER);		
	}
	
	/** FlowLayout center, for label */
	private void defineUpperMiddleRightLabelPanel() {
		upperMiddleRightLabel = new JPanel();
		upperMiddleRightLabel.setLayout(new FlowLayout(FlowLayout.CENTER));
		upperMiddleRightLabel.setBackground(GuiControl.FILLER_COLOR);		
		
		JLabel billLabel = new JLabel(BILL_LABEL);
		Font f = GuiControl.makeLargeFont(billLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		billLabel.setFont(f);
		upperMiddleRightLabel.add(billLabel);	
	}
	/** GridLayout for address fields */
	private void defineUpperMiddleRightFieldsPanel(){
		upperMiddleRightFields = new JPanel();
		upperMiddleRightFields.setLayout(new FlowLayout(FlowLayout.CENTER));
		upperMiddleRightFields.setBackground(GuiControl.FILLER_COLOR);
		
		
		JPanel gridPanel = new JPanel();
		gridPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		gridPanel.setBackground(GuiControl.SCREEN_BACKGROUND);
		GridLayout gl = new GridLayout(5,2);
		gl.setHgap(10);
		gridPanel.setLayout(gl);
		
		upperMiddleRightFields.add(gridPanel);
		
		JPanel paddedPanel = null;
		
		//billing name
		makeLabel(gridPanel,NAME);
		billNameField = new JTextField(10);		
		gridPanel.add(billNameField);				

		//billing address 
		makeLabel(gridPanel,ADDRESS_1);
		billAddressField = new JTextField(10);
		gridPanel.add(billAddressField);	
				


		//billing city
		makeLabel(gridPanel,CITY);
		billCityField = new JTextField(10);
		gridPanel.add(billCityField);	

		//billing state
		makeLabel(gridPanel,STATE);
		billStateField = new JTextField(10);
		gridPanel.add(billStateField);	


		//billing zip
		makeLabel(gridPanel,ZIP);
		billZipField = new JTextField(10);
		gridPanel.add(billZipField);	
			
	}
	/** Flow Layout, center, for checkbox */
	private void defineUpperBottom() {
		upperBottom = new JPanel();
		upperBottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		upperBottom.setBackground(GuiControl.FILLER_COLOR);
		
		addressesSameCheckbox = new JCheckBox();
		addressesSameCheckbox.setBackground(GuiControl.FILLER_COLOR);
		upperBottom.add(addressesSameCheckbox);
				
		JLabel addrSameLabel = new JLabel(CHECK_IF_SAME);
		upperBottom.add(addrSameLabel);
				
	}		
		
	/** Flow layout, center, for shipping method */
	private void defineMiddle(){
		middle = new JPanel();
		middle.setLayout(new FlowLayout(FlowLayout.CENTER));
		middle.setBackground(GuiControl.FILLER_COLOR);
		
		JPanel shipMethodPanel = new JPanel();
		shipMethodPanel.setLayout(new BorderLayout());
		middle.add(shipMethodPanel);
		
		
		defineMiddleTop();
		defineMiddleBottom();	
		
		shipMethodPanel.add(middleTop,BorderLayout.NORTH);
		shipMethodPanel.add(middleBottom,BorderLayout.CENTER);			
	}
	/** Flow Layout center for shipping method label */
	private void defineMiddleTop(){
		middleTop = new JPanel();
		middleTop.setLayout(new FlowLayout(FlowLayout.CENTER));
		middleTop.setBackground(GuiControl.FILLER_COLOR);	
		
		JLabel shipMethodLabel = new JLabel(SHIP_METHOD_LABEL);
		Font f = GuiControl.makeLargeFont(shipMethodLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		shipMethodLabel.setFont(f);
		middleTop.add(shipMethodLabel);						
	}
	
	/** BoxLayout for radio button group */
	private void defineMiddleBottom(){
		middleBottom = new JPanel();
		
		middleBottom.setLayout(new BoxLayout(middleBottom, BoxLayout.Y_AXIS));
		middleBottom.setBackground(GuiControl.SCREEN_BACKGROUND);
		middleBottom.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));
		
		groundButton = new JRadioButton(GROUND);
		groundButton.setBackground(GuiControl.SCREEN_BACKGROUND);
		airButton  = new JRadioButton(AIR);
		airButton.setBackground(GuiControl.SCREEN_BACKGROUND);
		overnightButton  = new JRadioButton(OVERNIGHT);
		overnightButton.setBackground(GuiControl.SCREEN_BACKGROUND);
	    overnightButton.setSelected(true);

	    ButtonGroup group = new ButtonGroup();
    	group.add(groundButton);
	    group.add(airButton);
    	group.add(overnightButton);
    	
    	middleBottom.add(groundButton);
    	middleBottom.add(airButton);
    	middleBottom.add(overnightButton);
	    
	}
	

	/** standard button row */
	private void defineLower(){
		//select ship button
		JButton selectShipButton = new JButton(SELECT_SHIP_ADDR);
		selectShipButton.addActionListener(new SelectShipButtonListener());
		
		
		//proceed checkout button
		JButton proceedCheckoutButton = new JButton(PROCEED_WITH_CHECKOUT);
		proceedCheckoutButton.addActionListener(new ProceedCheckoutButtonListener());
		
		//back to cart button
		JButton backButton = new JButton(BACK_TO_CART);
		backButton.addActionListener(new BackToCartButtonListener());		
		
		//create lower panel
		JButton [] buttons = {selectShipButton,proceedCheckoutButton,backButton};
		lower = GuiControl.createStandardButtonPanel(buttons);		
	}

	private JPanel leftPaddedPanel(JLabel label) {
		JPanel paddedPanel = new JPanel();
		paddedPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		paddedPanel.add(GuiControl.createHBrick(1));
		paddedPanel.add(label);
		paddedPanel.setBackground(GuiControl.SCREEN_BACKGROUND);
		return paddedPanel;		
	}
	
	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}	
	class SelectShipButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
        	ShipAddressesWindow shipAddrs = new ShipAddressesWindow(ShippingBillingWindow.this);
        	shipAddrs.setVisible(true);
        	shipAddrs.setParentWindow(ShippingBillingWindow.this);

        }
	}
	class ProceedCheckoutButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	setVisible(false);
        	PaymentWindow w = new PaymentWindow();
        	w.setVisible(true);
        	w.setParentWindow(ShippingBillingWindow.this);

        }
	}	
	
	class BackToCartButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			if(parent != null) {
				parent.setVisible(true);
			}
		    setVisible(false);			
		}
	}
	
	public static void main(String[] args) {
		(new ShippingBillingWindow()).setVisible(true);
	}
	private static final long serialVersionUID = 3256445819661072690L;
	
}
