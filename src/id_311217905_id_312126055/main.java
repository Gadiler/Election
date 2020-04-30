package id_311217905_id_312126055;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import id_311217905_id_312126055.Election.eMonth;
import id_311217905_id_312126055.Party.eFaction;
import messages.GraphicalUI;
import messages.Messageable;

public class main { // #### Gadi_Engelsman_311217905 Yakir_Azaria_312126055
	static Scanner s = new Scanner(System.in);
	private static Random rand = new Random();
	private static Messageable ui = new GraphicalUI();
	static Election firstRound;
	static int sizeOfPartyArr = 6;
	static int sizeOfCoronaPollingStationArr = 3;
	static int sizeOfContenderArr = 2; // minimum contenders per party
	static int sizeOfPollingStationArr = 11 + sizeOfCoronaPollingStationArr * 2;
	static int sizeOfVoterArr = 58 + (sizeOfContenderArr * sizeOfPartyArr); // 58 for numOfVoters

	public static void main(String[] args) throws Exception {
//		## HARD CODED ##
		ArrayList<Party> allParties = new ArrayList<Party>();
		ArrayList<Person> allCitizens = new ArrayList<Person>();
		ArrayList<PollingStation> allPollingStation = new ArrayList<PollingStation>();
//		##Setting parties
		allParties.add(new Party(eFaction.Center, "NewIsAlwaysBetter", "1998", sizeOfContenderArr, sizeOfVoterArr));
		allParties.add(new Party(eFaction.Left, "LeftIsTheNewRight", "1990", sizeOfContenderArr, sizeOfVoterArr));
		allParties.add(new Party(eFaction.Right, "WhyDoWeDoIt", "1980", sizeOfContenderArr, sizeOfVoterArr));
		allParties.add(new Party(eFaction.Center, "DemocracyNow", "1988", sizeOfContenderArr, sizeOfVoterArr));
		allParties.add(new Party(eFaction.Left, "GreenEarth", "2000", sizeOfContenderArr, sizeOfVoterArr));
		allParties.add(new Party(eFaction.Right, "Fachizem", "2003", sizeOfContenderArr, sizeOfVoterArr));
//		##Setting polling stations
		allPollingStation.add(new PollingStation("Yitzhak Rabin 30, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new PollingStation("Jabotinsky 3, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new PollingStation("Arlozorov 12, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new PollingStation("ibn Gabirol, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new PollingStation("Levi Eshkol 1, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new PollingStation("Yehuda Halevi 22, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new PollingStation("Michal Ha-Ktana 8, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new PollingStation("Yuval Ha-Mebulbal 123, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new PollingStation("Assi Dayan 10, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new PollingStation("Golda Meir 44, Tel-Aviv", sizeOfVoterArr));
//		##Setting corona military polling station
		allPollingStation.add(new CoronaPollingStation("Geula 3, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new CoronaPollingStation("Ha-Yarkon 42, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new CoronaPollingStation("Dizengoff 224, Tel-Aviv", sizeOfVoterArr));
//		##Setting military polling stations
		allPollingStation.add(new MilitaryPollingStation("Yitzhak Sadeh 67, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new MilitaryPollingStation("Ha-Masger 3, Tel-Aviv", sizeOfVoterArr));
		allPollingStation.add(new MilitaryPollingStation("Hertzel 16, Tel-Aviv", sizeOfVoterArr));
		
		allPollingStation.add(new CoronaMilitaryPollingStation("Tel Ha-Shomer", sizeOfVoterArr));
//		##Setting Voters
		allCitizens.add(new Voter("Ido", 100000001, "2000", allPollingStation));
		allCitizens.add(new Voter("Noam", 100000002, "1990", allPollingStation));
		allCitizens.add(new Voter("Yakir", 100000003, "1980", allPollingStation));
		allCitizens.add(new Voter("Tomer", 100000004, "1995", allPollingStation));
		allCitizens.add(new Voter("Itamar", 100000005, "1985", allPollingStation));
		allCitizens.add(new Voter("Yoav", 100000006, "1997", allPollingStation));
		allCitizens.add(new Voter("Eitan", 100000007, "2000", allPollingStation));
		allCitizens.add(new Voter("Daniel", 100000008, "2002", allPollingStation));
		allCitizens.add(new Voter("Ben", 100000009, "1993", allPollingStation));
		allCitizens.add(new Voter("Hans", 100000010, "1992", allPollingStation));
		allCitizens.add(new Voter("Raz", 100000011, "1987", allPollingStation));
		allCitizens.add(new Voter("Dor", 100000012, "1986", allPollingStation));
		allCitizens.add(new Voter("Barak", 100000013, "1989", allPollingStation));
		allCitizens.add(new Voter("Dorin", 100000014, "1990", allPollingStation));
		allCitizens.add(new Voter("Stav", 100000015, "2001", allPollingStation));
		allCitizens.add(new Voter("Amir", 100000016, "2001", allPollingStation));
		allCitizens.add(new Voter("Beny", 100000017, "2002", allPollingStation));
		allCitizens.add(new Voter("Keren", 100000018, "1999", allPollingStation));
		allCitizens.add(new Voter("David", 100000019, "1994", allPollingStation));
		allCitizens.add(new Voter("Victor", 100000020, "2000", allPollingStation));
		allCitizens.add(new Voter("Tal", 100000034, "2000", allPollingStation));
		allCitizens.add(new Voter("Doron", 100000035, "1990", allPollingStation));
		allCitizens.add(new Voter("Dekel", 100000036, "1980", allPollingStation));
		allCitizens.add(new Voter("Yotam", 100000037, "1995", allPollingStation));
		allCitizens.add(new Voter("Yiftach", 100000038, "1985", allPollingStation));
		allCitizens.add(new Voter("Ariel", 100000039, "1997", allPollingStation));
		allCitizens.add(new Voter("Liran", 100000040, "2000", allPollingStation));
		allCitizens.add(new Voter("Ernest", 100000041, "2002", allPollingStation));
		allCitizens.add(new Voter("Shiff", 100000042, "1993", allPollingStation));
		allCitizens.add(new Voter("Ella", 100000043, "1992", allPollingStation));
		allCitizens.add(new Voter("Gal", 100000044, "1987", allPollingStation));
		allCitizens.add(new Voter("Dean", 100000045, "1986", allPollingStation));
		allCitizens.add(new Voter("Bar", 100000046, "1989", allPollingStation));
		allCitizens.add(new Voter("Dori", 100000047, "1990", allPollingStation));
		allCitizens.add(new Voter("Shachar", 100000048, "2001", allPollingStation));
		allCitizens.add(new Voter("Yarden", 100000049, "2001", allPollingStation));
		allCitizens.add(new Voter("Ran", 100000050, "2002", allPollingStation));
		allCitizens.add(new Voter("Linor", 100000051, "1999", allPollingStation));
		allCitizens.add(new Voter("Davidovich", 100000052, "1994", allPollingStation));
		allCitizens.add(new Voter("Victoria", 100000053, "2000", allPollingStation));
		allCitizens.add(new Person("Harvey Specter", 100000060, "2010"));
		allCitizens.add(new Person("Donna Paulsen", 100000061, "1990"));
		allCitizens.add(new Person("Louis Litt", 100000062, "2000"));
		allCitizens.add(new Person("Jessica Pearson", 100000063, "2015"));
//		##Setting contenders
		allCitizens.add(new Contender("Barney Stinson", 100000022, "1990", allPollingStation, allParties.get(0)));
		allCitizens.add(new Contender("Ted Mosby", 100000023, "1991", allPollingStation, allParties.get(0)));
		allCitizens.add(new Contender("robin scherbatsky", 100000024, "1980", allPollingStation, allParties.get(1)));
		allCitizens.add(new Contender("lily Aldrin", 100000025, "1987", allPollingStation, allParties.get(1)));
		allCitizens.add(new Contender("Marshall Eriksen", 100000026, "1985", allPollingStation, allParties.get(2)));
		allCitizens.add(new Contender("Shay", 100000027, "2000", allPollingStation, allParties.get(2)));
		allCitizens.add(new Contender("Raz", 100000028, "2001", allPollingStation, allParties.get(3)));
		allCitizens.add(new Contender("Arin", 100000029, "1981", allPollingStation, allParties.get(3)));
		allCitizens.add(new Contender("Tom", 100000030, "1960", allPollingStation, allParties.get(4)));
		allCitizens.add(new Contender("Liraz", 100000031, "1977", allPollingStation, allParties.get(4)));
		allCitizens.add(new Contender("Nitzan", 100000032, "1965", allPollingStation, allParties.get(5)));
		allCitizens.add(new Contender("Gadi", 100000033, "1967", allPollingStation, allParties.get(5)));
		allCitizens.add(new Contender("Rachel Karen Green", 100000054, "1969", allPollingStation, allParties.get(rand.nextInt(sizeOfPartyArr))));
		allCitizens.add(new Contender("Ross Eustace Geller", 100000055, "1967", allPollingStation, allParties.get(rand.nextInt(sizeOfPartyArr))));
		allCitizens.add(new Contender("Chandler Muriel Bing", 100000056, "1968", allPollingStation, allParties.get(rand.nextInt(sizeOfPartyArr))));
		allCitizens.add(new Contender("Phoebe Buffay-Hannigan", 100000057, "1967", allPollingStation,allParties.get(rand.nextInt(sizeOfPartyArr))));
		allCitizens.add(new Contender("Joey Tribbiani", 100000058, "1968", allPollingStation, allParties.get(rand.nextInt(sizeOfPartyArr))));
		allCitizens.add(new Contender("Monica Geller-Bing", 100000059, "1969", allPollingStation, allParties.get(rand.nextInt(sizeOfPartyArr))));
		
		firstRound = new Election(eMonth.july, 13, allCitizens, allParties, allPollingStation);
		
		try {
			int res1 = 0;
			final int EXIT = -1;
			while (res1 != EXIT) {
//				ui.getMessage("Hello\n" + "Please enter number to choose\n" + "Add Voter --> 1\n"
//						+ "Add Contender --> 2\n" + "Add Party --> 3\n" + "Add Polling-Station --> 4\n"
//						+ "Start vote --> 5\n" + "Exit & Results --> -1\n");
				System.out.println("Hello\n" + "Please enter number to choose\n" + "Add Voter --> 1\n"
						+ "Add Contender --> 2\n" + "Add Party --> 3\n" + "Add Polling-Station --> 4\n"
						+ "Start vote --> 5\n" + "Exit & Results --> -1\n");

				res1 = s.nextInt();
				switch (res1) {

				case 1: // Add voter
					addVoter();
					break;

				case 2: // Add contender
					addContender();
					break;

				case 3: // Add party
					addParty();
					break;

				case 4: // Add polling station
					addPS();
					break;

				case 5:
					voting();
					break;

				case EXIT:
					System.out.println(firstRound.resultsToString());
					System.out.println(firstRound.resultsPSToString());
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + res1);
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public static void addVoter() throws Exception {
		System.out.println("Please enter the name of the voter: \n");
		String nameV = s.next();
//		String nameV = ui.getMessage("Please enter the name of the voter: \n");
//		ui.showMessage("Hi " + nameV);
		System.out.println("Please enter the ID of the voter: \n");
		long idV = s.nextLong();
		System.out.println("Please enter the birthYear of the voter: \n");
		String birthYearV = s.next();
		Election.allCitizens.add(new Voter(nameV, idV, birthYearV, Election.allPollingStations));
		System.out.println(nameV + " Added successfully\n");
	}

	public static void addContender() throws Exception {
		System.out.println("Please enter the name of the contender: \n");
		String nameC = s.next();
		System.out.println("Please enter the ID of the contender: \n");
		long idC = s.nextLong();
		System.out.println("Please enter the birthYear of the contender: \n");
		String birthYearC = s.next();
		Election.allCitizens.add(new Contender(nameC, idC, birthYearC, Election.allPollingStations, Election.allParties.get(rand.nextInt(Election.allParties.size()))));
		((Contender) Election.allCitizens.get(Election.allCitizens.size()-1)).getMyParty().allContenders = new Contender[((Contender) Election.allCitizens.get(Election.allCitizens.size()-1)).getMyParty().allContenders.length + 1];
		for (int i = 0; i < Election.allParties.size(); i++) {
			if (Election.allParties.get(i).nameOfParty.equals(((Contender) Election.allCitizens.get(Election.allCitizens.size()-1)).getMyParty().nameOfParty)) {
				Election.allParties.get(i).addContender(((Contender) Election.allCitizens.get(Election.allCitizens.size()-1)));
			}
		}
		System.out.println(Election.allCitizens.get(Election.allCitizens.size()-1).name + " Added successfully\n");
	}

	public static void addParty() throws Exception {
		System.out.println("Please enter the name of the Party: \n");
		String nameP = s.next();
		System.out.println("Please enter the faction of the party: (Left, Center, Right)\n");
		eFaction faction = eFaction.valueOf(s.next());
		System.out.println("Please enter the party establishment year:\n");
		String birthYearP = s.next();
		Election.allParties.add(new Party(faction, nameP, birthYearP, sizeOfContenderArr, Election.allCitizens.size()));
		System.out.println(Election.allParties.get(Election.allParties.size() - 1).getNameOfParty() + " added successfully\nNow enter 2 contenders.\n");

		for (int k = sizeOfContenderArr; k > 0; k--) {
			System.out.println("Please enter the name of the contender: \n");
			String nameC1 = s.next();
			System.out.println("Please enter the ID of the contender: \n");
			long idC1 = s.nextLong();
			System.out.println("Please enter the birthYear of the contender: \n");
			String birthYearC1 = s.next();
			Voter tempC1 = new Contender(nameC1, idC1, birthYearC1, Election.allPollingStations, Election.allParties.get(Election.allParties.size() - 1));
			((Contender) tempC1).getMyParty().allContenders = new Contender[((Contender) tempC1).getMyParty().allContenders.length + 1];
			Election.allParties.get(Election.allParties.size()-1).addContender(((Contender) tempC1));
			Election.allCitizens.add(tempC1);
			System.out.println(tempC1.name + " Added successfully\n");
		}
	}

	public static void addPS() throws CloneNotSupportedException {
		System.out.println("Please enter the address of the PollingStation: \n");
		String namePS = s.next();
		Election.allPollingStations.add(new PollingStation(namePS, Election.allCitizens.size())); // ##checking
		firstRound.setAllPollingStations(Election.allPollingStations);
		System.out.println("The polliing station number "
				+ Election.allPollingStations.get(Election.allPollingStations.size()-1).PollingStationID + " added successfully\n");
	}

	public static void voting() throws Exception {
		for (int i = 0; i < Election.allCitizens.size(); i++) {
			if (Election.allCitizens.get(i) != null) {
				System.out.println("Hello " + Election.allCitizens.get(i).name + " do you want to vote? (Y/N)");

//							## Manual initialized
//							String res = s.nextLine();

//							## Auto initialized			
				String res = "y";

				if (res.equals("y") || res.equals("Y")) {
					for (int j = 0; j < Election.allParties.size(); j++) {
						if (Election.allParties.get(j) != null) {
							System.out.println((j + 1) + "] " + Election.allParties.get(j).toString() + "\n");
						}
					}
					System.out.println(
							"Pick your party by write the index of the party and the index of your favorite contender: (<party>*space*<contender>)\n");

//								## Manual initialized --> turn on the clean buffer
//								int partyIndex = s.nextInt();
//								int contenderIndex = s.nextInt();
//								while (partyIndex > sizeOfPartyArr || contenderIndex > sizeOfContenderArr) {
//									System.out.println("Wrong input!\nPick your party by write the index of the party and the index of your favorite contender: (<party>*space*<contender>)\\n");
//									partyIndex = s.nextInt();
//									contenderIndex = s.nextInt();
//								}

//								## Random initialized
					int partyIndex = (int) rand.nextInt(Election.allParties.size()) + 1;
					int contenderIndex = (int) rand.nextInt(Election.allParties.get(partyIndex - 1).numOfContenders) + 1;

					if (Election.allCitizens.get(i) != null) {
						firstRound.makeAVote((Voter) Election.allCitizens.get(i), partyIndex, contenderIndex);
					}
//								s.nextLine(); //### Clean Buffer
				}
			}
		}
	}
}