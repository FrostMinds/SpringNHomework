package skypro.com.springhomework.Service;

import java.util.Collection;
import java.util.Set;

public interface ShoppingCartService {
    void putItems(Collection<Integer> itemIDs);

    Set<Integer> getItemIDs();
}
