package episen.si.ing1.pds.client.view.SpaceRental;

import episen.si.ing1.pds.client.socket.RequestSocket;
import episen.si.ing1.pds.client.socket.ResponseSocket;
import episen.si.ing1.pds.client.socket.SocketUtility;
import episen.si.ing1.pds.client.view.CommonFrame;
import episen.si.ing1.pds.client.view.HomePageRentView;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;
import  episen.si.ing1.pds.client.model.*;



public class FirstPageRentCriteria extends CommonFrame {

    private final JPanel pan1;
    private final JPanel pan2;
    private final JPanel pan3;
    private  JRadioButton r1;
    private  JRadioButton r2;
    private  JRadioButton r3;
    private final JButton b1;
    private final JButton b2;
    private final JComboBox jcb;
    private JTextField t1;
    private JTextField t2;
    private final JTextField t4;
    private JLabel j0;
    private final JLabel j1;
    private final JLabel j2;
    private final JLabel j3;
    private final JLabel j4;
    private JLabel j5;
     List<Map> meeting_list,OpenSpace_list,Office_list;



    public SocketUtility socketUtility = new SocketUtility ();
    public FirstPageRentCriteria() {

        setTitle("Louer mes espaces");
        pan2 = new JPanel();
        this.add(pan2);
        pan2.setLayout(null);

        b1 = new JButton("retour");
        b1.setBounds(10, 15, 70, 20);
        pan2.add(b1);
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                HomePageRentView hprm = new HomePageRentView();
                hprm.setVisible(true);
                dispose();
            }
        });


        j1 = new JLabel("ARRIVÉE");
        j1.setBounds(60, 60, 400, 20);
        j2 = new JLabel("DÉPART");
        j2.setBounds(160, 60, 400, 20);
        pan2.add(j1);
        pan2.add(j2);

        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        JFormattedTextField t1 = new JFormattedTextField(df);
        t1.setBounds(60, 80, 70, 20);

        JFormattedTextField t2 = new JFormattedTextField(df);
        t2.setBounds(160, 80, 70, 20);

        t1.setToolTipText("format : dd/MM/yyyy");
        t2.setToolTipText("format : dd/MM/yyyy");

        pan2.add(t1);
        pan2.add(t2);

        j3 = new JLabel("ADULTE");
        j3.setBounds(60, 100, 100, 20);
        pan2.add(j3);

        String[] choice = {"1", "2", "3", "4", "Entre 5 et 10", "Entre 10 et 20", "Entre 20 et 50", "Entre 50 et 70", "Entre 70 et 100", "Entre 100 et 200", "Entre 200 et 300", "Entre 300 et 500", "500 ou +"};

        jcb = new JComboBox(choice);
        jcb.setBounds(60, 120, 100, 20);
        pan2.add(jcb);


        j4 = new JLabel("BUDGET");
        j4.setBounds(60, 140, 100, 20);
        pan2.add(j4);
        t4 = new JTextField();
        t4.setBounds(60, 160, 70, 20);
        pan2.add(t4);


        pan3 = new JPanel();
        pan3.setBorder(new TitledBorder("Quel(s) type(s) d'espace(s) souhaitez-vous louer ?"));
        pan2.add(pan3);
        pan3.setBounds(50, 180, 400, 100);




        RequestSocket rs = new RequestSocket ();
        rs.setRequest ("meeting_list");
        Map<String,Object> m = new HashMap<> ();
        //m.put("person", Person.getPerson_id ());
        rs.setData(m);
        System.out.println("-------");
       ResponseSocket responseSocket = socketUtility.sendRequest (rs);

        meeting_list = (List<Map>) responseSocket.getData ();

        JComboBox jcb1 = new JComboBox();
        int countable = (int) meeting_list.get(0).get("countable");
        for(int i = 0;i <= countable; i++) {
       jcb1.addItem(("salle de réunion x " + i));
        }


        jcb1.setSelectedIndex(-1);
        jcb1.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                // we are in a loop
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                //if (value instanceof Map) {
                  //  Map val = (Map) value;
                  //  setText(val.get("card_id").toString());
               // }
                // before we click, setting a title to the JCOMBOBox
                if (index == -1 && value == null)
                    setText(" salle de réunion ");

                return this;
            }
        });


