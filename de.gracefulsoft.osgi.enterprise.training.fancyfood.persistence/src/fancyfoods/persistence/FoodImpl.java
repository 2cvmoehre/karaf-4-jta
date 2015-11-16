package fancyfoods.persistence;

import javax.persistence.Entity;
import javax.persistence.Table;

import fancyfoods.food.Food;
import fancyfoods.food.Resource;

@Entity
@Table(name = "FOOD")
public class FoodImpl extends Resource implements Food
// public class FoodImpl implements Food
{
    // @Id
    // private String name;
    private double price;
    private int quantityInStock;

    @Override
    public double getPrice()
    {
        return price;
    }

    @Override
    public int getQuantityInStock()
    {
        return quantityInStock;
    }

    // @Override
    // public String getName()
    // {
    // return name;
    // }
    //
    // public void setName(String name)
    // {
    // this.name = name;
    // }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setQuantityInStock(int quantityInStock)
    {
        this.quantityInStock = quantityInStock;
    }

}
