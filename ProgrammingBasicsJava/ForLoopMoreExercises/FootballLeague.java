package ForLoopMoreExercises;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int stadiumCapacity = Integer.parseInt(scan.nextLine());
        int fans = Integer.parseInt(scan.nextLine());
        int a = 0;
        int b = 0;
        int v = 0;
        int g = 0;

        for (int i = 0; i < fans; i++) {
            String sector = scan.nextLine();
            switch (sector){
                case "A":
                    a++;
                    break;
                case "B":
                    b++;
                    break;
                case "V":
                    v++;
                    break;
                case "G":
                    g++;
                    break;
            }
        }
        System.out.printf("%.2f%%%n",(double)a/fans*100);
        System.out.printf("%.2f%%%n",(double)b/fans*100);
        System.out.printf("%.2f%%%n",(double)v/fans*100);
        System.out.printf("%.2f%%%n",(double)g/fans*100);
        System.out.printf("%.2f%%%n",(double)(a+b+v+g)/stadiumCapacity*100);
    }
}
