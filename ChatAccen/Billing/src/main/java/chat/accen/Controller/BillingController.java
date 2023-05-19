package chat.accen.Controller;

import chat.accen.Service.BillingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private BillingService billingService;

}
