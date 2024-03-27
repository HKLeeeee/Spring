package kb.itskb.ws02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EvenOddSum {


    public static void main(String[] args) throws IOException {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        BufferedReader br =
                new BufferedReader(new FileReader("/Users/hkleeeee/Desktop/Spring/BasicJava/src/com/itskb/ws02/EvenOddSumInput.txt"));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            int row = 0;
            for (String s : br.readLine().split(" ", -1)) {
                arr[i][row++] = Integer.parseInt(s);
            }
        }
//
//        for (int[] a: arr){
//            System.out.println(Arrays.toString(a));
//        }

        int x, y, nx, ny, totalSum, tempSum;
        totalSum = 0;
        for(int i = 0 ; i < n ; i++){
            for (int j=0; j<n; j++){
                x = i;
                y = j;
                tempSum = 0;
                for(int k=0; k<4; k++){
                    nx = x + dx[k];
                    ny = y + dy[k];
                    try {
                        tempSum += arr[nx][ny];
                    } catch (Exception e){
                    }
                }
                if (tempSum % 2 == 0){
                    totalSum += arr[x][y];
                }
            }
        }

        System.out.println(totalSum);

    }
}
