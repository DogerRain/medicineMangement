package po;

public class Gys {
    private Integer gysbm;

    private String gysmc;

    private String gysfzr;

    private String gyslxfs;

    private String gysdz;

    public Integer getGysbm() {
        return gysbm;
    }

    public void setGysbm(Integer gysbm) {
        this.gysbm = gysbm;
    }

    public String getGysmc() {
        return gysmc;
    }

    public void setGysmc(String gysmc) {
        this.gysmc = gysmc == null ? null : gysmc.trim();
    }

    public String getGysfzr() {
        return gysfzr;
    }

    public void setGysfzr(String gysfzr) {
        this.gysfzr = gysfzr == null ? null : gysfzr.trim();
    }

   

    public String getGyslxfs() {
		return gyslxfs;
	}

	public void setGyslxfs(String gyslxfs) {
		this.gyslxfs = gyslxfs;
	}

	public String getGysdz() {
        return gysdz;
    }

    public void setGysdz(String gysdz) {
        this.gysdz = gysdz == null ? null : gysdz.trim();
    }
}