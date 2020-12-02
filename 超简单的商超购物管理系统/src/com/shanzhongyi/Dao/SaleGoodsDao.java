package com.shanzhongyi.Dao;

import com.shanzhongyi.Bean.Goods;
import com.shanzhongyi.Bean.User;

import java.util.List;
import java.util.Scanner;

public class SaleGoodsDao {

    //实现用户结算功能
    public static void jiesuan(List<Goods> goodslist,List<Goods> salegoodslist){
        System.out.println("\n\n*****************************");
        User user1 = new User();
        System.out.printf("ִ欢迎来到前台收银界面：\n");
        System.out.printf("请首先登陆！！\n");
        Scanner input = new Scanner(System.in);
        UserDao dao = new UserDao();
        int n = 0;
        while (n < 3) {
            System.out.println("请输入你的账号：");
            user1.setUsername(input.next());
            System.out.println("请输入你的密码：");
            user1.setPassword(input.next());
            if (dao.check(user1)) {
                System.out.println("登录成功！");
                break;
            }
            n++;
            System.out.println("账号密码错误！当前还剩余" + (3 - n) + "次机会！");
        }
        if (n >= 3) {
            System.out.println("登录失败！你被强制退出系统！！！");
            return;
        }
        System.out.println("Hello!!!");
        boolean flag = true;
        do {
            System.out.println("请输入要加入购物车的商品的名字：\n\n");
            String Tom = input.next();
            for (int i = 0; i < goodslist.size(); ) {
                if ((goodslist.get(i).getGoodsName()).equals(Tom)) {
                    System.out.println(goodslist.get(i).getGoodsName());
                    System.out.println(Tom);
                    int Upnum = 0;
                    do {
                        System.out.println("当前商场中有"+goodslist.get(i).getGoodsNum()+"库存！");
                        System.out.println("请输入你想添加到购物车的菜品数量！：");
                        int addNums = input.nextInt();
                        if (addNums > goodslist.get(i).getGoodsNum()) {
                            System.out.println("您输入的数据有错误请重新输入！！！");
                        }
                        goodslist.get(i).setGoodsNum((goodslist.get(i).getGoodsNum()-addNums));
                        Upnum = addNums;
                        System.out.println("Upnum=="+Upnum+":  addNums"+addNums);
                    } while (Upnum > goodslist.get(i).getGoodsNum()+Upnum);
                    System.out.println("您购物车中的菜品是：");
                    Goods goods = new Goods();
                    goods.set(Tom,goodslist.get(i).getGoodsPrice(),Upnum);
                    salegoodslist.add(goods);
                    for(Goods goods1:salegoodslist){
                        System.out.println(goods1);
                    }
                    break;
                } else {
                    i++;
                    if (i >= goodslist.size()) {
                        System.out.println("查询失败！！！");
                    }
                }
            }
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
        System.out.println("进行结算：");
        float Totle = 0;
        for(int i = 0; i < salegoodslist.size(); i++){
            Totle = (salegoodslist.get(i).getGoodsPrice())*(salegoodslist.get(i).getGoodsNum())+Totle;
        }
        System.out.println("当前您的消费是："+Totle+"元!");
        float Money = 0;
        do {
            System.out.println("请输入您要付的金钱：");
            Money = input.nextFloat();
            if (Money < Totle) {
                System.out.println("钱不够！请重新输入！！");
            }
            else{
                System.out.println("消费成功！找零"+(Money-Totle)+"元！");
                System.out.println("欢迎下次光临！！");
                return;
            }
        }while (Money<Totle);
    }

    //实现显示售卖订单
    public static void showSalegoods(List<Goods> salegoodslist){
        for(Goods goods:salegoodslist){
            System.out.println(goods);
        }
    }


}
