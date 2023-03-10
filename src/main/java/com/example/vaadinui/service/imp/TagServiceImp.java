package com.example.vaadinui.service.imp;

import com.example.vaadinui.dto.TagDto;
import com.example.vaadinui.service.TagService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagServiceImp implements TagService {
    private static final String HTTP_LOCALHOST_8081_TAGS = "http://localhost:8081/tags";
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public TagDto getTag(int id) {
        ResponseEntity<TagDto> responseEntity = restTemplate.getForEntity(HTTP_LOCALHOST_8081_TAGS + "/tg/" + id, TagDto.class);

        return responseEntity.getBody();
    }

    @Override
    public TagDto getTag(String name) {
        ResponseEntity<TagDto> responseEntity = restTemplate.getForEntity(HTTP_LOCALHOST_8081_TAGS + "/name/" + name, TagDto.class);

        return responseEntity.getBody();
    }

    @Override
    public List<TagDto> getTags() {
        ResponseEntity<TagDto[]> responseEntity = restTemplate.getForEntity(HTTP_LOCALHOST_8081_TAGS, TagDto[].class);
        TagDto[] objects = responseEntity.getBody();

        return Arrays.stream(objects).collect(Collectors.toList());
    }
}
