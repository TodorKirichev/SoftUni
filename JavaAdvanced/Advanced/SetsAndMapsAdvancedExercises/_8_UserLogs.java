package JavaAdvanced.SetsAndMapsAdvancedExercises;

import java.util.*;

public class _8_UserLogs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String,Map<String,Integer>> userIP = new TreeMap<>();

        while (true) {
            String input = scan.nextLine();
            if (input.equals("end")) {
                break;
            }
            String[] inputData = input.split("\\s+");
            String ip = inputData[0].split("=")[1];
            String user = inputData[2].split("=")[1];

            if (!userIP.containsKey(user)) {
                userIP.put(user,new LinkedHashMap<>());
                Map<String,Integer> ipCount = userIP.get(user);
                ipCount.put(ip,1);
            } else {
                Map<String,Integer> ipCount = userIP.get(user);
                if (!ipCount.containsKey(ip)) {
                    ipCount.put(ip,1);
                } else {
                    ipCount.put(ip, ipCount.get(ip) + 1);
                }
            }
        }
        userIP.forEach((key,value) -> {
            System.out.printf("%s:\n",key);
            List<String> output = new ArrayList<>();
            value.forEach((ip,count) -> {
                output.add(String.format("%s => %d",ip,count));
            });
            System.out.print(String.join(", ", output));
            System.out.println(".");
        });
    }
}
