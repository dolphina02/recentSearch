package org.dolphina.recentSearch.controller;

import org.dolphina.recentSearch.service.RecentSearchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecentSearchController {

    private final RecentSearchService recentSearchService;

    public RecentSearchController(RecentSearchService recentSearchService) {
        this.recentSearchService = recentSearchService;
    }
    // web 검색 --> kafka --> spring consuming --> redis
    // web 검색 --> spring api 호출 --> redis
    // 검색데이터 입력
    @PostMapping("/recentsearch/{userId}")
    public ResponseEntity<?> searchRecord(@PathVariable String userId, @RequestParam String keyword) {
        recentSearchService.addRecentSearchWord(userId, keyword);
        return ResponseEntity.ok("record success");
    }

    // 최근 검색 10개
    @GetMapping("/recentsearch/{userId}")
    public ResponseEntity<?> getRecentSearchList(@PathVariable String userId) {
        List<String> recentSearchList = recentSearchService.getRecentSearchList(userId);
        return ResponseEntity.ok(recentSearchList);
    }
}
