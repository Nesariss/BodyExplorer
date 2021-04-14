
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Klasa odpowiedzialna za wyświetlenie menu oraz zarządzanie nim
 *
 */


public class Menu extends JFrame implements ActionListener{
    JButton przycisk, przycisk2, przycisk3;
    JCheckBox wybor,wybor2;
    JCheckBox poziom1,poziom2,poziom3;
    JLabel background;
    JFrame f1;

    /** Zmienna odpowiedzialna za poziom trudności (domyślnie poziom łatwy) */
    public static int poziom=1;
    /** Czy wybrano checkbox miesnie */
    public static boolean miesnie=false;
    /** Czy wybrano checkbox narzady */
    public static boolean narzady=false;
    /** Czy wcisnieto przycisk nauka */
    public static boolean nauka=false;
    /** Czy wcisnieto przycisk wyzwanie */
    public static boolean wyzwanie=false;

    //public static JFrame frame = new JFrame("Animacja");
    /**
     * Konstruktor - ustawienie rozmieszczenia poszczególnych elementów oraz wyglądu graficznego menu
     *  Do elementów typu JButton,JCheckbox dodane są ActionListenery
     */

    public Menu( ) {
        f1=new JFrame("Menu Główne");
        f1.setSize(924,764);
        f1.setLayout(null);
        f1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ImageIcon img= new ImageIcon("images/background.png");
        background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1544,766);
        f1.add(background);
        f1.setVisible(true);
        background.setVisible(true);

         przycisk = new JButton(new ImageIcon ("images/przycisk.png"));
         przycisk2 = new JButton(new ImageIcon ("images/przycisk2.png"));
         przycisk3 = new JButton(new ImageIcon ("images/przycisk3.png"));
         wybor=new JCheckBox("Mięśnie");
         wybor2=new JCheckBox("Narządy");

        poziom1= new JCheckBox("Latwy");
        poziom2= new JCheckBox("Średni");
        poziom3= new JCheckBox("Trudny");

        // tylko jeden checkbox  moze byc wcisniety w danym momencie
       ButtonGroup group = new ButtonGroup();
        group.add(poziom1);
        group.add(poziom2);
        group.add(poziom3);

        ButtonGroup group2 = new ButtonGroup();
        group2.add(wybor);
        group2.add(wybor2);


        poziom1.setOpaque(false);
        poziom1.setContentAreaFilled(false);
        poziom2.setOpaque(false);
        poziom2.setContentAreaFilled(false);
        poziom3.setOpaque(false);
        poziom3.setContentAreaFilled(false);
        wybor.setOpaque(false);
        wybor.setContentAreaFilled(false);
        wybor2.setOpaque(false);
        wybor2.setContentAreaFilled(false);
        Font myFont= new Font("Calibri",Font.BOLD,26 );
        wybor.setFont(myFont);
        wybor2.setFont(myFont);
        poziom1.setFont(myFont);
        poziom2.setFont(myFont);
        poziom3.setFont(myFont);
        wybor.setForeground(Color.YELLOW);
        wybor2.setForeground(Color.YELLOW);
        poziom1.setForeground(Color.GREEN);
        poziom2.setForeground(Color.BLUE);
        poziom3.setForeground(Color.RED);

        przycisk.setBounds(300, 150, 250, 61);
        przycisk2.setBounds(300, 300, 250, 61);
        przycisk3.setBounds(300, 450, 250, 61);
        wybor.setBounds(600,433,140,30);
        wybor2.setBounds(600,393,140,30);
        poziom1.setBounds(740,373,140,30);
        poziom2.setBounds(740,406,140,30);
        poziom3.setBounds(740,436,140,30);
        background.add(przycisk);
        background.add(przycisk2);
        background.add(przycisk3);
        background.add(wybor);
        background.add(wybor2);
        background.add(poziom1);
        background.add(poziom2);
        background.add(poziom3);

        poziom1.addActionListener(this);
        poziom2.addActionListener(this);
        poziom3.addActionListener(this);
        przycisk.addActionListener(this);
        przycisk2.addActionListener(this);
        przycisk3.addActionListener(this);
        wybor.addActionListener(this);
        wybor2.addActionListener(this);

    }


    /**
     * Nadpisz metodę odpowiedzialną za obsługę zdarzeń
     */

    @Override
    public void actionPerformed (ActionEvent e){
        Object zrodlo = e.getSource();
            //przycisk nauka
        if (zrodlo == przycisk) {
            nauka=true;
            // po wcisnieciu przycisku nauka następuje otwarcie okna z nauką gry
            if(miesnie==true || narzady==true) {
                Nauka panelgraficzny=new Nauka();
                Nauka.f= new Frame();
                Nauka.f.setSize(977,761);
                Nauka.f.add(panelgraficzny);
                Nauka.f.setVisible(true);
                f1.dispose();


            }

        }
            // przycisk wyzwanie
      else  if (zrodlo == przycisk2) {

            wyzwanie=true;
            // po wcisnieciu przycisku wyzwanie następuje otwarcie okna z grą
            if(miesnie==true || narzady==true) {

                Wyzwanie panelgraficzny=new Wyzwanie();
                Wyzwanie.f= new Frame();
                Wyzwanie.f.setSize(977,761);
                 Wyzwanie.f.add(panelgraficzny);
                Wyzwanie.f.setVisible(true);
                f1.dispose();


            }
        }
      //przycisk zakoncz
        else if (zrodlo == przycisk3) {
            // wyłącznie gry
            System.exit(0);
        }

        //checkbox miesnie
        else if(zrodlo==wybor){
            if(wybor.isSelected()==true){

                miesnie=true;
                narzady=false;
            }

        }
        //checkbox narzady
        else if(zrodlo==wybor2){
            if(wybor2.isSelected()==true){
                narzady=true;
                miesnie=false;
            }

        }

        // jesli wybrany zostanie poziom łatwy
        else if(zrodlo==poziom1){
            if(poziom1.isSelected()==true){
                poziom=1;

            }

        }
        // jesli wybrany zostanie poziom średni
        else if(zrodlo==poziom2){
            if(poziom2.isSelected()==true){
                poziom=2;

            }


        }
      // jesli wybrany zostanie poziom trudny
        else if(zrodlo==poziom3){
            if(poziom3.isSelected()==true){
                poziom=3;

            }


        }



    }
}
