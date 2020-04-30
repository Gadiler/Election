package comparator;

import java.util.Comparator;

import id_311217905_id_312126055.Party;

public class ComparPartiesByNumOfVotes implements Comparator<Party> {

	@Override
	public int compare(Party o1, Party o2) {
		if (o1.getNumOfVotes() > o2.getNumOfVotes()) {
			return -1;
		} else if (o1.getNumOfVotes() < o2.getNumOfVotes()) {
			return 1;
		} else
			return 0;
	}

}
