package pers.jamie.fegin;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("product-service")
public interface Fegin {

    @RequestMapping("/productInfo/subStock/{id}/{quantity}")
    public boolean subStock(@PathVariable("id") Integer id, @PathVariable("quantity") Integer quantity);
}
