package episen.si.ing1.pds.client.ConfigElectroWindow;


import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;


public class WindowBeforePageOfConfig {

    public static void main(String[] args){

        JButton b = new JButton("EQUIPEMENTS");
        JButton b1 = new JButton("Configurer les fenêtres");
        JButton b2 = new JButton("Autres équipements");
        b.setBounds(80,100,450,60);
        b1.setBounds(200,250,200,50);
        b2.setBounds(200,400,200,50);
        b.setBackground(Color.white);
        b1.setBackground(Color.cyan);
        b2.setBackground(Color.cyan);

        JPanel panH = new JPanel();
        JPanel panb= new JPanel();
        JPanel pan= new JPanel();


        panH.setBackground(Color.orange);
        panb.setBackground(Color.orange);
        pan.setBackground(Color.lightGray);



        panH.setPreferredSize(new Dimension(30,30));
        panb.setPreferredSize(new Dimension(30,30));

        panH.setLayout(new BorderLayout());
        panb.setLayout(new BorderLayout());
        pan.setLayout(new BorderLayout());


        JFrame f = new JFrame("Tech-up");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(new BorderLayout());
        f.setSize(600,600);
        f.setVisible(true);
        f.setResizable(true);
        f.setLocationRelativeTo(null);
        f.setResizable(false);

        f.getContentPane().add(b);
        f.getContentPane().add(b1);
        f.getContentPane().add(b2);

        f.add(panH, BorderLayout.NORTH);
        f.add(panb, BorderLayout.SOUTH);
        f.add(pan, BorderLayout.CENTER);




       JLabel label = new JLabel();
        f.add(label);
        label.setText("Tech-up");
        label.setVerticalAlignment(JLabel.NORTH);
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setForeground(new Color(0xF));//color of test
      label.setFont(new Font("", Font.PLAIN,20));//size of the text
        label.setBackground(Color.orange);
            label.setOpaque(true);
            label.setBorder(label.getBorder());
        label.setBounds(0,0,600,200);
        panH.add(label,BorderLayout.NORTH);
    }
}

