package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.event.*;  
import java.awt.*;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.imageio.*;
import entities.*;
import repositories.*;
import java.awt.image.BufferedImage;

public class EmployeeAddMedicineFrame extends JFrame implements ActionListener
{

    private JLabel medicineIdLabel, medicineNameLabel, medicineCategoryLabel, pricePerUnitLabel, availableQuantityLabel;
	private JTextField medicineIdTF, medicineNameTF, medicineCategoryTF, pricePerUnitTF, availableQuantityTF;
    private JButton addBtn, backBtn;
    private JPanel panel;
	private User u;

    public EmployeeAddMedicineFrame(User u)
	{
		super("Add Medicine Frame");
		this.setSize(800,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.panel = new JPanel();
		this.panel.setLayout(null);

		Color c1 = new Color(0, 153, 153);

		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Operation.png");
		background=new JLabel("",img,JLabel.LEFT);
		background.setBounds(0,0,1000,650);
		panel.add(background);
		
		this.medicineIdLabel = new JLabel("Medicine ID:");
		this.medicineIdLabel.setBounds(50,50,100,30);
		background.add(medicineIdLabel);
		
		this.medicineIdTF = new JTextField();
		this.medicineIdTF.setBounds(150,50,100,30);
		background.add(medicineIdTF);
		
		this.medicineNameLabel = new JLabel("Medicine Name:");
		this.medicineNameLabel.setBounds(50,105,100,30);
		background.add(medicineNameLabel);
		
		this.medicineNameTF = new JTextField();
		this.medicineNameTF.setBounds(150,100,100,30);
		background.add(medicineNameTF);
		
		this.medicineCategoryLabel = new JLabel("Medicine "+"\n"+"Category:");
		this.medicineCategoryLabel.setBounds(50,150,150,30);
		background.add(medicineCategoryLabel);
		
		this.medicineCategoryTF = new JTextField();
		this.medicineCategoryTF.setBounds(200,150,100,30);
		background.add(medicineCategoryTF);

        this.pricePerUnitLabel = new JLabel("Price Per Unit:");
		this.pricePerUnitLabel.setBounds(50,200,100,30);
		background.add(pricePerUnitLabel);
		
		this.pricePerUnitTF = new JTextField();
		this.pricePerUnitTF.setBounds(150,200,100,30);
		background.add(pricePerUnitTF);
		
		this.availableQuantityLabel = new JLabel("Quantity:");
		this.availableQuantityLabel.setBounds(50,250,100,30);
		background.add(availableQuantityLabel);

        this.availableQuantityTF = new JTextField();
		this.availableQuantityTF.setBounds(150,250,100,30);
		background.add(availableQuantityTF);
       
        this.backBtn = new JButton("<-");
		this.backBtn.setBounds(0,0,40,20);
		this.backBtn.setBackground(c1);
        this.backBtn.addActionListener(this);
		background.add(backBtn);

        this.addBtn = new JButton("Add");
		this.addBtn.setBounds(120,300,100,30);
		this.addBtn.setBackground(c1);
        this.addBtn.addActionListener(this);
		background.add(addBtn);

        this.add(panel);
        this.u = u;
	}

    public void actionPerformed(ActionEvent ae)
	{
        String command = ae.getActionCommand();

        if(command.equals(backBtn.getText()))
		{
			MedicineListFrame2 mlf2 = new MedicineListFrame2(u); // Pass the User object
			this.setVisible(false);
			mlf2.setVisible(true);
		}
        if(command.equals(addBtn.getText()))
		{
            String medicineId, medicineName, medicineCategory;
            int pricePerUnit, availableQuantity; // Declare these as int
            // Validating every field has data or not
            if((!medicineIdTF.getText().isEmpty()) && (!medicineNameTF.getText().isEmpty()) && (!medicineCategoryTF.getText().isEmpty()) && (!pricePerUnitTF.getText().isEmpty()) && (!availableQuantityTF.getText().isEmpty()))
			{
                medicineId = medicineIdTF.getText();
                medicineName = medicineNameTF.getText();
                medicineCategory = medicineCategoryTF.getText();

                try
				{
                    pricePerUnit = Integer.parseInt(pricePerUnitTF.getText()); // Parse as int
                    availableQuantity = Integer.parseInt(availableQuantityTF.getText()); // Parse as int
                    
                    MedicineRepo mrp=new MedicineRepo();
                    Medicine med = new Medicine(medicineId, medicineName, medicineCategory, pricePerUnit, availableQuantity);
                    // After successful add operation a confirmation message will be shown.
                    mrp.addMedicine(med);
                    JOptionPane.showMessageDialog(this, "Medicine Added Successfully");
                }
                catch(Exception e)
				{
                    // If any exception occurred in the above operation, it is because of string to int conversion.
                    JOptionPane.showMessageDialog(this, "Provide Integer Value");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "please fill up all the field properly");
            }
        }
    }
}
