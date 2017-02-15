package ecorp.dao;
import com.fasterxml.jackson.databind.ObjectMapper;
import ecorp.domain.AddSlackControllerRequest;
import ecorp.service.MessageService;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.ResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Repository
public class SlackDaoRestImpl {

	@Autowired
	private CloseableHttpClient httpClient;

	private static Logger logger = Logger.getLogger(MessageService.class);

	public String send(AddSlackControllerRequest request) throws RuntimeException {
		try {
			HttpComponentsClientHttpRequestFactory httpComponetFactory = new HttpComponentsClientHttpRequestFactory();
			httpComponetFactory.setHttpClient(httpClient);

			httpComponetFactory.setConnectTimeout(10000);
			httpComponetFactory.setReadTimeout(10000);

			RestTemplate restTemplate = new RestTemplate(httpComponetFactory);
			restTemplate.setErrorHandler(new ResponseErrorHandler() {
				@Override
				public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
					return false;
				}

				@Override
				public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

				}
			});

			long startTime = System.currentTimeMillis();
			String responseString = restTemplate.postForObject("https://hooks.slack.com/services/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",request, String.class);
			long endTime = System.currentTimeMillis();
			logger.info("slack send data elapsed time = " + (endTime - startTime) + " ms.");

			logger.info("Server Response is : " + responseString);

			return responseString;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String sendExchange(AddSlackControllerRequest request) throws RuntimeException {
		try {
			HttpComponentsClientHttpRequestFactory httpComponetFactory = new HttpComponentsClientHttpRequestFactory();
			httpComponetFactory.setHttpClient(httpClient);

			httpComponetFactory.setConnectTimeout(10000);
			httpComponetFactory.setReadTimeout(10000);

			RestTemplate restTemplate = new RestTemplate(httpComponetFactory);
			restTemplate.setErrorHandler(new ResponseErrorHandler() {
				@Override
				public boolean hasError(ClientHttpResponse clientHttpResponse) throws IOException {
					return false;
				}

				@Override
				public void handleError(ClientHttpResponse clientHttpResponse) throws IOException {

				}
			});

			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

			HttpEntity<AddSlackControllerRequest> entity = new HttpEntity<AddSlackControllerRequest>(request, headers);

			long startTime = System.currentTimeMillis();
			// We can call Rest with exchange & postForObject
			ResponseEntity<String> response = restTemplate.exchange(
					"https://hooks.slack.com/services/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", HttpMethod.POST, entity, String.class);

			long endTime = System.currentTimeMillis();
			logger.info("slack send data elapsed time = " + (endTime - startTime) + " ms.");

			String responseString = response.getBody();
			logger.info("Server Response is : " + responseString);

			return responseString;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	public CloseableHttpClient getHttpClient() {
		return httpClient;
	}

	public void setHttpClient(CloseableHttpClient httpClient) {
		this.httpClient = httpClient;
	}

}
