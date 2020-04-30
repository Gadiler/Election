package id_311217905_id_312126055;

public class MilitaryPollingStation extends PollingStation {
	
	public MilitaryPollingStation(String address, int numOfVoters) {
		super(address, numOfVoters);
	}

	public MilitaryPollingStation(MilitaryPollingStation militaryPollingStation) {
		super(militaryPollingStation.address, militaryPollingStation.allVoters.length);
	}

	public void setAVoteInMilitaryPollingStation(Voter voter, int indexOfParty, int contenderIndex) throws Exception {
		int year = Integer.parseInt(voter.birthYear);
		if (year <= LIMITED_YEAR && year >= (LIMITED_YEAR + 3)) { // checking for age 18-21
			Election.allParties.get(indexOfParty-1).makeAVoteForOurParty(voter, contenderIndex);
			numOfVoters++;
		} else {
			throw new Exception(
					"setAVoteInMilitaryPollingStation Exception: The voter birth year is:" + voter.birthYear);
		}

	}

	public void setMilitaryVoter(Voter voter) {
		allVoters[(int)numOfVoters++] = voter;
	}

	@Override
	public String toString() {
		return super.toString() + "Type of polling station: Military Polling Station\n";
	}

}
