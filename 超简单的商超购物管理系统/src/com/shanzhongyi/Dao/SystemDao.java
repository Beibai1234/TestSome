package com.shanzhongyi.Dao;

public class SystemDao {


    //显示主目录：
    public static void ShowMenu(){
        System.out.println("****************************************");
        System.out.println("\t\t1.商品维护");
        System.out.println("\t\t2.前台收银");
        System.out.println("\t\t3.商品管理");
        System.out.println("\t\t4.售货员管理");
        System.out.println("*****************************************");
    }

    //显示商品管理目录：
    public static void ShowGoodsMenu(){
        System.out.println("\n\n****************************************");
        System.out.printf("ִ欢迎来到商品维护界面：\n");
        System.out.println("\t\t1.商品添加");
        System.out.println("\t\t2.商品更改");
        System.out.println("\t\t3.商品删除");
        System.out.println("\t\t4.商品列表显示");
        System.out.println("\t\t5.商品查询");
        System.out.println("****************************************");
        System.out.println("请输入你的选择：\n");
    }

    //显示售货员目录：
    public static void ShowSalePersonMenu(){
        System.out.println("\n\n*****************************");
        System.out.println("欢迎来到售货员管理界面！");
        System.out.println("\t\t1.添加售货员");
        System.out.println("\t\t2.更改售货员");
        System.out.println("\t\t3.删除售货员");
        System.out.println("\t\t4.显示所有售货员");
        System.out.println("\t\t5.查询售货员");
        System.out.println("*****************************************");
        System.out.println("请输入你的选择：\n");
    }
}
