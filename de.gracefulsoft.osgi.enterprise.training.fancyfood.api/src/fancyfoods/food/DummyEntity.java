package fancyfoods.food;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DUMMY")
public class DummyEntity extends Resource
{
    protected String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
