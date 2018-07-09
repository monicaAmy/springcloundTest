package com.su.component;

import com.su.api.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi
{
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }
}