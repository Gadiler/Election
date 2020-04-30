package id_311217905_id_312126055;

import java.util.Arrays;
import java.util.Random;

public class PollingStation implements Cloneable{
	protected final static int LIMITED_YEAR = 2002;
	protected static Random r = new Random();
	public static int numOfPollingStaion = 100;
	protected int PollingStationID;
	protected String address;
	protected Voter[] allVoters;
	protected double numOfVoters;
	protected double percentOfVoters;

	public PollingStation(String address, int numOfVoters) {
		setAddress(address);
		this.PollingStationID =++ numOfPollingStaion;
		allVoters = new Voter[numOfVoters];

	}

	public PollingStation(PollingStation myPollingStation) {
		this(myPollingStation.address, myPollingStation.allVoters.length);
	}

	public boolean setVoter(Voter voter) {
			this.allVoters[(int)numOfVoters++] = voter;
			return true;
	}

	public void setAVoteInPollingStation(Voter voter, int partyIndex, int contenderIndex) throws Exception {
		Election.allParties.get(partyIndex - 1).makeAVoteForOurParty(voter, contenderIndex);
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPercentOfVoters() {
		return percentOfVoters;
	}
	public void setPercentOfVoters() {
		this.percentOfVoters = (numOfVoters/allVoters.length)*100;
	}

	public int getPollingStationID() {
		return PollingStationID;
	}

	@Override
	public PollingStation clone() throws CloneNotSupportedException {
		PollingStation temp = (PollingStation)super.clone();
		return temp;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("###Polling Station ID: " + PollingStationID + "\n");//
		sb.append(((int)numOfVoters>0) ? "Our voters:\n" : "There are no votes in here!\n");
		for (int i = 0; i < (int)numOfVoters; i++) {
			sb.append((i+1)+") "+allVoters[i].name +", " +allVoters[i].id+ "\n");
		}
		setPercentOfVoters();
		sb.append("The number of voters is: " + (int)numOfVoters + "\n" + "The percent of voters is: "
				+ percentOfVoters);
		return sb.toString()+ "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PollingStation other = (PollingStation) obj;
		if (address == null) {
			if (address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (!Arrays.equals(allVoters, allVoters))
			return false;
		if (Double.doubleToLongBits(percentOfVoters) != Double.doubleToLongBits(other.percentOfVoters))
			return false;
		return true;
	}

}
