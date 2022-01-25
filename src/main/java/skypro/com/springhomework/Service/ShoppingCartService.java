package skypro.com.springhomework.Service;

import java.util.List;
import java.util.Set;

public interface ShoppingCartService {
    void putItems(List<Integer> itemIDs);

    Set<Integer> getItemIDs();
}
