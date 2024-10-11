package pelican.co_labor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pelican.co_labor.service.ElasticsearchService;
import pelican.co_labor.service.JsonLoader;
import pelican.co_labor.dto.CaseDocument;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/elasticsearch")
public class ElasticsearchController {

    private final ElasticsearchService elasticsearchService;

    @Value("${elasticsearch.index-name}")
    private String defaultIndexName;

    @Autowired
    public ElasticsearchController(ElasticsearchService elasticsearchService) {
        this.elasticsearchService = elasticsearchService;
    }

    @PostMapping("/bulk-index-directory")
    public ResponseEntity<String> bulkIndexFromDirectory(@RequestParam String directoryPath) {
        try {
            List<CaseDocument> documents = JsonLoader.loadJsonFromDirectory(directoryPath);
            elasticsearchService.bulkIndexDocuments(defaultIndexName, documents);
            return ResponseEntity.ok("Batch indexing from directory completed.");
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error during bulk indexing: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<String> deleteAllDocuments() {
        try {
            long deletedCount = elasticsearchService.deleteAllDocuments(defaultIndexName);
            return ResponseEntity.ok("Deleted " + deletedCount + " documents");
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error deleting documents: " + e.getMessage());
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchDocuments(
            @RequestParam(required = false) String query,
            @RequestParam(defaultValue = "0") int from,
            @RequestParam(defaultValue = "10") int size) {
        try {
            List<Map<String, Object>> results = elasticsearchService.searchDocuments(defaultIndexName, query, from, size);
            return ResponseEntity.ok(results);
        } catch (IOException e) {
            return ResponseEntity.internalServerError().body("Error searching documents: " + e.getMessage());
        }
    }
}