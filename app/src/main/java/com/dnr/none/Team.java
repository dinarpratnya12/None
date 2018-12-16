package com.dnr.none;

public class Team {

    private String Title;
    private String Coach ;
    private String Description ;
    private int Thumbnail ;

    public Team(){

    }

    public Team(String title, String coach, String description, int thumbnail){
        Title = title;
        Coach = coach;
        Description = description;
        Thumbnail = thumbnail;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCoach() {
        return Coach;
    }

    public void setCoach(String coach) {
        Coach = coach;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getThumbnail() {
        return Thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        Thumbnail = thumbnail;
    }
}
