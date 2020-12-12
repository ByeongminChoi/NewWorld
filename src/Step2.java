import java.util.*;

public class Step2 {
    static String[][] Cube = new String[3][];
    static String[] dir;

    public static void main(String args[]) {
        MyCube obj;
        obj = new MyCube();
        obj.initCube(Cube);
        while (true) {
            obj.getDir(dir);
        }
    }
}

class MyCube {
    void initCube(String[][] Cube) {
        Cube[0] = new String[]{"R", "R", "W"};
        Cube[1] = new String[]{"G", "C", "W"};
        Cube[2] = new String[]{"G", "B", "B"};

        for (int i = 0; i < Cube.length; i++) {
            for (int j = 0; j < Cube[i].length; j++) {
                System.out.print(Cube[i][j] + "\t");
            }
            System.out.println();
        }
    }

    void getDir(String[] dir) {
        Scanner sc = new Scanner(System.in);
        String temp = sc.next();
        dir = temp.split("");
        for (int i = 0; i < dir.length; i++) {
            String temp1[] = new String[dir.length];
            //temp1[i] = dir[i];
            if (dir[i].equals("'")) {
                temp1[i] = dir[i - 1].concat(dir[i]);
                dir[i - 1] = temp1[i];
            }
        }
        final List<String> list = new ArrayList<String>();
        Collections.addAll(list, dir);
        list.removeIf(n -> (n.equals("'")));
        dir = list.toArray(new String[list.size()]);

        //System.out.println(Arrays.deepToString(dir));

        if (dir[0].equals("Q")) {
            System.out.println("Bye~");
            System.exit(0);
        }
    }

    void Cal( String[][] Cube, String[] dir ){
        
    }
}