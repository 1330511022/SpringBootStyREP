package org.example.propertest;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.*;
@Component //声明该类为配置类
@ConfigurationProperties(prefix = "person") //批量注入配置属性
public class Person {
    private int id;
    private String name;
    private List hobby;
    private String[] family;
    private Map map;
    private Pet pet;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List getHobby() {
        return hobby;
    }

    public String[] getFamily() {
        return family;
    }

    public Map getMap() {
        return map;
    }

    public Pet getPet() {
        return pet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHobby(List hobby) {
        this.hobby = hobby;
    }

    public void setFamily(String[] family) {
        this.family = family;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", hobby=" + hobby +
                ", family=" + Arrays.toString(family) +
                ", map=" + map +
                ", pet=" + pet +
                '}';
    }
}
