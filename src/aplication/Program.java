package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderIten;
import entities.Product;
import entities.enun.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Client name: ");
		String nameClient = sc.nextLine();
		System.out.print("E-mail: ");
		String email = sc.nextLine();
		System.out.print("Birth date: ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		Client client = new Client(nameClient, email, birthDate);
		
		System.out.print("Order Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order od1 = new Order(new Date(),status , client);
		
		System.out.print("How many Itens in this order: ");
		int qtd = sc.nextInt();
		sc.nextLine();
		
		for(int i = 1 ; i <= qtd ; i++) {
			
			System.out.println("Enter Product "+"# "+i+" data");
			System.out.println();
			System.out.print("Product Name: ");
			String name = sc.nextLine();
			System.out.println("Product Price: ");
			double price = sc.nextDouble();
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			Product product = new Product(name, price);
			
			OrderIten odi = new OrderIten(quantity, price, product);
			
			od1.addItem(odi);
			
		}
		
		System.out.println(od1);
		
		
		sc.close();
	}

}
