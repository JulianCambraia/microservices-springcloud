package com.juliancambraia.hrworker.resources;

import com.juliancambraia.hrworker.entities.Worker;
import com.juliancambraia.hrworker.repositories.WorkerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

    private Environment env;

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerResource.class);

    private WorkerRepository repository;

    public WorkerResource(Environment env, WorkerRepository repository) {
        this.env = env;
        this.repository = repository;
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        List<Worker> workers = repository.findAll();
        return ResponseEntity.ok(workers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) throws InterruptedException {
        LOGGER.info("PORT: " + env.getProperty("local.server.port"));
        return ResponseEntity.ok(repository.findById(id).get());
    }
}
