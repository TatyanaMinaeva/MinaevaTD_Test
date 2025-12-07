package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TitleNaming {
    PRODUCTS("Products"),
    CARTS("Your Cart"),
    CHECKOUT("Checkout: Your Information");

    private final String displayName;

    /*TitleNaming(String displayName) {         //этот конструктор заменим на аннотацию @AllArgsConstructor
        this.displayName = displayName;
    }*/

    /*public String getDisplayName() {          //этот конструктор заменим на аннотацию @Getter
        return displayName;
    }*/
}
