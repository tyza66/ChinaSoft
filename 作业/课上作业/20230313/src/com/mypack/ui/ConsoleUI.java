package com.mypack.ui;

import com.mypack.entity.Person;
import com.mypack.entity.sub.Student;
import com.mypack.entity.sub.Teacher;
import com.mypack.service.PeopleManagement;

import java.util.Scanner;

public class ConsoleUI {
    PeopleManagement peopleManagement = new PeopleManagement();

    public void showUI() {
        boolean run = true;
        Scanner input = new Scanner(System.in);
        int now = 0;
        PeopleManagement peopleManagement = new PeopleManagement();
        while (run) {
            System.out.println("********超级人员管理系统********");
            System.out.println("*(1)保存新学生信息");
            System.out.println("*(2)保存新教师信息");
            System.out.println("*(3)查询人员信息");
            System.out.println("*(4)查询所有人");
            System.out.println("*(5)删除某人信息");
            System.out.println("*(6)修改某人员信息");
            System.out.println("*(0)退出系统");
            System.out.println("********输入对应序号选择********");
            now = input.nextInt();
            switch (now) {
                case 1:
                    System.out.print("请输入需要用到的参数们：");
                    int id = input.nextInt();
                    String name = input.next();
                    int sid = input.nextInt();
                    int grade = input.nextInt();
                    peopleManagement.addOne(new Student(id,name,sid,grade));
                    break;
                case 2:
                    System.out.print("请输入需要用到的参数们：");
                    int id2 = input.nextInt();
                    String name2 = input.next();
                    int money = input.nextInt();
                    String statu = input.next();
                    peopleManagement.addOne(new Teacher(id2,name2,money,statu));
                    break;
                case 3:
                    System.out.print("请输入需想要查找人的id：");
                    int findId = input.nextInt();
                    peopleManagement.queryOne(findId);
                    break;
                case 4:
                    peopleManagement.queryAll();
                    System.out.println();
                    break;
                case 5:
                    System.out.print("请输入需要删除人的id：");
                    int deleteId = input.nextInt();
                    peopleManagement.deleteOne(deleteId);
                    System.out.println("删除成功");
                    break;
                case 6:
                    System.out.print("请输入需要修改人的id和要修改的名字：");
                    int updateId = input.nextInt();
                    String updateName = input.next();
                    peopleManagement.update(updateId,updateName);
                    System.out.println("修改成功");
                    break;
                default:
                    run = false;
            }
            System.out.println("----------------------------");
        }
    }
}
