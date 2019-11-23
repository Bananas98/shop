package ua.nasirovd;

import ua.nasirovd.domain.Goods;
import ua.nasirovd.domain.Order;
import ua.nasirovd.ejb.GoodsManagerBean;
import ua.nasirovd.ejb.OrdersManagerBean;

import javax.ejb.EJB;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Named
@SessionScoped
public class OrderBean implements Serializable {
    private Order order;
    private  String name;

    private int quantity;

    @EJB
    private OrdersManagerBean ordersManagerBean;

    @EJB
    private GoodsManagerBean goodsManagerBean;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void createOrder(){
        if (order == null){
            order  = ordersManagerBean.createOrder();
        }
    }

    public void createGoods(){
        goodsManagerBean.createGoods(name,quantity);
    }

    public List<Goods> getGoods(){
        return goodsManagerBean.getGoods();
    }

    public void addGoods(Goods goods){
        if (order == null){
            return;
        }
        ordersManagerBean.addToOrder(goods.getId(),order.getId(),0);
    }
    public List<Goods> getGoodsInOrder(){
        if (order == null){
            return Collections.emptyList();
        }
        return ordersManagerBean.getGoodsInOrder(order.getId());
    }
}
