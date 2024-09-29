package org.dolphina.recentSearch.service;


import org.dolphina.recentSearch.repository.RecentSearchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecentSearchService {

    private RecentSearchRepository recentSearchRepository;

    public RecentSearchService(RecentSearchRepository recentSearchRepository ) {
        this.recentSearchRepository = recentSearchRepository;
    }

    public void addRecentSearchWord(String userId, String keyword) {
        recentSearchRepository.addRecentSearch(userId, keyword);
    }

    public List<String> getRecentSearchList(String userId) {
        return recentSearchRepository.getRecentSearch(userId);
    }

}
