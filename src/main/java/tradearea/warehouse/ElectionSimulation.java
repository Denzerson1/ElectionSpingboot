package tradearea.warehouse;

import java.util.ArrayList;
import java.util.List;
import tradearea.model.ElectionData;
import tradearea.model.PartyVotes;
import tradearea.model.PreferenceVotes;

public class ElectionSimulation {

	public ElectionData getData(String regionID) {
		ElectionData data = new ElectionData();
		data.setRegionID(regionID);
		data.setRegionName("Favoriten");
		data.setRegionAddress("Bahnhofstrasse 1");
		data.setRegionPostalCode("1010");
		data.setFederalState("Austria");

		// Simulate vote counts for parties
		List<PartyVotes> parties = new ArrayList<>();
		parties.add(new PartyVotes("ÖVP", getRandomInt(100, 500)));
		parties.add(new PartyVotes("SPÖ", getRandomInt(100, 500)));
		parties.add(new PartyVotes("FPÖ", getRandomInt(100, 500)));
		data.setCountingData(parties);

		// Simulate preference votes
		List<PreferenceVotes> preferences = new ArrayList<>();
		preferences.add(new PreferenceVotes(1, "Cüs Boma", getRandomInt(10, 100)));
		preferences.add(new PreferenceVotes(2, "Momo der Besänftigende", getRandomInt(10, 100)));
		preferences.add(new PreferenceVotes(3, "Simon der Penetrante", getRandomInt(10, 100)));
		data.setPreferenceVotes(preferences);

		return data;
	}

	private int getRandomInt(int min, int max) {
		return (int) (Math.random() * (max - min + 1)) + min;
	}
}
