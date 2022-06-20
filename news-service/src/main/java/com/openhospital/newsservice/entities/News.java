package com.openhospital.newsservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "NEWS")
public class News {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "LANG", nullable = false, length = 2)
    private String lang;

    @Column(name = "INSTITUTION", nullable = false, length = 50)
    private String institution;

    @Column(name = "INSTITUTION_IMAGE", nullable = false, length = 50)
    private String institutionImage;

    @Column(name = "TITLE", nullable = false, length = 100)
    private String title;

    @Column(name = "SHORT_DESCRIPTION", nullable = false, length = 300)
    private String shortDescription;

    @Column(name = "DESCRIPTION", nullable = false, length = 1500)
    private String description;

    @Column(name = "IMAGE", nullable = false, length = 500)
    private String image;

    @Column(name = "LINK", nullable = false, length = 500)
    private String link;

    @Column(name = "CLICKABLE", nullable = false)
    private Boolean clickable = false;

    @Column(name = "INSERT_TIMESTAMP", nullable = false)
    private Instant insertTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

    @Column(name = "ENABLED", nullable = false)
    private Boolean enabled = false;

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Instant getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Instant updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    public Instant getInsertTimestamp() {
        return insertTimestamp;
    }

    public void setInsertTimestamp(Instant insertTimestamp) {
        this.insertTimestamp = insertTimestamp;
    }

    public Boolean getClickable() {
        return clickable;
    }

    public void setClickable(Boolean clickable) {
        this.clickable = clickable;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInstitutionImage() {
        return institutionImage;
    }

    public void setInstitutionImage(String institutionImage) {
        this.institutionImage = institutionImage;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}