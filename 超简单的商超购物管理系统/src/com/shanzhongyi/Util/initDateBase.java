package com.shanzhongyi.Util;

import com.shanzhongyi.Bean.Goods;
import com.shanzhongyi.Bean.SalePerson;

import java.util.ArrayList;
import java.util.List;

        /*
        *
        * 实现模拟(数据库初始化)
        * 对一些信息进行初始化
        *
        * */
public class initDateBase {

    //初始化商品
    public static List<Goods> initGoods() {

        List<Goods> goodsList = new ArrayList<>();

        Goods goods1 = new Goods();
        goods1.set("东瓜", 66, 44);
        goodsList.add(goods1);

        Goods goods2 = new Goods();
        goods2.set("西瓜", 66, 44);
        goodsList.add(goods2);

        Goods goods3 = new Goods();
        goods3.set("南瓜", 66, 44);
        goodsList.add(goods3);

        Goods goods4 = new Goods();
        goods4.set("北瓜", 66, 44);
        goodsList.add(goods4);

        return goodsList;
    }


    //初始化售货员信息
    public static List<SalePerson> initSalePerson(){

        List<SalePerson> salePersonList = new ArrayList<>();

        SalePerson salePerson = new SalePerson();
        salePerson.set("张三","山东","前台");
        salePersonList.add(salePerson);

        SalePerson salePerson1 = new SalePerson();
        salePerson1.set("李四","湖北","后台");
        salePersonList.add(salePerson1);

        SalePerson salePerson2 = new SalePerson();
        salePerson2.set("王五","湖南","食品区");
        salePersonList.add(salePerson2);

        SalePerson salePerson3 = new SalePerson();
        salePerson3.set("张三","山东","前台");
        salePersonList.add(salePerson3);

        return salePersonList;
    }

    //初始化售卖订单
    public static List<Goods> initSalegoodslist(){
        List<Goods> salegoodsList = new ArrayList<>();
        Goods goods =  new Goods();
        goods.set("测试商品",0,1);
        salegoodsList.add(goods);
        return salegoodsList;
    }
    
}
