package org.xmlproccessingex;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.xmlproccessingex.service.CarService;
import org.xmlproccessingex.service.PartService;
import org.xmlproccessingex.service.SupplierService;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final SupplierService supplierService;
    private final CarService carService;

    private final PartService partService;
    public CommandLineRunnerImpl(SupplierService supplierService, CarService carService, PartService partService) {
        this.supplierService = supplierService;
        this.carService = carService;
        this.partService = partService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.supplierService.seedSupplier();
        this.partService.seedParts();
        this.carService.seedCars();
    }
}
