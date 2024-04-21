package entities;

import enums.OrderStatus;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String moment;
    private OrderStatus status;
    private OrderItem orderItem;
    private Client client;


    private List<OrderItem> items = new ArrayList<>();

    public Order() {

    }

    public Order(String moment, OrderStatus status) {
        this.moment = moment;
        this.status = status;
    }

    public String getMoment() {
        return moment;
    }

    public void setMoment(String moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public void setClient(Client client) {
        this.client = client;
    }


    public Double total() {
        Double total = 0.0;
        for (OrderItem item : items) {
            total += item.subTotal();
        }
        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMARY: \n");
        sb.append("MOMENT: " + moment + "\n");
        sb.append("STATUS: " + status + "\n");
        sb.append("CLIENT: \n" +  "Nome: " + client.getName() + " E-mail: " + client.getEmail() + "Date of Birth: " + client.getDateOfBirth() + "\n");

        sb.append("ORDER ITEMS:\n");
        for (OrderItem item : items) {
                sb.append(item.getProduct().getProductName() + " Quantity: " + item.getQuantity() + " Subtotal: " + item.subTotal() + "\n");
        }
        sb.append("Total price: ").append(total()).append("\n");
        return sb.toString();
    }


}
