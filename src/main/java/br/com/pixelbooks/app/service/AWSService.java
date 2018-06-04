package br.com.pixelbooks.app.service;

import br.com.pixelbooks.app.dto.ItemDTO;
import br.com.pixelbooks.app.dto.ItemSearchResponseDTO;
import br.com.pixelbooks.app.dto.ItemsDTO;
import br.com.pixelbooks.app.util.SignedRequestsHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;


/**
 * Service responsable for consume Amazon Product
 */
@Service
public class AWSService {
    @Value("${aws.private.key}")
    private String privateKey;

    @Value("${aws.access.key}")
    private String accessKey;

    @Value("${aws.associate.tag}")
    private String associateTag;

    @Value("${aws.base.uri}")
    private String baseURI;

    public List<ItemDTO> searchBookByTitle(String title) throws UnsupportedEncodingException, NoSuchAlgorithmException, InvalidKeyException {
        RestTemplate restTemplate = new RestTemplate();
        SignedRequestsHelper helper = null;

            helper = SignedRequestsHelper.getInstance(baseURI, accessKey, privateKey);


        Map<String, String> params = new HashMap<String, String>();

        params.put("Service", "AWSECommerceService");
        params.put("Operation", "ItemSearch");
        params.put("AWSAccessKeyId", accessKey);
        params.put("AssociateTag", associateTag);
        params.put("SearchIndex", "Books");
        params.put("ResponseGroup", "ItemAttributes");
        params.put("Title", title);

        String url = helper.sign(params);
        System.out.println("Signed URL:" + url );
        URI uri = URI.create(url);

        ResponseEntity<ItemSearchResponseDTO> searchResponse =
                restTemplate.exchange(uri,
                        HttpMethod.GET, null, new ParameterizedTypeReference<ItemSearchResponseDTO>() {
                        });
        System.out.println(searchResponse);

        ItemsDTO itemsDTO = searchResponse.getBody().getItemsDTO();

        return itemsDTO.getItem();
    }
}
