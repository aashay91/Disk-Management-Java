import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Designs extends Frame implements ActionListener{
	private Label lblCount;    // Declare component Label
	   private TextField tfCount; // Declare component TextField
	   private Button btnCount;   // Declare component Button
	   private int count = 0;
	
	public Designs()
	{
	
		 setLayout(new FlowLayout());
		 lblCount = new Label("See");  // construct Label
	      add(lblCount);
	      
		 btnCount = new Button("Count");   // construct Button
	      add(btnCount);
	      btnCount.addActionListener(this);
	      
	      setTitle("AWT Counter");  // "super" Frame sets title
	      setSize(10000, 100000); 
	      
	      setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	
		System.out.println();
		lblCount.setText("helllllllllllll");
		
	}

}
