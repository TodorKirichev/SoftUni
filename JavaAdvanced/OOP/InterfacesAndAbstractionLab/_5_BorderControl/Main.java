package SoftUni.JavaAdvanced.OOP.InterfacesAndAbstractionLab._5_BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<Identifiable> list = new ArrayList<>();

        String command = scan.nextLine();

        while (!"End".equals(command)) {

            Identifiable identifiable = null;

            String[] info = command.split("\\s+");
            if (info.length == 3) {
                String name = info[0];
                int age = Integer.parseInt(info[1]);
                String id = info[2];
                identifiable = new Citizen(name,age,id);
            } else if (info.length == 2) {
                String id = info[0];
                String model = info[1];
                identifiable = new Robot(id,model);
            }
            list.add(identifiable);

            command = scan.nextLine();
        }
        String fakeId = scan.nextLine();
        list.stream().filter(i -> i.getId().endsWith(fakeId)).forEach(i -> System.out.println(i.getId()));
    }
}
