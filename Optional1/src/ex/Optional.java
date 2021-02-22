package ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
import java.lang.*;

public class Optional {


    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an integer");
        int n = keyboard.nextInt();
        //int n = Integer.parseInt(args[0]);

        //generez matricea de adiacenta corespunzatoare grafului random
        int[][] m = new int[n][n];
        Random rand = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                m[i][j] = rand.nextInt(1000) % 2;
                m[j][i] = m[i][j];
            }
        }
        //afisez matricea corespunzatoare grafului doar daca m nu este foarte mare
        if(n<30_000) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(m[i][j] + " ");
                }
                System.out.println();
            }
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < visited.length; ) {

            visited[i++] = false;
        }

        int[] componenta = new int[n];
        int[] nrComponenta = new int[1];
        //dfs(1, m, visited, componenta, nrComponenta);
        System.out.println();
        System.out.print("Noduri vizitate" + ':' + ' ');
        componenteConexe(n, m, visited, componenta, nrComponenta);
        System.out.println();
        afisareComponenteConexe(n, m, visited, componenta, nrComponenta);


   long t2 = System.currentTimeMillis();
      System.out.println(t2 - t1);

    }

    public static void dfs(int i, int[][] mat, boolean[] visited, int[] componenta, int[] nrComponenta) {

        visited[i] = true;  // Mark node as "visited"
        componenta[i] = nrComponenta[0];
        System.out.print(i + "\t");

        for (int j = 0; j < visited.length; j++) {

            if (mat[i][j] == 1 && !visited[j]) {

                dfs(j, mat, visited, componenta, nrComponenta);       // Visit node
            }

        }
    }

    public static void componenteConexe(int n, int[][] mat, boolean[] visited, int[] componenta, int[] nrComponenta) {
        int i;


        for (i = 0; i < n; i++)
            if (!visited[i]) {
                nrComponenta[0]++;
                dfs(i, mat, visited, componenta, nrComponenta);


            }
    }

    public static void afisareComponenteConexe(int n, int[][] mat, boolean[] visited, int[] componenta, int[] nrComponenta) {
        int i, j;
        int[] a = {1};


       /* for ( i = 0; i < n; i++) {
            System.out.println();
            System.out.println("Componenta pentru nodul" +' '+ i + "este" + ' '+ componenta[i]);
        }*/
        if (Arrays.equals(nrComponenta, a)) {
            System.out.println();
            System.out.println("Graful este conex!");
        } else {
            System.out.println("Graful nu este conex! Este format din urmatoarele componente conexe: ");
            for (i = 1; i <= nrComponenta[0]; i++) {
                System.out.println();
                System.out.print("Componenta" + ' ' + i + ':');
                for (j = 0; j < n; j++) {
                    if (componenta[j] == i)
                        System.out.print(j);

                }
                System.out.println();
            }
        }
    }


}

