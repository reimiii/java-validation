package franxx.code.validation;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.LuhnCheck;
import org.hibernate.validator.constraints.Range;

public class Payment {

    @NotBlank(message = "order id cannot be blank")
    private String orderId;

    @Range(min = 10_000L, max = 100_000_000, message = "amount must be 10,000 or 100,000,000")
    @NotNull(message = "amount cannot be null")
    private Long amount;

    @LuhnCheck(message = "Invalid Credit Card Number")
    @NotBlank(message = "credit card cannot be blank")
    private String creditCard;

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
                '}';
    }
}
