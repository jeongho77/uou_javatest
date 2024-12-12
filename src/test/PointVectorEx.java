package test;

import java.util.Scanner;
import java.util.Vector;

public class PointVectorEx {
        public static void main(String[] args) {
                    Scanner scanner = new Scanner(System.in);
                    Vector<String> v = new Vector<String>(); // ① 이름을 저장하는 Vector v 생성

                    while (true) {
                        System.out.print("이름 입력 (q 입력시 종료)>> ");
                        String name = scanner.next();
                        if (name.equals("q")) // ② "q" 입력시 무한반복을 벗어남
                            break;
                        v.add(name); // ③ 입력받은 이름을 vector에 추가
                        System.out.println(v);
                    }

                    // 가장 긴 이름 출력
                    int longestIndex = 0; // 현재 가장 긴 이름이 있는 Vector 내의 인덱스
                    for (int i = 1; i < v.size(); i++) {
                        if (v.get(i).length() > v.get(longestIndex).length()) // ④ 이름 길이 비교
                            longestIndex = i; // i 번째 이름이 더 긴 이름임
                    }
                    System.out.println("\n가장 긴 이름은 : " + v.get(longestIndex)); // ⑤ Vector에서 가장 긴 이름 출력
                    scanner.close();



        }

    }
//// Point 객체를 요소로만 가지는 벡터 생성
//        Vector<Point> v = new Vector<Point>();
//// 3 개의 Point 객체 삽입
//        v.add(new Point(2, 3));
//        v.add(new Point(-5, 20));
//        v.add(new Point(30, -8));
//        v.remove(1); // 인덱스 1의 Point(-5, 20) 객체 삭제
//// 벡터에 있는 Point 객체 모두 검색하여 출력
//        for(int i=0; i<v.size(); i++) {
//            Point p = v.get(i); // 벡터에서 i 번째 Point 객체 얻어내기
//            System.out.println(p); // p.toString()이 되는이유
//        }
//    }
