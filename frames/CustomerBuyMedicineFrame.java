package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;  
import java.awt.*;
import entities.*;
import repositories.*;

public class CustomerBuyMedicineFrame extends JFrame implements ActionListener {
    private JLabel lbl;
    private JTextField[] t;
    private JButton backBtn, buyBtn;
    private JPanel panel;
    private User u;
    private Font font;
    private JCheckBox[] m1;
    private JScrollPane scroll;
    private Medicine[] medicineList;
    private MedicineRepo mrp;

    public CustomerBuyMedicineFrame(User u) {
        super("Medicine Shop");
        this.setSize(850, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new JPanel();
        this.panel.setLayout(null);

        this.font = new Font("Agency FB", Font.BOLD, 20);
        Color c1 = new Color(0, 153, 153);   // red
        Color c2 = new Color(81, 163, 0);    // green
        Color c3 = new Color(51, 51, 255);   // blue

        this.lbl = new JLabel("Write the needed number of quantity under the medicine");
        lbl.setFont(font);
        lbl.setBounds(250, 10, 350, 30);
        this.panel.add(lbl);

        this.mrp = new MedicineRepo();
        this.medicineList = mrp.getAllMedicine();
        String[] str = new String[medicineList.length];
        this.m1 = new JCheckBox[medicineList.length]; // Initialize the array of checkboxes
        this.t = new JTextField[medicineList.length];

        int k = 0;
        int j = 0;
        for (int i = 0; i < medicineList.length; i++) {
            if (medicineList[i] != null && medicineList[i].getMedicineName() != null) {
                
				try{
                str[i] = "<html>" + "<br>" + medicineList[i].getMedicineName() + "<br>" + 
                         medicineList[i].getCategory() + "<br>" + 
                         medicineList[i].getPricePerUnit() + "</html>";
               if((!str[i].equals(null)))
			   {
                // Initialize the checkbox
                this.m1[i] = new JCheckBox(str[i]);
                this.m1[i].setFont(font);
                this.m1[i].setForeground(Color.WHITE);
                this.m1[i].setBackground(c1);

                // Set the position of each checkbox
                this.m1[i].setBounds(30 + (k * 200), 50 + (j * 140), 180, 100); // Adjust the y position based on index
                
                // Initialize and set position of text field
                this.t[i] = new JTextField();
                t[i].setBounds(80 + (k * 200), 155 + (j * 140), 60, 30);

                // Add the checkbox and text field to the panel
                this.panel.add(m1[i]);
                this.panel.add(t[i]);
                k++;
                if ((i + 1) % 4 == 0) { // Move to the next row after every 4 checkboxes
                    j++;
                    k = 0; // Reset column position
                }
			   }
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
            }
        }

        this.buyBtn = new JButton("Buy Medicine");
        this.buyBtn.setBounds(0, 10, 180, 30);
        this.buyBtn.setForeground(Color.WHITE);
        this.buyBtn.setBackground(c3);
        this.buyBtn.addActionListener(this);
        this.panel.add(buyBtn);

        this.backBtn = new JButton("Back");
        this.backBtn.setBounds(740, 10, 80, 30);
        this.backBtn.setForeground(Color.WHITE);
        this.backBtn.setBackground(c3);
        this.backBtn.addActionListener(this);
        this.panel.add(backBtn);

        this.panel.revalidate();
        this.panel.repaint();

        this.scroll = new JScrollPane();
        scroll.setSize(850, 600);

        this.panel.add(scroll);
        this.add(panel);
        this.u = u;
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals(buyBtn.getText())) {
            String[] mName = new String[100];
            int mPrice=0;

            for (int i = 0; i <100; i++) {
                if (medicineList[i] != null && this.m1[i].isSelected()) {
                    try {
                        String quantityText = t[i].getText();

                        if ((!quantityText.equals(null))) {
                            int quantity = Integer.parseInt(quantityText);
                            mName[i] = medicineList[i].getMedicineName();
                            mPrice += ((medicineList[i].getPricePerUnit() )* quantity);
                        } else {
                            JOptionPane.showMessageDialog(this, "Please enter the medicine quantity as required");
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(this, "Please enter a valid number for the quantity");
                    }
                }
            }
         try{
			 
			if(mPrice != 0)
			{
            BuyFrame bf = new BuyFrame(this.u, mPrice);
            this.setVisible(false);
            bf.setVisible(true);
			}
		 }
		 catch(Exception e)
		 {
			 e.printStackTrace();
		 }
        }
        if (command.equals(backBtn.getText())) {
        
			//back button will take you to Medicine home page.
			CustomerHomeFrame cmhf=new CustomerHomeFrame(this.u);
			this.setVisible(false);
			cmhf.setVisible(true);

        }
    }
}
