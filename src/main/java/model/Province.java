package model;

public class Province {
    protected int id;
    protected String name_province;

    public Province() {
    }

    public Province(int id, String name_province) {
        this.id = id;
        this.name_province = name_province;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName_province() {
        return name_province;
    }

    public void setName_province(String name_province) {
        this.name_province = name_province;
    }
}
