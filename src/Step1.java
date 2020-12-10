import java.util.*;

public class Step1 {
    public static void main(String[] args) {
        String word = "";
        int strLen = 0;
        int num = 0;
        String dir = "";
        while (true) {
            while (true) {
                try {
                    System.out.println("영어단어 -100<=N<100 L(l) or R(r) 입력하세요. (프로그램 종료 : EXIT)");
                    Scanner sc = new Scanner(System.in);
                    String getData = sc.nextLine();
                    //System.out.println(getData);
                    String[] array = getData.split(" ");
                    // System.out.println(array[0]);
                    word = array[0];
                    strLen = word.length(); // 입력받은 단어의 길이
                    num = Integer.parseInt(array[1]); // 이동 횟수
                    dir = array[2];
                    if ((num >= -100) || (num < 100)) { // 주어진 조건과 맞다면 반복문을 나옴
                        if (dir.equals("L") || dir.equals("l")) {
                            //System.out.printf("%d %s%n", num, dir);
                            break;
                        } else if (dir.equals("R") || dir.equals("r")) {
                            //System.out.printf("%d %s%n", num, dir);
                            break;
                        }
                    } else continue;
                } catch (IndexOutOfBoundsException e) {
                    System.out.println(e);
                    if(word.equals("EXIT")) System.exit(0);
                    else continue;
                }
            }

            if (num >= 0) {
                if (dir.equals("R") || dir.equals("r")) {
                    MyShift Cal = new MyShift();
                    Cal.RShift(word, strLen, num);
                }
                else if (dir.equals("L") || dir.equals("l")) {
                    MyShift Cal = new MyShift();
                    Cal.LShift(word, strLen, num);
                }
            }
            else {
                num = num * -1;
                if (dir.equals("R") || dir.equals("r")) {
                    MyShift Cal = new MyShift();
                    Cal.LShift(word, strLen, num);
                }
                else if (dir.equals("L") || dir.equals("l")) {
                    MyShift Cal = new MyShift();
                    Cal.RShift(word, strLen, num);
                }
            }
        }
    }
}

class MyShift {
    public void RShift(String str, int len, int num) {
        String[] getWord = str.split("");
        String[] tempWord = new String[len];
        int b = num % len;
        for (int i = 0; i < len; i++) {
            int roomNum = i - b;
            if (roomNum < 0) {
                roomNum = roomNum + len;
            }
            tempWord[i] = getWord[roomNum];
            //System.out.println(tempWord[i]);
        }
        //String word = Arrays.toString(tempWord);
        String word = String.join(",", tempWord);
        word = word.replaceAll(",", "");
        System.out.println(word);
    }

    public void LShift(String str, int len, int num) {
        String[] getWord = str.split("");
        String[] tempWord = new String[len];
        int b = num % len;
        for (int i = 0; i < len; i++) {
            int roomNum = i + b;
            if (roomNum >= len) {
                roomNum = roomNum - len;
            }
            tempWord[i] = getWord[roomNum];
            //System.out.println(tempWord[i]);
        }
        //String word = Arrays.toString(tempWord);
        String word = String.join(",", tempWord);
        word = word.replaceAll(",", "");
        System.out.println(word);
    }
}
