package application.gui;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/** 
 * 
 * @author klevi, pcorazza 
 * @since 10/20/04
 * <p>
 * Class Description: This class is responsible for building
 * the window for adding or editing a catalog group. 
 * <p>
 * <table border="1">
 * <tr>
 * 		<th colspan="3">Change Log</th>
 * </tr>
 * <tr>
 * 		<th>Date</th> <th>Author</th> <th>Change</th>
 * </tr>
 * <tr>
 * 		<td>10/20/04</td>
 *      <td>klevi, pcorazza</td>
 *      <td>New class file</td>
 * </tr>
 * <tr>
 * 		<td>1/19/04</td>
 *      <td>klevi</td>
 *      <td>renamed class--previously AddEditCatalogGroup</td>
 * </tr>
 * </table>
 *
 */
public class AddEditCatalog extends JDialog implements ParentWindow {
	/**
	 * @uml.property  name="parent"
	 */
	private Window parent;


	/**
	 * final value of label will be set in the constructor
	 * @uml.property  name="mainLabel"
	 */
	private String mainLabel = " CatalogImpl Type";
	/**
	 * @uml.property  name="sAVE_BUTN"
	 */
	private final String SAVE_BUTN = "Save";
	/**
	 * @uml.property  name="bACK_BUTN"
	 */
	private final String BACK_BUTN = "Close";
	

	
	/**
	 * @uml.property  name="pRODUCT_NAME"
	 */
	private final String PRODUCT_NAME = "ProductImpl Name";
	/**
	 * @uml.property  name="productNameField"
	 * @uml.associationEnd  
	 */
	private JTextField productNameField;

	/**
	 * catalogGroup have value "Books", "Clothes" etc
	 * @uml.property  name="catalogGroup"
	 */
	private String catalogGroup;
	
	/**
	 * value is "Add New" or "Edit"
	 * @uml.property  name="addOrEdit"
	 */
	private String addOrEdit = GuiControl.ADD_NEW;
	

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
	
	/** 
	 * Constructor sets addOrEdit and catalogGroup instance variables and
	 * then builds the gui. Made visible or invisible by calling classes.
	 * @param addOrEdit - value "add" means it's the window for adding; "edit" 
	 * means it's for editing.
	 * @param catalogGroup - catalogGroup is "Books" or "Clothes"
	 */
	public AddEditCatalog(String addOrEdit, String catalogGroup) {
		this.catalogGroup = catalogGroup;
		this.addOrEdit = addOrEdit;
		
		initializeWindow();
		defineMainPanel();
		getContentPane().add(mainPanel);
			
	}
	

	
	private void initializeWindow() {
		
		setSize(Math.round(.7f*GuiControl.SCREEN_WIDTH),
				Math.round(.5f*GuiControl.SCREEN_HEIGHT));
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
		
		JLabel mainLabel = new JLabel(finalMainLabelName());
		Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
		f = GuiControl.makeBoldFont(f);
		mainLabel.setFont(f);
		upper.add(mainLabel);					
	}
	
	private String finalMainLabelName() {
		return addOrEdit+" "+mainLabel;
	}
	
	public void defineMiddlePanel(){
		middle = new JPanel();
		middle.setBackground(GuiControl.FILLER_COLOR);
		middle.setLayout(new FlowLayout(FlowLayout.CENTER));

		JLabel label = new JLabel(PRODUCT_NAME);
		productNameField = new JTextField(10);
		productNameField.setText(catalogGroup);
		
		middle.add(label);
		middle.add(productNameField);

	}
	//buttons
	public void defineLowerPanel(){
		//proceed button
		JButton saveButton = new JButton(SAVE_BUTN);
		saveButton.addActionListener(new SaveListener());
		
		
		//back to cart button
		JButton backButton = new JButton(BACK_BUTN);
		backButton.addActionListener(new BackListener());
		

		
		//create lower panel
		JButton [] buttons = {saveButton,backButton};
		lower = GuiControl.createStandardButtonPanel(buttons);
	}
	

	public void setParentWindow(Window parentWindow) {
		parent = parentWindow;
	}
	
	public Window getParentWindow() {
		return parent;
	}					
	class SaveListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
				JOptionPane.showMessageDialog(AddEditCatalog.this, 
										  "Need to write code for this!", 
										  "Information", 
										  JOptionPane.INFORMATION_MESSAGE); 
 
        }
	}
	/**
	 * Returns the user to the previous screen
	 */
	class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	
        	if(parent != null) {
        		parent.setVisible(true);
        	}
        	dispose();

        }
	}
	
	public static void main(String[] args) {
		
		
	}
	private static final long serialVersionUID = 1L;	
}
