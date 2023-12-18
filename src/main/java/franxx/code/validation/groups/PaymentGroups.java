package franxx.code.validation.groups;

import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;

@GroupSequence(value = {
        Default.class,
        CreditCard.class,
        VirtualAccount.class
})
public interface PaymentGroups {
}
