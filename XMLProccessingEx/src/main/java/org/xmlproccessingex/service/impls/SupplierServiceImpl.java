package org.xmlproccessingex.service.impls;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.xmlproccessingex.data.entities.Supplier;
import org.xmlproccessingex.data.repositories.SupplierRepository;
import org.xmlproccessingex.service.SupplierService;
import org.xmlproccessingex.service.dtos.imports.SupplierSeedDto;
import org.xmlproccessingex.service.dtos.imports.SupplierSeedRootDto;
import org.xmlproccessingex.util.ValidationUtil;
import org.xmlproccessingex.util.XmlParser;

import java.io.File;

@Service
public class SupplierServiceImpl implements SupplierService {

    private static final String FILE_IMPORT_PATH = "src/main/resources/xml/imports/suppliers.xml";
    private final SupplierRepository supplierRepository;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final ModelMapper modelMapper;

    public SupplierServiceImpl(SupplierRepository supplierRepository, XmlParser xmlParser, ValidationUtil validationUtil, ModelMapper modelMapper) {
        this.supplierRepository = supplierRepository;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.modelMapper = modelMapper;
    }

    @Override
    public void seedSupplier() throws JAXBException {
        if (this.supplierRepository.count() == 0) {
            SupplierSeedRootDto supplierSeedRootDto = xmlParser.parse(SupplierSeedRootDto.class, FILE_IMPORT_PATH);

            for (SupplierSeedDto supplierSeedDto : supplierSeedRootDto.getSupplierSeedDtoList()) {
                if (!this.validationUtil.isValid(supplierSeedDto)) {
                    this.validationUtil.getViolations(supplierSeedDto)
                            .forEach(v -> System.out.println(v.getMessage()));

                    continue;
                }

                Supplier supplier = this.modelMapper.map(supplierSeedDto, Supplier.class);
                this.supplierRepository.saveAndFlush(supplier);
            }
        }
        System.out.println();
    }
}
