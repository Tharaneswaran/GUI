package com.anna.app;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
 
public class GUI{
    public static void main(String args[]) {
        File4Frm file4Frm = new File4Frm();
    }
}
 
class File4Frm extends Frame implements ActionListener {
    FileDialog sv;
    Label l1,l2,l3,l4,Hd,Ol,pr;
    JTextField  f1,f2,f3,f4;
    JButton button1, button2;
    JTextArea textArea = new JTextArea();
    JTextArea preview;
 
    File4Frm() {
                 super("CUSTOMER SHOPPING LIST");
        setLayout(null);
        setBackground(Color.CYAN);
        setSize(1000, 1000);
        setVisible(true);
                 button1 = new JButton("Save");
                 button2 = new JButton("Close");
                 textArea = new JTextArea("ITEM\tQTY\tPRICE\n");
              Hd=new Label("****SHOPPING LIST****");
          	  Hd.setBounds(140, 50, 260, 20);
              Hd.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
              Hd.setForeground(Color.BLACK);
              
              Ol=new Label("***ORDER HERE***");
              Ol.setBounds(160, 250, 300, 60);
              Ol.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
              Ol.setForeground(Color.BLACK);
              
              pr=new Label("***PREVIEW***");
              pr.setBounds(760, 250, 300, 60);
              pr.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
              pr.setForeground(Color.BLACK);
              
              l1=new Label("Name:");
       		  l1.setBounds(30, 100, 60, 20);
       		  l1.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
       		  l1.setForeground(Color.BLACK);
       		  f1 = new JTextField(15);
       	      f1.setBounds(180, 100, 310, 20);
       	      
       	      l2=new Label("Email ID:");
 		      l2.setBounds(30, 130, 100, 20);
 		      l2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      		  l2.setForeground(Color.BLACK);
 		      f2 = new JTextField(40);
 	          f2.setBounds(180, 130, 310, 20);
 	      
 	          l3=new Label("Contact No:");
 		      l3.setBounds(30, 160, 150, 20);
 		      l3.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
      		  l3.setForeground(Color.BLACK);
 		      f3 = new JTextField(40);
 	          f3.setBounds(180, 160, 310, 20);
 	          
 	          l4=new Label("Order Date:");
		      l4.setBounds(30, 190, 150, 20);
		      l4.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
     		  l4.setForeground(Color.BLACK);
		      f4 = new JTextField(40);
	          f4.setBounds(180, 190, 310, 20);
 	         
 	          preview = new JTextArea();
 	          
        add(button1);
        add(button2);
        add(textArea);
        add(preview);
        add(l1);
        add(f1);
        add(Hd);
        add(Ol);
        add(pr);
        add(l2);
        add(f2);
        add(l3);
        add(f3);
        add(l4);
        add(f4);
        
        textArea.setBounds(30, 300, 460, 400);
        preview.setBounds(600, 300, 460, 400);
        button1.setBounds(420, 730, 100, 50);
        button2.setBounds(560, 730, 100, 50);
                 sv = new FileDialog(this, "Save", FileDialog.SAVE); 
        button1.addActionListener(this);
        button2.addActionListener(this);
                 addWindowListener(new WindowAdapter() 
                 {
            public void windowClosing(WindowEvent e) 
            {
                System.exit(0);
            }
        });
    }
 
         public void actionPerformed(ActionEvent e) 
         {
        	 
                 if (e.getSource() == button1) 
                	 
                 {
                	 sv.setVisible(true);
                	 try 
                	 {
                	 preview.setText(preview.getText() + "Name:           "+ f1.getText()+ "\n");
                	 preview.setText(preview.getText() + "Email ID:       "+ f2.getText()+ "\n");
                	 preview.setText(preview.getText() + "Contact NO:     "+ f3.getText()+ "\n");
                	 preview.setText(preview.getText() + "Order Date:     "+ f4.getText()+ "\n\n");
                	 preview.setText(preview.getText() + textArea.getText()+ "\n");
                	 
                	 FileWriter fw= new FileWriter("java.txt", true);
                     fw.write(preview.getText());
                     fw.close();
                     
                     File fl = new File(sv.getDirectory(), sv.getFile());
                     FileWriter fw1 = new FileWriter(fl);
                     BufferedWriter bw = new BufferedWriter(fw1);
                     String gt = preview.getText();
                     bw.write(gt, 0, gt.length());
                     bw.flush();
                     fw1.close();
                    
                	 
                
            } catch (Exception e1) {
            }
        }
                 if (e.getSource() == button2) 
                 {
            System.exit(0);
        }
                 
    }
}
