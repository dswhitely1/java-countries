package com.countries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
    private static final AtomicLong counter = new AtomicLong();
    private long id;
    private String name;
    private long population;
    private long size;
    private int age;

    public Country(String name, long population, long size, int age)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.size = size;
        this.age = age;
    }

    public Country(Country toClone)
    {
        this.id = toClone.getId();
        this.name = toClone.getName();
        this.population = toClone.getPopulation();
        this.size = toClone.getSize();
        this.age = toClone.getAge();
    }

    public long getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public String getFirstLetterName()
    {
        return name.substring(0,0);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public long getPopulation()
    {
        return population;
    }

    public void setPopulation(long population)
    {
        this.population = population;
    }

    public long getSize()
    {
        return size;
    }

    public void setSize(long size)
    {
        this.size = size;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Country{" + "id=" + id + ", name='" + name + '\'' + ", population=" + population + ", size=" + size + ", age=" + age + '}';
    }
}
