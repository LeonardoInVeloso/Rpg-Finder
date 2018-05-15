package classes;

import android.media.Image;

import java.time.LocalDateTime;

/**
 * Created by 318005 on 10/05/2018.
 */

public class Board {
    private int id;
    private String name;
    private int banner;
    private int icon;
    private String system;
    private String scenary;
    private String sessionDay;
    private String summary;
    private double rating;
    private String local;
    private boolean publicLocal;
    private LocalDateTime created;
    private int limitPeople;
    private int sessions;
    private int masterId;
    private boolean active;
    private boolean female;
    private boolean children;
    private boolean begginer;

    public Board(int id, String name, int banner, int icon, String system, String scenary, String sessionDay, String summary, int rating, String local, boolean publicLocal, LocalDateTime created, int limitPeople, int sessions, int masterId, boolean active, boolean female, boolean children, boolean begginer) {
        this.id = id;
        this.name = name;
        this.banner = banner;
        this.icon = icon;
        this.system = system;
        this.scenary = scenary;
        this.sessionDay = sessionDay;
        this.summary = summary;
        this.rating = rating;
        this.local = local;
        this.publicLocal = publicLocal;
        this.created = created;
        this.limitPeople = limitPeople;
        this.sessions = sessions;
        this.masterId = masterId;
        this.active = active;
        this.female = female;
        this.children = children;
        this.begginer = begginer;
    }

    public Board(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBanner() {
        return banner;
    }

    public void setBanner(int banner) {
        this.banner = banner;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getScenary() {
        return scenary;
    }

    public void setScenary(String scenary) {
        this.scenary = scenary;
    }

    public String getSessionDay() {
        return sessionDay;
    }

    public void setSessionDay(String sessionDay) {
        this.sessionDay = sessionDay;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        summary = summary;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public boolean isPublicLocal() {
        return publicLocal;
    }

    public void setPublicLocal(boolean publicLocal) {
        this.publicLocal = publicLocal;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public int getLimitPeople() {
        return limitPeople;
    }

    public void setLimitPeople(int limitPeople) {
        this.limitPeople = limitPeople;
    }

    public int getSessions() {
        return sessions;
    }

    public void setSessions(int sessions) {
        this.sessions = sessions;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isFemale() {
        return female;
    }

    public void setFemale(boolean female) {
        this.female = female;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public boolean isBegginer() {
        return begginer;
    }

    public void setBegginer(boolean begginer) {
        this.begginer = begginer;
    }
}
