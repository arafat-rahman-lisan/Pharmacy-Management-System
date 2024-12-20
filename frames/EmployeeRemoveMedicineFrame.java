
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

public class EmployeeRemoveMedicineFrame extends JFrame implements ActionListener {

    private JButton removeBtn, backBtn;
    private JPanel panel;
    private User u;
    private JTextField medicineIdTF;

    public EmployeeRemoveMedicineFrame(User u) {
        super("Remove Medicine Frame");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new JPanel();
        this.panel.setLayout(null);

        Color c1 = new Color(0, 153, 153);

		JLabel background;
		ImageIcon img= new ImageIcon("frames/Picture/Operation.png");
		background=new JLabel("",img,JLabel.LEFT);
		background.setBounds(0,0,1000,650);
		panel.add(background);

        JLabel medicineIdLabel = new JLabel("Medicine ID:");
        medicineIdLabel.setBounds(50, 50, 100, 30);
        background.add(medicineIdLabel);

        this.medicineIdTF = new JTextField();
        this.medicineIdTF.setBounds(150, 50, 100, 30);
        background.add(medicineIdTF);

        this.backBtn = new JButton("<-");
        this.backBtn.setBounds(0, 0, 40, 20);
        this.backBtn.setBackground(c1);
        this.backBtn.addActionListener(this);
        background.add(backBtn);

        this.removeBtn = new JButton("Remove");
        this.removeBtn.setBounds(120, 100, 100, 30);
        this.removeBtn.setBackground(c1);
        this.removeBtn.addActionListener(this);
        background.add(removeBtn);

        this.add(panel);
        this.u = u;
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals(backBtn.getText())) {
            MedicineListFrame2 mlf2 = new MedicineListFrame2(u); // Pass the User object
            this.setVisible(false);
            mlf2.setVisible(true);
        }
        if (command.equals(removeBtn.getText())) {
            String medicineId = medicineIdTF.getText();

            if (!medicineId.isEmpty()) {
                MedicineRepo mrp = new MedicineRepo();
                Medicine m = mrp.searchMedicineByMedicineId(medicineId);

                if (m != null) {
                    mrp.removeMedicine(medicineId);
                    JOptionPane.showMessageDialog(this, "Medicine removed Successfully");
                } else {
                    JOptionPane.showMessageDialog(this, "Provide Valid Medicine ID");
                }

            } else {
                JOptionPane.showMessageDialog(this, "Please Provide a valid Medicine ID");
            }
        }
    }
}
