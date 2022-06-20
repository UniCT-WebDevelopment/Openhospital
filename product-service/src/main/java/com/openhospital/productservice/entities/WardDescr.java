package com.openhospital.productservice.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "WARD_DESCR", indexes = {
        @Index(name = "CONSTRAINT_INDEX_A", columnList = "WARD_CODE")
})
public class WardDescr {
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "WARD_CODE", nullable = false, referencedColumnName = "WARD_CODE")
    private Ward wardCode;

    @Column(name = "LANG", nullable = false, length = 2)
    private String lang;

    @Column(name = "DESCRIPTION", nullable = false, length = 100)
    private String description;

    @Column(name = "INFO", length = 100)
    private String info;

    @Column(name = "INSERT_TIMESTAMP", nullable = false)
    private Instant insertTimestamp;

    @Column(name = "UPDATE_TIMESTAMP", nullable = false)
    private Instant updateTimestamp;

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

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public Ward getWardCode() {
        return wardCode;
    }

    public void setWardCode(Ward wardCode) {
        this.wardCode = wardCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}