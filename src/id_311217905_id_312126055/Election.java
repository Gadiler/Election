package id_311217905_id_312126055;

import java.util.ArrayList;
import java.util.Random;

import comparator.BubbleSort;
import comparator.ComparPartiesByNumOfVotes;

public class Election implements Cloneable {

	public enum eMonth {
		January, February, March, April, May, June, july, August, September, October, November, Desember
	};

	protected eMonth month;
	protected int Day;// protected - access in package
	protected static int numOfParties;
	protected int numOfPollingStation;
	protected static ArrayList<Voter> allCitizens;
	protected static ArrayList<PollingStation> allPollingStations;
	protected static ArrayList<Party> allParties;

	public Election(eMonth july, int day, ArrayList<Person> allCitizens, ArrayList<Party> allParties, ArrayList<PollingStation> allPollingStation) throws Exception {
		this.month = july;
		this.Day = day;
		setAllPollingStations(allPollingStation);
		setVoters(allCitizens);
		setParties(allParties);
	}

	public void setParties(ArrayList<Party> allParties) throws Exception {
		for (int i = allParties.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (allParties.get(j).getNameOfParty().equals(allParties.get(i).getNameOfParty())) {
					throw new Exception(
							"setPartiesException: The party: " + allParties.get(i).getNameOfParty() + "already exists");
				}
			}
		}
		Election.allParties = new ArrayList<Party>();
		for (int i = 0; i < allParties.size(); i++) {
			Election.allParties.add(allParties.get(i));
			Election.numOfParties++;
		}
		setContenders(allCitizens, allCitizens.size());

	}

	public static Party getParty(Party Party) {
		for (int i = 0; i < numOfParties; i++) {
			if (allParties.get(i).getNameOfParty().equals(Party.getNameOfParty())) {
				return allParties.get(i);
			}
		}
		return null;
	}

	public void setAllPollingStations(ArrayList<PollingStation> allPollingStation) {
		allPollingStations = new ArrayList<PollingStation>();
		for (int i = 0; i < allPollingStation.size(); i++) {
			allPollingStations.add(allPollingStation.get(i));
		}

	}

	public void setVoters(ArrayList<Person> arr) throws Exception {
		allCitizens = new ArrayList<Voter>();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).adult) {
				if (arr.get(i) instanceof Voter) {
					allCitizens.add((Voter) arr.get(i));
				} else {
					allCitizens
							.add(new Voter(arr.get(i).name, arr.get(i).id, arr.get(i).birthYear, allPollingStations));
				}

			}
		}
	}

	public Boolean setContenders(ArrayList<Voter> arr, int numOfVoters) throws Exception {
		for (int i = 0; i < numOfVoters; i++) {
			for (int j = 0; j < Election.allParties.size(); j++) {
				if (arr.get(i) instanceof Contender) {
					if (((Contender) arr.get(i)).getMyParty().getNameOfParty().equals(allParties.get(j).nameOfParty)) {
						allParties.get(j).addContender(((Contender) arr.get(i)));
					}
				}
			}
		}
		return true;
	}

	public void makeAVote(Voter voter, int partyIndex, int contenderIndex) throws Exception { //
		for (int i = 0; i < allCitizens.size(); i++) {
			if (voter.equals(allCitizens.get(i))) {
				for (int j = 0; j < allPollingStations.size(); j++) { // Need to change for setting the PS
					if (voter.getMyPollingStation().equals(allPollingStations.get(j))) {
						allPollingStations.get(j).setVoter(voter);
					}
				}
				allCitizens.get(i).myPollingStation.setAVoteInPollingStation(voter, partyIndex, contenderIndex);
			}
		}
	}

	public String resultsToString() {
		allParties.sort(new ComparPartiesByNumOfVotes());
		StringBuilder sb = new StringBuilder(
				"********************************************************************************************************************************\n\n"
						+ "**** Elction Day ****\n" + "After calculating the votes, the results are:\n");
		for (int i = 0; i < allParties.size(); i++) {
			sb.append((1 + i) + "} " + allParties.get(i).ourVotesToString());
		}
		return sb.toString()
				+ "********************************************************************************************************************************\n\n";
	}

	public String resultsPSToString() {
		StringBuilder sb = new StringBuilder("##The list of voters by polling stations is:\n");
		for (int i = 0; i < allPollingStations.size(); i++) {
			sb.append("\n" + (1 + i) + "] " + allPollingStations.get(i).toString());
		}
		return sb.toString();
	}
}
