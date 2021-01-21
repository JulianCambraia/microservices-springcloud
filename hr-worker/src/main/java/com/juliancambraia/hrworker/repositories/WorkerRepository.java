package com.juliancambraia.hrworker.repositories;

import com.juliancambraia.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
