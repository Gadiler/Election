package interfaces;

import java.util.Comparator;

import id_311217905_id_312126055.Contender;

public class ComparContendersByNumOfVotes implements Comparator<Contender> {

	@Override
	public int compare(Contender o1, Contender o2) {
		if (o1.getNumOfVotesForContender() < o2.getNumOfVotesForContender()) {
			return 1;
		} else if (o1.getNumOfVotesForContender() > o2.getNumOfVotesForContender()) {
			return -1;
		} else
			return 0;
	}

}
