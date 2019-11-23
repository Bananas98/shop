package ua.nasirovd.ejb;

import ua.nasirovd.domain.Goods;
import ua.nasirovd.domain.GoodsInOrder;
import ua.nasirovd.domain.Order;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Stateless
@LocalBean
public class OrdersManagerBean {

    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;
    public Order createOrder(){
        Order order = new Order();
        entityManager.persist(order);
        return order;
    }
    public boolean addToOrder(long goodsId,long orderId,int quantity){
        Goods goods = entityManager.find(Goods.class, goodsId);
        if (goods == null){
            return false;
        }

        Order order = entityManager.find(Order.class, orderId);
        if (order == null){
            return false;
        }

        GoodsInOrder goodsInOrder = new GoodsInOrder();
        goodsInOrder.setOrder(order);
        goodsInOrder.setGoods(goods);
        goodsInOrder.setQuantity(quantity);
        entityManager.persist(goodsInOrder);

        return true;
    }

    public List<Goods> getGoodsInOrder(long orderId){
        Order order = entityManager.find(Order.class, orderId);
        if (order == null){
            return Collections.emptyList();
        }
        List<GoodsInOrder> goodsInOrders = order.getGoodsInOrders();
        List<Goods> result  = new ArrayList<>();
        for(GoodsInOrder goodsInOrder : goodsInOrders){
            result.add(goodsInOrder.getGoods());
        }
        return result;
    }
}
