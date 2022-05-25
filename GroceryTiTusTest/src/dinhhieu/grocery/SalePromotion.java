package dinhhieu.grocery;

public class SalePromotion {
	private String type;
	// (BUY_2_FREE_1, BUY_1_FREE_1)
	private String content;

	public SalePromotion(String type, String content) {
		this.type = type;
		this.content = content;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
