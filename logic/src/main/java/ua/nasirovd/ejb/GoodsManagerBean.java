package ua.nasirovd.ejb;

import ua.nasirovd.domain.Goods;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
@LocalBean
public class GoodsManagerBean {
    @PersistenceContext(unitName = "examplePU")
    private EntityManager entityManager;

    public Goods createGoods(String name, int price) {
        Goods good = new Goods();
        good.setName(name);
        good.setQuantity(price);
        entityManager.persist(good);
        return good;
    }

    public List<Goods> getGoods(){
        TypedQuery<Goods> query = entityManager.createQuery("select c from Order c",Goods.class );
        return query.getResultList();
    }
}
