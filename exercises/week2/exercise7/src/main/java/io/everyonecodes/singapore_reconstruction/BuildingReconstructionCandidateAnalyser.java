package io.everyonecodes.singapore_reconstruction;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@ConfigurationProperties("singapore")
public class BuildingReconstructionCandidateAnalyser {

    private List<Building> buildings;

    public BuildingReconstructionCandidateAnalyser() {
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Building> findCandidates(){
        return buildings.stream()
                .filter(building -> !building.isHistoric())
                .filter(built -> built.getBuilt().isBefore(LocalDate.now().minusYears(20)))
                .collect(Collectors.toList());
    }
}
