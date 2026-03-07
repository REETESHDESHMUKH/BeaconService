package com.service.beacon.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.SourcesRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import com.kwabenaberko.newsapilib.models.response.SourcesResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class NewsApiService {
    @Value("${NEWS_API_TOKEN}")
    private String newsApiToken;

    private final NewsApiClient newsApiClient = new NewsApiClient(newsApiToken);

    private ArticleResponse getTopHeadlines(TopHeadlinesRequest request) {
        CompletableFuture<ArticleResponse> future = new CompletableFuture<>();
        newsApiClient.getTopHeadlines(request, new NewsApiClient.ArticlesResponseCallback() {
            @Override
            public void onSuccess(ArticleResponse response) {
                future.complete(response);
            }

            @Override
            public void onFailure(Throwable throwable) {
                future.completeExceptionally(throwable);
            }
        });

        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch top headlines", e);
        }
    }

    private ArticleResponse getTopHeadlines(EverythingRequest request) {
        CompletableFuture<ArticleResponse> future = new CompletableFuture<>();
        newsApiClient.getEverything(request, new NewsApiClient.ArticlesResponseCallback() {
            @Override
            public void onSuccess(ArticleResponse response) {
                future.complete(response);
            }

            @Override
            public void onFailure(Throwable throwable) {
                future.completeExceptionally(throwable);
            }
        });

        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch top headlines", e);
        }
    }

    private SourcesResponse getSources(SourcesRequest request) {
        CompletableFuture<SourcesResponse> future = new CompletableFuture<>();
        newsApiClient.getSources(request, new NewsApiClient.SourcesCallback() {
            @Override
            public void onSuccess(SourcesResponse response) {
                future.complete(response);
            }

            @Override
            public void onFailure(Throwable throwable) {
                future.completeExceptionally(throwable);
            }
        });

        try {
            return future.get();
        } catch (Exception e) {
            throw new RuntimeException("Failed to fetch top headlines", e);
        }
    }
}
