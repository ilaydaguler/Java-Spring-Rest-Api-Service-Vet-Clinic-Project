package com.works.model;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("Vendor")
@AllArgsConstructor
public class VendorSession extends  BaseVendor{


}
