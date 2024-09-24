package tradearea.warehouse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.MediaType;
import tradearea.model.ElectionData;

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
