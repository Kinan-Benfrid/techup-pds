package episen.si.ing1.pds.client.view.WindowConfig;
import episen.si.ing1.pds.client.model.*;
import episen.si.ing1.pds.client.socket.RequestSocket;
import episen.si.ing1.pds.client.socket.ResponseSocket;
import episen.si.ing1.pds.client.socket.SocketUtility;
import episen.si.ing1.pds.client.view.CommonFrame;
import episen.si.ing1.pds.client.view.Mapping.RentedSpacesView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public class blindConfig extends CommonFrame implements ActionListener {
    //declaration of variable
    private JButton bconfiguration, bvalider, bsuivant , bretour;
    private final SocketUtility socketUtility = new SocketUtility();
    private static final long serialVersionUID = 1L;
    private JPanel panel;
    private JTextField debutstore,valeuraugmente, pourcentagestore,valeuraugmentestorepourcentage;
    private JLabel  labeldebutstore,labelsituationstore,labelpourcentagestore, labeluniteaugmentestorepourcentage,
            labelaugmentestorepourcentage,labelaugmente,labeldebutstoreecoute,labeluniteaugmente,pourcentagestoreunite;


    public blindConfig() {
        panel = new JPanel();
        this.add(panel);
        panel.setLayout(null);

//label textfiel for insde brightness

        labelsituationstore = new JLabel("Fermeture des volets");
        labelsituationstore.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelsituationstore.setBounds(258, 100, 700, 29);
        labelsituationstore.setFont(labelsituationstore.getFont().deriveFont(20.0f));
        labelsituationstore.setForeground(new Color(155,0,0));
        panel.add(labelsituationstore);

        labeldebutstore = new JLabel("Valeur de la temperature exterieure a partir de laquelle le store commence a se fermer (entier)");
        labeldebutstore.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labeldebutstore.setBounds(58, 150, 770, 29);
        panel.add(labeldebutstore);

        debutstore = new JTextField();
        debutstore.setFont(new Font("Tahoma", Font.PLAIN, 32));
        debutstore.setBounds(800, 150, 70, 40);
        panel.add(debutstore);
        debutstore.setColumns(10);

        labeldebutstoreecoute = new JLabel("degre");
        labeldebutstoreecoute.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labeldebutstoreecoute.setBounds(880, 150, 210, 29);
        panel.add(labeldebutstoreecoute);

        labelpourcentagestore = new JLabel("A combien de pourcent le store doit se fermer (entre 0 et 100)");
        labelpourcentagestore.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelpourcentagestore.setBounds(58, 200, 600, 29);
        panel.add(labelpourcentagestore);

        pourcentagestore= new JTextField();
        pourcentagestore.setFont(new Font("Tahoma", Font.PLAIN, 32));
        pourcentagestore.setBounds(620, 200, 70, 40);
        panel.add(pourcentagestore);
        pourcentagestore.setColumns(10);

        pourcentagestoreunite = new JLabel("%");
        pourcentagestoreunite.setFont(new Font("Tahoma", Font.PLAIN, 17));
        pourcentagestoreunite.setBounds(700, 200, 210, 29);
        panel.add(pourcentagestoreunite);

        labelaugmente= new JLabel("Si la valeur de cette temperature augmenter de... (positif)");
        labelaugmente.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelaugmente.setBounds(58, 250, 600, 29);
        panel.add(labelaugmente);

        valeuraugmente = new JTextField();
        valeuraugmente.setFont(new Font("Tahoma", Font.PLAIN, 32));
        valeuraugmente.setBounds(620, 250, 70, 40);
        panel.add(valeuraugmente);
        valeuraugmente.setColumns(10);

        labeluniteaugmente= new JLabel("degre");
        labeluniteaugmente.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labeluniteaugmente.setBounds(700, 250, 210, 29);
        panel.add(labeluniteaugmente);


        labelaugmentestorepourcentage= new JLabel("Le pourcentage de la store doit aussi augmenter de combien  (entre 0 et 20)");
        labelaugmentestorepourcentage.setFont(new Font("Tahoma", Font.PLAIN, 18));
        labelaugmentestorepourcentage.setBounds(58, 300, 700, 29);
        panel.add(labelaugmentestorepourcentage);

        valeuraugmentestorepourcentage = new JTextField();
        valeuraugmentestorepourcentage.setFont(new Font("Tahoma", Font.PLAIN, 32));
        valeuraugmentestorepourcentage.setBounds(700, 300, 70, 40);
        panel.add(valeuraugmentestorepourcentage);
        valeuraugmentestorepourcentage.setColumns(10);

        labeluniteaugmentestorepourcentage= new JLabel("%");
        labeluniteaugmentestorepourcentage.setFont(new Font("Tahoma", Font.PLAIN, 17));
        labeluniteaugmentestorepourcentage.setBounds(770, 300, 210, 29);
        panel.add( labeluniteaugmentestorepourcentage);



        bconfiguration = new JButton("CONFIGURATION DES STORES");
        bconfiguration.setBounds(250,20,650,50);
        bconfiguration.setBackground(new Color(111,173,143));
        bconfiguration.setFont(bconfiguration.getFont().deriveFont(15.0f));
        panel.add(bconfiguration);

//declaration of button
        bvalider = new JButton("Valider");
        bvalider.setBounds(800,380,92,25);
        panel.add(bvalider);
        bvalider.addActionListener(this);

        bsuivant = new JButton("suivant");
        bsuivant .setBounds(800,450,92,25);
        panel.add(bsuivant );
        bsuivant .addActionListener(this);

        bretour = new JButton("Retour");
        bretour.setBounds(10,20,110,25);
        panel.add(bretour);
        bretour.addActionListener(this);

    }
    public void actionPerformed(ActionEvent eb) {
        Object source = eb.getSource();
        if(source == bsuivant ){
            this.dispose();
            BrightnessWindowConfig tc = new BrightnessWindowConfig();
            tc.setVisible(true);
        }
        if(source == bretour){
            this.dispose();
            ListOfWindow lw = new ListOfWindow();
            lw.setVisible(true);
        }
        if(source == bvalider){

            String vd = debutstore.getText();
            String pd = pourcentagestore.getText();

            String va = valeuraugmente.getText();
            String pa = valeuraugmentestorepourcentage.getText();

            int vd_pars,pd_pars,va_pars,pa_pars ;

            if(!isInteger(vd) ||!isInteger(pd)||!isInteger(va) ||!isInteger(pa) ){
                JOptionPane.showMessageDialog(debutstore,"Saisir un entier !", "ERREUR", JOptionPane.ERROR_MESSAGE);

                            }
            else {
                vd_pars = Integer.parseInt(vd);
                if (vd_pars > 40 || vd_pars < -20) {
                    JOptionPane.showMessageDialog(debutstore, "La Valeur de debut de la temperature doit etre comprise entre -20 et 40 degre", "ERREUR", JOptionPane.ERROR_MESSAGE);
                }

                pd_pars = Integer.parseInt(pd);
                if (pd_pars > 100 || pd_pars < 0) {
                    JOptionPane.showMessageDialog(pourcentagestore, "La pourcentage de debut doit etre comprise entre 0 et 100 %", "ERREUR", JOptionPane.ERROR_MESSAGE);
                }

                va_pars = Integer.parseInt(va);
                if (va_pars > 10 || va_pars < 0) {
                    JOptionPane.showMessageDialog(valeuraugmente, "L'augmentation de la valeur doit etre comprise entre 0 et 15 degre", "ERREUR", JOptionPane.ERROR_MESSAGE);
                }

                pa_pars = Integer.parseInt(pa);
                if (pa_pars > 15 || pa_pars < 0) {
                    JOptionPane.showMessageDialog(valeuraugmentestorepourcentage, "L'augmentation du pourcentage doit etre comprise entre 0 et 20 %", "ERREUR", JOptionPane.ERROR_MESSAGE);
                }

                if ((vd_pars <= 40 && vd_pars >= -20) && (pd_pars <= 100 && pd_pars >= 0) && (va_pars <= 15 && vd_pars >= 0) && (pa_pars <= 20 && pd_pars >= 0)) {
                    RequestSocket request = new RequestSocket();
                    request.setRequest("temperature");
                    Map<String, Object> data = new HashMap<>();
                    data.put("valeurtemp_debut", vd_pars);
                    data.put("pourcentagetemp_debut", pd_pars);
                    data.put("valeurtemp_avance", va_pars);
                    data.put("pourcentagetemp_avance", pa_pars);

                    System.out.println(data);
                    request.setData(data);
                    System.out.println(data);

                    JOptionPane.showMessageDialog(debutstore, "configuration prise en compte", "INFORMATION", JOptionPane.INFORMATION_MESSAGE);


                    ResponseSocket response2 = socketUtility.sendRequest(request);
                }
            }
            }
    }

    public static boolean isInteger(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static void main (String[]args){
        blindConfig bc = new blindConfig();
        bc.setVisible(true);
    }



}
