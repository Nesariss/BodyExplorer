import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Główny obszar graficzny gry
 * Klasa dziedzicząca po klasie JPanel
 */

public class Wyzwanie extends JPanel implements ActionListener {
    /** srednica */
   public static int dim = 50;
    /** polozenie */
    int x = 75, y = 75;
     /** kierunek ruchu */
    int dx = 3;
     /** opoznienie odswiezania panelu */
    int delay = 40;

    JButton menu;
    static Frame f;
    /** Tablica obrazków*/
    public static Image[] obrazki;
    /** szerokosc obrazku w pikselach*/
    private int width;
    /** wysokosc obrazku w pikselach*/
    private int height;
    /** Zmienna pomocnicza określająca początkowy czas gry */
    private long czasPocz;
    /** Bieżący czas  */
    private long czas2;
    /** limit czasu w milisekundach zależny od poziomu trudności */
    private long limit_czasu;
    /** Liczba zgromadzonych punktów */
    public static int punkty=0;
    /** Liczba zgromadzonych karnych punktów za trafienie w błędny obiekt */
    public static int karne_punkty=0;
    /** tablica z losowo wygenerowanymi liczbami z przedziału 0-6 */
    public static int [] kolejnosc;


    Wyzwanie(){
        //stworzenie obiektu klasu Dzwieki
        Dzwieki dzwiek= new Dzwieki();

        wygladokna();
        trudnosc();

        /* Jeśli zaznaczono checkbox miesnie załaduj do tablicy obrazy mięśni */
        if(Menu.miesnie==true) {
            obrazki = new Image[7];
            obrazki[0] = loadImage("images/m1.png");
            obrazki[1] = loadImage("images/m2.png");
            obrazki[2] = loadImage("images/m3.png");
            obrazki[3] = loadImage("images/m4.png");
            obrazki[4] = loadImage("images/m5.png");
            obrazki[5] = loadImage("images/m6.png");
            obrazki[6] = loadImage("images/m7.png");

        }
        /* Jeśli zaznaczono checkbox narzady załaduj do tablicy obrazy narządów */
        if(Menu.narzady==true){
            obrazki = new Image[7];
            obrazki[0] = loadImage("images/n1.png");
            obrazki[1] = loadImage("images/n2.png");
            obrazki[2] = loadImage("images/n3.png");
            obrazki[3] = loadImage("images/n4.png");
            obrazki[4] = loadImage("images/n5.png");
            obrazki[5] = loadImage("images/n6.png");
            obrazki[6] = loadImage("images/n7.png");

        }

        // wywołanie funkcji losującej kolejność pojawiających się dźwięków
        losowanie();

        // pobranie wysokości i szerokości drugiego obrazka (każdy obrazek ma zbliżony rozmiar)
        width=obrazki[1].getWidth(null);
        height=obrazki[1].getHeight(null);

        czasPocz=System.currentTimeMillis();

        Dzwieki.playSound();
        /* Dodaj obsługę zdarzeń - wciśnięcie przycisku myszki*/
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent me){
                    //sprawdź czy trafiono w pierwszy wypowiedziany obiekt
                    if(x+width>=me.getX() && x<me.getX()+width/3) {

                        if (y+height>=me.getY() && y<me.getY()+height/2)
                        {
                            karne_punkty++;
                            //jeśli trafiono usuń obrazek
                            if (Dzwieki.flagi[0] == true) {
                                obrazki[0] = null;
                                karne_punkty--;
                                Dzwieki.playSound();
                            }

                        }
                    }
                //sprawdź czy trafiono w drugi wypowiedziany obiekt
                if(x+280+width>=me.getX() && x+280<me.getX()+width/3){
                    if (y+height>=me.getY() && y<me.getY()+height/2) {
                        karne_punkty++;
                        //jeśli trafiono usuń obrazek
                        if (Dzwieki.flagi[1] == true) {
                            obrazki[1] = null;
                            karne_punkty--;
                            Dzwieki.playSound();
                        }

                    }
                }
                //sprawdź czy trafiono w trzeci wypowiedziany obiekt
                if(x+530+width>=me.getX() && x+530<me.getX()+width/3){
                    if (y+height>=me.getY() && y<me.getY()+height/2) {
                        karne_punkty++;
                        //jeśli trafiono usuń obrazek
                        if (Dzwieki.flagi[2] == true){
                            obrazki[2] = null;
                            karne_punkty--;
                            Dzwieki.playSound();
                        }

                    }
                }

                //sprawdź czy trafiono w czwarty wypowiedziany obiekt
                if(x+width>=me.getX() && x<me.getX()+width/3){
                    if (y+height+200>=me.getY() && y+200<me.getY()+height/2) {
                        karne_punkty++;
                        //jeśli trafiono usuń obrazek
                        if (Dzwieki.flagi[3] == true) {
                            obrazki[3] = null;
                            karne_punkty--;
                            Dzwieki.playSound();
                        }

                    }
                }
                //sprawdź czy trafiono w piąty wypowiedziany obiekt
                if(x+280+width>=me.getX() && x+280<me.getX()+width/3){
                    if (y+height+200>=me.getY() && y+200<me.getY()+height/2) {
                        karne_punkty++;
                        //jeśli trafiono usuń obrazek
                        if (Dzwieki.flagi[4] == true) {
                            obrazki[4] = null;
                            karne_punkty--;
                            Dzwieki.playSound();
                        }

                    }
                }
                //sprawdź czy trafiono w szósty wypowiedziany obiekt
                if(x+530+width>=me.getX() && x+530<me.getX()+width/3){
                    if (y+height+200>=me.getY() && y+200<me.getY()+height/2) {
                        karne_punkty++;
                        //jeśli trafiono usuń obrazek
                        if (Dzwieki.flagi[5] == true) {
                            obrazki[5] = null;
                            karne_punkty--;
                            Dzwieki.playSound();
                        }

                    }
                }
                //sprawdź czy trafiono w siódmy wypowiedziany obiekt
                if(x+width>=me.getX() && x<me.getX()+width/3){
                    if (y+height+400>=me.getY() && y+400<me.getY()+height/2) {
                        karne_punkty++;
                        //jeśli trafiono usuń obrazek
                        if (Dzwieki.flagi[6] == true) {
                            obrazki[6] = null;
                            karne_punkty--;
                            Dzwieki.playSound();
                        }

                    }
                }

            }


        });

        }

    /**
     * Nadpisz metodę odpowiedzialną za odrysowanie panelu - własne wypełnienie
     * pola graficznego gry, zgodnie z wybraną treścią.
     * @param g
     */
    public void paint(Graphics g){

        super.paint(g);
        Graphics2D graph = (Graphics2D)g;
            //Ustaw tryb lepszej jakości grafiki (wygładzanie/antyaliasing)
        graph.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Ustaw kolor domyślny
        graph.setColor(Color.red);
        //Ustaw czcionki
        graph.setFont(new Font("Calibri", Font.BOLD, 72));
        //Do bieżącego czasu dodaj 0,5s za każde błędne trafienie w obiekt
        czas2= System.currentTimeMillis()+karne_punkty*500;
        //funkcja napisana osobno z powodu błędu powodowanego przez Thread.sleep
        if((czas2-czasPocz)>limit_czasu-300)
        graph.drawString("KONIEC CZASU", 330,250);
        // jeśli czas gry będzie  większy niż limit czasu ustaw pause z wyświetlonym w powyższej funkcji napisem "Koniec czasu"
        if((czas2-czasPocz)>limit_czasu){

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            powrotDoMenu();

        }
            // narysowanie na panelu danych dotyczących czasu i zdobytych punktów
        graph.setFont(new Font("Calibri", Font.BOLD, 24));
        graph.drawString(String.valueOf((czas2-czasPocz)/1000.0),200, 650);
        graph.drawString("Czas[s]:",110, 650);
        graph.drawString("Zdobyte punkty:",270, 650);
        graph.drawString(String.valueOf(punkty-karne_punkty ),480,650);

        // narysowanie całej puli obrazków
            graph.drawImage(obrazki[0], x, y, null);
            graph.drawImage(obrazki[1], x + 280, y, null);
            graph.drawImage(obrazki[2], x + 530, y, null);
            graph.drawImage(obrazki[3], x, y + 200, null);
            graph.drawImage(obrazki[4], x + 280, y + 200, null);
            graph.drawImage(obrazki[5], x + 530, y + 200, null);
            graph.drawImage(obrazki[6], x, y + 400, null);

         // odbicie obrazków
        if((x+633) + dim > getWidth() || x < 0)
            dx = -dx;
         // przesunięcie obrazków na płaszczyźnie x
        x += dx;

        punkty=0;
        // Zliczenie ilości punktów
        for(int i=0; i<7;i++)
        {
            if(obrazki[i]==null){
                punkty++;
            }

        // Jeśli wszystkie obrazki zostaną trafione wyświetl napis o wygranej
            if(punkty==7){
                graph.setFont(new Font("Calibri", Font.BOLD, 72));
                graph.drawString("WYGRANA!",330, 370);

            }
        }
        repaint();




        // opoznienie odswiezania panelu
        try{
            Thread.sleep(delay);
        }
        catch(InterruptedException e){
        }


    }


    /**
     * Metoda pobierania obiektu klasy Image na podstawie ścieżki
     * dostepu podanej jako String
     */
    public static Image loadImage(String fileName) {
        return new ImageIcon(fileName).getImage();
    }

    /**
     Wstawienie rozmieszczenia poszczególnych elementów oraz wyglądu graficznego
     */
    public void wygladokna(){
        JLabel background;
        setSize(924,764);

        setLayout(null);
        ImageIcon img= new ImageIcon("images/tloo.jpg");
        menu = new JButton("Menu");
        menu.setBounds(570, 630, 150, 61);

        menu.addActionListener(this);
        background= new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,1544,766);
        add(background);
        background.add(menu);
        setVisible(true);

    }

    /**
     Funkcja pomocnicza do losowania dźwięków z klasy Dzwieki
     */
    public void losowanie(){
        int [] kolejnosc_tymczasowa;
        kolejnosc_tymczasowa=new int[7];
        kolejnosc_tymczasowa[0]=0;
        kolejnosc_tymczasowa[1]=1;
        kolejnosc_tymczasowa[2]=2;
        kolejnosc_tymczasowa[3]=3;
        kolejnosc_tymczasowa[4]=4;
        kolejnosc_tymczasowa[5]=5;
        kolejnosc_tymczasowa[6]=6;

        Random rand = new Random();

        for (int i = 0; i < kolejnosc_tymczasowa.length; i++) {
            int randomIndexToSwap = rand.nextInt(kolejnosc_tymczasowa.length);
            int temp = kolejnosc_tymczasowa[randomIndexToSwap];
            kolejnosc_tymczasowa[randomIndexToSwap] = kolejnosc_tymczasowa[i];
            kolejnosc_tymczasowa[i] = temp;

        }

        kolejnosc=new int[8];
        kolejnosc[0]= kolejnosc_tymczasowa[0];
        kolejnosc[1] =kolejnosc_tymczasowa[1];
        kolejnosc[2]=kolejnosc_tymczasowa[2];
        kolejnosc[3]=kolejnosc_tymczasowa[3];
        kolejnosc[4]=kolejnosc_tymczasowa[4];
        kolejnosc[5]=kolejnosc_tymczasowa[5];
        kolejnosc[6]=kolejnosc_tymczasowa[6];
        kolejnosc[7]=2137;
    }

    /**
     Funkcja ustawiająca parametry gry w zależności od poziomu trudności
     */
    public void trudnosc(){
        if(Menu.poziom==1){
            dx=3;
            limit_czasu=22000;
        }

       else if(Menu.poziom==2){
            dx=6;
            limit_czasu=19000;
        }
        else if(Menu.poziom==3){
            dx=11;
            limit_czasu=15000;
        }

    }
    /**
     Funkcja umożliwiająca powrót do menu z okna gry
     */
    public  void powrotDoMenu(){


        new Menu();
        f.dispose();
        obrazki=null;
        Nauka.obrazki=null;
        Dzwieki.flagi=null;
        Menu.miesnie=false;
        Menu.narzady=false;
        Menu.nauka=false;
        Menu.wyzwanie=false;
        kolejnosc=null;
        punkty=0;
        karne_punkty=0;
    }

    /**
     * Nadpisz metodę odpowiedzialną za obsługę zdarzeń
     */
    @Override
    public void actionPerformed (ActionEvent e) {
        Object zrodlo = e.getSource();
        // jeśli wcisnieto przycisk menu następuje powrót do menu
        if (zrodlo == menu) {
            powrotDoMenu();

        }

    }

}
