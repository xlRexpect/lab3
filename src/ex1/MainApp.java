package ex1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainApp {
    public static void main(String[] args) throws IOException {
        class Parabola{
            private int a,b,c;

            public Parabola(int a,int b,int c){
                this.a=a;
                this.b=b;
                this.c=c;

            }

            @Override
            public String toString() {
                return a+"x^2+"+b+"x+"+c;
            }

            public String VarfPar(){
                float vx1,vy1,vx2,vy2;
                if(a!=0) {
                    vx1 =-b;
                    vx1=vx1/(2*a);
                    vy1=-(b*b);
                    vy1=vy1+4*a*c;
                    vy1=vy1/(4*a);
                    //System.out.println(vx1+" "+vy1);
                    return "("+vx1+" , "+vy1+")";
                }else{
                    return "error";
                }
            }
            public String calcMijlDrept(int k,int l,int m){
                float vx1,vy1,vx2,vy2;
                if(a!=0) {
                    vx1 =-b;
                    vx1=vx1/(2*a);
                    vy1=-(b*b);
                    vy1=vy1+4*a*c;
                    vy1=vy1/(4*a);
                    //System.out.println(vx1+" "+vy1);
                }else{
                    return "error";
                }
                if(k!=0) {
                    vx2 =-l;
                    vx2=vx2/(2*k);
                    vy2=-(l*l);
                    vy2=vy2+4*k*l;
                    vy2=vy2/(4*k);
                    //System.out.println(vx2+" "+vy2);
                }else{
                    return "error";
                }

                float rx,ry;
                rx=(vx1+vx2)/2;
                ry=(vy1+vy2)/2;
                return "( " + rx+" , "+ry+" )";
            }

            public static String calcMijlDreptStat(int d,int e,int f,int k,int l,int m){
                float vx1,vy1,vx2,vy2;
                if(d!=0) {
                    vx1 =-e;
                    vx1=vx1/(2*d);
                    vy1=-(e*e);
                    vy1=vy1+4*d*f;
                    vy1=vy1/(4*d);
                    //System.out.println(vx1+" "+vy1);
                }else{
                    return "error";
                }
                if(k!=0) {
                    vx2 =-l;
                    vx2=vx2/(2*k);
                    vy2=-(l*l);
                    vy2=vy2+4*k*m;
                    vy2=vy2/(4*k);
                    //System.out.println(vx2+" "+vy2);
                }else{
                    return "error";
                }

                float rx,ry;
                rx=(vx1+vx2)/2;
                ry=(vy1+vy2)/2;
                return "( " + rx+" , "+ry+" )";
            }

            public double calcLung(int k,int l,int m){
                double vx1,vy1,vx2,vy2;
                if(a!=0) {
                    vx1 =-b;
                    vx1=vx1/(2*a);
                    vy1=-(b*b);
                    vy1=vy1+4*a*c;
                    vy1=vy1/(4*a);
                    //System.out.println(vx1+" "+vy1);
                }else{
                    return 0;
                }
                if(k!=0) {
                    vx2 =-l;
                    vx2=vx2/(2*k);
                    vy2=-(l*l);
                    vy2=vy2+4*k*l;
                    vy2=vy2/(4*k);
                    //System.out.println(vx2+" "+vy2);
                }else{
                    return 0;
                }
                return Math.hypot((vx2-vx1),(vy2-vy1));
            }

            public static double calcLungStat(int a,int b,int c,int k,int l,int m){
                double vx1,vy1,vx2,vy2;
                if(a!=0) {
                    vx1 =-b;
                    vx1=vx1/(2*a);
                    vy1=-(b*b);
                    vy1=vy1+4*a*c;
                    vy1=vy1/(4*a);
                    //System.out.println(vx1+" "+vy1);
                }else{
                    return 0;
                }
                if(k!=0) {
                    vx2 =-l;
                    vx2=vx2/(2*k);
                    vy2=-(l*l);
                    vy2=vy2+4*k*l;
                    vy2=vy2/(4*k);
                    //System.out.println(vx2+" "+vy2);
                }else{
                    return 0;
                }
                return Math.hypot((vx2-vx1),(vy2-vy1));
            }


            public int getA() {
                return a;
            }
            public void setA(int a) {
                this.a = a;
            }
            public int getB() {
                return b;
            }
            public void setB(int b) {
                this.b = b;
            }
            public int getC() {
                return c;
            }
            public void setC(int c) {
                this.c = c;
            }


        }

        BufferedReader flux_in0 = new BufferedReader(new FileReader("in.txt"));
        String linie;
        int n=0;
        int a,b,c;
        List<Parabola> p =new ArrayList<Parabola>();
        while ((linie = flux_in0.readLine()) != null) {
            n++;
        }
        flux_in0.close();
        BufferedReader flux_in = new BufferedReader(new FileReader("in.txt"));
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(flux_in.readLine());
            //while (st.hasMoreTokens()) {
            //System.out.println(st.nextToken());

            //}
            a=Integer.parseInt(st.nextToken());
            b=Integer.parseInt(st.nextToken());
            c=Integer.parseInt(st.nextToken());
            Parabola par =new Parabola(a,b,c);
            //System.out.println(par);
            p.add(par);
        }


        for(int i=0;i<n;i++){
            System.out.println(p.get(i));
            Parabola par=p.get(i);
            System.out.println(par.VarfPar());
        }

        Scanner sc=new Scanner(System.in);

        System.out.println("dati un index");
        int j=sc.nextInt();
        System.out.println("dati un alt index");
        int k=sc.nextInt();
        int d,e,f,g,h,i;
        d=(p.get(j)).getA();
        e=(p.get(j)).getB();
        f=(p.get(j)).getC();
        g=(p.get(k)).getA();
        h=(p.get(k)).getB();
        i=(p.get(k)).getC();
        System.out.println(Parabola.calcMijlDreptStat(d,e,f,g,h,i));
        System.out.println(Parabola.calcLungStat(d,e,f,g,h,i));


    }
}

