package com.genvict.online.utility;

import lombok.Getter;
import lombok.Setter;

public class Product {
	private static final long serialVersionUID = 1L;

    // ========================================================================
    // fields =================================================================
    @Getter @Setter private String itemCode;                                    // 产品货号
    @Getter @Setter private String name;                                        // 产品名称
    @Getter @Setter private String bandName;                                    // 产品品牌名称
    @Getter @Setter private int price;                                          // 产品价格(分)

    // ========================================================================
    // constructor ============================================================
    public Product() {
    }

    public Product(String itemCode, String name, String bandName, int price) {
        this.itemCode = itemCode;
        this.name = name;
        this.bandName = bandName;
        this.price = price;
    }

}
