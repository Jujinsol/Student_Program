import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Map_students {

    public static void main(String[] args) {
        int answer;
        int ID;
        String name;
        String birth;
        String major;

        HashMap<Integer, ArrayList> Student;
        Student = new HashMap<>();
//        ArrayList Info = new ArrayList();
//        처음에 이곳에서 ArrayList의 선언과 초기화를 동시에 진행했고, 학생 전부가 따로 저장되는 것이 아니라 하나의 Info 안에 전부 저장되는 오류가 나타났다.
//        지역변수와 전역변수의 차이를 제대로 인지하지 못한 탓이 크다.

        Scanner sc = new Scanner(System.in);

        while (true) {
            ArrayList Info = new ArrayList();

            System.out.println("1. 학생 정보 등록 \n2. 학생 정보 검색 \n3. 종료");
            answer = sc.nextInt();

            if (answer == 1) {

                System.out.println("학생 학번을 입력해주세요.");
                ID = sc.nextInt();

                System.out.println("학생 이름을 입력해주세요.");
                name = sc.next();
                Info.add(name);

                System.out.println("학생 생일을 입력해주세요.");
                birth = sc.next();
                Info.add(birth);

                System.out.println("학생 학과를 입력해주세요.");
                major = sc.next();
                Info.add(major);

                Student.put(ID, Info);

            } else if (answer == 2) {
                System.out.println("학번을 입력해주세요.");
                int newID = sc.nextInt();

                System.out.println("학번 : " + newID + "\n이름 : " + Student.get(newID).get(0) + "\n생일 : " + Student.get(newID).get(1) + "\n학과 : " + Student.get(newID).get(2));
                System.out.println();


            } else if (answer == 3) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
                System.out.println();
            }

        }
    }
}
