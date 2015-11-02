package br.mackenzie.simacr.controllers;

public class Main {

	/**
	 * @param args
	 */
    public static void main(String args[]) {
    	ControllerFront controllerFront;
    	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        	java.util.logging.Logger.getLogger("Error");
        } catch (InstantiationException ex) {
        	java.util.logging.Logger.getLogger("Error");
        } catch (IllegalAccessException ex) {
        	java.util.logging.Logger.getLogger("Error");
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	java.util.logging.Logger.getLogger("Error");
        }
        
        //</editor-fold>
        ControllerFront.getInstance().novoController(new ControllerFormLogin());
        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                
            }
        });
    }

}