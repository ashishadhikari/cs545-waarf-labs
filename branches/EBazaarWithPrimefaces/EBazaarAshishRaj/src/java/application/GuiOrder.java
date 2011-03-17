package application;

public class GuiOrder {

	public GuiOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

		
		/**
		 */
		public void reviewOrders(){
		
		}


			
			/**
			 */
			public void viewDetails(){
			
			}


				
				/**
				 * displays a list of orders in the SelectOrderWindow window
				 */
				public void displayOrders(){
				
				}


					
					/**
					 */
					public void displayOrderDetails(){
					
					}



					/**
					 * @uml.property  name="viewOrderController"
					 * @uml.associationEnd  inverse="guiBoundary:application.ViewOrderController"
					 */
					private ViewOrderController viewOrderController;



					/** 
					 * Getter of the property <tt>viewOrderController</tt>
					 * @return  Returns the viewOrderController.
					 * @uml.property  name="viewOrderController"
					 */
					public ViewOrderController getViewOrderController() {
						return viewOrderController;
					}


					/** 
					 * Setter of the property <tt>viewOrderController</tt>
					 * @param viewOrderController  The viewOrderController to set.
					 * @uml.property  name="viewOrderController"
					 */
					public void setViewOrderController(ViewOrderController viewOrderController) {
						this.viewOrderController = viewOrderController;
					}

}
