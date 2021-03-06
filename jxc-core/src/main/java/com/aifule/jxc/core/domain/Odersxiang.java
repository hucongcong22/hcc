package com.aifule.jxc.core.domain;

public class Odersxiang {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odersxiang.oderid
     *
     * @mbg.generated
     */
    private Integer oderid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odersxiang.gid
     *
     * @mbg.generated
     */
    private Integer gid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odersxiang.oid
     *
     * @mbg.generated
     */
    private Integer oid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odersxiang.shuliang
     *
     * @mbg.generated
     */
    private Integer shuliang;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odersxiang.zhekou
     *
     * @mbg.generated
     */
    private Double zhekou;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column odersxiang.oderprize
     *
     * @mbg.generated
     */
    private Double oderprize;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odersxiang.oderid
     *
     * @return the value of odersxiang.oderid
     * @mbg.generated
     */
    public Integer getOderid() {
        return oderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odersxiang.oderid
     *
     * @param oderid the value for odersxiang.oderid
     * @mbg.generated
     */
    public void setOderid(Integer oderid) {
        this.oderid = oderid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odersxiang.gid
     *
     * @return the value of odersxiang.gid
     * @mbg.generated
     */
    public Integer getGid() {
        return gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odersxiang.gid
     *
     * @param gid the value for odersxiang.gid
     * @mbg.generated
     */
    public void setGid(Integer gid) {
        this.gid = gid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odersxiang.oid
     *
     * @return the value of odersxiang.oid
     * @mbg.generated
     */
    public Integer getOid() {
        return oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odersxiang.oid
     *
     * @param oid the value for odersxiang.oid
     * @mbg.generated
     */
    public void setOid(Integer oid) {
        this.oid = oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odersxiang.shuliang
     *
     * @return the value of odersxiang.shuliang
     * @mbg.generated
     */
    public Integer getShuliang() {
        return shuliang;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odersxiang.shuliang
     *
     * @param shuliang the value for odersxiang.shuliang
     * @mbg.generated
     */
    public void setShuliang(Integer shuliang) {
        this.shuliang = shuliang;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odersxiang.zhekou
     *
     * @return the value of odersxiang.zhekou
     * @mbg.generated
     */
    public Double getZhekou() {
        return zhekou;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odersxiang.zhekou
     *
     * @param zhekou the value for odersxiang.zhekou
     * @mbg.generated
     */
    public void setZhekou(Double zhekou) {
        this.zhekou = zhekou;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column odersxiang.oderprize
     *
     * @return the value of odersxiang.oderprize
     * @mbg.generated
     */
    public Double getOderprize() {
        return oderprize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column odersxiang.oderprize
     *
     * @param oderprize the value for odersxiang.oderprize
     * @mbg.generated
     */
    public void setOderprize(Double oderprize) {
        this.oderprize = oderprize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table odersxiang
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
        Odersxiang other = (Odersxiang) that;
        return (this.getOderid() == null ? other.getOderid() == null : this.getOderid().equals(other.getOderid()))
                && (this.getGid() == null ? other.getGid() == null : this.getGid().equals(other.getGid()))
                && (this.getOid() == null ? other.getOid() == null : this.getOid().equals(other.getOid()))
                && (this.getShuliang() == null ? other.getShuliang() == null : this.getShuliang().equals(other.getShuliang()))
                && (this.getZhekou() == null ? other.getZhekou() == null : this.getZhekou().equals(other.getZhekou()))
                && (this.getOderprize() == null ? other.getOderprize() == null : this.getOderprize().equals(other.getOderprize()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table odersxiang
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOderid() == null) ? 0 : getOderid().hashCode());
        result = prime * result + ((getGid() == null) ? 0 : getGid().hashCode());
        result = prime * result + ((getOid() == null) ? 0 : getOid().hashCode());
        result = prime * result + ((getShuliang() == null) ? 0 : getShuliang().hashCode());
        result = prime * result + ((getZhekou() == null) ? 0 : getZhekou().hashCode());
        result = prime * result + ((getOderprize() == null) ? 0 : getOderprize().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table odersxiang
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oderid=").append(oderid);
        sb.append(", gid=").append(gid);
        sb.append(", oid=").append(oid);
        sb.append(", shuliang=").append(shuliang);
        sb.append(", zhekou=").append(zhekou);
        sb.append(", oderprize=").append(oderprize);
        sb.append("]");
        return sb.toString();
    }
}