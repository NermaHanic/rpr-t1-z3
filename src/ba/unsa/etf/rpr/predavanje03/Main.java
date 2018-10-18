package ba.unsa.etf.rpr.predavanje03;
import java.util.Scanner;

public class Main {

    public static class Sat {
        int sati,minute,sekunde;

        public Sat(int sati, int minute, int sekunde) {
            this.SetSati(sati);
            this.SetMinute(minute);
            this.SetSekunde(sekunde);
        }

         void Sati(int sati, int minute, int sekunde){
            this.sati = sati;
            this.minute = minute;
            this.sekunde = sekunde;
        }
        public void SetSati(int sati){this.sati = sati;}
        public void SetMinute(int minute){this.minute = minute;}
        public void SetSekunde(int sekunde){this.sekunde = sekunde;}

        public int GetSati(){return sati;}
        public int GetMinute(){return minute;}
        public int GetSekunde(){return sekunde;}


        void Sljedeci() {
            SetSekunde(GetSekunde()+1);
            if (GetSekunde()==60) { SetSekunde(0); SetMinute(GetMinute()+1); }
            if (GetMinute()==60) { SetMinute(0); SetSati(GetSati()+1); }
            if (GetSati()==24) SetSati(0);
        }
        void Prethodni() {
            SetSekunde(GetSekunde()-1);
            if (GetSekunde()==-1) { SetSekunde(59); SetMinute(GetMinute()-1); }
            if (GetMinute()==-1) { SetMinute(59); SetSati(GetSati()-1); }
            if (GetSati()==-1) SetSati(23);
        }
        void PomjeriZa(int pomak) {
            if (pomak>0) for (int i=0; i<pomak; i++) Sljedeci();
            else for (int i = 0; i<-pomak; i++) Prethodni();
        }

        void Ispisi()  { ispisi(GetSati()+ " : " + GetMinute() + " : " + GetSekunde()); }

        public static void ispisi(String s){
            System.out.println(s);
        }
    };

    public static void main(String[] args) {
        Sat s = new Sat(15, 30, 45);
        s.Ispisi();
        s.Sljedeci();
        s.Ispisi();
        s.PomjeriZa(-48);
        s.Ispisi();
        s.Sati(0, 0, 0);
        s.Ispisi();
    }
}