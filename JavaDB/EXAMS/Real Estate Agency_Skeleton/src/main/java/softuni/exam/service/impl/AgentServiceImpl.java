package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.AgentImportDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.repository.AgentRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class AgentServiceImpl implements AgentService {

    public static final String AGENTS_PATH = "src/main/resources/files/json/agents.json";
    private final AgentRepository agentRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public AgentServiceImpl(AgentRepository agentRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.agentRepository = agentRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count() > 0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(Path.of(AGENTS_PATH));
    }

    @Override
    public String importAgents() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readAgentsFromFile(), AgentImportDto[].class))
                .filter(agentImportDto -> {
                    boolean isValid = validationUtil.isValid(agentImportDto);

                    Agent agent = agentRepository.findByFirstName(agentImportDto.getFirstName());

                    if (agent != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported agent - %s %s",
                                agentImportDto.getFirstName(),
                                agentImportDto.getLastName()));
                    } else {
                        sb.append("Invalid agent");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(agentImportDto -> modelMapper.map(agentImportDto, Agent.class))
                .forEach(agentRepository::save);

        return sb.toString().trim();
    }
}
