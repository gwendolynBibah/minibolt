package com.gwen.minibolt.controllers;

import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.enums.ORDER_STATUS;
import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.service.ServiceInt.AppStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/status")
public class AppStatusController {
    private final AppStatusService appStatusService;

    @GetMapping("/general")
    public List<GENERAL_STATUS> getGeneralStatus() {
        return this.appStatusService.getGeneralStatus();
    }

    @GetMapping("/order")
    public List<ORDER_STATUS> getOrderStatus() {
        return this.appStatusService.getOrderStatus();
    }

    @GetMapping("/role")
    public List<ROLE> getRoles() {
        return this.appStatusService.getRoles();
    }
}
