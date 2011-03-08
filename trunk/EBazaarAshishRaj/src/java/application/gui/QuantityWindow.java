package application.gui;


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import business.subsystemExternalInterfaces.Product;

import application.BrowseSelectController;
public class QuantityWindow extends JDialog {
	BrowseSelectController bsController;
	String productName;
	/**
	 * @uml.property  name="parent"
	 */
	private Window parent;


    /**
	 * @uml.property  name="mAIN_LABEL"
	 */
    private final String MAIN_LABEL = "Quantity Desired";
    /**
	 * @uml.property  name="oK_BUTN"
	 */
    private final String OK_BUTN = "OK";
    /**
	 * @uml.property  name="cANCEL_BUTN"
	 */
    private final String CANCEL_BUTN = "Cancel";
    
    
    /**
	 * @uml.property  name="quantityField"
	 * @uml.associationEnd  
	 */
    private JTextField quantityField;
    
    

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
    public QuantityWindow(BrowseSelectController bsCont, String prodname) {
    	bsController = bsCont;
    	productName = prodname;
        initializeWindow();
        defineMainPanel();
        getContentPane().add(mainPanel);
        
            
    }
    private void initializeWindow() {
        setTitle("Quantity Desired");
        setSize(Math.round(.5f*GuiControl.SCREEN_WIDTH),
                Math.round(.4f*GuiControl.SCREEN_HEIGHT));      
        GuiControl.centerFrameOnDesktop(this);
        
    }
    
    private void defineMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBackground(GuiControl.QUANTITY_SCREEN_BGRND);
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
        upper.setBackground(GuiControl.QUANTITY_SCREEN_BGRND);
        upper.setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JLabel mainLabel = new JLabel(MAIN_LABEL);
        Font f = GuiControl.makeVeryLargeFont(mainLabel.getFont());
        f = GuiControl.makeBoldFont(f);
        mainLabel.setFont(f);
        upper.add(mainLabel);                   
    }
    //table
    public void defineMiddlePanel(){
        middle = new JPanel();
        middle.setBackground(GuiControl.QUANTITY_SCREEN_BGRND);
        middle.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel gridPanel = new JPanel();
        gridPanel.setBackground(GuiControl.SCREEN_BACKGROUND);
        middle.add(gridPanel);
        GridLayout gl = new GridLayout(1,1);
        gridPanel.setLayout(gl);
        gridPanel.setBorder(new WindowBorder(GuiControl.WINDOW_BORDER));

        //add text area
        quantityField = new JTextField(4);
        quantityField.setBackground(GuiControl.SCREEN_BACKGROUND);
        quantityField.setFont(GuiControl.makeDialogFont(quantityField.getFont()));
        quantityField.setText("1");
        gridPanel.add(quantityField);
    }
    
    //buttons
    public void defineLowerPanel(){
        //proceed button
        JButton okButton = new JButton(OK_BUTN);
        okButton.addActionListener(new OkListener());
        
        
        //back to cart button
        JButton cancelButton = new JButton(CANCEL_BUTN);
        cancelButton.addActionListener(new CancelListener());
        
        //create lower panel
        JButton [] buttons = {okButton,cancelButton};
        lower = GuiControl.createStandardButtonPanel(buttons, 
                                 GuiControl.QUANTITY_SCREEN_BGRND);
    }
    

    public String getQuantityDesired(){
        return (quantityField==null ? "1" : quantityField.getText());
    }
    public void setParentWindow(Window parentWindow) {
        parent = parentWindow;
    }
    
    public Window getParentWindow() {
        return parent;
    }   
                    
    class OkListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            setVisible(false);
            /* TODO kl -- should probably do the validation here, and then some popup message
             * if fails to validate--yes, validate should throw an exception, which gets 
             * handled here;  that way, can add new exceptions and just add new catch clauses
             * to handle them--not if-else cascade.
             */
            int quant = new Integer(quantityField.getText());
            bsController.add2Cart(productName, quant);
            CartItemsWindow cartWindow = new CartItemsWindow(bsController);
            cartWindow.setVisible(true);
            cartWindow.setParentWindow(parent);
            
 
        }
    }
    class CancelListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            setVisible(false);
            if(parent != null){
                parent.setVisible(true);
            }
 
        }
    }      
    public static void main(String[] args) {
        
        //(new QuantityWindow()).setVisible(true);
    }       
	private static final long serialVersionUID = 3618135641289078841L;



}
