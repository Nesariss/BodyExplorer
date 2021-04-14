import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Dzwieki {
    /**
     * Klasa odpowiedzialna za wszystkie dźwięki w programie
     */

    /** Zmienna pomocnicza inkrementowana o 1 przy każdym wywołaniu metody playSound*/
    public static int c=0;
    /** Tablica zmiennych boolowskich, określa czy dany dźwięk został już zagrany */
    public static boolean[] flagi;


    Dzwieki(){
    }

    /**
     * Metoda, w której wszystkie dźwięki zostają załadowane. W zależności od wylosowanych wartości w
     * funkcji losowanie() z taką samą  kolejnością  grane są dźwięki, flagi zmieniają wartość
     * na true o odpowiadających indeksach (przykładowo: kolejnosc[0]=3, wtedy wywoływany jest dźwięk narządu n4 lub m4
     * oraz flaga[3] przyjmuje wartość true.
     */
    public static void playSound(){
        {
            flagi= new boolean[10];
            try {
                InputStream im = new FileInputStream("sounds/m1.wav");
                InputStream im2 = new FileInputStream("sounds/m2.wav");
                InputStream im3 = new FileInputStream("sounds/m3.wav");
                InputStream im4 = new FileInputStream("sounds/m4.wav");
                InputStream im5 = new FileInputStream("sounds/m5.wav");
                InputStream im6 = new FileInputStream("sounds/m6.wav");
                InputStream im7 = new FileInputStream("sounds/m7.wav");

                InputStream in = new FileInputStream("sounds/n1.wav");
                InputStream in2 = new FileInputStream("sounds/n2.wav");
                InputStream in3 = new FileInputStream("sounds/n3.wav");
                InputStream in4 = new FileInputStream("sounds/n4.wav");
                InputStream in5 = new FileInputStream("sounds/n5.wav");
                InputStream in6 = new FileInputStream("sounds/n6.wav");
                InputStream in7 = new FileInputStream("sounds/n7.wav");

                AudioStream m1 = new AudioStream(im);
                AudioStream m2 = new AudioStream(im2);
                AudioStream m3 = new AudioStream(im3);
                AudioStream m4 = new AudioStream(im4);
                AudioStream m5 = new AudioStream(im5);
                AudioStream m6 = new AudioStream(im6);
                AudioStream m7 = new AudioStream(im7);

                AudioStream n1 = new AudioStream(in);
                AudioStream n2 = new AudioStream(in2);
                AudioStream n3 = new AudioStream(in3);
                AudioStream n4 = new AudioStream(in4);
                AudioStream n5 = new AudioStream(in5);
                AudioStream n6 = new AudioStream(in6);
                AudioStream n7 = new AudioStream(in7);





                if (Menu.narzady == true) {


                    if (Menu.wyzwanie == true) {

                        if (Wyzwanie.kolejnosc[c] == 0) {
                            AudioPlayer.player.start(n1);
                            flagi[0] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 1) {
                            AudioPlayer.player.start(n2);
                            flagi[1] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 2) {
                            AudioPlayer.player.start(n3);
                            flagi[2] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 3) {
                            AudioPlayer.player.start(n4);
                            flagi[3] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 4) {
                            AudioPlayer.player.start(n5);
                            flagi[4] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 5) {
                            AudioPlayer.player.start(n6);
                            flagi[5] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 6) {
                            AudioPlayer.player.start(n7);
                            flagi[6] = true;
                        }

                    }


                    if (Menu.nauka == true) {
                        if (Nauka.kolejnosc[c] == 0) {
                            AudioPlayer.player.start(n1);
                            flagi[0] = true;
                        }
                        if (Nauka.kolejnosc[c] == 1) {
                            AudioPlayer.player.start(n2);
                            flagi[1] = true;
                        }
                        if (Nauka.kolejnosc[c] == 2) {
                            AudioPlayer.player.start(n3);
                            flagi[2] = true;
                        }
                        if (Nauka.kolejnosc[c] == 3) {
                            AudioPlayer.player.start(n4);
                            flagi[3] = true;
                        }
                        if (Nauka.kolejnosc[c] == 4) {
                            AudioPlayer.player.start(n5);
                            flagi[4] = true;
                        }
                        if (Nauka.kolejnosc[c] == 5) {
                            AudioPlayer.player.start(n6);
                            flagi[5] = true;
                        }
                        if (Nauka.kolejnosc[c] == 6) {
                            AudioPlayer.player.start(n7);
                            flagi[6] = true;
                        }
                    }

                }


                if (Menu.miesnie == true) {

                    if (Menu.wyzwanie == true)  {

                        if (Wyzwanie.kolejnosc[c] == 0) {
                            AudioPlayer.player.start(m1);
                            flagi[0] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 1) {
                            AudioPlayer.player.start(m2);
                            flagi[1] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 2) {
                            AudioPlayer.player.start(m3);
                            flagi[2] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 3) {
                            AudioPlayer.player.start(m4);
                            flagi[3] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 4) {
                            AudioPlayer.player.start(m5);
                            flagi[4] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 5) {
                            AudioPlayer.player.start(m6);
                            flagi[5] = true;
                        }
                        if (Wyzwanie.kolejnosc[c] == 6) {
                            AudioPlayer.player.start(m7);
                            flagi[6] = true;
                        }

                    }


                    if (Menu.nauka == true) {
                        if (Nauka.kolejnosc[c] == 0) {
                            AudioPlayer.player.start(m1);
                            flagi[0] = true;
                        }
                        if (Nauka.kolejnosc[c] == 1) {
                            AudioPlayer.player.start(m2);
                            flagi[1] = true;
                        }
                        if (Nauka.kolejnosc[c] == 2) {
                            AudioPlayer.player.start(m3);
                            flagi[2] = true;
                        }
                        if (Nauka.kolejnosc[c] == 3) {
                            AudioPlayer.player.start(m4);
                            flagi[3] = true;
                        }
                        if (Nauka.kolejnosc[c] == 4) {
                            AudioPlayer.player.start(m5);
                            flagi[4] = true;
                        }
                        if (Nauka.kolejnosc[c] == 5) {
                            AudioPlayer.player.start(m6);
                            flagi[5] = true;
                        }
                        if (Nauka.kolejnosc[c] == 6) {
                            AudioPlayer.player.start(m7);
                            flagi[6] = true;
                        }
                    }



                }

                if(c==7)
                    c=-1;
                c++;

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }






        }

    }

