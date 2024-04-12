package reflectionExercises.barracksWars;

import reflectionExercises.barracksWars.interfaces.Repository;
import reflectionExercises.barracksWars.interfaces.Runnable;
import reflectionExercises.barracksWars.interfaces.UnitFactory;
import reflectionExercises.barracksWars.core.Engine;
import reflectionExercises.barracksWars.core.factories.UnitFactoryImpl;
import reflectionExercises.barracksWars.data.UnitRepository;

public class Main {

    public static void main(String[] args) {
        Repository repository = new UnitRepository();
        UnitFactory unitFactory = new UnitFactoryImpl();

        Runnable engine = new Engine(repository, unitFactory);
        engine.run();
    }
}
