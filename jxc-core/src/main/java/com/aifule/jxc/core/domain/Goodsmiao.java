package com.aifule.jxc.core.domain;

public class Goodsmiao {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goodsmiao.gaid
     *
     * @mbg.generated
     */
    private Integer gaid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goodsmiao.gid
     *
     * @mbg.generated
     */
    private Integer gid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goodsmiao.ymoney
     *
     * @mbg.generated
     */
    private Double ymoney;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goodsmiao.miao
     *
     * @mbg.generated
     */
    private String miao;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goodsmiao.tupian
     *
     * @mbg.generated
     */
    private String tupian;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goodsmiao.gaid
     *
     * @return the value of goodsmiao.gaid
     * @mbg.generated
     */
    public Integer getGaid() {
        return gaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goodsmiao.gaid
     *
     * @param gaid the value for goodsmiao.gaid
     * @mbg.generated
     */
    public void setGaid(Integer gaid) {
        this.gaid = gaid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goodsmiao.gid
     *
     * @return the value of goodsmiao.gid
     * @mbg.generated
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goodsmiao.gid
     *
     * @param gid the value for goodsmiao.gid
     * @mbg.generated
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goodsmiao.ymoney
     *
     * @return the value of goodsmiao.ymoney
     * @mbg.generated
     */
    public Double getYmoney() {
        return ymoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goodsmiao.ymoney
     *
     * @param ymoney the value for goodsmiao.ymoney
     * @mbg.generated
     */
    public void setYmoney(Double ymoney) {
        this.ymoney = ymoney;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goodsmiao.miao
     *
     * @return the value of goodsmiao.miao
     * @mbg.generated
     */
    public String getMiao() {
        return miao;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goodsmiao.miao
     *
     * @param miao the value for goodsmiao.miao
     * @mbg.generated
     */
    public void setMiao(String miao) {
        this.miao = miao == null ? null : miao.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goodsmiao.tupian
     *
     * @return the value of goodsmiao.tupian
     * @mbg.generated
     */
    public String getTupian() {
        return tupian;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goodsmiao.tupian
     *
     * @param tupian the value for goodsmiao.tupian
     * @mbg.generated
     */
    public void setTupian(String tupian) {
        this.tupian = tupian == null ? null : tupian.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goodsmiao
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
        Goodsmiao other = (Goodsmiao) that;
        return (this.getGaid() == null ? other.getGaid() == null : this.getGaid().equals(other.getGaid()))
                && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
                && (this.getYmoney() == null ? other.getYmoney() == null : this.getYmoney().equals(other.getYmoney()))
                && (this.getMiao() == null ? other.getMiao() == null : this.getMiao().equals(other.getMiao()))
                && (this.getTupian() == null ? other.getTupian() == null : this.getTupian().equals(other.getTupian()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goodsmiao
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getGaid() == null) ? 0 : getGaid().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getYmoney() == null) ? 0 : getYmoney().hashCode());
        result = prime * result + ((getMiao() == null) ? 0 : getMiao().hashCode());
        result = prime * result + ((getTupian() == null) ? 0 : getTupian().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table goodsmiao
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gaid=").append(gaid);
        sb.append(", gid=").append(gid);
        sb.append(", ymoney=").append(ymoney);
        sb.append(", miao=").append(miao);
        sb.append(", tupian=").append(tupian);
        sb.append("]");
        return sb.toString();
    }
}