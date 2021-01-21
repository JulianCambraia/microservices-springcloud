package com.juliancambraia.hrpayroll.services;

import com.juliancambraia.hrpayroll.entities.Payment;
import com.juliancambraia.hrpayroll.entities.Worker;
import com.juliancambraia.hrpayroll.feignclients.WorkerFeignClient;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private WorkerFeignClient feignClient;

    public PaymentService(WorkerFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    public Payment getPayment(long workerId, int days) {
        Worker worker = feignClient.findById(workerId).getBody();
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }
}
