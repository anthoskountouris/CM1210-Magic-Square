// Anthos Kountouris C1945047

import java.util.Scanner;
import java.util.Random;
public class magicone {
    public static void main(String[] args) {

        int n=size_input();
        int[][] a = new int[n][n];
        magicsquare(a,n);
        shuffle(a, n);
        user(a,n);
    }

//The User inputs the dimension of the magic square
    public static int size_input(){
      Scanner input = new Scanner(System.in);
      System.out.println("Enter the dimension of the matrix(Odd number): ");
      int n = input.nextInt();
      while (n % 2 == 0 || n==1) {
          System.out.println("Please enter an odd number: ");
          n = input.nextInt();
      }
      return n;
    }

    public static void magicsquare(int[][] a, int n){
      int x = 0;
      int y = ((n + 1) / 2)-1;
      //The matrix is filled with zeros
      System.out.println("Length of magic aquare is " + a.length +"x"+ a.length+"\n");
      for (int i = 2; i < a.length; i++) {
          for (int j = 0; j < a[i].length; j++) {
              a[i][j] = 0;
          }
      }
      //Placing number "1" in a[0][1]
      a[x][y] = 1;
      //All zeros with this algorithm now are being replaced with n*n numbers
      for(int i=2; i<=n*n; i++){
        int x1 = x;
        int y1 = y;

          if(x-1==-1){
            x1=n;
          }
          if(y-1==-1){
            y1=n;
          }
          if (a[x1-1][y1-1]==0){
              x = x1 - 1;
              y = y1 - 1;
          }else{
            if(x==n-1){
              x=0;
            }else{
                  x = x + 1;
            }
        }

          a[x][y] = i ;
      }
      //Printing the magic square
      for (int i = 0; i < a.length; i++) {
          for (int j = 0; j < a[i].length; j++) {
            //System.out.format("|%2d|", a[i][j]);
            System.out.print("| "+a[i][j]+ " |"+"\t");
           }
            System.out.println("\n");
        }

      System.out.println();
    }

    /*The shuffle method is randomly shuffling repeatedly (for n2 times)
    choosing a random element and swapping it with a random neighbour */
    public static void shuffle(int[][] a, int n) {
        String[] moves = {"U", "D", "R", "L"};
        Random random = new Random();
        int temp;
        String M;
        int x;
        int y;
        for (int i = 0; i < n * n; i++) {
            int random_move = random.nextInt(moves.length);
            M = moves[random_move];
            x = random.nextInt(n);
            y = random.nextInt(n);
            temp = a[x][y];
            if (M.equals("D")) {
                if ((x + 1) == n) {
                    a[x][y] = a[0][y];
                    a[0][y] = temp;
                } else {
                    a[x][y] = a[x + 1][y];
                    a[x + 1][y] = temp;
                }
            } else if (M.equals("U")) {
                if ((x - 1) == -1) {
                    a[x][y] = a[n - 1][y];
                    a[n - 1][y] = temp;
                } else {
                    a[x][y] = a[x - 1][y];
                    a[x - 1][y] = temp;
                }
            } else if (M.equals("R")) {
                if ((y + 1) == n) {
                    a[x][y] = a[x][0];
                    a[x][0] = temp;
                } else {
                    a[x][y] = a[x][y + 1];
                    a[x][y + 1] = temp;
                }
            } else if (M.equals("L")) {
                if ((y - 1) == -1) {
                    a[x][y] = a[x][n - 1];
                    a[x][y] = temp;
                } else {
                    a[x][y] = a[x][y - 1];
                    a[x][y] = temp;
                }
            }
        }
        //Printing the magic square shuffled
        System.out.println("The square below is the randomly shuffled square:\n");

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
              System.out.print("| "+a[i][j]+ " |"+"\t");
             }
              System.out.println("\n");
        }
    }
    /*The user method is taking the directions from the player and makes the moves,
    if the player reconstruct the magic square correctly the game finishes */
    public static void user(int[][] a,int n) {
        int num1, num2, temp, c=0;
        String dir;
        System.out.println("You now have to reconstruct the magic square!!");
        while(counter(a,n)==false) {
            System.out.println("Enter your move (\" Row \", \" Column \", \" [U] [D] [R] [L] \": ");

            Scanner input = new Scanner(System.in);
            String m = input.nextLine();

            String[] splitted_m = m.split(" ");

            num1 = Integer.parseInt(splitted_m[0]) - 1;
            num2 = Integer.parseInt(splitted_m[1]) - 1;
            dir = splitted_m[2];
            temp = a[num1][num2];
            if (dir.equals("D")) {
                if ((num1 + 1) == n) {
                    a[num1][num2] = a[0][num2];
                    a[0][num2] = temp;
                } else {
                    a[num1][num2] = a[num1 + 1][num2];
                    a[num1 + 1][num2] = temp;
                }
            } else if (dir.equals("U")) {
                if ((num1 - 1) == -1) {
                    a[num1][num2] = a[n - 1][num2];
                    a[n - 1][num2] = temp;
                } else {
                    a[num1][num2] = a[num1 - 1][num2];
                    a[num1 - 1][num2] = temp;
                }
            } else if (dir.equals("R")) {
                if ((num2 + 1) == n) {
                    a[num1][num2] = a[num1][0];
                    a[num1][0] = temp;
                } else {
                    a[num1][num2] = a[num1][num2 + 1];
                    a[num1][num2 + 1] = temp;
                }
            } else if (dir.equals("L")) {
                if ((num2 - 1) == -1) {
                    a[num1][num2] = a[num1][n - 1];
                    a[num1][n - 1] = temp;
                } else {
                    a[num1][num2] = a[num1][num2 - 1];
                    a[num1][num2 - 1] = temp;
                }
            }
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[i].length; j++) {
                  System.out.print("| "+a[i][j]+ " |"+"\t");
                 }
                  System.out.println("\n");
            }
            c++;
        }
        System.out.println("Congratulations!!!!! You have reconstructed the magic square. ");
        System.out.println("You have made " + c + " moves");
    }
    //The counter method is calculating the sum of the rows, columns and diagonals.
    public static boolean counter(int[][] a,int n){
        int sum_row, sum_col, sum_diag1=0, sum_diag2=0;
        int result = (n*(n*n+1))/2;
        for (int i = 0; i < a.length; i++) {
            sum_row=0;
            sum_col=0;
            for (int j = 0; j < a[i].length; j++) {
                sum_row+=a[i][j];
                sum_col+=a[j][i];
                if (i==j){
                    sum_diag1+=a[i][j];
                }
                if (i==n-j-1){
                    sum_diag2+=a[i][j];
                }
            }
            if (sum_row != result){

                return false;
            }
            if (sum_col!= result){
                return false;
            }
        }
        if ((sum_diag1 != result) || (sum_diag2 != result)){
            return false;
        }
        return true;
    }

}
