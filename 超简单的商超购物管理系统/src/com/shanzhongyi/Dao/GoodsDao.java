package com.shanzhongyi.Dao;

import com.shanzhongyi.Bean.Goods;
import com.shanzhongyi.Bean.SalePerson;
import com.shanzhongyi.View.IndexPage;

import java.util.List;
import java.util.Scanner;

public class GoodsDao {

    //实现商品添加功能：
    public static List<Goods> insertGoods(List<Goods> goodslist){
        Scanner input = new Scanner(System.in);
        System.out.println("ִ您进入了商品添加界面：\n\n");
        Boolean flag = false;
        do {
            System.out.println("请输入你想添加的菜品的名字：");
            String addName = input.next();
            float addPrices = 0;
            do {
                System.out.println("请输入你想添加的菜品的价格：");
                float addPrice = input.nextFloat();
                if (addPrice <= 0) {
                    System.out.println("您输入的数据有错误请重新输入！！！");
                }
                addPrices = addPrice;
            } while (addPrices <= 0);

            int addNums = 0;
            do {
                System.out.println("请输入你想添加的菜品的数量：");
                int addNum = input.nextInt();
                if (addNum <= 0) {
                    System.out.println("您输入的数据有错误请重新输入！！！");
                }
                addNums = addNum;
            } while (addNums <= 0);
            Goods goods = new Goods();
            goods.set(addName, addPrices, addNums);
            goodslist.add(goods);
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

        return goodslist;

    }


    //实现商品的修改功能：
    public static List<Goods> UpdateGoods(List<Goods> goodslist, List<SalePerson> salePersonlist, List<Goods> salegoodslist) {
        Scanner input = new Scanner(System.in);
        System.out.println("您进入了商品更改界面:\n\n");
        System.out.println("请输入要修改的商品名字：\n\n");
        String Tom = input.next();
        for (int i = 0; i < goodslist.size();) {
            if((goodslist.get(i).getGoodsName()).equals(Tom)) {
                System.out.println(goodslist.get(i).getGoodsName());
                System.out.println(Tom);
                int Upnum = 0;
                do {
                    System.out.println("请输入你想更改的菜品的数量！：");
                    int addNums = input.nextInt();
                    if (addNums <= 0) {
                        System.out.println("您输入的数据有错误请重新输入！！！");
                    }
                    Upnum = addNums;
                } while (Upnum <= 0);

                int UpnPrice = 0;
                do {
                    System.out.println("请输入你更改的菜品的价格：");
                    int UpnPrices = input.nextInt();
                    if (UpnPrices <= 0) {
                        System.out.println("您输入的数据有错误请重新输入！！！");
                    }
                    UpnPrice = UpnPrices;
                } while (UpnPrice <= 0);
                goodslist.get(i).set(Tom,UpnPrice,Upnum);
                System.out.println("修改成功！！");
                IndexPage.mainMenu01(goodslist,salePersonlist,salegoodslist);
                break;
            }
            else {
                i++;
                if(i>=goodslist.size()){
                    System.out.println("修改失败！！！");
                }
            }
        }
        return goodslist;
    }


    //实现商品的查询功能：
    public static void findGoods(List<Goods> goodslist){
        System.out.println("请输入你想要查询的商品的名称：");
        Scanner input = new Scanner(System.in);
        String Tom1 = input.next();
        System.out.println("你要查询的商品名称是："+Tom1);
        for (int i = 0; i < goodslist.size(); ) {
            if(goodslist.get(i).getGoodsName().equals(Tom1)) {
                System.out.println("查询成功！！");
                System.out.println("北瓜的信息是："+goodslist.get(i).toString());
                break;
            }
            else {
                i++;
                if(i>=goodslist.size()){
                    System.out.println("查询失败！！！返回上一级目录\n\n");
                }
            }
        }
    }
}
