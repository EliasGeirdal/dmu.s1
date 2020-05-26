package soegningelevopgaver;

import java.util.ArrayList;

public class Soegning {

	public boolean findUlige(int[] tabel) {
		// TODO Opgave1
		int i = 0;
		while (i < tabel.length) {
			if (tabel[i] % 2 != 0)
				return true;
			i++;
		}
		return false;
	}

	// her skriver du metoder til opgaverne 2,3,5,6 og 7

	// ----------------opgave 2------------------------

	/**
	 * Find max interget in interval 10-15.
	 * 
	 * @param tabel
	 * @return
	 */
	public int findMaxInterval(int[] tabel) {
		int max = -1;
		int i = 0;
		while (i < tabel.length) {
			if (tabel[i] >= max && tabel[i] <= 15 && tabel[i] >= 10) {
				max = tabel[i];
			}
			i++;
		}
		return max;
	}

	// -----------------opgave 3-----------------------

	public boolean findAdjacentNum(int[] tabel) {
		int previous = tabel[0];
		int i = 1;
		while (i < tabel.length) {
			if (tabel[i] == previous) {
				return true;
			}
			previous = tabel[i];
			i++;
		}
		return false;
	}

	// ---------------opgave 5---------------------
	public int findMaxSqrtLinear(int n) {
		int r = 0;
		while (r <= n) {
			if ((r * r) <= n && ((r + 1) * (r + 1) > n)) {
				return r;
			}
			r++;
		}
		return -1;
	}

	public int findMaxSqrtBinary(int n) {
		int left = 0;
		int right = n;
		while (left <= n) {
			int k = (left + right) / 2;
			if ((k * k) <= n && ((k + 1) * (k + 1)) > n) {
				return k;
			}
			if ((k * k) < n) {
				left = k + 1;
			} else
				right = k - 1;
		}
		return -1;
	}

	public int find(ArrayList<Integer> list, int n) {
		int i = 1;
		if (list.get(0) == n)
			return 0;
		while (i < list.size()) {
			if (list.get(i) == n) {
				int temp = list.get(i - 1);
				list.set(i - 1, list.get(i));
				list.set(i, temp);
				return i - 1;
			}
			i++;
		}
		return -1;
	}

}
