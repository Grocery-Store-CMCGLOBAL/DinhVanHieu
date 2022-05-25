package dinhhieu.grocery;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class CalculateService {

	public static float calOriginPrice(float singlePrice, float number) {
		return number * singlePrice;
	}
    //Caculate discount of product
	public static float calDiscount(float singlePrice, float number, String saleType) {
		float discount = 0; 
		Optional<SalePromotion> salePromotionOpt = Data.salePromotions.stream().filter(salePromotion -> salePromotion.getType().equals(saleType)).findFirst(); 
		
		if (!salePromotionOpt.isPresent()) return discount; 
		SalePromotion salePromotion = salePromotionOpt.get(); 
		int numOfFree = 0; 
		int NUM_FREE = 1; 
		
		if (Constants.SaleType.BUY_2_FREE_1.equals(salePromotion.getType())) {
			numOfFree = number / 2 > 1 ? (int) (number / (2 + NUM_FREE)) : 0; 
			} else numOfFree = number > 1 ? (int) (number / (1 + NUM_FREE)) : 0; 
			 
			return numOfFree * singlePrice; 
			}
	
	public static OrderDetail calOrder(Product product, OrderDetail order) {
		float originPrice = calOriginPrice(product.getSinglePrice(), order.getQuantity());
		float discount = product.getSalePromotion() != null
				? calDiscount(product.getSinglePrice(), order.getQuantity(), product.getSalePromotion().getType())
				: 0;
		float totalPrice = originPrice - discount;
		order.setOriginPrice(originPrice);
		order.setDiscount(discount);
		order.setTotalPrice(totalPrice);
		return order;
	}

	public static void printOrders(ArrayList<OrderDetail> orders) {
		AtomicReference<Double> orderTotalPrice = new AtomicReference<>(0.0);
		
		for (int i = 0; i < orders.size(); i++) {
			
			OrderDetail orderDetail = orders.get(i);
			System.out.println("===========" + (i + 1) + "===========");
			
			System.out.print("Product Name: ");
			System.out.println(orderDetail.getProduct().getName());
			
			System.out.print("Quantity : ");
			System.out.println(orderDetail.getQuantity()
					+ (Constants.TypePrice.WEIGHT == orderDetail.getProduct().getUnit() ? "(kg)" : ""));
			
			System.out.print("Single Price: ");
			System.out.println(orderDetail.getProduct().getSinglePrice());
			
			System.out.print("Total Origin Price: ");
			System.out.println(orderDetail.getOriginPrice());
			
			System.out.print("Free Price: ");
			SalePromotion salePromotion = orderDetail.getProduct().getSalePromotion();
			System.out.println(orderDetail.getDiscount()
					+ (salePromotion != null ? " (" + orderDetail.getProduct().getSalePromotion().getContent() + ")"
							: ""));
			
			System.out.print("Final price: ");
			System.out.println(orderDetail.getTotalPrice());
			
			orderTotalPrice.updateAndGet(v -> v + orderDetail.getTotalPrice());
		}
		
		System.out.println("================> Total price: " + orderTotalPrice);
	}
}
