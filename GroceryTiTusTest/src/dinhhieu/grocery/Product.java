package dinhhieu.grocery;

public class Product {

	private String code;
	private String name;
	private int unit;
	// options are weight (1), piece (2),
	// default piece;
	private SalePromotion salePromotion;
	// mapping to sale promotions
	private float singlePrice;

	public Product(String code, String name, int typePrice, SalePromotion salePromotion, float singlePrice) {
		this.code = code;
		this.name = name;
		this.unit = typePrice;
		this.salePromotion = salePromotion;
		this.singlePrice = singlePrice;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	public SalePromotion getSalePromotion() {
		return salePromotion;
	}

	public void setSalePromotion(SalePromotion salePromotion) {
		this.salePromotion = salePromotion;
	}

	public float getSinglePrice() {
		return singlePrice;
	}

	public void setSinglePrice(float singlePrice) {
		this.singlePrice = singlePrice;
	}
}
