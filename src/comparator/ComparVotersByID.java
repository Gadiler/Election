package comparator;

import java.util.Comparator;
import id_311217905_id_312126055.Voter;

public class ComparVotersByID implements Comparator<Voter>{

	@Override
	public int compare(Voter o1, Voter o2) {
		if (o1.getId() < o2.getId()) {
			return 1;
		}else if (o1.getId() > o2.getId()) {
			return -1;
		}else
		return 0;
	}

}
