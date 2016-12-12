package com.alexcarstensen.itbfis_hi_prot;

import java.io.Serializable;

/**
 * Created by ubuntuudvikling on 12/7/16.
 */

enum DeliveryType{
    SecurityLevel1,
    SecurityLevel2,
    SecurityLevel3
}
public class customer implements Serializable {
    private String name;
    private DeliveryType deliveryType;
    customer(String name, DeliveryType deliveryType)
    {
        this.name = name;
        this.deliveryType = deliveryType;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }
}