//---------------------------------

        RequestSocket rs2 = new RequestSocket ();
        rs2.setRequest ("OpenSpace_list");
        Map<String,Object> m2 = new HashMap<> ();
        //m.put("person", Person.getPerson_id ());
        rs2.setData(m2);
        System.out.println("-------");
        ResponseSocket responseSocket2 = socketUtility.sendRequest (rs2);

        OpenSpace_list = (List<Map>) responseSocket2.getData ();


        JComboBox jcb2 = new JComboBox();
       int countable2 = (int) OpenSpace_list.get(0).get("countable2");
        for(int i = 0;i <= countable2; i++) {
            jcb2.addItem(("Open space x " + i));
        }


        jcb2.setSelectedIndex(-1);
        jcb2.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                // we are in a loop
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                //if (value instanceof Map) {
                //  Map val = (Map) value;
                //  setText(val.get("card_id").toString());
                // }
                // before we click, setting a title to the JCOMBOBox
                if (index == -1 && value == null)
                    setText("Open space");

                return this;
            }
        });


//---------------------------------


        RequestSocket rs3 = new RequestSocket ();
        rs3.setRequest ("Office_list");
        Map<String,Object> m3 = new HashMap<> ();
        //m.put("person", Person.getPerson_id ());
        rs3.setData(m3);
        System.out.println("-------");
        ResponseSocket responseSocket3 = socketUtility.sendRequest (rs3);


        Office_list = (List<Map>) responseSocket3.getData ();


        JComboBox jcb3 = new JComboBox();
       int countable3 = (int) Office_list.get(0).get("countable3");
              for(int i = 0;i <= countable3; i++) {
              jcb3.addItem(("Bureau individuel x " + i));
            }


        jcb3.setSelectedIndex(-1);
        jcb3.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                // we are in a loop
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                //if (value instanceof Map) {
                //  Map val = (Map) value;
                //  setText(val.get("card_id").toString());
                // }
                // before we click, setting a title to the JCOMBOBox
                if (index == -1 && value == null)
                    setText("Bureau individuel ");

                return this;
            }
        });





        pan3.add(jcb1);
      pan3.add(jcb2);
       pan3.add(jcb3);




        pan1 = new JPanel();
        JLabel j0 = new JLabel("Bienvenue dans votre espace de location !");

        pan1.add(j0);
        pan2.add(pan1);
        pan1.setBounds(600, 15, 500, 20);


        b2 = new JButton("Suivant");
        b2.setBounds(380, 300, 100, 20);


        b2.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (r1.isSelected()) {


                    dispose();
                  FirstPageSelectionOffers fpso = new FirstPageSelectionOffers();
                  fpso.setVisible(true);

                } else {
                    System.out.println("la case n'est pas cochée");
                }
            }

        });


        pan2.add(b2);
    }


    /*
        r1.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {

                Object obj = e.getItem();
                //String selection = (String)obj;

                if (obj == r1) {
                  //  Map item = (Map) e.getItem();
                    //int cardId = (Integer) item.get("card_id");


                    request = new RequestSocket();
                    request.setRequest("meeting_room");
                    Map<String, Object> hm = new HashMap<>();
                    request.setData(hm);
                    System.out.println("Requete :" + request.getRequest());
                    System.out.println("Data :" + request.getData());


                    ResponseSocket response = socketUtility.sendRequest(request);
                    // data is the list of map we sent in the server (look response)
                    java.util.List<Map> meeting_list = (List<Map>) response.getData();
                    System.out.println("name" + meeting_list);


                    System.out.println(response);
                    System.out.println(response.getData());
                    validate();
                }
            }
        });


 */


/*
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == r1) {
            this.dispose();
            FirstPageRentCriteria fprc = new FirstPageRentCriteria();
            fprc.setVisible(true);
        }
        if (source == r2) {
            this.dispose();
            RentedSpacesView r = new RentedSpacesView();
            r.setVisible(true);
        }

    }


 */

    public static void main(String[] args) {
        FirstPageRentCriteria fprc = new FirstPageRentCriteria();
        fprc.setVisible(true);

    }
}



