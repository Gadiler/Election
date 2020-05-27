package id_311217905_id_312126055;

public class Contender extends Voter {
	private Party<Citizen> myParty;
	private int numOfVotesForContender;

	public Contender(String name, long id, String birthYear, Party<Citizen> p) throws Exception {
		super(name, id, birthYear);
		this.myParty = (Party<Citizen>) p;
	}

	public void makeAVote() {
		this.numOfVotesForContender++;
	}

	public int getNumOfVotesForContender() {
		return numOfVotesForContender;
	}

	public Party<Citizen> getMyParty() {
		return myParty;
	}

	@Override
	public String toString() {
		return super.toString() + ", my party is: " + getMyPartyName();
	}

	public String getMyPartyName() {
		return myParty.nameOfParty;
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
