import javax.swing.*;

public class View extends JFrame {
    
    public Sample Amostra;

	public View() {
	    Amostra = new Sample(3);
    }

    public void askSample(){
        
		JTextField e0 = new JTextField();
		JTextField e1 = new JTextField();
		JTextField e2 = new JTextField();
		JTextField e3 = new JTextField();
		Object[] msg = {"entrada 1", e1, "entrada 2", e2, "entrada 3", e3, "valor esperado", e0};

		JOptionPane panel = new JOptionPane(
		msg,
		JOptionPane.QUESTION_MESSAGE,
		JOptionPane.OK_CANCEL_OPTION,
		null,
		null);

		JDialog dialog = panel.createDialog(this, "Entradas");
		dialog.setVisible(true);

		int result = JOptionPane.OK_OPTION;

		result = ((Integer)panel.getValue()).intValue();

		if(result == JOptionPane.OK_OPTION) {
            double [] E = new double[4];
            E[1] = Double.parseDouble(e1.getText()); // entrada 1
            E[2] = Double.parseDouble(e2.getText()); // entrada 2
            E[3] = Double.parseDouble(e3.getText()); // entrada 3
            E[0] = Integer.parseInt(e0.getText()); // valor esperado
            
            Amostra.getSample(E);

		} else {
			System.out.println("canceled " );
            System.exit(1);
		}
	}

    public static void main(String [] args) {
//    	JFrame frame = new View();
    	View frame = new View();
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	frame.pack();
    	frame.setVisible(true);
        frame.askSample();      // obtem uma amostra
    }
}
