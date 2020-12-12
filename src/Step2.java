import java.util.*;
public class Step2 {
    static String[][] Cube = new String[3][];
    static String dir = new String() ;

    public static void main(String args[]){
        MyCube obj;
        obj = new MyCube();
        obj.initCube(Cube);
        obj.inputData(dir);
//        while(true){
//
//        }
    }
}

class MyCube {
    void initCube( String[][] Cube ){
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

    void inputData( String dir ){
        Scanner sc = new Scanner(System.in);
        dir = sc.next();
       // System.out.println(dir);
    }
}