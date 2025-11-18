package com.hoty.sec.controller;

import com.hoty.sec.model.DataItem;
import com.hoty.sec.repository.DataItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@RestController
@RequestMapping("/api/data")
@RequiredArgsConstructor
public class DataController {

    private final DataItemRepository repository;

    @GetMapping
    public List<DataItemResponse> getAll() {
        return repository.findAll().stream()
                .map(item -> new DataItemResponse(
                        item.getId(),
                        HtmlUtils.htmlEscape(item.getTitle()),
                        HtmlUtils.htmlEscape(item.getContent())
                ))
                .toList();
    }

    @PostMapping
    public DataItemResponse create(@RequestBody DataItemRequest request) {
        DataItem item = DataItem.builder()
                .title(request.title())
                .content(request.content())
                .build();
        DataItem saved = repository.save(item);
        return new DataItemResponse(
                saved.getId(),
                HtmlUtils.htmlEscape(saved.getTitle()),
                HtmlUtils.htmlEscape(saved.getContent())
        );
    }

    public record DataItemRequest(String title, String content) {}
    public record DataItemResponse(Long id, String title, String content) {}
}
