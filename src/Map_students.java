import database.DBconnection;
import database.Info;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Map_students {

    public static void main(String[] args) throws SQLException {
        int answer;

        DBconnection db = new DBconnection();
        Info info = new Info();


        HashMap<Integer, ArrayList> Student; // -> db
        Student = new HashMap<>();
//        ArrayList Info = new ArrayList();
//        처음에 이곳에서 ArrayList의 선언과 초기화를 동시에 진행했고, 학생 전부가 따로 저장되는 것이 아니라 하나의 Info 안에 전부 저장되는 오류가 나타났다.
//        지역변수와 전역변수의 차이를 제대로 인지하지 못한 탓이다.

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. 학생 정보 등록 \n2. 학생 정보 검색 \n3. 학생 정보 수정 \n4. 학생 정보 삭제 \n0. 종료");
            System.out.println();
            answer = sc.nextInt();

            if (answer == 1) { //등록

                System.out.println("학생 학번을 입력해주세요.");
                 int WID= sc.nextInt();
                 info.setID(WID);

                System.out.println("학생 이름을 입력해주세요.");
                String Wname = sc.next();
                info.setName(Wname);

                System.out.println("학생 생일을 입력해주세요.");
                String Wbirth = sc.next();
                info.setBirth(Wbirth);

                System.out.println("학생 학과를 입력해주세요.");
                String Wmajor = sc.next();
                info.setMajor(Wmajor);

                int result = db.insert(info.getID(), info.getName(), info.getBirth(), info.getMajor());
                if (result != 0) {
                    System.out.println("삽입 성공");
                    System.out.println();
                }

            } else if (answer == 2) { //검색
                System.out.println("학번을 입력해주세요.");
                int newID = sc.nextInt();

                Info select = db.select(newID);
                System.out.println("학번 : "+ select.getID()+" 이름 : "+select.getName()+" 생일 : "+select.getBirth()+" 학과 : "+select.getMajor());

            } else if (answer == 3) { //수정
                System.out.println("정보를 수정하고 싶은 학생의 학번을 입력해주세요.");
                int ChanID = sc.nextInt();

                System.out.println();

                System.out.println("학생의 새 이름을 입력해주세요.");
                String ChanName = sc.next();

                System.out.println("학생의 새 생일을 입력해주세요.");
                String ChanBirth = sc.next();

                System.out.println("학생의 새 학과를 입력해주세요.");
                String ChanMajor = sc.next();

                int updateResult = db.update(ChanID, ChanName, ChanBirth, ChanMajor);
                if (updateResult != 0) {
                    System.out.println("수정 성공");
                }


            } else if (answer == 4) { //삭제
                System.out.println("정보를 삭제하고 싶은 학생의 학번을 입력해주세요.");
                int DelID = sc.nextInt();
                int deleteResult = db.delete(DelID);

                if (deleteResult != 0) {
                    System.out.println("삭제 성공");
                }

            } else if (answer == 0) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
                System.out.println();
            }

        }
    }
}
