package com.korai.servletstudy2.database;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {
    private int menu_id;
    private int restaurant_id;
    private String name;
    private int price;
    private String description;
    private boolean isSignature;
    private boolean isSoldOut;
}
