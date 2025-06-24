package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pin extends JFrame implements ActionListener {
    JButton b1,b2;
    JPasswordField p1,p2;
    Pin(){
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label1 = new JLabel("CHANGE YOUR PIN");
        label1.setBounds(430, 180, 400, 35);
        label1.setFont(new Font("System", Font.BOLD, 23));
        label1.setForeground(Color.white);
        l3.add(label1);

        JLabel label2 = new JLabel("NEW PIN:");
        label2.setBounds(430, 220, 150, 35);
        label2.setFont(new Font("System", Font.BOLD, 23));
        label2.setForeground(Color.white);
        l3.add(label2);

        p1 = new JPasswordField();
        p1.setBounds(600, 220, 180, 25);
        p1.setFont(new Font("Raleway", Font.BOLD, 22));
        p1.setBackground(new Color(65, 125, 128));
        p1.setForeground(Color.white);
        l3.add(p1);

        JLabel label3 = new JLabel("re-enter PIN:");
        label3.setBounds(430, 250, 400, 35);
        label3.setFont(new Font("System", Font.BOLD, 23));
        label3.setForeground(Color.white);
        l3.add(label3);

        p2 = new JPasswordField();
        p2.setBounds(600, 255, 180, 25);
        p2.setFont(new Font("Raleway", Font.BOLD, 22));
        p2.setBackground(new Color(65, 125, 128));
        p2.setForeground(Color.white);
        l3.add(p2);

        b1 = new JButton("DEPOSIT");
        b1.setBounds(700, 365, 150, 35);
        b1.setForeground(Color.white);
        b1.setBackground(new Color(65, 125, 128));
        b1.addActionListener(this);
        l3.add(b1);

        b2 = new JButton("BACK");
        b2.setBounds(700, 406, 150, 35);
        b2.setForeground(Color.white);
        b2.setBackground(new Color(65, 125, 128));
        b2.addActionListener(this);
        l3.add(b2);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }@Override
    public void actionPerformed(ActionEvent e) {
        try {
            String pin = p1.getText();
            String repin = p2.getText();
            if (e.getSource() == b1) {
                if (pin.equals(repin)) {
                    if (pin.length() == 4) {
                        Con c = new Con();
                        String query = "update bank set pin = '" + pin + "' where pin = '" + repin + "'";
                        c.statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "PIN changed successfully");
                        setVisible(false);
                        new main_Class(pin);
                    } else {
                        JOptionPane.showMessageDialog(null, "PIN must be 4 digits");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "PIN does not match");
                }
            } else if (e.getSource() == b2) {
                setVisible(false);
                new main_Class(pin);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public static void main(String[] args) {
        new Pin();
    }


}
