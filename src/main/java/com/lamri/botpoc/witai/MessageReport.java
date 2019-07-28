package com.lamri.botpoc.witai;

import com.lamri.botpoc.witai.model.WitaiEntity;
import lombok.Data;

@Data
public class MessageReport {

    private String _text;

    private WitaiEntity entities;
}
