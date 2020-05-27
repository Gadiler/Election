package id_311217905_id_312126055;

import java.util.Comparator;

public class Voter extends Citizen implements Cloneable, Comparator<Voter> {

	public Voter(String name, long id, String birthYear) throws Exception {
		super(name, id, birthYear);
	}

	@Override
	public Voter clone() throws CloneNotSupportedException {
		Voter temp = (Voter) super.clone();
		temp.myBallotBox = myBallotBox.clone();
		return temp;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int compare(Voter o1, Voter o2) {
		if (o1.getId() < o2.getId()) {
			return 1;
		} else if (o1.getId() > o2.getId()) {
			return -1;
		} else
			return 0;
	}
}
