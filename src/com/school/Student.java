package com.school;

public class Student {

    public int studentId;
    public String name;
    public String major;
    public String phoneNumber;

    public Student(int studentId, String name, String major, String phoneNumber) {

        this.studentId = studentId;
        this.name = name;
        this.major = major;
        this.phoneNumber = phoneNumber;
    }





    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId){
        this.studentId = studentId;
        }
    public String getName(){
        return name;
        }

    public void setName(String name) {
        this.name = name;
    }

    public String getMajor(){
        return major;

        }
    public void setMajor(String major){
        this.major = major;
        }


    public String getPhoneNumber(){
       return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


    public String toString() {
        return "학번:" + studentId + "\n" +
               "이름:" + name + "\n"+
                "학과:" + major + "\n"+
                "전화번호:" + phoneNumber +"\n"+
                "--------------------------------";
    }
    }






