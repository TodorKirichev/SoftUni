package ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.System.in;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(in);

        List<Integer> pokemons = Arrays.stream(scan.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int sum = 0;

        while (pokemons.size() > 0){
            int index = Integer.parseInt(scan.nextLine());
            if (index >= 0 && index < pokemons.size()){
                int removed = pokemons.get(index);
                pokemons.remove(index);
                increaseOrDecrease(pokemons,removed);
                sum += removed;
            }else if (index < 0){
                int removed = pokemons.get(0);
                pokemons.remove(0);
                pokemons.add(0,pokemons.get(pokemons.size() - 1));
                increaseOrDecrease(pokemons,removed);
                sum += removed;
            } else {
                int removed = pokemons.get(pokemons.size() - 1);
                pokemons.remove(pokemons.size() - 1);
                pokemons.add(pokemons.get(0));
                increaseOrDecrease(pokemons,removed);
                sum += removed;
            }

        }
        System.out.println(sum);
    }
    public static void increaseOrDecrease(List<Integer> pokemons,int removed){

        for (int i = 0; i < pokemons.size(); i++) {
            int currentNum = pokemons.get(i);
            if (currentNum <= removed){
                currentNum += removed;
            } else {
                currentNum -= removed;
            }
            pokemons.set(i,currentNum);
        }
    }
}
