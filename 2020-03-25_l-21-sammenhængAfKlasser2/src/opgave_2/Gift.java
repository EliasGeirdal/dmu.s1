package opgave_2;

public class Gift {
	private String description = "";
	private double price;
	private Person giver;

	/**
	 * Initialise gift object
	 * 
	 * @param description the description of the gift
	 * @param giver       the person giving the gift.
	 */
	public Gift(String description, Person giver) {
		this.description = description;
		this.setGiver(giver);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Person getGiver() {
		return giver;
	}

	public void setGiver(Person giver) {
//		if (this.giver != giver) {
//			if (giver != null) {
//				this.giver = giver;
//			}
//		}
		if (this.giver != giver) {
			Person oldGiver = this.giver;
			if (oldGiver != null)
				oldGiver.removeGift(this);
			this.giver = giver;
			if (giver != null) {
				giver.addGift(this);
			}
		}
	}
}
