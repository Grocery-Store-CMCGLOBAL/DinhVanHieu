package dinhhieu.grocery;

import java.util.ArrayList;

public class Data {
	
	public static ArrayList<SalePromotion> salePromotions = new ArrayList<>(); 
	public static ArrayList<Product> products = new ArrayList<>(); 
	
	static {
	SalePromotion sale1 = new SalePromotion(Constants.SaleType.BUY_1_FREE_1, "Buy 1 get free 1"); 
	SalePromotion sale2 = new SalePromotion(Constants.SaleType.BUY_2_FREE_1, "Buy 2 get free 1"); 
	salePromotions.add(sale1); 
	salePromotions.add(sale2); 
	
	Product redbull = new Product("p0001", "Redbull", Constants.TypePrice.PIECE, sale1, 10); 
	Product fish = new Product("p0002", "Fish 0", Constants.TypePrice.WEIGHT, sale2, 20); 
	Product chicken = new Product("p0003", "Chicken 1", Constants.TypePrice.WEIGHT, null, 50); 
	
	products.add(redbull); 
	products.add(fish); 
	products.add(chicken); 
	}
	} 
