package robotService.core;

import robotService.entities.robot.FemaleRobot;
import robotService.entities.robot.MaleRobot;
import robotService.entities.robot.Robot;
import robotService.entities.services.MainService;
import robotService.entities.services.SecondaryService;
import robotService.entities.services.Service;
import robotService.entities.supplements.MetalArmor;
import robotService.entities.supplements.PlasticArmor;
import robotService.entities.supplements.Supplement;
import robotService.repositories.SupplementRepository;

import java.util.ArrayList;
import java.util.Collection;

import static robotService.common.ConstantMessages.*;
import static robotService.common.ExceptionMessages.*;

public class ControllerImpl implements Controller {
    private SupplementRepository supplements;
    private Collection<Service> services;

    public ControllerImpl() {
        this.supplements = new SupplementRepository();
        this.services = new ArrayList<>();
    }

    @Override
    public String addService(String type, String name) {
        switch (type) {
            case "MainService":
                this.services.add(new MainService(name));
                break;
            case "SecondaryService":
                this.services.add(new SecondaryService(name));
                break;
            default:
                throw new NullPointerException(INVALID_SERVICE_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SERVICE_TYPE, type);
    }

    @Override
    public String addSupplement(String type) {
        switch (type) {
            case "PlasticArmor":
                this.supplements.addSupplement(new PlasticArmor());
                break;
            case "MetalArmor":
                this.supplements.addSupplement(new MetalArmor());
                break;
            default:
                throw new IllegalArgumentException(INVALID_SUPPLEMENT_TYPE);
        }
        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_TYPE, type);
    }

    @Override
    public String supplementForService(String serviceName, String supplementType) {
        Supplement currentSupplement = this.supplements.findFirst(supplementType);

        if (currentSupplement == null) {
            throw new IllegalArgumentException(String.format(NO_SUPPLEMENT_FOUND, supplementType));
        }
        Service currentService = this.services.stream().filter(service -> service.getName().equals(serviceName)).findFirst().orElse(null);
        currentService.addSupplement(currentSupplement);
        supplements.removeSupplement(currentSupplement);

        return String.format(SUCCESSFULLY_ADDED_SUPPLEMENT_IN_SERVICE, supplementType, serviceName);
    }

    @Override
    public String addRobot(String serviceName, String robotType, String robotName, String robotKind, double price) {

        Service currentService = this.services.stream().filter(service -> service.getName().equals(serviceName)).findFirst().orElse(null);
        boolean isServiceRight = false;

        switch (robotType) {
            case "MaleRobot":
                if (currentService.getClass().getSimpleName().equals("MainService")) {
                    isServiceRight = true;
                    currentService.addRobot(new MaleRobot(robotName, robotKind, price));
                }
                break;
            case "FemaleRobot":
                if (currentService.getClass().getSimpleName().equals("SecondaryService")) {
                    isServiceRight = true;
                    currentService.addRobot(new FemaleRobot(robotName, robotKind, price));
                }
                break;
            default:
                throw new IllegalArgumentException(INVALID_ROBOT_TYPE);
        }
        if (isServiceRight) {
            return String.format(SUCCESSFULLY_ADDED_ROBOT_IN_SERVICE, robotType, serviceName);
        } else {
            return UNSUITABLE_SERVICE;
        }
    }

    @Override
    public String feedingRobot(String serviceName) {
        Service currentService = services.stream().filter(service -> service.getName().equals(serviceName)).findFirst().orElse(null);
        currentService.feeding();
        return String.format(FEEDING_ROBOT, currentService.getRobots().size());
    }

    @Override
    public String sumOfAll(String serviceName) {
        Service currentService = services.stream().filter(service -> service.getName().equals(serviceName)).findFirst().orElse(null);
        double robotSum = currentService.getRobots().stream().mapToDouble(Robot::getPrice).sum();
        double supplementSum = currentService.getSupplements().stream().mapToDouble(Supplement::getPrice).sum();

        return String.format(VALUE_SERVICE, serviceName, robotSum + supplementSum);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        services.forEach(service -> sb.append(service.getStatistics()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}
