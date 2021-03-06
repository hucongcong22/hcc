package com.aifule.jxc.core.domain;

import java.util.Date;

public class Goods {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.gid
     *
     * @mbg.generated
     */
    private Integer gid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.lid
     *
     * @mbg.generated
     */
    private Integer lid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.gname
     *
     * @mbg.generated
     */
    private String gname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.price
     *
     * @mbg.generated
     */
    private Double price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.gdate
     *
     * @mbg.generated
     */
    private Date gdate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.gstate
     *
     * @mbg.generated
     */
    private String gstate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.gid
     *
     * @return the value of goods.gid
     * @mbg.generated
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.gid
     *
     * @param gid the value for goods.gid
     * @mbg.generated
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.lid
     *
     * @return the value of goods.lid
     * @mbg.generated
     */
    public Integer getLid() {
        return lid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.lid
     *
     * @param lid the value for goods.lid
     * @mbg.generated
     */
    public void setLid(Integer lid) {
        this.lid = lid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.gname
     *
     * @return the value of goods.gname
     * @mbg.generated
     */
    public String getGname() {
        return gname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.gname
     *
     * @param gname the value for goods.gname
     * @mbg.generated
     */
    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.price
     *
     * @return the value of goods.price
     * @mbg.generated
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.price
     *
     * @param price the value for goods.price
     * @mbg.generated
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.gdate
     *
     * @return the value of goods.gdate
     * @mbg.generated
     */
    public Date getGdate() {
        return gdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.gdate
     *
     * @param gdate the value for goods.gdate
     * @mbg.generated
     */
    public void setGdate(Date gdate) {
        this.gdate = gdate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.gstate
     *
     * @return the value of goods.gstate
     * @mbg.generated
     */
    public String getGstate() {
        return gstate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.gstate
     *
     * @param gstate the value for goods.gstate
     * @mbg.generated
     */
    public void setGstate(String gstate) {
        this.gstate = gstate == null ? null : gstate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Goods other = (Goods) that;
        return (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
                && (this.getLid() == null ? other.getLid() == null : this.getLid().equals(other.getLid()))
                && (this.getGname() == null ? other.getGname() == null : this.getGname().equals(other.getGname()))
                && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
                && (this.getGdate() == null ? other.getGdate() == null : this.getGdate().equals(other.getGdate()))
                && (this.getGstate() == null ? other.getGstate() == null : this.getGstate().equals(other.getGstate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getLid() == null) ? 0 : getLid().hashCode());
        result = prime * result + ((getGname() == null) ? 0 : getGname().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getGdate() == null) ? 0 : getGdate().hashCode());
        result = prime * result + ((getGstate() == null) ? 0 : getGstate().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goods
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gid=").append(gid);
        sb.append(", lid=").append(lid);
        sb.append(", gname=").append(gname);
        sb.append(", price=").append(price);
        sb.append(", gdate=").append(gdate);
        sb.append(", gstate=").append(gstate);
        sb.append("]");
        return sb.toString();
    }
}