## 1. Projektübersicht

Das Projekt erweitert eine Spring-Boot-Anwendung zur Verwaltung von Wahldaten. Die Hauptziele sind:

- Hinzufügen von Vorzugsstimmen.
- Darstellung der Daten in zwei HTML-Tabellen (Parteien und Vorzugsstimmen).
- Ermöglichen von Filtern nach Parteinamen und Vorzugsstimmen.

## 2. Implementierung

### 2.1 Erweiterung der Datenstruktur

- **Neue Klasse `PreferenceVotes`**: Diese Klasse speichert Vorzugsstimmen mit Listennummer, Name der Person und Stimmenanzahl.

`public class PreferenceVotes {     private int listNumber;     private String personName;     private int voteCount; }`

- **`WarehouseData`-Klasse**: Um Vorzugsstimmen abzurufen, wurde eine Liste für `PreferenceVotes` hinzugefügt.

### 2.2 Simulation der Daten

In der Klasse `WarehouseSimulation` werden sowohl Partei-Stimmen als auch Vorzugsstimmen simuliert:

`public WarehouseData getData(String regionID) {     WarehouseData data = new WarehouseData();     // Simuliere Parteien     // Simuliere Vorzugsstimmen }`

### 2.3 HTML-Darstellung

Die Wahldaten werden in zwei Tabellen angezeigt:

- **Parteien-Tabelle**: Zeigt den Parteinamen und die Stimmen an.
- **Vorzugsstimmen-Tabelle**: Listet die Listennummer, den Namen der Person und die Stimmen auf.

html

Code kopieren

`<table>     <tr><th>Partei</th><th>Stimmen</th></tr>     <tr><td>OEVP</td><td>300</td></tr> </table>`

## 3. Herausforderungen und Lösungen

- **Datenstruktur erweitern**: Es war wichtig, die bestehende Struktur nicht zu stören. Die neuen Klassen wurden modular hinzugefügt.
- **HTML-Darstellung**: Das Backend musste die richtigen Daten liefern, um die Tabellen korrekt darzustellen.
- **Filterung**: Die Filterlogik wurde mit JavaScript umgesetzt, um eine dynamische Suche zu ermöglichen.

Filterfunktion:

```javascript
function applyFilters() {
        const partyFilter = document.getElementById('partyFilter').value.toUpperCase();
        const minVotesFilter = parseInt(document.getElementById('minVotesFilter').value);

        const personFilter = document.getElementById('personFilter').value.toLowerCase();
        const minPreferenceVotesFilter = parseInt(document.getElementById('minPreferenceVotesFilter').value);

        // party votes
        const filteredPartyVotes = warehouseData.countingData.filter(vote => {
            return vote.partyID.includes(partyFilter) && vote.amountVotes > minVotesFilter;
        });

        // preference votes
        const filteredPreferenceVotes = warehouseData.preferenceVotes.filter(vote => {
            return vote.personName.toLowerCase().includes(personFilter) && vote.voteCount > minPreferenceVotesFilter;
        });

        // Re-render tables with filtered data
        renderPartyVotes(filteredPartyVotes);
        renderPreferenceVotes(filteredPreferenceVotes);
    }
```

Diese Funktionalität wurde in der html file reingeschrieben.

## 4. ElectionData

Es wird diese Datenstruktur benutzt:

```java
private String regionID;
    private String regionName;
    private String regionAddress;
    private String regionPostalCode;
    private String federalState;
    private String timestamp;
    private List<PartyVotes> countingData;
    private List<PreferenceVotes> preferenceVotes; 
```

in den beiden listen werden die Partei und Vorzugsstimmen gespeichert.

## 4. Electionsimulation

Hier wurden die Objekte hinzugefügt

```javascript
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
```

## 6. Electioncontroller

mit `return "index"` wird die html Seite zurückgegeben und auf `localhost:8080/index.html` gehostet. Bei den Requestmappings werden die Daten in JSON und XML zurückgegeben.

```javascript
@RestController
public class ElectionController {

    @Autowired
    private ElectionService service;



    @RequestMapping(value = "/election/{regionID}/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ElectionData getElectionData(@PathVariable String regionID) {
        return service.getWarehouseData(regionID);
    }

    @RequestMapping(value = "/election/{regionID}/data.xml", produces = MediaType.APPLICATION_XML_VALUE)
    public ElectionData getElectionDataXML(@PathVariable String regionID) {
        return service.getWarehouseData(regionID);
    }
}

@Controller
class WebController {

    @GetMapping("/")
    public String index() {
        return "index"; //src/main/resources/static/index.html
    }
}
```

## 7. build.gradle

Diese dependencies sind nötig, um die Frameworks zu implementieren.

```java
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-data-rest'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
}
```

```java
implementation 'com.fasterxml.jackson.dataformat:jackson-dataformat-xml'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
```

Diese zwei Zeilen sind für die Benutzung von JSON und Thymeleaf (für das Frontend) nötig.
