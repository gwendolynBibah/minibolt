package com.gwen.minibolt.service.ServiceInt;

import com.gwen.minibolt.enums.GENERAL_STATUS;
import com.gwen.minibolt.enums.ORDER_STATUS;
import com.gwen.minibolt.enums.ROLE;

import java.util.List;

public interface AppStatusService {
    List<GENERAL_STATUS> getGeneralStatus();

    List<ORDER_STATUS> getOrderStatus();

    List<ROLE> getRoles();

}
