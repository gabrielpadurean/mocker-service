package org.mocker.service;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import org.mocker.domain.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author gabrielpadurean
 */
@Service
public class MockService {
	@Autowired
	private MappingService mappingService;
	
	
	/**
	 * Finds the mock for the given combination of parameters.
	 * The body is not used at this moment.
	 */
	public Optional<Mapping> findMock(String endpoint, String method, String body) {
		return ofNullable(mappingService
				.findByEndpoint(endpoint)
				.filter(mapping -> mapping.getRequest().getMethod().equalsIgnoreCase(method))
				.orElse(null));
	}
}