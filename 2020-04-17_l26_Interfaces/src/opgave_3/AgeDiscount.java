package opgave_3;

public class AgeDiscount implements Discount {

	private double customerAge;

	public AgeDiscount(double customerAge) {
		super();
		this.customerAge = customerAge;
	}

	@Override
	public double getDiscount(double price) {
		// TODO Auto-generated method stub

		return price - ((1 - customerAge / 100) * price);
	}

	@Override
	public String toString() {
		return "AgeDiscount [customerAge=" + customerAge + "]";
	}

	public double getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(double customerAge) {
		this.customerAge = customerAge;
	}

}
