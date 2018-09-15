package com.example.qiaoxian.borrowbook;

public class Book {
    private String name;
    private int pic,readAge;
    private boolean history,suspense,art;
    private String type;

    public Book(String name, int pic, int readAge, boolean history, boolean suspense, boolean art,String type) {
        this.name = name;
        this.pic = pic;
        this.readAge = readAge;
        this.history = history;
        this.suspense = suspense;
        this.art = art;
        this.type = type;
    }

    public Book() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public int getReadAge() {
        return readAge;
    }

    public void setReadAge(int readAge) {
        this.readAge = readAge;
    }

    public boolean isHistory() {
        return history;
    }

    public void setHistory(boolean history) {
        this.history = history;
    }

    public boolean isSuspense() {
        return suspense;
    }

    public void setSuspense(boolean suspense) {
        this.suspense = suspense;
    }

    public boolean isArt() {
        return art;
    }

    public void setArt(boolean art) {
        this.art = art;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", pic=" + pic +
                ", readAge=" + readAge +
                ", history=" + history +
                ", suspense=" + suspense +
                ", art=" + art +
                ", type='" + type + '\'' +
                '}';
    }
}
