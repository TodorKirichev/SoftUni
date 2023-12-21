package ObjectsAndClassesLab.Song;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = Integer.parseInt(scan.nextLine());
        List<Songs> songs = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] input = scan.nextLine().split("_");
            String typeList = input[0];
            String name = input[1];
            String time = input[2];

            Songs currentSong = new Songs(typeList,name,time);
            songs.add(currentSong);
        }
        String command = scan.nextLine();
        if (command.equals("all")) {
            for (Songs song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Songs song : songs) {
                if (command.equals(song.getTypeList())) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
