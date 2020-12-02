package com.shanzhongyi.View;
import com.shanzhongyi.Bean.Goods;
import com.shanzhongyi.Bean.SalePerson;
import com.shanzhongyi.Dao.GoodsDao;
import com.shanzhongyi.Dao.SaleGoodsDao;
import com.shanzhongyi.Dao.SalePersonDao;
import com.shanzhongyi.Dao.SystemDao;
import com.shanzhongyi.Util.initDateBase;

import java.util.List;
import java.util.Scanner;

public class IndexPage {
    public static void main(String[] args) {
        List<Goods> goodslist = initDateBase.initGoods();
        List<SalePerson> salePersonlist = initDateBase.initSalePerson();
        List<Goods> salegoodslist = initDateBase.initSalegoodslist();
        mainMenu(goodslist,salePersonlist,salegoodslist);
    }

    //进入系统之后的主目录：
    public static void mainMenu(List<Goods> goodslist,List<SalePerson> salePersonlist,List<Goods> salegoodslist) {
        SystemDao.ShowMenu();
        System.out.println("请输入你的选择：\n");
        Scanner input = new Scanner(System.in);
        boolean con = false;
        do {
            int num = input.nextInt();
            switch (num) {
                case 0:
                    System.out.println("成功退出系统！！\n\n");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("ִ您进入了商品维护界面：\n\n");
                    mainMenu01(goodslist,salePersonlist,salegoodslist);
                    break;
                case 2:
                    System.out.println("ִ您进入了前台收银界面:\n\n");
                    mainMenu02(goodslist,salegoodslist);
                    break;
                case 3:
                    System.out.println("ִ您进入了商品管理界面：\n\n");
                    mainMenu03(goodslist,salePersonlist,salegoodslist);
                    break;
                case 4:
                    System.out.println("ִ您进入了售货员管理界面：\n\n");
                    mainMenu04(goodslist,salePersonlist,salegoodslist);
                    break;
                default:
                    System.out.println("您输入了错误的选择，请重新输入：\n");
                    con = true;
                    break;
            }
        } while (con);

        input.close();
    }

    //商品维护目录:
    public static void mainMenu01(List<Goods> goodslist, List<SalePerson> salePersonlist,List<Goods> salegoodslist){
           SystemDao.ShowGoodsMenu();
        Scanner input = new Scanner(System.in);
        boolean con = false;
        do {
            int num = input.nextInt();
            switch (num) {
                case 0:
                    System.out.println("返回上一级目录！！\n\n");
                    mainMenu(goodslist,salePersonlist,salegoodslist);
                    break;
                case 1:
                    goodslist = GoodsDao.insertGoods(goodslist);
                    mainMenu01(goodslist,salePersonlist,salegoodslist);
                    break;
                case 2:
                    System.out.println("您进入了商品更改界面:\n\n");
                    goodslist = GoodsDao.UpdateGoods(goodslist,salePersonlist,salegoodslist);
                    mainMenu01(goodslist,salePersonlist,salegoodslist);
                    break;
                case 3:
                    System.out.println("您进入了商品删除界面：\n\n");
                    System.out.println(goodslist.get(goodslist.size()-1).getGoodsName());
                    goodslist.remove(goodslist.size()-1);
                    mainMenu01(goodslist,salePersonlist,salegoodslist);
                    break;
                case 4:
                    System.out.println("您进入了商品列表显示界面：\n\n");
                    for(Goods goods1:goodslist)
                        System.out.println(goods1);
                    mainMenu01(goodslist,salePersonlist,salegoodslist);
                    break;
                case 5:
                    System.out.println("您进入了商品查询界面:\n\n");
                    GoodsDao.findGoods(goodslist);
                    mainMenu01(goodslist,salePersonlist,salegoodslist);
                    break;
                default:
                    System.out.println("您输入了错误的选择，请重新输入：\n");
                    con = true;
                    break;
            }
        } while (con);
        input.close();
    }

    //前台收银目录:
    public static void mainMenu02(List<Goods> goodslist, List<Goods> salegoodslist) {
        SaleGoodsDao.jiesuan(goodslist,salegoodslist);
    }

    //商品管理目录:
    public static void mainMenu03(List<Goods> goodslist, List<SalePerson> salePersonlist,List<Goods> salegoodslist) {
        System.out.println("\n\n*****************************");
        System.out.println("欢迎来到商品管理界面");
        System.out.println("今天卖出的物品有：");
        SaleGoodsDao.showSalegoods(salegoodslist);
     mainMenu(goodslist,salePersonlist,salegoodslist);
    }

    //售货员管理目录：
    public static void mainMenu04(List<Goods> goodslist, List<SalePerson> salePersonlist,List<Goods> salegoodslist) {
        SystemDao.ShowSalePersonMenu();
        Scanner input = new Scanner(System.in);
        boolean con = false;
        do {
            int num = input.nextInt();
            switch (num) {
                case 0:
                    System.out.println("返回上一级目录！！\n\n");
                    mainMenu(goodslist,salePersonlist,salegoodslist);
                    break;
                case 1:
                    System.out.println("\n\n**************************");
                    System.out.println("ִ您进入了添加售货员界面：\n\n");
                    salePersonlist = SalePersonDao.addSalePerson(salePersonlist);
                    mainMenu04(goodslist,salePersonlist,salegoodslist);
                    break;
                case 2:
                    System.out.println("\n\n**************************");
                    System.out.println("ִ您进入了更改售货员界面:");
                    salePersonlist =SalePersonDao.updateSalePerson(salePersonlist);
                    mainMenu04(goodslist,salePersonlist,salegoodslist);
                    break;
                case 3:
                    System.out.println("\n\n**************************");
                    System.out.println("ִ您进入了删除售货员界面：\n\n");
                    salePersonlist = SalePersonDao.delSalePerson(salePersonlist);
                    mainMenu04(goodslist,salePersonlist,salegoodslist);
                    break;
                case 4:
                    System.out.println("\n\n**************************");
                    System.out.println("ִ您进入了显示所有售货员界面：\n\n");
                    SalePersonDao.showSaleperson(salePersonlist);
                    mainMenu04(goodslist,salePersonlist,salegoodslist);
                    break;
                case 5:
                    System.out.println("\n\n**************************");
                    System.out.println("ִ您进入了查询售货员界面：\n\n");
                    SalePersonDao.findOneSaleperson(salePersonlist);
                    mainMenu04(goodslist,salePersonlist,salegoodslist);
                    break;
                default:
                    System.out.println("\n\n**************************");
                    System.out.println("您输入了错误的选择，请重新输入：\n");
                    con = true;
                    break;
            }
        } while (con);
        input.close();
    }

}
