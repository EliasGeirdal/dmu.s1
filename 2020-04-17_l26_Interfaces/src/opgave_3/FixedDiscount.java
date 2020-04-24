package opgave_3;

public class FixedDiscount implements Discount {

	@Override
	public String toString() {
		return "FixedDiscount [fixedDiscount=" + fixedDiscount + ", discountLimit=" + discountLimit + "]";
	}

	private double fixedDiscount;
	private double discountLimit;

	public FixedDiscount(double fixedDiscount, double discountLimit) {
		this.fixedDiscount = fixedDiscount;
		this.discountLimit = discountLimit;
	}

	@Override
	public double getDiscount(double price) {
		// TODO Auto-generated method stub
		double discount = 0;
		if (price > discountLimit) {
			discount = fixedDiscount;
		}
		return discount;
	}

	public double getFixedDiscount() {
		return fixedDiscount;
	}

	public void setFixedDiscount(double fixedDiscount) {
		this.fixedDiscount = fixedDiscount;
	}

	public double getDiscountLimit() {
		return discountLimit;
	}

	public void setDiscountLimit(double discountLimit) {
		this.discountLimit = discountLimit;
	}

}
