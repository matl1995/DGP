package es.ugr.redforest.museumsforeveryone.models;


import java.util.Date;

/**
 * Class containing all data from a guided visit
 *
 * @author Miguel Ángel Torres López
 * @version 1.0.0
 */

public class GuidedVisit {

    private int id;
    private String name;
    private String description;
    private Date dateOut;

    public GuidedVisit(int id, String name, String description, Date dateOut) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateOut = dateOut;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }
}
