package   factories;

import models.Enums.SpotAssignmentStrategyType;
import strategies.spotAssignmentStrategy.CheaptestSpotAssignmentStrategy;
import strategies.spotAssignmentStrategy.SpotAssignmentStrategy;

public class SpotAssignmentStrategyFactory {
    public static SpotAssignmentStrategy getSpotAssignmentStrategy(
            SpotAssignmentStrategyType spotAssignmentStrategyType
    ) {
        if (spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.CHEAPEST)) {
            return new CheaptestSpotAssignmentStrategy();
        } else if (spotAssignmentStrategyType.equals(SpotAssignmentStrategyType.RANDOM)) {
            return new parkinglot.strategies.spotAssignmentStrategy.RandomSpotAssignmentStrategy();
        }

        return null;
    }
}