package ua.nasirovd.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    @OneToMany(mappedBy = "order")
    private List<GoodsInOrder> goodsInOrders;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<GoodsInOrder> getGoodsInOrders() {
        return goodsInOrders;
    }

    public void setGoodsInOrders(List<GoodsInOrder> goodsInOrders) {
        this.goodsInOrders = goodsInOrders;
    }
}
