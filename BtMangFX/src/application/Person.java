package application;

public class Person {
	private String ten;
	private Double dtb;
	private String kq;
	private String xl;
	public Person() {
        this(null,null,null,null);
    }
	public Person(String ht,Double dtb,String kq,String xl) {
		this.ten=ht;
		this.kq=kq;
		this.dtb=dtb;
		this.xl=xl;
	}
	public String getName() {
		return this.ten;
	}
	public String getKQ() {
		return this.kq;
	}
	public String getXL() {
		return this.xl;
	}
	public Double getdtb() {
		return this.dtb;
	}
}
