    package ForLoop;

    import java.util.Scanner;

    public class LeftAndRightSum {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in);

            int n = Integer.parseInt(scan.nextLine());
            int leftSum =0;
            int rightSum=0;

            for (int i =0;i<n;i++){
                int num =Integer.parseInt(scan.nextLine());
                leftSum+=num;
            }
            for (int i =0;i<n;i++){
                int num =Integer.parseInt(scan.nextLine());
                rightSum+=num;
            }
            int diff = Math.abs(leftSum-rightSum);
            if (diff==0){
                System.out.println("Yes, sum = " + leftSum);
            }else {
                System.out.println("No, diff = " + diff);
            }
        }
    }
