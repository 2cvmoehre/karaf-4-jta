package fancyfoods.persistence;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import fancyfoods.food.Food;
import fancyfoods.food.FoodRepository;
import fancyfoods.persistence2.CustomerImpl;

public class FoodRepositoryImpl implements FoodRepository
{

    @PersistenceContext(unitName = "fancyfoods")
    private EntityManager entityManager;

    private EntityManagerFactory entityManagerFactory;

    @Override
    public Food getFood(String name)
    {
        return entityManager.find(FoodImpl.class, name);
    }

    @Override
    public List<Food> getFoodsWhoseNameContains(String name, int maxResults)
    {
        String query = "SELECT f FROM FOOD f WHERE f.name LIKE '%" + name
                + "%' ORDER BY f.quantity DESC";
        Query q = entityManager.createQuery(query);
        q.setMaxResults(maxResults);
        @SuppressWarnings("unchecked")
        List<Food> list = q.getResultList();
        return list;
    }

    @Override
    // @Transaction(TransactionPropagationType.Mandatory)
    public void createFood(String name, double price, int quantity)
    {
        FoodImpl food = new FoodImpl();
        food.setUuid(UUID.randomUUID().toString());
        food.setName(name);
        food.setPrice(price);
        food.setQuantityInStock(quantity);
        entityManager.persist(food);
    }

    public void createCustomer(String name, int creditLimit, double balance)
    {
        CustomerImpl customer = new CustomerImpl();
        // customer.setUuid(UUID.randomUUID().toString());
        customer.setBalance(balance);
        customer.setCreditLimit(creditLimit);
        customer.setName(name);
        entityManager.persist(customer);
    }

    @Override
    public int removeStock(String name, int quantity)
    {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int getFoodCount()
    {
        Query query = entityManager.createQuery("SELECT COUNT(f) FROM FOOD f");
        Number count = (Number) query.getSingleResult();
        return count.intValue();
    }

    public EntityManager getEntityManager()
    {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    public EntityManagerFactory getEntityManagerFactory()
    {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(
            EntityManagerFactory entityManagerFactory)
    {
        this.entityManagerFactory = entityManagerFactory;
    }

    public void initData()
    {
        createFood("Blue cheese", 3.45, 10);
        createFood("Wensleydale cheese", 1.81, 15);
        createFood("Normal chocolates", 6.99, 8);

        createCustomer("test", 100, 100d);
    }
}
