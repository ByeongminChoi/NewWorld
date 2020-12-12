import java.util.*;
public class Step2 {
    public static void main(String args[]){
        String[][] Cube = new String[3][];
        Cube[0] = new String[]{"R", "R", "W"};
        Cube[1] = new String[]{"G", "C", "W"};
        Cube[2] = new String[]{"G", "B", "B"};

        for ( int i = 0; i < Cube.length; i++){
            for ( int j =0; j < Cube[i].length; j++){
                System.out.print(Cube[i][j] + "\t");
            }
            System.out.println();
        }

    }
}
