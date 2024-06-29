import java.util.concurrent.atomic.AtomicInteger;

public class Customer {

    private static final AtomicInteger count = new AtomicInteger(0); // For auto-generating customer IDs
    private int customerId;
    private String customerName;
    private String customerStatus;
    private int totalCustomerMileage;


    public Customer() {
        this.customerId = count.incrementAndGet();
    }


    public Customer(String customerName, String customerStatus, int totalCustomerMileage) {
        this.customerId = count.incrementAndGet();
        this.customerName = customerName;
        this.customerStatus = customerStatus;
        this.totalCustomerMileage = totalCustomerMileage;
    }


    public int getCustomerId() {
        return customerId;
    }



    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    public int getTotalCustomerMileage() {
        return totalCustomerMileage;
    }

    public void setTotalCustomerMileage(int totalCustomerMileage) {
        this.totalCustomerMileage = totalCustomerMileage;
    }
}

