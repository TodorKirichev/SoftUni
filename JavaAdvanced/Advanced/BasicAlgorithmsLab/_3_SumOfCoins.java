package JavaAdvanced.Advanced.BasicAlgorithmsLab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.in;

public class _3_SumOfCoins {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);


        Scanner in = new Scanner(System.in);

        String[] elements = in.nextLine().substring(7).split(", ");
        int[] coins = new int[elements.length];
        for (int i = 0; i < coins.length; i++) {
            coins[i] = Integer.parseInt(elements[i]);
        }

        int targetSum = Integer.parseInt(in.nextLine().substring(5));


        Map<Integer, Integer> usedCoins = chooseCoins(coins, targetSum);

        for (Map.Entry<Integer, Integer> usedCoin : usedCoins.entrySet()) {
            System.out.println(usedCoin.getKey() + " -> " + usedCoin.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int targetSum) {
        Map<Integer,Integer> map = new LinkedHashMap<>();
        int index = coins.length - 1;

        while (targetSum > 0) {
            int coin = coins[index--];
            int numOfCoins = targetSum / coin;
            targetSum %= coin;

            if (numOfCoins > 0) {
                map.put(coin,numOfCoins);
            }
        }
        return map;
    }
}
