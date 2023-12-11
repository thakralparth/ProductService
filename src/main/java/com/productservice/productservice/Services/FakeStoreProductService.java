package com.productservice.productservice.Services;

import com.productservice.productservice.dtos.FakeStoreProductDto;
import com.productservice.productservice.dtos.GenericProductDto;
import com.productservice.productservice.exceptions.ProductNotFoundException;
import com.productservice.productservice.thirdPartyClients.fakestoreclient.FakeStoreClientAdapter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreClientAdapter fakeStoreAdapter;
    FakeStoreProductService(FakeStoreClientAdapter fakeStoreAdapter){
        this.fakeStoreAdapter = fakeStoreAdapter;
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

//    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
//    private String genericProductUrl = "https://fakestoreapi.com/products";
    @Override
    public GenericProductDto getProductById(Long id) throws ProductNotFoundException {
        //Integrate the fakestore api
        //RestTemplate --can help you to make the call to external systems

        return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));

//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> responseEntity =
//                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class,id);
//
//        FakeStoreProductDto fakeStoreProductDto=responseEntity.getBody();
//
//        if(fakeStoreProductDto == null){
//            //Throw an exception
//            throw new ProductNotFoundException("Product with id :"+ id + " not found!");
//        }
//
//        GenericProductDto genericProductDto = convertToGenericProductDto(fakeStoreProductDto);
////        return null;
////        return "Parth || Product fetched with id: " +id;
////        return responseEntity.getBody();
//            return genericProductDto;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreAdapter.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }
        return genericProductDtos;
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<List<FakeStoreProductDto>> =
//        restTemplate.getForEntity(getAllProductsUrl,List<FakeStoreProductDto>.class)

        //ArrayList<Integer> -> here Integer is a compile time check,
        //Java is a backward compatible language , Generics was introduced in Java 5.
        //AT runtime the response we get is of type ArrayList.class (whereas the return-type is ArrayList<FakeStoreProductDto>)
        // so, instead we use simple Array

        //ArrayList<Integer> => ArrayList.class  -> Erasure

//        ResponseEntity<FakeStoreProductDto[]> responseEntity =
//        restTemplate.getForEntity(genericProductUrl,FakeStoreProductDto[].class);
//
//        List<GenericProductDto> result = new ArrayList<>();
//        List<FakeStoreProductDto> fakeStoreProductDtos = List.of(responseEntity.getBody());
//        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
//            result.add(convertToGenericProductDto(fakeStoreProductDto));
//        }
//
//        return result;
//        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
//        RestTemplate restTemplate = restTemplateBuilder.build();
//
//        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        ResponseEntity<FakeStoreProductDto> responseEntity=
//                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);
//
//        return convertToGenericProductDto(responseEntity.getBody());
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
//    return null;
//        RestTemplate restTemplate =restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> responseEntity=
//        restTemplate.postForEntity(genericProductUrl,genericProductDto, FakeStoreProductDto.class);
//
//        return convertToGenericProductDto(responseEntity.getBody());
        
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.updateProductById(id,genericProductDto));
//        RestTemplate restTemplate = restTemplateBuilder.build();
////        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
////        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
////        ResponseEntity<FakeStoreProductDto> responseEntity=
////                restTemplate.execute(specificProductUrl, HttpMethod.PATCH, requestCallback, responseExtractor, id);
//
////        FakeStoreProductDto fakeStoreProductDto=
////        restTemplate.put(specificProductUrl,genericProductDto,FakeStoreProductDto.class,id);
//
//        RequestCallback requestCallback = restTemplate.httpEntityCallback(genericProductDto, FakeStoreProductDto.class);
//        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor = restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
//        ResponseEntity<FakeStoreProductDto> responseEntity=
//         restTemplate.execute(specificProductUrl, HttpMethod.PUT, requestCallback, responseExtractor, id);
//
//
//
//        return convertToGenericProductDto(responseEntity.getBody());
//        restTemplate.put(specificProductUrl,genericProductDto,id);
    }
}
