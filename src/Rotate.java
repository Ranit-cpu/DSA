public class Rotate {
      
      public static void main(String[] args){
            
            int[][] mat= {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
            
            for(int i = 0; i < mat.length;i++) {
                  for (int j = 0; j < mat.length; j++) {
                        System.out.print(mat[i][j]+" ");
                  }
                  System.out.println();
            }
            System.out.println();
            rotated(mat);
      }
      
      private static void rotated(int[][] matrix)
      {
            int n = matrix.length;
            int[][] rotated = new int[n][n];
            
            for(int i = 0; i < n;i++){
                  for(int j = 0; j < n; j++){
                        rotated[n-j-1][i] = matrix[i][j];
                  }
            }
            
            for(int i = 0; i < n;i++) {
                  for (int j = 0; j < n; j++) {
                        System.out.print(rotated[i][j]+" ");
                  }
                  System.out.println();
            }
      }
}
