package Storage;

import java.util.ArrayList;

import Model.KontoType;

public class Storage {

	private static ArrayList<KontoType> kontoTyper = new ArrayList<KontoType>();

	public static void addKontoType(KontoType kontoType) {
		if (!kontoTyper.contains(kontoType)) {
			kontoTyper.add(kontoType);
		}
	}

}
