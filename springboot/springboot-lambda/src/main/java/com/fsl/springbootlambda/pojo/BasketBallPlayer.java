package com.fsl.springbootlambda.pojo;

import java.util.Date;

public class BasketBallPlayer {

    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 所在球队
     */
    private String team;

    /**
     * 加入nba的日期
     */
    private Date  bornDate;

    /**
     * 场均得分
     */
    private Float score;

    /**
     * 场均篮板
     */
    private Float rebound;

    /**
     * 场均助攻
     */
    private Float assist;

    public BasketBallPlayer(Integer id,String name, Integer age, String team, Date bornDate, Float score, Float rebound, Float assist) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.team = team;
        this.bornDate = bornDate;
        this.score = score;
        this.rebound = rebound;
        this.assist = assist;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Float getRebound() {
        return rebound;
    }

    public void setRebound(Float rebound) {
        this.rebound = rebound;
    }

    public Float getAssist() {
        return assist;
    }

    public void setAssist(Float assist) {
        this.assist = assist;
    }
}
