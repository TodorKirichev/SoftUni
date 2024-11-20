package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.DeviceRootImportDto;
import softuni.exam.models.entity.Device;
import softuni.exam.models.entity.DeviceType;
import softuni.exam.models.entity.Sale;
import softuni.exam.repository.DeviceRepository;
import softuni.exam.service.DeviceService;
import softuni.exam.service.SaleService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {

    public static final String DEVICES_PATH = "src/main/resources/files/xml/devices.xml";
    private final DeviceRepository deviceRepository;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;
    private final SaleService saleService;

    public DeviceServiceImpl(DeviceRepository deviceRepository, ModelMapper modelMapper, XmlParser xmlParser, ValidationUtil validationUtil, SaleService saleService) {
        this.deviceRepository = deviceRepository;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
        this.saleService = saleService;
    }

    @Override
    public boolean areImported() {
        return deviceRepository.count() > 0;
    }

    @Override
    public String readDevicesFromFile() throws IOException {
        return Files.readString(Path.of(DEVICES_PATH));
    }

    @Override
    public String importDevices() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile(DEVICES_PATH, DeviceRootImportDto.class)
                .getDevices()
                .stream().filter(deviceImportDto -> {
                    boolean isValid = validationUtil.isValid(deviceImportDto);

                    Device device = deviceRepository.findByBrandAndModel(deviceImportDto.getBrand(), deviceImportDto.getModel());

                    if (device != null) {
                        isValid = false;
                    }

                    Sale sale = saleService.findSaleById(deviceImportDto.getSale());

                    if (sale == null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported device of type %s with brand %s",
                                deviceImportDto.getDeviceType(),
                                deviceImportDto.getBrand()));
                    } else {
                        sb.append("Invalid device");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(deviceImportDto -> {
                    Device device = modelMapper.map(deviceImportDto, Device.class);

                    Sale sale = saleService.findSaleById(deviceImportDto.getSale());

                    device.setSale(sale);

                    sale.getDevices().add(device);

                    return device;
                }).forEach(deviceRepository::save);

        return sb.toString().trim();
    }

    @Override
    public String exportDevices() {
        StringBuilder sb = new StringBuilder();

        List<Device> devices = deviceRepository
                .findAllByDeviceTypeAndPriceLessThanAndStorageGreaterThanEqualOrderByBrand(DeviceType.SMART_PHONE, 1000.0, 128);

        devices.forEach(device -> {
            sb.append(String.format("Device brand: %s\n" +
                    "   *Model: %s\n" +
                    "   **Storage: %d\n" +
                    "   ***Price: %.2f",
                    device.getBrand(),
                    device.getModel(),
                    device.getStorage(),
                    device.getPrice()))
                    .append(System.lineSeparator());
        });

        return sb.toString().trim();
    }
}
