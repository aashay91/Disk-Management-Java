import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;


public class GRN extends JFrame  implements WindowListener{

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblEnterPendriveName;
	private  JButton btnNewButton;
	private JButton btnSearchFile;
	private JTextField textField_1;
	private JLabel lblEnterFileName;
	private String pendname="";
	private DefaultListModel model;
	private JButton btnShowFiles;
	private JLabel DrivesLable;
	private JLabel lblPendrivelist;
	private  JComboBox comboBox;
	/**
	 * Launch the application.
	 */
	public  void main1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GRN frame = new GRN();
					frame.setSize(1950,1000);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	


  
       
	@SuppressWarnings("deprecation")
	public GRN() throws IOException {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(0, -27, 816, 775);
		contentPane = new Draw();
	
		contentPane.setForeground(new Color(0, 204, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(new JLabel(new ImageIcon("Pendrives.jpg")));
	            // handle exception...
		 lblEnterPendriveName = new JLabel("Enter Pendrive Name");
		lblEnterPendriveName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEnterPendriveName.setBounds(341, 147, 270, 35);
		contentPane.add(lblEnterPendriveName);
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.BOLD, 18));
		textField.setBounds(281, 195, 352, 49);
		contentPane.add(textField);
		textField.setColumns(10);
		
			
		
		
	 btnNewButton = new JButton("ReadPendrive");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//lblEnterPendriveName.show();
				
				String ss=textField.getText();
				
				ReadF.show(ss);
				JOptionPane.showMessageDialog(null, "Files has been copied");
	
				textField.setText("");
				comboBox.removeAll();
				comboBox.setModel(new DefaultComboBoxModel(ReadF.pdlist.toArray()));
				
				btnNewButton.setEnabled(false);
			}
		});
		
	     
		textField.addKeyListener(new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	            super.keyReleased(e);
	            if(textField.getText().length() > 0 )
	            	btnNewButton.setEnabled(true);
	            else
	            	btnNewButton.setEnabled(false);
	        }
	    });
		
		btnNewButton.setBounds(64, 164, 181, 80);
		contentPane.add(btnNewButton);
		btnNewButton.setEnabled(false);
		
		btnSearchFile = new JButton("Search File ");
		btnSearchFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				

				String ss=textField_1.getText();
				
			      String ss1=ReadF.search(ss);
			      if(ss1!="")
				JOptionPane.showMessageDialog(null, "Find in pendrive named:"+ss1);
			      else
			    JOptionPane.showMessageDialog(null, "File is not found");
			      btnSearchFile.setEnabled(false);	 
			      textField_1.setText("");
	
			}
		});
		btnSearchFile.setFont(new Font("Dialog", Font.BOLD, 18));
		btnSearchFile.setEnabled(false);
		btnSearchFile.setBounds(64, 313, 181, 80);
		contentPane.add(btnSearchFile);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Dialog", Font.BOLD, 18));
		textField_1.setColumns(10);
		textField_1.setBounds(281, 329, 352, 49);
		contentPane.add(textField_1);
		
		lblEnterFileName = new JLabel("Enter File Name");
		lblEnterFileName.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEnterFileName.setBounds(353, 294, 172, 25);
		contentPane.add(lblEnterFileName);
		
		btnShowFiles = new JButton("Show Files ");
		btnShowFiles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				   btnShowFiles.setEnabled( false );
				   ReadF.PenFiles(pendname);
				   sample.main2(pendname+".txt");
				   
			}
		});
		btnShowFiles.setFont(new Font("Dialog", Font.BOLD, 18));
		btnShowFiles.setEnabled(false);
		btnShowFiles.setBounds(64, 437, 181, 80);
		contentPane.add(btnShowFiles);
		
		DrivesLable = new JLabel("");
		DrivesLable.setForeground(new Color(0, 51, 153));
		DrivesLable.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		DrivesLable.setBounds(355, 24, 762, 49);
		contentPane.add(DrivesLable);
		
		DrivesLable.setText("Active Drives"+ReadF.getDrives());
		
		lblPendrivelist = new JLabel("PendriveList ");
		lblPendrivelist.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPendrivelist.setBounds(341, 410, 270, 35);
		contentPane.add(lblPendrivelist);
		
		  comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(ReadF.pdlist.toArray()));
		comboBox.setBounds(341, 460, 200, 50);
		contentPane.add(comboBox);
		
		comboBox.addActionListener( new ActionListener() {
		    @Override
		    public void actionPerformed( final ActionEvent event ) {
		        // Your logic to determine when to enable/disable:
		    //	if(comboBox.)
		      //  final boolean enabled = comboBox.getSelectedIndex() == 0;
		        btnShowFiles.setEnabled( true );
		        pendname=comboBox.getSelectedItem().toString();
		    
		     
		    }
		} );
		
		String[]arr={"a","b"};

		/*
		model = new DefaultListModel();
		list_1.setModel(model);
		model.addElement("aashay");
*/

		textField_1.addKeyListener(new KeyAdapter() {
	        public void keyReleased(KeyEvent e) {
	            super.keyReleased(e);
	            if(textField_1.getText().length() > 0 )
	            	btnSearchFile.setEnabled(true);
	            else
	            	btnSearchFile.setEnabled(false);
	        }
	    });
		
		String	listData[] =
			{
				"Item 1",
				"Item 2",
				"Item 3",
				"Item 4"
			};
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		
		ReadF.closewritter();
		System.out.println("calling");
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("calling");
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
