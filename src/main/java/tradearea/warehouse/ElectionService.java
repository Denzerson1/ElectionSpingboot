package tradearea.warehouse;

import org.springframework.stereotype.Service;
import tradearea.model.ElectionData;

@Service
public class ElectionService {

    public ElectionData getWarehouseData(String regionID) {
        ElectionSimulation simulation = new ElectionSimulation();
        return simulation.getData(regionID);
    }
}