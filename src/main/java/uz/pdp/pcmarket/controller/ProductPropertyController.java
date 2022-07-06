package uz.pdp.pcmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.pcmarket.entity.ProductProperty;
import uz.pdp.pcmarket.payload.ApiResponse;
import uz.pdp.pcmarket.payload.ProductPropertyDto;
import uz.pdp.pcmarket.service.ProductPropertyService;

import java.util.List;

@RestController
@RequestMapping("/productProperty")
public class ProductPropertyController {
    @Autowired
    ProductPropertyService productPropertyService;

    @GetMapping
    public List<ProductProperty> getProductProperties(){return productPropertyService.getProductProperties();}

    @GetMapping("/{id}")
    public ProductProperty getProductProperty(@PathVariable Integer id){return productPropertyService.getProductPropertyById(id);}

    @PostMapping
    public ResponseEntity<ApiResponse> addProductProperty(@RequestBody ProductPropertyDto productPropertyDto){
        ApiResponse apiResponse = productPropertyService.addProductProperty(productPropertyDto);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> editProductProperty(@RequestBody ProductPropertyDto productPropertyDto,
                                                  @PathVariable Integer id){
        ApiResponse apiResponse = productPropertyService.editProductProperty(productPropertyDto, id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteProductProperty(@PathVariable Integer id){
        ApiResponse apiResponse = productPropertyService.deleteProductProperty(id);
        return ResponseEntity.status(apiResponse.isStatus()?202:409).body(apiResponse);
    }
}
