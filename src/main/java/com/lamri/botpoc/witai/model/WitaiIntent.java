package com.lamri.botpoc.witai.model;

import lombok.Data;

@Data
public class WitaiIntent {

    private double confidence;

    private String value;
}
