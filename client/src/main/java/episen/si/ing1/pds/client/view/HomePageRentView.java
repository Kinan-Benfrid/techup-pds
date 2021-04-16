package episen.si.ing1.pds.client.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageRentView extends JFrame implements ActionListener {
    private final JButton bouton1;
    private JPanel pan2;


    public HomePageRentView() {

        this.setTitle("Louer des espaces");
        this.setSize(200, 200);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pan2 = new JPanel();
        pan2.setBackground(Color.PINK);
        pan2.setPreferredSize(new Dimension(500,70));
        this.add(pan2, BorderLayout.PAGE_START);

        pan2 = new JPanel();
        pan2.setBackground(Color.PINK);
        pan2.setPreferredSize(new Dimension(500,70));
        this.add(pan2, BorderLayout.PAGE_END);

        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("Bienvenue dans votre espace de réservation !");
        panel.add(label1);

        bouton1 = new JButton("Reserver ");
        bouton1.setBounds(575,400,400,70);
        bouton1.setBackground(Color.black);
        bouton1.setForeground(Color.white);
        this.add(bouton1);

        getContentPane().add(panel);





    }

    public void actionPerformed(ActionEvent e) {
        bouton1.setText("Reserver des espaces");
    }


    public static void main(String[] args) {

        HomePageRentView hprm = new HomePageRentView();
        hprm.setVisible(true);


    }
}



