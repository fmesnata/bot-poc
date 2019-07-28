package com.lamri.botpoc.witai.model;

import lombok.Data;

import java.util.List;

@Data
public class WitaiEntity {

    private List<WitaiIntent> intent;

    private String msg_id;
}
