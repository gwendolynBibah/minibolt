package com.gwen.minibolt.service.serviceImp.utility_service;

import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.enums.ORDER_STATUS;
import com.gwen.minibolt.enums.ROLE;
import com.gwen.minibolt.service.ServiceInt.AppStatusService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AppStatusServiceImpl implements AppStatusService {
    /**
     * @return
     */
    @Override
    public List<GENERAL_STATUS> getGeneralStatus() {
        return Arrays.stream(GENERAL_STATUS.values()).toList();
    }

    /**
     * @return
     */
    @Override
    public List<ORDER_STATUS> getOrderStatus() {
        return Arrays.stream(ORDER_STATUS.values()).toList();
    }

    /**
     * @return
     */
    @Override
    public List<ROLE> getRoles() {
        return Arrays.stream(ROLE.values()).toList();
    }
}
