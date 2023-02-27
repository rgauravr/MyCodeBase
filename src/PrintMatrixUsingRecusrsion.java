

public class PrintMatrixUsingRecusrsion {
//print horizontal

    final static int N = 3;
    final static int M = 3;

    // Function to traverse the matrix recursively
    static int traverseMatrix(int arr[][], int current_row,
                              int current_col)
    {
        // If the entire column is traversed
        if (current_col >= M)
            return 1;

        // If the entire row is traversed
        if (current_row >= N)
            return 0;

        // Print the value of the current
        // cell of the matrix
        System.out.print(arr[current_row][current_col] + ", ");

        // Recursive call to traverse the matrix
        // in the Horizontal direction
        if (traverseMatrix(arr, current_row,
                current_col + 1)
                == 0)
            return 0;

        // Recursive call for changing the
        // Row of the matrix
        return traverseMatrix(arr,
                current_row + 1,
                0);
    }

 //print vertical

    public int printVerticalMatrix(int row,int col,int[][] matrix){

        if(row>=matrix.length)
            return 0;

        if(col>=matrix[row].length)
            return 1;


        System.out.println(matrix[row][col]);
        if(printVerticalMatrix(row+1,col,matrix)==1){

            return 1;
        }

        return printVerticalMatrix(0,col+1,matrix);
    }

    // Driver code
    public static void main (String[] args)
    {
        int arr[][] = { { 1, 2, 3 },
                { 4, 5, 6 },
                {7,8,9}};

        traverseMatrix(arr, 0, 0);
        System.out.println( "===========================");
        new PrintMatrixUsingRecusrsion().printVerticalMatrix(0,0,arr);
    }


}
