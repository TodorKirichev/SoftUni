package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.LibraryMemberImportDto;
import softuni.exam.models.entity.LibraryMember;
import softuni.exam.repository.LibraryMemberRepository;
import softuni.exam.service.LibraryMemberService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class LibraryMemberServiceImpl implements LibraryMemberService {

    public static final String MEMBERS_PATH = "src/main/resources/files/json/library-members.json";
    private final LibraryMemberRepository libraryMemberRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public LibraryMemberServiceImpl(LibraryMemberRepository libraryMemberRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.libraryMemberRepository = libraryMemberRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return libraryMemberRepository.count() > 0;
    }

    @Override
    public String readLibraryMembersFileContent() throws IOException {
        return Files.readString(Path.of(MEMBERS_PATH));
    }

    @Override
    public String importLibraryMembers() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson.fromJson(readLibraryMembersFileContent(), LibraryMemberImportDto[].class))
                .filter(libraryMemberImportDto -> {
                    boolean isValid = validationUtil.isValid(libraryMemberImportDto);

                    LibraryMember libraryMember = libraryMemberRepository.findByPhoneNumber(libraryMemberImportDto.getPhoneNumber());

                    if (libraryMember != null) {
                        isValid = false;
                    }

                    if (isValid) {
                        sb.append(String.format("Successfully imported library member %s - %s",
                                libraryMemberImportDto.getFirstName(),
                                libraryMemberImportDto.getLastName()));
                    } else {
                        sb.append("Invalid library member");
                    }
                    sb.append(System.lineSeparator());

                    return isValid;
                }).map(libraryMemberImportDto -> modelMapper.map(libraryMemberImportDto, LibraryMember.class))
                .forEach(libraryMemberRepository::save);

        return sb.toString().trim();
    }

    @Override
    public LibraryMember findLibraryMemberById(long id) {
        return libraryMemberRepository.findById(id);
    }
}
