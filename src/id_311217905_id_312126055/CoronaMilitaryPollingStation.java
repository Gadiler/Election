package id_311217905_id_312126055;

public class CoronaMilitaryPollingStation extends MilitaryPollingStation {
	public CoronaMilitaryPollingStation(String address, int numOfVoters) {
		super(address, numOfVoters);
	}
	public CoronaMilitaryPollingStation(MilitaryPollingStation militaryPollingStation) {
		super(militaryPollingStation);
	}
	public void setAVoteInCoronaMilitaryPollingStation(Voter voter, int indexOfParty, int contenderIndex) throws Exception {
		if (voter.fMilitaryVoter && voter.fMilitaryVoter) {
			Election.allParties.get(indexOfParty-1).makeAVoteForOurParty(voter, contenderIndex);
			numOfVoters++;
		} else {
			throw new Exception(
					"setAVoteInCoronaMilitaryPollingStation Exception: The voter birth year is:" + voter.birthYear);
		}

	}

	public void setCoronaMilitaryVoter(Voter voter) {
		allVoters[(int)numOfVoters++] = voter;
	}

	@Override
	public String toString() {
		return super.toString() + "Type of polling station: Corona Military Polling Station\n";
	}
}
