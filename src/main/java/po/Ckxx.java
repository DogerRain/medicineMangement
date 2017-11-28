package po;

import java.util.Date;

public class Ckxx {
    private Integer ckid;

    private Integer ypbm;

    private String ypmc;

    private Integer zgbm;

    private Date ckrq;

    private Integer sl;

    public Integer getCkid() {
        return ckid;
    }

    public void setCkid(Integer ckid) {
        this.ckid = ckid;
    }

    public Integer getYpbm() {
        return ypbm;
    }

    public void setYpbm(Integer ypbm) {
        this.ypbm = ypbm;
    }

    public String getYpmc() {
        return ypmc;
    }

    public void setYpmc(String ypmc) {
        this.ypmc = ypmc == null ? null : ypmc.trim();
    }

    public Integer getZgbm() {
        return zgbm;
    }

    public void setZgbm(Integer zgbm) {
        this.zgbm = zgbm;
    }

    public Date getCkrq() {
        return ckrq;
    }

    public void setCkrq(Date ckrq) {
        this.ckrq = ckrq;
    }

    public Integer getSl() {
        return sl;
    }

    public void setSl(Integer sl) {
        this.sl = sl;
    }
}