package com.aifule.jxc.core.domain;

public class Goodslei {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goodslei.lid
     *
     * @mbg.generated
     */
    private Integer lid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goodslei.lname
     *
     * @mbg.generated
     */
    private String lname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goodslei.lid
     *
     * @return the value of goodslei.lid
     * @mbg.generated
     */
    public Integer getLid() {
        return lid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goodslei.lid
     *
     * @param lid the value for goodslei.lid
     * @mbg.generated
     */
    public void setLid(Integer lid) {
        this.lid = lid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goodslei.lname
     *
     * @return the value of goodslei.lname
     * @mbg.generated
     */
    public String getLname() {
        return lname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goodslei.lname
     *
     * @param lname the value for goodslei.lname
     * @mbg.generated
     */
    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goodslei
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
        Goodslei other = (Goodslei) that;
        return (this.getLid() == null ? other.getLid() == null : this.getLid().equals(other.getLid()))
                && (this.getLname() == null ? other.getLname() == null : this.getLname().equals(other.getLname()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goodslei
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLid() == null) ? 0 : getLid().hashCode());
        result = prime * result + ((getLname() == null) ? 0 : getLname().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goodslei
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", lid=").append(lid);
        sb.append(", lname=").append(lname);
        sb.append("]");
        return sb.toString();
    }
}