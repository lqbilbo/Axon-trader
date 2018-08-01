package org.axonframework.samples.trader.query.kds;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;

@Entity
public class ServeryView {

    @Id
    @javax.persistence.Id
    private String identifier;
    private String stallIdentifier;
    private int seq;
    private String requirement;
    private long poiId;
    private String name;
    private String remark;
    private boolean online;
    private boolean offline;

    /*-------------------------------------------------------------------------------------------*/
    /* Getters and setters                                                                       */
    /*-------------------------------------------------------------------------------------------*/
    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getStallIdentifier() {
        return stallIdentifier;
    }

    public void setStallIdentifier(String stallIdentifier) {
        this.stallIdentifier = stallIdentifier;
    }

    public long getPoiId() {
        return poiId;
    }

    public void setPoiId(long poiId) {
        this.poiId = poiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isOffline() {
        return offline;
    }

    public void setOffline(boolean offline) {
        this.offline = offline;
    }

    @Override
    public String toString() {
        return "ServeryView{" +
                "identifier='" + identifier + '\'' +
                ", poiId=" + poiId +
                ", name='" + name + '\'' +
                ", remark='" + remark + '\'' +
                ", online=" + online +
                ", offline=" + offline +
                '}';
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }
}
