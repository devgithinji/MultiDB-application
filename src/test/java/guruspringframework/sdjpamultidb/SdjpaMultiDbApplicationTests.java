package guruspringframework.sdjpamultidb;

import guruspringframework.sdjpamultidb.domain.creditcard.CreditCard;
import guruspringframework.sdjpamultidb.services.CreditCardService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SdjpaMultiDbApplicationTests {
    @Autowired
    CreditCardService creditCardService;


    @Test
    void testSaveAndCreditCard() {
        CreditCard cc = CreditCard.builder()
                .firstName("John")
                .lastName("doe")
                .zipCode("12345")
                .creditCardNumber("234353534534")
                .cvv("123")
                .expirationDate("12/26")
                .build();

        CreditCard savedCC = creditCardService.saveCreditCard(cc);

        assertThat(savedCC).isNotNull();
        assertThat(savedCC.getId()).isNotNull();
        assertThat(savedCC.getCreditCardNumber()).isNotNull();
    }

    @Test
    void contextLoads() {
    }

}
