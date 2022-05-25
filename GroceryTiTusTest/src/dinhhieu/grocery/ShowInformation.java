package dinhhieu.grocery;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class ShowInformation {

	Scanner sc = new Scanner(System.in);
	ArrayList<OrderDetail> orders;

	public void menu() {

		System.out.println("====================== MENU ======================");
		System.out.println("1. Input Order | 2. Exit");
		System.out.println("Please type your choice");
		String chosen = sc.nextLine();

		switch (chosen) {
		
		case "1":
			inputOrder();
			
		case "2":
			System.exit(1);
			
		default:
			System.out.println("Input invalid");
			menu();
		}
	}

	private void inputOrder() {
		
		orders = new ArrayList<>();
		boolean cont = true;
		
		do {
			String productCode;
			float productNumber = 0;
			
			System.out.println("Please input product code: ");
			productCode = sc.nextLine();
            
			//Check product is exist or not?
			Optional<Product> productInputOpt = Data.products.stream()
					.filter(product -> product.getCode().equals(productCode)).findFirst();

			if (!productInputOpt.isPresent()) {
				System.out.println("This product is not present!");
				continue;
			}
            
			Product productInput = productInputOpt.get();
		
			System.out.println("====================== PRODUCT INFORMATION ======================");
			
			System.out.println("Product Code: " + productInput.getCode() + " | Product Name: " + productInput.getName()
					+ " | Sale Type: "
					+ (productInput.getSalePromotion() != null ? productInput.getSalePromotion().getContent() : "None")
					+ " | Unit: " + (Constants.TypePrice.PIECE == productInput.getUnit() ? "Piece" : "Kg")
					+ " | Single Price: " + productInput.getSinglePrice());

			System.out.println("=================================================================");

			if (productInput.getUnit() == Constants.TypePrice.PIECE) {
				System.out.println("Quatity (piece): ");
				productNumber = sc.nextFloat();
			} else {
				System.out.println("Weight: ");
				productNumber = sc.nextFloat();
			}

			OrderDetail orderDetail = new OrderDetail(productInput, productNumber, 0, 0, 0);
			CalculateService.calOrder(productInput, orderDetail);
			orders.add(orderDetail);
			
			System.out.println("=========== Continue? ===========");
			System.out.println("1. Add more | 2. Print price | 3. Cancel");
			System.out.println("Select menu...");
			int chosen = sc.nextInt();
			
			switch (chosen) {
			case 2:
				System.out.println("====================== Print orders ======================");
				CalculateService.printOrders(orders);
				sc.nextLine();
				System.out.println("====================== END Print orders ======================");
			case 3:
				menu();
			default:
			}
			cont = chosen == 1;
			sc.nextLine();
		} while (cont);
	}

}
