package opgave_3;

public class PercentDiscount implements Discount {

	private double discountPercentage;

	public PercentDiscount(double percent) {
		this.discountPercentage = percent;
	}

	@Override
	public String toString() {
		return "PercentDiscount [discountPercentage=" + discountPercentage + "]";
	}

	@Override
	public double getDiscount(double price) {
		// TODO Auto-generated method stub
		return price - ((1 - (discountPercentage / 100)) * price);
	}

	public double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

}
