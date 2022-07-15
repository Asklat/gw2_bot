/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.asklat.gw2_bot.Objects;

/**
 *
 * @author algam
 */
public class Item {
    private String id;
    private String name;
    private int count;
    private int countNeed;
    private int countTotal;

    //public Item(String id, String name, int count, int countNeed, int countTotal) {
    //    this.id = id;
    //    this.name = name;
    //    this.count = count;
    //    this.countNeed = countNeed;
    //    this.countTotal = countTotal;
    //}

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getCount() {
        return count;
    }
    public int getCountNeed() {
        return countNeed;
    }
    public int getCountTotal() {
        return countTotal;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public void setCountNeed(int countNeed) {
        this.countNeed = countNeed;
    }
    public void setCountTotal(int countTotal) {
        this.countTotal = countTotal;
    }    
}
