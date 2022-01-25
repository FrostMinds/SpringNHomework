package skypro.com.springhomework.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import skypro.com.springhomework.Service.ShoppingCartService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/list")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping("add")
    public void add(@RequestParam List<Integer> itemIDs) {
        shoppingCartService.putItems(itemIDs);
    }

    @GetMapping("get")
    public Set<Integer> get() {
        return shoppingCartService.getItemIDs();
    }
}
