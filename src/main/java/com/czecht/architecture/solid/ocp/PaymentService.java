package com.czecht.architecture.solid.ocp;

import java.util.ArrayList;
import java.util.List;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

/**
 * Created by czecht on 2017-05-29.
 */
public class PaymentService {

	List<Item> items = new ArrayList<>();

	public void checkOut(Receipt receipt, PaymentMethod pm) {
		Money total = Money.zero(CurrencyUnit.EUR);

		boolean credit = true;

		for(Item item : items) {
			total.plus(item.getPrice());
			receipt.addItem(item);
		}

		Payment p = pm.acceptPayment(total);
		receipt.addPayment(p);
	}

	private Payment acceptCash(Money total) {
		return new Payment();
	}

	private Payment acceptCredit(Money total) {
		return new Payment();
	}


	public interface PaymentMethod {
		Payment acceptPayment(Money total);
	}




}
