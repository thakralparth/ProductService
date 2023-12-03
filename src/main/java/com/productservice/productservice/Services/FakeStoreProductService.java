package com.productservice.productservice.Services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{
    private RestTemplateBuilder restTemplateBuilder;//who'll create the object --> Spring

    FakeStoreProductService(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder= restTemplateBuilder;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
//        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
//        fakeStoreProductDto = responseEntity.getBody();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());

        return genericProductDto;
    }

    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductUrl = "https://fakestoreapi.com/products";
    @Override
    public GenericProductDto getProductById(Long id) {
        //Integrate the fakestore api
        //RestTemplate --can help you to make the call to external systems

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);


        GenericProductDto genericProductDto = convertToGenericProductDto(responseEntity.getBody());
//        return null;
//        return "Parth || Product fetched with id: " +id;
//        return responseEntity.getBody();
            return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<List<FakeStoreProductDto>> =
//        restTemplate.getForEntity(getAllProductsUrl,List<FakeStoreProductDto>.class)

        //ArrayList<Integer> -> here Integer is a compile time check,
        //Java is a backward compatible language , Generics was introduced in Java 5.
        //AT runtime the response we get is of type ArrayList.class (whereas the return-type is ArrayList<FakeStoreProductDto>)
        // so, instead we use simple Array

        //ArrayList<Integer> => ArrayList.class  -> Erasure

        ResponseEntity<FakeStoreProductDto[]> responseEntity =
        restTemplate.getForEntity(genericProductUrl,FakeStoreProductDto[].class);

        List<GenericProductDto> result = new ArrayList<>();
        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            result.add(convertToGenericProductDto(fakeStoreProductDto));
        }

        return result;
//        return null;
    }

    @Override
    public void deleteProductById() {

    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
//    return null;
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=
        restTemplate.postForEntity(genericProductUrl,genericProductDto, FakeStoreProductDto.class);

        return convertToGenericProductDto(responseEntity.getBody());
        
    }

    @Override
    public void updateProductById() {

    }
}
