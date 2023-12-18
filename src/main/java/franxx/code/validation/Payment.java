package franxx.code.validation;

import franxx.code.validation.groups.CreditCard;
import franxx.code.validation.groups.VirtualAccount;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

    @NotBlank(groups = {CreditCard.class, VirtualAccount.class}, message = "order id cannot be blank")
    private String orderId;

    @Range(groups = {CreditCard.class, VirtualAccount.class}, min = 10_000L, max = 100_000_000, message = "amount must be 10,000 or 100,000,000")
    @NotNull(groups = {CreditCard.class, VirtualAccount.class}, message = "amount cannot be null")
    private Long amount;

    @LuhnCheck(groups = {CreditCard.class}, message = "Invalid Credit Card Number")
    @NotBlank(groups = {CreditCard.class}, message = "credit card cannot be blank")
    private String creditCard;

    @NotBlank(groups = {VirtualAccount.class}, message = "virtual account cannot be blank")
    private String virtualAccount;

    @Valid
    @NotNull(groups = {VirtualAccount.class, CreditCard.class}, message = "Customer not null")
    @ConvertGroup(from = CreditCard.class, to = Default.class)
    @ConvertGroup(from = VirtualAccount.class, to = Default.class)
    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getVirtualAccount() {
        return virtualAccount;
    }

    public void setVirtualAccount(String virtualAccount) {
        this.virtualAccount = virtualAccount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "orderId='" + orderId + '\'' +
                ", amount=" + amount +
                ", creditCard='" + creditCard + '\'' +
                ", virtualAccount='" + virtualAccount + '\'' +
                ", customer=" + customer +
                '}';
    }
}
