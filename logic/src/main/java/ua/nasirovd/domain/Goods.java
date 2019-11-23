package ua.nasirovd.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int quantity;//in a penny

    @OneToMany( fetch = FetchType.EAGER, mappedBy = "goods")
    private List<GoodsInOrder> goodsInOrders;

    public List<GoodsInOrder> getGoodsInOrders() {
        return goodsInOrders;
    }

    public void setGoodsInOrders(List<GoodsInOrder> goodsInOrders) {
        this.goodsInOrders = goodsInOrders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
