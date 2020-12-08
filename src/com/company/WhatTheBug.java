package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class WhatTheBug {

    public enum color {
        red, green, blue, black, yellow, purple, cyan, white

    }

    /**
     * print out some data
     */
    public static <T> void log(String Title, T data)
    {
        System.out.println();
        System.out.println("+" + getTable(Title.length()+6, '-') + "+");
        System.out.println("|   "+ Title+"   |");
        System.out.println("+" + getTable(Title.length()+6, '-')+ "+");
        System.out.println("| ");
        System.out.println("| "+data);
        System.out.println("| ");
        System.out.println();
    }
    /**
     * print out some data from ArrayList
     */
    public static <T> void log(String Title, ArrayList<T> data)
    {
        System.out.println();
        System.out.println("+" + getTable(Title.length()+6, '-') + "+");
        System.out.println("|   "+ Title+"   |");
        System.out.println("+" + getTable(Title.length()+6, '-')+ "+");
        System.out.println("| ");
        for(T element : data)
        {
            System.out.println("| "+element);
        }
        System.out.println("| ");
        System.out.println();
    }

    private static String getTable(int tyt, char character){
        String x = "";
        for(int i = 0; i<tyt; i++)
        {
            x+=character;
        }
        return x;
    }
    /**
     * print 2d table
     * where every new array inside an array is a new row
     */
    public static void table(String[][] Danec)
    {
        int rowmax =  Arrays.stream(Danec).map(row -> row.length).max(Integer::compare).get();
        String[][] Dane = new String[Danec.length][rowmax];
        String[][] Danecc = Danec.clone();
        int yc =0;

        for(String y[] : Danec ) {
            int xc =0;
            for(String x : y)
            {
                String tekst = "";

                tekst = Danecc[yc][xc].replace("\u001B[0m","");
                tekst = tekst.replace("\u001B[30m","");
                tekst = tekst.replace("\u001B[31m","");
                tekst = tekst.replace("\u001B[32m","");
                tekst = tekst.replace("\u001B[33m","");
                tekst = tekst.replace("\u001B[34m","");
                tekst = tekst.replace("\u001B[35m","");
                tekst = tekst.replace("\u001B[36m","");
                tekst = tekst.replace("\u001B[37m","");
                Dane[yc][xc] = tekst;


                xc++;
            }
            yc+=1;
        }
        char lewyGorny = '╔';
        char pion = '║';
        char prawyGorny = '╗';
        char prawyDolny = '╝';
        char poziom = '═';
        char lewyDolny = '╚';
        char krzyz = '╬';
        char wciecieprawe = '╠';
        char wcieciedol = '╦';
        char wciecielewo = '╣';
        char wcieciegora = '╩';

        int maxx = 0;
        for(String y[] : Dane )
        {
            int currx = 0;
            int columnsc = 0;
            boolean pszy = true;
            for(String x : y)
            {
                if(x!= null) {
                    if (pszy) {
                        pszy = false;
                        currx += 4;
                        currx += x.length();
                    } else {
                        currx += x.length() + 3;
                    }
                }

            }

            if(currx > maxx)
                maxx = currx;

        }

        String line ="";
        String linec = "";


        line+=lewyGorny;
        for (String x : Dane[0]) {
            if(x == null){continue;}
            for (int i = 0; i < x.length() + 2; i++) {
                line+=poziom;
            }
            line+=wcieciedol;
        }
        line = line.substring(0,line.length() - 1);
        while(line.length() < maxx-1)
        {
            line+=poziom;
        }
        line+= prawyGorny;
        System.out.println(line);
        line = "";
        String OLdLine = "";


        int calscy = -1;
        for(String y[] : Dane)
        {
            calscy +=1;
            int calcx = 0;
            for(String x : y)
            {
                if(x!= null) {
                    line+=pion + " ";
                    line+= x;
                    line += " ";

                    linec += pion + " ";
                    linec += Danec[calscy][calcx];
                    linec += " ";

                    calcx++;
                }
            }

            while(line.length() < maxx-1)
            {
                line+=" ";
                linec +=" ";
            }

            if(OLdLine!=""){
                String przerywnik ="";
                przerywnik += wciecieprawe;
                int k=1;
                while(przerywnik.length() <maxx-1)
                {

                    if(line.charAt(k)==pion && OLdLine.charAt(k)==pion)
                    {
                        przerywnik += krzyz;
                    }
                    else if(line.charAt(k)==pion)
                    {
                        przerywnik+= wcieciedol;
                    }
                    else if(OLdLine.charAt(k)==pion)
                    {
                        przerywnik += wcieciegora;
                    }
                    else {
                        przerywnik += poziom;
                    }


                    k+=1;
                }
                przerywnik += wciecielewo;

                System.out.println(przerywnik);
            }



            OLdLine  = line;

            line+=pion;
            linec +=pion;
            System.out.println(linec);
            linec = "";
            line = "";
        }





        line+=lewyDolny;
        for (String x : Dane[Dane.length-1]) {
            if(x==null){continue;}
            for (int i = 0; i < x.length() + 2; i++) {
                line+=poziom;
            }
            line+=wcieciegora;
        }
        line = line.substring(0,line.length() - 1);
        while(line.length() < maxx-1)
        {
            line+=poziom;
        }
        line+= prawyDolny;
        System.out.println(line);




    }
    /**
     * Generate some colored text
     */
    public static String coloredText(String text, color kolor) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_BLUE = "\u001B[34m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_WHITE = "\u001B[37m";
        String ending = "";
        switch (kolor) {
            case red:
                ending = ANSI_RED;
                break;
            case green:
                ending = ANSI_GREEN;
                break;
            case blue:
                ending = ANSI_BLUE;
                break;
            case yellow:
                ending = ANSI_YELLOW;
                break;
            case black:
                ending = ANSI_BLACK;
                break;
            case purple:
                ending = ANSI_PURPLE;
                break;
            case cyan:
                ending = ANSI_CYAN;
                break;
            case white:
                ending = ANSI_WHITE;
                break;
            default:
                ending = ANSI_WHITE;
                break;


        }



        return  ending + text + ANSI_RESET;
    }

    


}









