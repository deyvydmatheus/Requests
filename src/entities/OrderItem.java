package entities;

public class OrderItem {
    private Double quantity;
    private Double price;

    private Client client;
    private Product product;
    private Order order;

    public OrderItem(Double quantity, Double price, Product product, Client client, Order order) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.client = client;
        this.order = order;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double subTotal() {
        double subtotal = quantity * price;
        return subtotal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ORDER SUMARY: \n");
        builder.append("Order moment: " + order.getMoment() + "\n");
        builder.append("Order Status: " + order.getStatus() + "\n");
        builder.append("Client: " + client + "\n");
        builder.append("ORDER ITEMS: \n");
        builder.append(order);

        return builder.toString();
    }
}
