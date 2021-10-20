import java.util.ArrayList;
import java.util.Scanner;

public class students {
    public static void main(String[] args) {
        int number;
        int ID;
        String name;
        String birth;
        String major;
        int PW;
        int i = 0;


        ArrayList<ArrayList> students = new ArrayList<ArrayList>();
        ArrayList Infos = new ArrayList();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("관리자이시면 1번을 학생이시면 2번을 눌러주세요. 종료하시려면 0번을 누르세요.");
            number = sc.nextInt();

            if (number == 1) {

                System.out.println("비밀번호를 입력하세요.");
                PW = sc.nextInt();

                while (true) {

                    if (PW == 11111) {
                        System.out.println("학생 이름을 입력하세요.");
                        name = sc.next();
                        System.out.println(name + " 학생의 생년월일을 입력하세요( 예: 99.01.01 ).");
                        birth = sc.next();
                        System.out.println(name + " 학생 학과를 입력하세요.");
                        major = sc.next();

                        Infos.add(name);
                        Infos.add(birth);
                        Infos.add(major);

                        students.add(i, Infos);

                        System.out.println("학생 학번 : " + (i+1) + " 번" + "\n학생의 이름 : " + name + "\n학생 생년월일 : " + birth + "\n학생 학과 : " + major);
//                        System.out.println("학생 이름 : " + students.get(ID).get(0) + "\n학생 생년월일 : " + students.get(ID).get(1) + "\n학생 학과 : " + students.get(ID).get(2));
                        i++;


                        System.out.println("정보를 더 입력하시려면 1번을 메인 화면으로 돌아가시려면 2번을 눌러주세요.");
                        number = sc.nextInt();
                        if (number == 1) {
                            continue;
                        } else {
                            break;
                        }

                    } else {
                        System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
                        break;
                    }
                }

            } else if (number == 2) {
                System.out.println("학번을 입력하세요.");
                ID = sc.nextInt();
                ID = i;

                System.out.println("학생 이름 : " + students.get(ID-1).get(0) + "\n학생 생년월일 : " + students.get(ID-1).get(1) + "\n학생 학과 : " + students.get(ID-1).get(2));

            } else if (number == 0) {
                break;
            } else {
                System.out.println("잘못 입력하셨습니다. 다시 시도해주세요.");
            }
        }
    }
}
