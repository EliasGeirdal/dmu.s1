package opgave_1;

import java.util.Arrays;

public class Data {

	public Data() {
	}

	public static Measurable max(Measurable[] objects) {
		int max = 0;
		double maxSum = 0;
		for (int i = 0; i < objects.length; i++) {
			if (objects[i].getMeasure() > maxSum) {
				maxSum = objects[i].getMeasure();
				max = i;
			}
		}
		return objects[max];
	}

	public static double avg(Measurable[] objects) {
		double sum = 0;
		for (Measurable measurable : objects) {
			sum += measurable.getMeasure();
		}
		if (objects.length > 0)
			return sum / objects.length;
		else
			return 0;
	}

	public static double avgOver5000(Measurable[] objects, Filter obj) {
		Measurable[] accepted = acceptList(objects);
		return avg(accepted);
	}

	public static Measurable[] acceptList(Measurable[] objects) {
		Measurable[] test = new Measurable[objects.length];
		int count = 0;
		for (int i = 0; i < objects.length; i++) {
			if (objects[i].accept(objects[i])) {
				test[i] = objects[i];
				count++;
			}
		}
		return Arrays.copyOf(test, count);

	}
}
