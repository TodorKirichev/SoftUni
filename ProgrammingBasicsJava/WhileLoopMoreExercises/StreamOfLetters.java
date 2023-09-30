package WhileLoopMoreExercises;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int counterC = 0;
        int counterO = 0;
        int counterN = 0;
        String word = "";

        String letter = scan.nextLine();
        while (!letter.equals("End")) {
            if (letter.equals("c")){
                counterC++;
                if (counterC>=2){
                    word+=letter;
                }
            }else if (letter.equals("o")){
                counterO++;
                if (counterO>=2){
                    word+=letter;
                }
            }else if (letter.equals("n")){
                counterN++;
                if (counterN>=2){
                    word+=letter;
                }
            }else if (letter.matches("\\w")){
                word+=letter;
            }
            if (counterC>=1&&counterO>=1&&counterN>=1){
                System.out.print(word + " ");
                counterC=0;
                counterO=0;
                counterN=0;
                word="";
            }
                letter= scan.nextLine();
        }
    }
}

