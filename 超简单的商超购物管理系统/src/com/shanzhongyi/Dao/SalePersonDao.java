package com.shanzhongyi.Dao;

import com.shanzhongyi.Bean.SalePerson;

import java.util.List;
import java.util.Scanner;

public class SalePersonDao {


    //实现添加售货员功能：
    public static List<SalePerson> addSalePerson(List<SalePerson> salePersonlist){
        Scanner input = new Scanner(System.in);
        Boolean flag = false;
        do{
            System.out.println("请输入你想添加的售货员的名字：");
            String addSaleName = input.next();
            System.out.println("请输入你想添加的售货员的地址：");
            String addSaleAdress = input.next();
            System.out.println("请输入你想添加的售货员的职位：");
            String addSalepost = input.next();
            SalePerson salePerson= new SalePerson();
            salePerson.set(addSaleName,addSaleAdress,addSalepost);
            salePersonlist.add(salePerson);
            System.out.println("添加成功！！");
            System.out.println("请确认是否再次添加：Y/N");
            String a =input.next();
            if(a.equals("Y")||a.equals("y")){
                flag = true;
                System.out.println(flag);
            }
            else {
                flag = false;
                System.out.println(flag);
            }
        }while(flag);
        return salePersonlist;
    }

    //实现更新售货员工功能：
    public static List<SalePerson> updateSalePerson(List<SalePerson> salePersonlist){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入要修改的售货员的名字：");
        String Tom = input.next();
        for (int i = 0; i < salePersonlist.size();) {
            if((salePersonlist.get(i).getSalePersonName()).equals(Tom)) {
                System.out.println(salePersonlist.get(i).getSalePersonName());
                System.out.println(Tom);
                System.out.println("请输入你想修改的售货员的地址！：");
                String addSaleAdress = input.next();
                System.out.println("请输入你想修改的售货员的位置：：");
                String UpnSalepost = input.next();
                salePersonlist.get(i).set(Tom,addSaleAdress,UpnSalepost);
                System.out.println("修改成功！！");
                break;
            }
            else {
                i++;
                if(i>=salePersonlist.size()){
                    System.out.println("修改失败！！！");
                }
            }
        }
        return salePersonlist;
    }

    //实现删除售货员功能:
    public static List<SalePerson> delSalePerson(List<SalePerson> salePersonlist){
        salePersonlist.remove(salePersonlist.size()-1);
        return salePersonlist;
    }

    //实现显示所有售货员功能：
    public static void showSaleperson(List<SalePerson> salePersonlist){
        for(SalePerson salePerson:salePersonlist){
            System.out.println(salePerson);
        }
    }

    //实现售货员查询功能：
    public static void findOneSaleperson(List<SalePerson> salePersonlist){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入你想要查询的售货员的姓名：");
        String Tom1 = input.next();
        System.out.println("你要查询的商品名称是："+Tom1);
        for (int i = 0; i < salePersonlist.size(); ) {
            if((salePersonlist.get(i).getSalePersonName()).equals(Tom1)) {
                System.out.println("查询成功！！");
                System.out.println(Tom1+"的信息是："+salePersonlist.get(i).toString());
                break;
            }
            else {
                i++;
                if(i>=salePersonlist.size()){
                    System.out.println("查询失败！！！返回上一级目录\n\n");
                }
            }
        }
    }
    
}
