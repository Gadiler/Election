package interfaces;

import java.util.Comparator;

import id_311217905_id_312126055.Citizen;

public class ComparVotersByID implements Comparator<Citizen>{

	@Override
	public int compare(Citizen o1, Citizen o2) {
		if (o1.getId() < o2.getId()) {
			return -1;
		}else if (o1.getId() > o2.getId()) {
			return 1;
		}else
			return 0;
	}

}
