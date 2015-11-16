package fancyfoods.persistence;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

import fancyfoods.food.FoodRepository;

public class RepositoryPopulator implements RepositoryPopulatorMBean
{
    FoodRepository repository;

    // @Transaction(TransactionPropagationType.Required)
    public void populate()
    {
        try
        {
            repository.initData();
            // repository.createFood("Blue cheese", 3.45, 10);
            // repository.createFood("Wensleydale cheese", 1.81, 15);
            // repository.createFood("Normal chocolates", 6.99, 8);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public FoodRepository getRepository()
    {
        return repository;
    }

    public void setRepository(FoodRepository repository)
    {
        this.repository = repository;
    }

    public void registerBean()
    {
        String objectName = "RepositoryPopulator:type=RepositoryPopulator";

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        // Construct the ObjectName for the Hello MBean we will register
        // and register it with the server
        ObjectName mbeanName;
        try
        {
            mbeanName = new ObjectName(objectName);
            server.registerMBean(this, mbeanName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    public void unregisterBean()
    {
        String objectName = "RepositoryPopulator:type=RepositoryPopulator";

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        ObjectName mbeanName;
        try
        {
            mbeanName = new ObjectName(objectName);
            server.unregisterMBean(mbeanName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
