package ex2;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class MainApp {
    public static void main(String[] args) throws IOException {
        class Produs{
            private String Denumire;
            private float Pret;
            private int Cant;
            private LocalDate DataExp;

            private static float Profit;

            public static float getProfit() {
                return Profit;
            }

            public static void setProfit(float profit) {
                Profit = profit;
            }

            Produs(String d, float p, int c, LocalDate de){
                Denumire=d;
                Pret=p;
                Cant=c;
                DataExp=de;
            }

            @Override
            public String toString() {
                return "Produs{" +
                        "Denumire='" + Denumire + '\'' +
                        ", Pret=" + Pret +
                        ", Cant=" + Cant +
                        ", DataExp=" + DataExp +
                        '}';
            }

            public String getDenumire() {
                return Denumire;
            }

            public void setDenumire(String denumire) {
                Denumire = denumire;
            }

            public float getPret() {
                return Pret;
            }

            public void setPret(float pret) {
                Pret = pret;
            }

            public int getCant() {
                return Cant;
            }

            public void setCant(int cant) {
                Cant = cant;
            }

            public LocalDate getDataExp() {
                return DataExp;
            }

            public void setDataExp(LocalDate dataExp) {
                DataExp = dataExp;
            }
        }


        List<Produs> listProdus= new ArrayList<Produs>();
        BufferedReader flux_in0=new BufferedReader(new FileReader("produse.csv"));
        String linie;
        String den;
        float pre;
        int can;
        LocalDate dat;
        int n=0;
        while((linie=flux_in0.readLine())!=null){
            n++;
        }

        flux_in0.close();
        BufferedReader flux_in=new BufferedReader(new FileReader("produse.csv"));
        for(int i=0;i<n;i++){
            linie=flux_in.readLine();
            StringTokenizer st=new StringTokenizer(linie);
            den=st.nextToken();
            pre=Float.valueOf(st.nextToken());
            can=Integer.valueOf(st.nextToken());
            //can=Integer.parseInt(st.nextToken().toString());
            dat=LocalDate.parse(st.nextToken());
            Produs pro=new Produs(den,pre,can,dat);
            listProdus.add(pro);
        }

        /*for(int i=0;i<n;i++){
            System.out.println(listProdus.get(i));
        }*/


        byte ui;
        Scanner scan=new Scanner(System.in);
        System.out.println("Welcome!");
        do{
            System.out.println("Profit= "+Produs.getProfit());
            System.out.println("0 = exit");
            System.out.println("1 = afisare toate produsele");
            System.out.println("2 = afisare produse expirate");
            System.out.println("3 = vanzare produs");
            System.out.println("4 = produsul cu pretul minim");
            System.out.println("5 = produse cu pret mai mic decat");

            ui=scan.nextByte();
            switch (ui){
                case 0:
                    System.out.println("closing program");
                    break;
                case 1:
                    for(int i=0;i<n;i++){
                        System.out.println(listProdus.get(i));
                    }
                    break;
                case 2:
                    for(int i=0;i<n;i++) {
                        LocalDate dt1 = LocalDate.now();
                        LocalDate dt2 = listProdus.get(i).getDataExp();
                        if (dt1.isAfter(dt2)) {
                            System.out.println(listProdus.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.println("ce produs a fost cumparat?");
                    den=scan.next();
                    for(int i=0;i<n;i++){
                        can=listProdus.get(i).getCant();
                        System.out.println(den+" ??? "+listProdus.get(i).getDenumire()+" , "+can);
                        if(den.equals(listProdus.get(i).getDenumire()) && can>0){
                            System.out.println("produs vandut!");
                            listProdus.get(i).setCant(can-1);
                            pre=listProdus.get(i).getPret();
                            Produs.setProfit(Produs.getProfit()+pre);
                        }
                    }
                    break;
                case 4:
                    float min=Float.MAX_VALUE;
                    byte minInd=0;
                    for(byte i=0;i<n;i++) {
                        if (listProdus.get(i).getPret()<min){
                            min=listProdus.get(i).getPret();
                            //minInd=i;
                        }
                    }
                    System.out.println(min);
                    for(byte i=0;i<n;i++){
                        if (listProdus.get(i).getPret()==min){
                            System.out.println(listProdus.get(i));
                        }
                    }
                    //System.out.println(listProdus.get(minInd));
                    break;
                case 5:
                    PrintStream flux_out = new PrintStream ("out.csv");
                    System.out.println("Introduceti pretul");
                    min=scan.nextFloat();
                    for(byte i=0;i<n;i++) {
                        if (listProdus.get(i).getPret()<min){
                            System.out.println(listProdus.get(i));
                            flux_out.println(listProdus.get(i));
                        }
                    }
                    flux_out.close();
                    break;
                default:
                    System.out.println("error");
            }
        }while(ui!=0);


    }
}
