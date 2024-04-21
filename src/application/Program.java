package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import enums.OrderStatus;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Date date = new Date();


        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("E-mail: ");
        String email = sc.nextLine();

        System.out.print("Birth date: ");
        String birthDate = sc.nextLine();

        LocalDate birthday = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        Client client = new Client(name, email, birthday);


        System.out.println("ENTER ORDER DATA: ");
        System.out.print("Status: ");
        String status = sc.nextLine();


        System.out.print("How many items to this order? ");
        int items = sc.nextInt();
        sc.nextLine();


        Order order = new Order(new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(date), OrderStatus.valueOf(status));

        order.setClient(client);

        for (int i = 0; i < items; i++) {
            System.out.println("Enter #" + (i + 1) + " item data:" );
            System.out.print("Product name: ");
            String productName = sc.nextLine();

            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();

            System.out.print("Quantity: ");
            double quantity = sc.nextDouble();
            sc.nextLine();

            OrderItem item = new OrderItem(quantity, productPrice, new Product(productName, productPrice), client, order);
            order.addItem(item);
        }

        System.out.println(order);


        sc.close();
    }
}
