package po;

public class Zgxx {
    private Integer zgbm;

    private String zgmc;

    private String zgmm;

    public Integer getZgbm() {
        return zgbm;
    }

    public void setZgbm(Integer zgbm) {
        this.zgbm = zgbm;
    }

    public String getZgmc() {
        return zgmc;
    }

    public void setZgmc(String zgmc) {
        this.zgmc = zgmc == null ? null : zgmc.trim();
    }

    public String getZgmm() {
        return zgmm;
    }

    public void setZgmm(String zgmm) {
        this.zgmm = zgmm == null ? null : zgmm.trim();
    }
}