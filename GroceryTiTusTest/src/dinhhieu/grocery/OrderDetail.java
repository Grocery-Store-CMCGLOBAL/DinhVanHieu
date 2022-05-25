package dinhhieu.grocery;

public class OrderDetail {
	
	private Product product; 
	private float quantity; 
	private float originPrice; 
	private float discount; 
	private float totalPrice; 
	
	public OrderDetail(Product product, float number, float originPrice, float free, float totalPrice) {
		this.product = product; 
		this.quantity = number; 
		this.originPrice = originPrice; 
		this.discount = free; 
		this.totalPrice = totalPrice; 
		}
	public Product getProduct() {
		return product; 
		}
	public void setProduct(Product product) {
		this.product = product; 
		}
	
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public float getOriginPrice() {
		return originPrice; 
		}
	public void setOriginPrice(float originPrice) {
		this.originPrice = originPrice; 
		}
	
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public float getTotalPrice() {
		return totalPrice; 
		}
	public void setTotalPrice(float totalPrice) {this.totalPrice = totalPrice; }

}
