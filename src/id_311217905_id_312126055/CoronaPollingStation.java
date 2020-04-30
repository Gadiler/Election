package id_311217905_id_312126055;

public class CoronaPollingStation extends PollingStation {
	
	public CoronaPollingStation(String address, int numOfVoters) {
		super(address, numOfVoters);
	}

	public CoronaPollingStation(CoronaPollingStation coronaPollingStation) {
		this(coronaPollingStation.address, coronaPollingStation.allVoters.length);
	}

	public void setAVoteInCoronaPollingStation(Voter voter, int indexOfParty) throws Exception {
		if (voter.fInsulation.equals(true)) {
			Election.allParties.get(indexOfParty-1).makeAVoteForOurParty(voter, indexOfParty);
			numOfVoters++;
		} else {
			throw new Exception(
					"setAVoteInCoronaPollingStation Exception: The voter insulation mode is: " + voter.fInsulation);
		}

	}

	public void setCoronaVoter(Voter voter) {
		allVoters[(int)numOfVoters++] = voter;
	}

	@Override
	public String toString() {
		return super.toString() + "Type of polling station: Corona Polling Station\n";
	}
}
