package kodlama.io.rentacar.business.rules;

import kodlama.io.rentacar.common.dto.CreateRentalPaymentRequest;
import kodlama.io.rentacar.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PaymentBusinessRules {
    private final PaymentRepository repository;

    public void checkIfPaymentExists(int id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Ödeme bilgisi bulunamadı!");
        }
    }

    public void checkIfBalanceIsEnough(double balance, double price) {
        if (balance < price) {
            throw new RuntimeException("Yetersiz bakiye.");
        }
    }

    public void checkIfCardExists(String cardNumber) {
        if (repository.existsByCardNumber(cardNumber)) {
            throw new RuntimeException("Kart numarası zaten kayıtlı.");
        }
    }

    public void chechkIfPaymentIsValid(CreateRentalPaymentRequest request) {
        if (!repository.existsByCardNumberAndCardHolderAndCardExpirationYearAndCardExpirationMonthAndCardCvv(
                request.getCardNumber(),
                request.getCardHolder(),
                request.getCardExpirationYear(),
                request.getCardExpirationMonth(),
                request.getCardCvv()
        )) {
            throw new RuntimeException("Kart bilgileriniz hatalı!");
        }
    }
}
