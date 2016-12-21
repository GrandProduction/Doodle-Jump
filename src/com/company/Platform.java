package com.company;

public abstract class Platform {

    protected int x, y;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRandomPlatformX(int a){
        setX((int)(Math.random() * a));
        return getX();
    }
    public int getRandomPlatformY(int a){
        setY((int)(Math.random() * a));
        return getY();
    }

}
