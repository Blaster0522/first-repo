    package com.school;

    import java.util.ArrayList;
    import java.util.InputMismatchException;
    import java.util.Scanner;
    import java.util.regex.Pattern;

    public class StudentMain {
        public ArrayList<Student> students;
        public Scanner scanner;


        public static void main(String[] args) {
            StudentMain student = new StudentMain();
            student.run();


        }

        public StudentMain() {
            students = new ArrayList<>();
            scanner = new Scanner(System.in);

        }

        public void run() {
            int num1 = 0;
            while (true) {
                try {
                    System.out.print("학생 수 입력" + ":");
                    num1 = scanner.nextInt();
                    scanner.nextLine(); // 버퍼를 비웁니다.

                    if (num1 == 3) {
                        break;
                    } else {
                        System.out.println("유효하지 않습니다."); //학생수를 3 이외의 다른 수를 입력했을때 나타납니다.
                    }
                } catch (InputMismatchException e) {
                    System.out.println("숫자를 입력하세요.");
                    scanner.nextLine();
                }

            }


            while (true) {
                System.out.println("**** 학생 관리 프로그램**** ");
                System.out.println("1.학생 등록");
                System.out.println("2.전체 출력");
                System.out.println("3.학생 조회");
                System.out.println("4.정보 수정");
                System.out.println("5.프로그램 종료");

                int num2 = 0;
                while (true) {
                    System.out.print("관리번호를 입력하세요:");

                    num2 = scanner.nextInt();
                    scanner.nextLine(); //버퍼를 비웁니다.
                    System.out.println("----------------------");

                    if (num2 >= 1 && num2 <= 5) {
                        break;
                    } else {
                        System.out.println("유효하지 않은 관리번호입니다.");//관리번호는 1~5사이의 숫자만 입력해서 매서드가 올바르게 실행됩니다.


                    }
                }


                switch (num2) {
                    case 1:
                        if (students.size() < 3) {
                            registerStudent();
                        } else {
                            System.out.println("학생 등록이 완료되었습니다. 더 이상 등록할 수 없습니다.");
                        }
                        break;
                    case 2:
                        listAllStudent();
                        break;
                    case 3:
                        searchStudent();
                        break;
                    case 4:
                        updateStudent();
                        break;
                    case 5:
                        while (true) {
                            System.out.println("프로그램을 종료하시겠습니까?");
                            String choice = scanner.nextLine().toLowerCase();
                            if (choice.equals("y")) {
                                System.out.println("프로그램을 종료합니다.");
                                return;
                            } else if (choice.equals("n")) {
                                System.out.println("프로그램 종료를 취소합니다.");
                                break;
                            } else {
                                System.out.println("유효하지 않은 선택입니다.");

                            }
                        }


                }


            }

        }

        public void registerStudent() {
            for (int i = 0; i < 3; i++) {
                System.out.println("[학생을 등록합니다]");

                int studentId;
                while (true) {
                    System.out.print("학번 입력:");
                    studentId = Integer.parseInt(scanner.nextLine());

                    if (String.valueOf(studentId).length() == 8) {
                        boolean duplicate = false;
                        for (Student student : students) {
                            if (student.getStudentId() == studentId) {
                                System.out.println("동일한 학번입니다. 다시 입력하세요.");
                                duplicate = true;
                                break;
                            }
                        }
                        if (!duplicate) {
                            break; //
                        }
                    } else {
                        System.out.println("학번은 8자리 숫자여야 합니다.");
                    }
                }


                String name;
                while (true) {
                    System.out.print("이  름 입력:");
                    name = scanner.nextLine();
                    if (name.matches("[가-힣]+")) {
                        break;
                    } else {
                        System.out.println("다시 입력하세요.");
                    }
                }



                String major;
                while (true) {
                    System.out.print("학  과 입력:");
                    major = scanner.nextLine();
                    if (major.matches( "[가-힣]+")) {
                        break;
                    } else {
                        System.out.println("다시 입력하세요.");
                    }
                }

                // Validate phone number format
                String phoneNumber;
                while (true) {
                    System.out.print("전화번호 입력:");
                    phoneNumber = scanner.nextLine();
                    if (phoneNumber.matches("\\d{3}-\\d{4}-\\d{4}")) {
                        break;
                    } else {
                        System.out.println("전화번호 형식이 올바르지 않습니다.");
                    }
                }

                // Add student to the list
                students.add(new Student(studentId, name, major, phoneNumber));
                System.out.println("----------------------");
            }
        }


        public void listAllStudent() {
            System.out.println("=====전체학생출력=====");
            for (Student student : students) {
                System.out.println(student);
            }
        }


        public void searchStudent() {

            System.out.println("[학생을 조회합니다]");

            System.out.print("학번을 입력하십시오:");
            int studentId = Integer.parseInt(scanner.nextLine());

            boolean found = false; // 일치하는 학번이 있는지 알아봅니다.

            for (Student student : students) {
                if (student.getStudentId() == studentId) {
                    System.out.println(student);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("등록되지 않은 학번입니다."); // 등록된 학번과 일치하지 않으면 출력됩니다.
            }
        }





        public void updateStudent() {
            System.out.println("[학생 정보를 수정합니다]");
            System.out.print("학번을 입력하십시오. :");
            int studentId = Integer.parseInt(scanner.nextLine());

            boolean studentFound = false; // flag 변수를 통해 해당 학생이 등록되어 있는지 확인합니다.

            for (Student student : students) {
                if (student.getStudentId() == studentId) {
                    System.out.print("이   름 입력:");
                    student.setName(scanner.nextLine());
                    System.out.print("학   과 입력:");
                    student.setMajor(scanner.nextLine());
                    System.out.print("전화번호 입력:");
                    student.setPhoneNumber(scanner.nextLine());
                    System.out.println("학생 정보가 수정되었습니다.");
                    studentFound = true; // 수정할 학생 정보를 찾았으니 flag 변수값을 true로 바꿉니다.
                    break;
                }
            }

            if (!studentFound) { // 일치하는 학번이 없는 경우 실행됩니다.
                System.out.println("등록되지 않은 학번입니다.");
            }
        }

    }




















