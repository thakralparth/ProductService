package com.productservice.productservice.thirdPartyClients.fakestoreclient;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class FakeStoreClientAdapter {
    private RestTemplateBuilder restTemplateBuilder;//who'll create the object --> Spring


//    @Value("${fakestore.api.url}")
    private String fakeStoreUrl;

//    @Value("${fakestore.api.paths.products}")
    private String pathForProducts;

    private String specificProductUrl ;
    private String genericProductUrl ;

    FakeStoreClientAdapter(RestTemplateBuilder restTemplateBuilder,
                           @Value("${fakestore.api.url}") String fakeStoreUrl,
                           @Value("${fakestore.api.paths.products}")String pathForProducts){
        this.restTemplateBuilder= restTemplateBuilder;
        this.genericProductUrl =fakeStoreUrl +pathForProducts;
        this.specificProductUrl =fakeStoreUrl +pathForProducts + "/{id}";
    }

//    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
//        GenericProductDto genericProductDto = new GenericProductDto();
////        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
////        fakeStoreProductDto = responseEntity.getBody();
//        genericProductDto.setId(fakeStoreProductDto.getId());
//        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
//        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
//        genericProductDto.setImage(fakeStoreProductDto.getImage());
//        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
//        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
//
//        return genericProductDto;
//    }


    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the fakestore api
        //RestTemplate --can help you to make the call to external systems

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);

        FakeStoreProductDto fakeStoreProductDto=responseEntity.getBody();

        if(fakeStoreProductDto == null){
            //Throw an exception
            throw new ProductNotFoundException("Product with id :"+ id + " not found!");
        }

        return fakeStoreProductDto;
//        GenericProductDto genericProductDto = convertToGenericProductDto(fakeStoreProductDto);
//        return null;
//        return "Parth || Product fetched with id: " +id;
//        return responseEntity.getBody();
//        return genericProductDto;
    }


    public List<FakeStoreProductDto> getAllProducts() {
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

//        List<GenericProductDto> result = new ArrayList<>();
//        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
//        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
//            result.add(convertToGenericProductDto(fakeStoreProductDto));
//        }


        return List.of(responseEntity.getBody());

//        return null;
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

          return responseEntity.getBody();
//        return convertToGenericProductDto(responseEntity.getBody());
    }


    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
//    return null;
        RestTemplate restTemplate =restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.postForEntity(genericProductUrl,genericProductDto, FakeStoreProductDto.class);

        return responseEntity.getBody();

    }

    
    public FakeStoreProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        ResponseEntity<FakeStoreProductDto> responseEntity=
//                restTemplate.execute(specificProductUrl, HttpMethod.PATCH, requestCallback, responseExtractor, id);

//        FakeStoreProductDto fakeStoreProductDto=
//        restTemplate.put(specificProductUrl,genericProductDto,FakeStoreProductDto.class,id);

        RequestCallback requestCallback = restTemplate.httpEntityCallback(genericProductDto, FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity=
                restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);



        return responseEntity.getBody();
//        restTemplate.put(specificProductUrl,genericProductDto,id);
    }
}
