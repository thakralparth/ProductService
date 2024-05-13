package com.productservice.productservice.Services;

import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.dtos.SearchRequestDto;
import com.productservice.productservice.models.Product;
import com.productservice.productservice.models.SortParams;
import com.productservice.productservice.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

//import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<GenericProductDto> searchProducts(String query, int pageNumber, int itemsPerPage, List<SortParams> sortParams) {


        Sort sort = null;
        if(sortParams.get(0).getSortType().equals("ASC")){
            sort = Sort.by(sortParams.get(0).getSortParamsName()).ascending();
        }
        else{
            sort = Sort.by(sortParams.get(0).getSortParamsName()).descending();
        }

        for(int i=0;i<sortParams.size();i++){
            if(sortParams.get(i).getSortType().equals("ASC")){
                sort.and(Sort.by(sortParams.get(0).getSortParamsName())).ascending();
            }
            else{
                sort.and(Sort.by(sortParams.get(0).getSortParamsName())).descending();
            }
        }


        Pageable pageRequest = PageRequest.of(pageNumber, itemsPerPage, sort);

        List<Product> products = productRepository.findAllByTitleContainingIgnoreCase(query, pageRequest);

        // Convert List<Product> to List<GenericProductDto> in product model

        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (Product product : products){
            genericProductDtos.add(product.fromProduct(product));
        }
        return genericProductDtos;

    }

}
