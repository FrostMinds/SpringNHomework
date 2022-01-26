package skypro.com.springhomework.Data;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Component
@SessionScope
public class ShoppingCart {

    private final Set<Integer> itemIDs;

    public ShoppingCart() {
        this.itemIDs = new LinkedHashSet<>();
    }

    public void addItem(int itemID) {
        itemIDs.add(itemID);
    }

    public Set<Integer> getItems() {
        return Set.copyOf(itemIDs);
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "itemIDs=" + itemIDs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(itemIDs, that.itemIDs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemIDs);
    }
}
