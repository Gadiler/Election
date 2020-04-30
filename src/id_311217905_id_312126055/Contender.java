package id_311217905_id_312126055;

import java.util.ArrayList;

public class Contender extends Voter {
	private Party myParty;
	private int numOfVotesForContender;

	public Contender(Contender contender) throws Exception {
		super(contender.name, contender.id, contender.birthYear, contender.myPollingStation);
		this.myParty = contender.myParty;
	}

	public Contender(String nameC, long idC, String birthYearC, ArrayList<PollingStation> allPollingStations,
			Party myParty2) throws Exception {
		super(nameC, idC, birthYearC, allPollingStations);
		this.myParty = new Party(myParty2);
	}

	public void makeAVote() {
		this.numOfVotesForContender++;
	}

	public int getNumOfVotesForContender() {
		return numOfVotesForContender;
	}

	public Party getMyParty() {
		return myParty;
	}

	@Override
	public String toString() {
		return "Contender name: " + name + ", id: " + id + ", birthYear: " + birthYear + ", my party is: "
				+ myParty.getNameOfParty() + ", the numOfVotes: " + numOfVotesForContender + ".\n";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contender other = (Contender) obj;
		if (myParty == null) {
			if (other.myParty != null)
				return false;
		} else if (!myParty.equals(other.myParty))
			return false;
		if (numOfVotesForContender != other.numOfVotesForContender)
			return false;
		return true;
	}
}
